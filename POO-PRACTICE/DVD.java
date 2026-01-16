import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DVD extends Document {
    private int dureeMinutes;
    private String realisateur;
    private String type;
    
    // ⚠️ CORRECTION : paramètre "realisateur" mal orthographié
    public DVD(String titre, String auteur, int annee, int dureeMinutes, String realisateur, String type) {
        super(titre, auteur, annee);
        setDureeMinutes(dureeMinutes);
        setRealisateur(realisateur);  // ⚠️ "realisateur" pas "realisateu"
        setType(type);
    }
    
    // ========== GETTERS ==========
    public int getDureeMinutes() {
        return dureeMinutes;
    }
    
    public String getRealisateur() {
        return realisateur;
    }
    
    public String getType() {  // ⚠️ Retourne String, pas int !
        return type;
    }
    
    // ========== SETTERS ==========
    public void setDureeMinutes(int dureeMinutes) {
        if (dureeMinutes <= 0) {
            throw new IllegalArgumentException("La durée doit être positive");
        }
        if (dureeMinutes > 600) {  // 10 heures max (réaliste)
            throw new IllegalArgumentException("Durée invraisemblable (> 600 minutes)");
        }
        this.dureeMinutes = dureeMinutes;
    }
    
    public void setRealisateur(String realisateur) {  // ⚠️ Paramètre "realisateur" pas "titre"
        if (realisateur == null || realisateur.trim().isEmpty()) {
            throw new IllegalArgumentException("Le réalisateur est obligatoire");
        }
        this.realisateur = realisateur.trim();
    }
    
    public void setType(String type) {
        String[] typesValides = {"FILM", "DOCUMENTAIRE", "SERIE"};
        
        // ⚠️ Vérification correcte
        boolean typeValide = false;
        String typeMaj = type != null ? type.trim().toUpperCase() : "";
        
        for (String t : typesValides) {
            if (t.equals(typeMaj)) {
                typeValide = true;
                break;
            }
        }
        
        if (!typeValide) {
            throw new IllegalArgumentException(
                "Type invalide. Types acceptés: " + String.join(", ", typesValides));
        }
        
        this.type = type.trim();
    }
    
    // ========== MÉTHODES UTILITAIRES ==========
    public String getDureeFormatee() {
        int heures = dureeMinutes / 60;
        int minutes = dureeMinutes % 60;
        
        if (heures == 0) {
            return minutes + " min";
        } else if (minutes == 0) {
            return heures + " h";
        } else {
            return heures + " h " + minutes + " min";
        }
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public int calculerDureeEmprunt() {
        // Logique : les séries peuvent être empruntées plus longtemps
        switch (type.toUpperCase()) {
            case "SERIE":
                return 14;  // 2 semaines pour les séries
            case "DOCUMENTAIRE":
                return 10;  // 10 jours pour les documentaires
            case "FILM":
            default:
                return 7;   // 1 semaine pour les films
        }
    }
    
    @Override
    public double calculerAmende(LocalDate dateRetour) {
        LocalDate dateLimite = LocalDate.now().plusDays(calculerDureeEmprunt());
        
        if (dateRetour.isAfter(dateLimite)) {
            long joursRetard = ChronoUnit.DAYS.between(dateLimite, dateRetour);
            
            // Amende pour DVD : 1€ par jour de retard
            // Mais maximum 20€
            double amende = joursRetard * 1.0;
            return Math.min(amende, 20.0);  // Maximum 20€
        }
        return 0.0;
    }
    
    // ========== MÉTHODE SPÉCIFIQUE ==========
    public boolean estLongMetrage() {
        return dureeMinutes >= 60;  // Un long métrage fait au moins 1 heure
    }
    
    // ========== REDÉFINITION DES MÉTHODES ==========
    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("Réalisateur : " + realisateur);
        System.out.println("Type : " + type);
        System.out.println("Durée : " + getDureeFormatee() + 
                         " (" + dureeMinutes + " minutes)");
        System.out.println("Durée emprunt : " + calculerDureeEmprunt() + " jours");
        System.out.println("Long métrage : " + (estLongMetrage() ? "Oui" : "Non"));
    }
    
    @Override
    public String toString() {
        // ⚠️ CORRECTION : "dureeMinutes" pas "dureeMinute"
        return String.format("DVD[titre=%s, auteur=%s, durée=%s, réalisateur=%s, type=%s]", 
                           getTitre(), getAuteur(), getDureeFormatee(), realisateur, type);
    }
}