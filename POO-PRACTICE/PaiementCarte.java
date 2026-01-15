import java.time.LocalDate;

public class PaiementCarte extends Paiement {
    private String numeroCarte;
    private String titulaire;
    private LocalDate dateExpiration;  // ⚠️ LocalDate au lieu de Date
    
    public PaiementCarte(double montant, String numeroCarte, String titulaire, LocalDate dateExpiration) {
        super(montant);  // ⚠️ Appelle Paiement(montant) seulement
        setNumeroCarte(numeroCarte);
        setTitulaire(titulaire);
        setDateExpiration(dateExpiration);
    }
    
    // ========== GETTERS ==========
    public String getNumeroCarte() {
        return numeroCarte;
    }
    
    public String getTitulaire() {
        return titulaire;
    }
    
    public LocalDate getDateExpiration() {
        return dateExpiration;
    }
    
    // ========== SETTERS ==========
    public void setNumeroCarte(String numeroCarte) {
        if (numeroCarte == null || numeroCarte.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de carte est obligatoire");
        }
        
        // Nettoyer les espaces
        String nettoye = numeroCarte.trim().replaceAll("\\s+", "");
        
        // Vérifier format : 16 chiffres
        if (!nettoye.matches("\\d{16}")) {
            throw new IllegalArgumentException("Numéro de carte invalide (16 chiffres attendus)");
        }
        
        this.numeroCarte = formaterNumeroCarte(nettoye);
    }
    
    private String formaterNumeroCarte(String numero) {
        // Formate comme "1234 5678 9012 3456"
        return numero.replaceAll("(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4");
    }
    
    public void setTitulaire(String titulaire) {
        if (titulaire == null || titulaire.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titulaire est obligatoire");
        }
        this.titulaire = titulaire.trim();
    }
    
    public void setDateExpiration(LocalDate dateExpiration) {
        if (dateExpiration == null) {
            throw new IllegalArgumentException("La date d'expiration est obligatoire");
        }
        
        // Vérifier que la date est dans le futur
        if (dateExpiration.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La carte est expirée");
        }
        
        this.dateExpiration = dateExpiration;
    }
    
    // ========== MÉTHODES SPÉCIFIQUES ==========
    private boolean estCarteValide() {
        return !dateExpiration.isBefore(LocalDate.now());
    }
    
    private void simulerConnexionBancaire() {
        System.out.println("🔗 Connexion à la banque...");
        System.out.println("📡 Vérification des fonds...");
        // Simulation d'attente
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public void traiterPaiement() {
        System.out.println("\n💳 Traitement du paiement par carte...");
        
        // 1. Vérifier la carte
        if (!estCarteValide()) {
            System.out.println("❌ Carte expirée ! Paiement refusé.");
            return;
        }
        
        // 2. Simuler connexion bancaire
        simulerConnexionBancaire();
        
        // 3. Simuler vérification (90% de réussite)
        double chance = Math.random();
        if (chance > 0.1) {  // 90% de chance de réussite
            System.out.println("✅ Paiement accepté par la banque");
            setEstValide(true);  // ⚠️ Important : utiliser le setter protégé
        } else {
            System.out.println("❌ Fond insuffisants ou carte refusée");
        }
    }
    
    @Override
    public double calculerFrais() {
        // Frais de 2% du montant
        return getMontant() * 0.02;
    }
    
    // ========== REDÉFINITION toString() ==========
    @Override
    public String toString() {
        return String.format("Carte[%s - %s - %.2f€ - %s]", 
                           getNumeroTransaction(), titulaire, getMontant(),
                           isEstValide() ? "VALIDE" : "EN ATTENTE");
    }
}