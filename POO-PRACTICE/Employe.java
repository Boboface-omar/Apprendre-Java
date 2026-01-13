public class Employe {
    // ⚠️ TOUJOURS 'private' pour l'encapsulation
    private String nom;
    private double salaireBase;
    private int anciennete;  // en années
    
    // ⚠️ CONSTRUCTEUR avec TOUS les paramètres nécessaires
    public Employe(String nom, double salaireBase, int anciennete) {
        // ⚠️ TOUJOURS utiliser les setters pour validation
        setNom(nom);
        setSalaireBase(salaireBase);
        setAnciennete(anciennete);
    }
    
    // ========== GETTERS ==========
    public String getNom() {
        return nom;
    }
    
    public double getSalaireBase() {
        return salaireBase;
    }
    
    public int getAnciennete() {
        return anciennete;
    }
    
    // ========== SETTERS avec validation ==========
    public void setNom(String nom) {
        // ⚠️ TOUJOURS vérifier null ET empty
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        // ⚠️ TOUJOURS trim() pour enlever les espaces
        this.nom = nom.trim();
    }
    
    public void setSalaireBase(double salaireBase) {
        // ⚠️ TOUJOURS valider les nombres
        if (salaireBase < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        }
        this.salaireBase = salaireBase;
    }
    
    public void setAnciennete(int anciennete) {
        if (anciennete < 0) {
            throw new IllegalArgumentException("L'ancienneté ne peut pas être négative");
        }
        this.anciennete = anciennete;
    }
    
    // ========== MÉTHODE POLYMORPHE ==========
    public double calculerSalaire() {
        // Salaire de base + prime d'ancienneté (5% par an)
        return salaireBase * (1 + anciennete * 0.05);
    }
    
    // ========== MÉTHODE COMMUNE ==========
    public void afficherFiche() {
        System.out.println("=== Fiche Employé ===");
        System.out.println("Nom: " + nom);
        System.out.println("Salaire: " + calculerSalaire() + "€");
        System.out.println("Ancienneté: " + anciennete + " ans");
    }
    
    // ⚠️ TOUJOURS implémenter toString()
    @Override
    public String toString() {
        return String.format("Employe[%s - %.2f€ - %d ans]", 
                           nom, calculerSalaire(), anciennete);
    }
}