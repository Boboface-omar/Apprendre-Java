public class PaiementEspece extends Paiement {
    private double montantVerse;
    private double monnaieRendue;
    
    public PaiementEspece(double montant, double montantVerse) {
        super(montant);  // montant = ce qu'il faut payer
        setMontantVerse(montantVerse);
        this.monnaieRendue = 0;  // Pas encore calculé
    }
    
    // ========== GETTERS ==========
    public double getMontantVerse() {
        return montantVerse;
    }
    
    public double getMonnaieRendue() {
        return monnaieRendue;
    }
    
    // ========== SETTERS ==========
    public void setMontantVerse(double montantVerse) {
        if (montantVerse <= 0) {
            throw new IllegalArgumentException("Le montant versé doit être positif");
        }
        this.montantVerse = montantVerse;
    }
    
    // Pas de setter pour monnaieRendue, elle est calculée automatiquement
    
    // ========== MÉTHODE SPÉCIFIQUE ==========
    private double calculerMonnaie() {
        if (montantVerse >= getMontant()) {
            return montantVerse - getMontant();
        } else {
            return 0;  // Pas assez d'argent, pas de monnaie à rendre
        }
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public void traiterPaiement() {
        System.out.println("\n💰 Traitement du paiement en espèces...");
        
        // Vérifier si le client a donné assez d'argent
        if (montantVerse < getMontant()) {
            double manquant = getMontant() - montantVerse;
            System.out.println("❌ Montant insuffisant ! Il manque " + 
                             String.format("%.2f", manquant) + "€");
            return;
        }
        
        // Calculer la monnaie à rendre
        this.monnaieRendue = calculerMonnaie();
        
        if (monnaieRendue > 0) {
            System.out.println("✅ Paiement accepté");
            System.out.println("🪙 Monnaie à rendre : " + 
                             String.format("%.2f", monnaieRendue) + "€");
        } else {
            System.out.println("✅ Paiement exact, pas de monnaie à rendre");
        }
        
        // En espèces, le paiement est toujours valide s'il y a assez d'argent
        setEstValide(true);
    }
    
    @Override
    public double calculerFrais() {
        // Pas de frais pour les paiements en espèces
        return 0.0;
    }
    
    @Override
    public String toString() {
        return String.format("Espèces[%s - Versé: %.2f€ - À payer: %.2f€]", 
                           getNumeroTransaction(), montantVerse, getMontant());
    }
}