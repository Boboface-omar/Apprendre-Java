import java.time.LocalDate;

public abstract class Document {
    private String titre;
    private String auteur;
    private int annee;
    
    public Document(String titre, String auteur, int annee) {
        setTitre(titre);
        setAuteur(auteur);
        setAnnee(annee);
    }
    
    // ========== GETTERS ==========
    public String getTitre() {
        return titre;
    }
    
    public String getAuteur() {
        return auteur;
    }
    
    public int getAnnee() {
        return annee;
    }
    
    // ========== SETTERS ==========
    public void setTitre(String titre) {
        if (titre == null || titre.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre est obligatoire");
        }
        this.titre = titre.trim();  // ⚠️ Ajoute .trim() pour nettoyer
    }
    
    public void setAuteur(String auteur) {
        if (auteur == null || auteur.trim().isEmpty()) {
            throw new IllegalArgumentException("L'auteur est obligatoire");
        }
        this.auteur = auteur.trim();  // ⚠️ Ajoute .trim()
    }
    
    public void setAnnee(int annee) {
        int anneeCourante = LocalDate.now().getYear();
        
        if (annee <= 0) {
            throw new IllegalArgumentException("L'année doit être positive");
        }
        if (annee > anneeCourante + 1) {  // +1 pour accepter l'année prochaine
            throw new IllegalArgumentException(
                String.format("L'année ne peut pas être dans le futur (max %d)", 
                            anneeCourante + 1));
        }
        this.annee = annee;  // ⚠️ NE PAS ajouter +1 !
    }
    
    // ========== MÉTHODES ABSTRAITES ==========
    public abstract int calculerDureeEmprunt();
    public abstract double calculerAmende(LocalDate dateRetour);
    
    // ========== MÉTHODE CONCRÈTE ==========
    public void afficherInfo() {  // ⚠️ "afficherInfo" pas "Affichage" (convention camelCase)
        System.out.println("\n=== Détails du Document ===");
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("Année : " + annee);
        System.out.println("Type : " + this.getClass().getSimpleName());  // ⚠️ Ajouté
        System.out.println("===========================");
    }
    
    // ========== REDÉFINITION toString() ==========
    @Override  // ⚠️ "@Override" avec 'O' majuscule, pas "@override"
    public String toString() {
        return String.format("Document[titre=%s, auteur=%s, annee=%d]", 
                           titre, auteur, annee);
    }
}