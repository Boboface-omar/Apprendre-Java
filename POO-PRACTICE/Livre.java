import java.time.LocalDate;
import java.time.temporal.ChronoUnit;  // ⚠️ IMPORT MANQUANT !

public class Livre extends Document {
    private int nombrePages;  // ⚠️ "nombrePages" (avec 's')
    private String genre;
    
    // ⚠️ CONSTRUCTEUR : doit s'appeler "Livre" pas "Document" !
    public Livre(String titre, String auteur, int annee, int nombrePages, String genre) {
        super(titre, auteur, annee);  // ⚠️ POINT-VIRGULE manquant
        setNombrePages(nombrePages);  // ⚠️ "setNombrePages" pas "setNombrePage"
        setGenre(genre);
    }
    
    // ========== GETTERS ==========
    public int getNombrePages() {  // ⚠️ "getNombrePages" (avec 's')
        return nombrePages;
    }
    
    public String getGenre() {
        return genre;
    }
    
    // ========== SETTERS ==========
    public void setNombrePages(int nombrePages) {  // ⚠️ "setNombrePages"
        if (nombrePages <= 0) {
            throw new IllegalArgumentException("Le nombre de pages doit être positif");
        }
        if (nombrePages > 5000) {  // ⚠️ Validation supplémentaire réaliste
            throw new IllegalArgumentException("Nombre de pages invraisemblable (> 5000)");
        }
        this.nombrePages = nombrePages;
    }
    
    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Le genre est obligatoire");
        }
        
        // ⚠️ Validation : liste des genres acceptés ====================A reviser====================
        String[] genresValides = {"ROMAN", "POLICIER", "SCIENCE-FICTION", 
                                 "FANTASTIQUE", "HISTORIQUE", "BIOGRAPHIE", 
                                 "DOCUMENTAIRE", "JEUNESSE"};
        
        String genreMaj = genre.trim().toUpperCase();
        boolean genreValide = false;
        
        for (String g : genresValides) {
            if (g.equals(genreMaj)) {
                genreValide = true;
                break;
            }
        }
        
        if (!genreValide) {
            throw new IllegalArgumentException(
                "Genre invalide. Valides: " + String.join(", ", genresValides));
        }
        
        this.genre = genre.trim();
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public int calculerDureeEmprunt() {
        // Logique : plus le livre est gros, plus la durée est longue
        if (nombrePages < 200) {
            return 14;  // 2 semaines pour les petits livres
        } else if (nombrePages < 500) {
            return 21;  // 3 semaines pour les livres moyens
        } else {
            return 28;  // 4 semaines pour les gros livres
        }
    }
    
    @Override
    public double calculerAmende(LocalDate dateRetour) {
        LocalDate dateLimite = LocalDate.now().plusDays(calculerDureeEmprunt());
        
        if (dateRetour.isAfter(dateLimite)) {
            long joursRetard = ChronoUnit.DAYS.between(dateLimite, dateRetour);
            
            // Amende progressive :
            if (joursRetard <= 7) {
                return joursRetard * 0.50;  // 0.50€ par jour (1ère semaine)
            } else if (joursRetard <= 30) {
                return (7 * 0.50) + ((joursRetard - 7) * 1.00);  // 1€ après
            } else {
                return (7 * 0.50) + (23 * 1.00) + ((joursRetard - 30) * 2.00);  // 2€ après 1 mois
            }
        }
        return 0.0;
    }
    
    // ========== MÉTHODE SPÉCIFIQUE ==========
    public String getCategoriePoids() {
        if (nombrePages < 100) return "Léger";
        if (nombrePages < 300) return "Moyen";
        if (nombrePages < 600) return "Lourd";
        return "Très lourd";
    }
    
    // ========== REDÉFINITION DES MÉTHODES ==========
    @Override
    public void afficherInfo() {
        super.afficherInfo();  // ⚠️ Appelle d'abord la version parent
        System.out.println("Pages : " + nombrePages);
        System.out.println("Genre : " + genre);
        System.out.println("Durée emprunt : " + calculerDureeEmprunt() + " jours");
        System.out.println("Catégorie : " + getCategoriePoids());
    }
    
    @Override
    public String toString() {
        return String.format("Livre[titre=%s, auteur=%s, pages=%d, genre=%s]", 
                           getTitre(), getAuteur(), nombrePages, genre);
    }
}