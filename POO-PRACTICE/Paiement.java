import java.time.LocalDate;
import java.util.UUID;

// ⚠️ Note : On utilise LocalDate au lieu de Date (plus moderne)
public abstract class Paiement {
    private double montant;
    private String numeroTransaction;
    private LocalDate date;
    private boolean estValide;
    
    // ⚠️ CONSTRUCTEUR SIMPLIFIÉ : estValide est TOUJOURS false au début
    public Paiement(double montant) {
        setMontant(montant);
        this.numeroTransaction = genererNumeroTransaction();  // Génère automatiquement
        this.date = LocalDate.now();  // Date du jour
        this.estValide = false;       // Pas encore traité
    }
    
    // ========== GETTERS ==========
    public double getMontant() {
        return montant;
    }
    
    public String getNumeroTransaction() {
        return numeroTransaction;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public boolean isEstValide() {  // ⚠️ Convention : 'is' pour boolean
        return estValide;
    }
    
    // ========== SETTERS ==========
    public void setMontant(double montant) {
        if (montant <= 0) {  // ⚠️ Pas de 'null' pour un double !
            throw new IllegalArgumentException("Le montant doit être positif");
        }
        if (montant > 100000) {  // ⚠️ 100000 sans point
            throw new IllegalArgumentException("Montant trop élevé. Contactez-nous.");
        }
        this.montant = montant;
    }
    
    // ⚠️ Pas de setter pour numeroTransaction (généré automatiquement)
    // ⚠️ Pas de setter pour date (fixée à la création)
    
    // Setter protégé pour estValide (seulement les enfants peuvent modifier)
    protected void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
    
    // ========== MÉTHODE UTILITAIRE ==========
    private String genererNumeroTransaction() {
        // Génère un ID unique comme "TXN-7b9c4a..."
        return "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
    // ========== MÉTHODE ABSTRAITE ==========
    public abstract void traiterPaiement();
    public abstract double calculerFrais();
    
    // ========== MÉTHODE CONCRÈTE ==========
    public void afficherInfo() {
        System.out.println("=== Détails Paiement ===");
        System.out.println("Transaction : " + numeroTransaction);
        System.out.println("Montant : " + String.format("%.2f", montant) + "€");
        System.out.println("Date : " + date);
        System.out.println("Statut : " + (estValide ? "✅ VALIDE" : "❌ EN ATTENTE"));
        System.out.println("Frais : " + String.format("%.2f", calculerFrais()) + "€");
        System.out.println("========================");
    }
}