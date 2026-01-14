public abstract class ExoM13 {
    
    // 1. Attributs (Encapsulation : private)
    private String nom;
    protected int vie; // 'protected' pour que les enfants (Guerrier) puissent y toucher directement
    
    // 2. Constructeur
    public Personnage(String nom, int vie) {
        this.nom = nom;
        this.vie = vie;
    }

    // Getters
    public String getNom() {
        return nom;
    }
    
    public int getVie() {
        return vie;
    }

    // 3. Méthode Abstraite : Le contrat
    // On attend un objet 'Personnage' complet, pas juste un nom
    public abstract void attaquer(Personnage cible);
}