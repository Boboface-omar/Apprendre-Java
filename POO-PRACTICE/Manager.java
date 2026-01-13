public class Manager extends Employe {
    private double prime;
    private int nombreSubordonnes;
    
    public Manager(String nom, double salaireBase, int anciennete, 
                   double prime, int nombreSubordonnes) {
        super(nom, salaireBase, anciennete);
        setPrime(prime);
        setNombreSubordonnes(nombreSubordonnes);
    }
    
    // ========== GETTERS/SETTERS ==========
    public double getPrime() {
        return prime;
    }
    
    public void setPrime(double prime) {
        if (prime < 0) {
            throw new IllegalArgumentException("La prime ne peut pas être négative");
        }
        this.prime = prime;
    }
    
    public int getNombreSubordonnes() {
        return nombreSubordonnes;
    }
    
    public void setNombreSubordonnes(int nombreSubordonnes) {
        if (nombreSubordonnes < 0) {
            throw new IllegalArgumentException("Nombre de subordonnés invalide");
        }
        this.nombreSubordonnes = nombreSubordonnes;
    }
    
    // ========== OVERRIDE ==========
    @Override
    public double calculerSalaire() {
        // Salaire parent + prime + bonus par subordonné
        double salaireBase = super.calculerSalaire();
        double bonusSubordonnes = nombreSubordonnes * 50;  // 50€ par subordonné
        return salaireBase + prime + bonusSubordonnes;
    }
    
    // Méthode spécifique au Manager
    public void organiserReunion() {
        System.out.println(getNom() + " organise une réunion avec " + 
                          nombreSubordonnes + " subordonnés");
    }
    
    @Override
    public String toString() {
        return String.format("Manager[%s - %.2f€ - Prime: %.2f - Subordonnés: %d]", 
                           getNom(), calculerSalaire(), prime, nombreSubordonnes);
    }
}