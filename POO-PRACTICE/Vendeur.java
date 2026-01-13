public class Vendeur extends Employe {  // ⚠️ 'extends' pour héritage
    private double commission;  // en pourcentage (ex: 0.1 = 10%)
    
    // ⚠️ CONSTRUCTEUR : super() en PREMIER
    public Vendeur(String nom, double salaireBase, int anciennete, double commission) {
        super(nom, salaireBase, anciennete);  // ⚠️ Appelle le parent
        setCommission(commission);
    }
    
    // ========== GETTER/SETTER ==========
    public double getCommission() {
        return commission;
    }
    
    public void setCommission(double commission) {
        // ⚠️ Validation spécifique
        if (commission < 0 || commission > 1) {
            throw new IllegalArgumentException("Commission doit être entre 0 et 1 (0-100%)");
        }
        this.commission = commission;
    }
    
    // ========== OVERRIDE (Redéfinition) ==========
    @Override  // ⚠️ TOUJOURS mettre @Override
    public double calculerSalaire() {
        // Salaire parent + commission
        double salaireParent = super.calculerSalaire();  // ⚠️ Appelle la version parent
        return salaireParent + (salaireParent * commission);
    }
    
    // ⚠️ Redéfinir aussi toString()
    @Override
    public String toString() {
        return String.format("Vendeur[%s - %.2f€ - Commission: %.1f%%]", 
                           getNom(), calculerSalaire(), commission * 100);
    }
}