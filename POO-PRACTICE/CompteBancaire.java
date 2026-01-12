public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String proprietaire;  // "owner" → "proprietaire" (français cohérent)
    
    // Constructeur avec validation
    public CompteBancaire(String numeroCompte, double solde, String proprietaire) {
        setNumeroCompte(numeroCompte);
        setSolde(solde);  // Utilise setter pour validation
        setProprietaire(proprietaire);
    }
    
    // ========== GETTERS ==========
    public String getNumeroCompte() {
        return numeroCompte;
    }
    
    public double getSolde() {
        return solde;
    }
    
    public String getProprietaire() {
        return proprietaire;
    }
    
    // ========== SETTERS avec validation ==========
    public void setNumeroCompte(String numeroCompte) {
        if (numeroCompte == null || numeroCompte.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de compte ne peut pas être vide");
        }
        if (!numeroCompte.matches("[0-9]+")) {
            throw new IllegalArgumentException("Le numéro de compte doit contenir uniquement des chiffres");
        }
        this.numeroCompte = numeroCompte.trim();
    }
    
    public void setSolde(double solde) {
        if (solde < 0) {
            throw new IllegalArgumentException("Le solde ne peut pas être négatif: " + solde);
        }
        // Limite réaliste
        if (solde > 1_000_000_000) {
            throw new IllegalArgumentException("Solde trop élevé");
        }
        this.solde = solde;
    }
    
    public void setProprietaire(String proprietaire) {
        if (proprietaire == null || proprietaire.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du propriétaire ne peut pas être vide");
        }
        if (proprietaire.trim().length() < 2) {
            throw new IllegalArgumentException("Le nom est trop court");
        }
        this.proprietaire = proprietaire.trim();
    }
    
    // ========== MÉTHODES MÉTIER ==========
    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant à déposer doit être positif: " + montant);
        }
        if (montant > 100000) {
            throw new IllegalArgumentException("Dépôt trop important. Contactez votre agence.");
        }
        solde += montant;
        System.out.printf("✓ %.2f€ déposés. Nouveau solde: %.2f€\n", montant, solde);
    }
    
    public void retirer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant à retirer doit être positif: " + montant);
        }
        if (montant > solde) {
            System.out.printf("✗ Solde insuffisant! Retrait de %.2f€ refusé (solde: %.2f€)\n", 
                            montant, solde);
            return;
        }
        if (montant > 1000) {
            System.out.println("⚠️  Retrait important détecté (> 1000€)");
        }
        solde -= montant;
        System.out.printf("✓ %.2f€ retirés. Nouveau solde: %.2f€\n", montant, solde);
    }
    
    public void virerVers(CompteBancaire destinataire, double montant) {
        if (destinataire == null) {
            throw new IllegalArgumentException("Le compte destinataire est invalide");
        }
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }
        if (montant > solde) {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le virement");
        }
        
        // Effectue le virement
        this.retirer(montant);
        destinataire.deposer(montant);
        
        System.out.printf("✓ Virement de %.2f€ effectué vers %s\n", 
                         montant, destinataire.getProprietaire());
    }
    
    // ========== MÉTHODE D'AFFICHAGE ==========
    public void afficherInfo() {
        System.out.println("\n=== Informations du Compte ===");
        System.out.println("Propriétaire : " + proprietaire);
        System.out.println("N° Compte    : " + numeroCompte);
        System.out.printf("Solde        : %.2f€\n", solde);
        System.out.println("==============================\n");
    }
    
    // Méthode toString() pour l'affichage par défaut
    @Override
    public String toString() {
        return String.format("Compte[%s] - %s : %.2f€", 
                           numeroCompte, proprietaire, solde);
    }
}