import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Magazine extends Document {
    private int numero;
    private String periodicite;
    private String editeur;  // ⚠️ Convention : commencer par minuscule
    
    // ⚠️ CORRECTION : "titre" pas "itre", "Editeur" pas "editeur" (attention à la casse)
    public Magazine(String titre, String auteur, int annee, int numero, String periodicite, String editeur) {
        super(titre, auteur, annee);  // ⚠️ "titre" pas "itre"
        setNumero(numero);
        setPeriodicite(periodicite);
        setEditeur(editeur);
    }
    
    // ========== GETTERS ==========
    public int getNumero() {
        return numero;
    }
    
    public String getPeriodicite() {
        return periodicite;
    }
    
    public String getEditeur() {
        return editeur;
    }
    
    // ========== SETTERS ==========
    public void setNumero(int numero) {  // ⚠️ "setNumero" pas "seNumero"
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numéro doit être positif");
        }
        if (numero > 10000) {  // Validation réaliste
            throw new IllegalArgumentException("Numéro trop élevé (> 10000)");
        }
        this.numero = numero;
    }
    
    public void setPeriodicite(String periodicite) {
        if (periodicite == null || periodicite.trim().isEmpty()) {
            throw new IllegalArgumentException("La périodicité est obligatoire");
        }
        
        String[] periodicitesValides = {"MENSUEL", "TRIMESTRIEL", "ANNUEL"};
        String periodiciteMaj = periodicite.trim().toUpperCase();  // ⚠️ "periodicite" pas "genre"
        boolean periodiciteValide = false;
        
        // ⚠️ CORRECTION : boucle avec les bonnes variables
        for (String p : periodicitesValides) {
            if (p.equals(periodiciteMaj)) {  // ⚠️ "p.equals" pas "g.equals"
                periodiciteValide = true;
                break;
            }
        }
        
        // ⚠️ IMPORTANT : cette vérification doit être APRÈS la boucle
        if (!periodiciteValide) {
            throw new IllegalArgumentException(
                "Périodicité invalide. Valides: " + String.join(", ", periodicitesValides));
        }
        
        this.periodicite = periodicite.trim();
    }
    
    public void setEditeur(String editeur) {
        if (editeur == null || editeur.trim().isEmpty()) {
            throw new IllegalArgumentException("L'éditeur est requis");
        }
        this.editeur = editeur.trim();
    }
    
    // ========== MÉTHODES UTILITAIRES ==========
    public String getProchainNumero() {
        // Retourne le numéro formaté
        return String.format("N°%04d", numero);
    }
    
    public boolean estRecent() {
        int anneeCourante = LocalDate.now().getYear();
        return (anneeCourante - getAnnee()) <= 2;  // Moins de 2 ans
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public int calculerDureeEmprunt() {
        // Logique : les magazines récents s'empruntent moins longtemps
        if (estRecent()) {
            return 3;  // 3 jours pour les récents
        } else {
            return 7;  // 1 semaine pour les anciens
        }
    }
    
    @Override
    public double calculerAmende(LocalDate dateRetour) {
        LocalDate dateLimite = LocalDate.now().plusDays(calculerDureeEmprunt());
        
        if (dateRetour.isAfter(dateLimite)) {
            long joursRetard = ChronoUnit.DAYS.between(dateLimite, dateRetour);
            
            // Amende pour magazine : 2€ par jour de retard
            // Mais avec un plafond selon la périodicité
            double amendeParJour = 2.0;
            double amendeTotale = joursRetard * amendeParJour;
            
            // Plafond différent selon la périodicité
            double plafond;
            switch (periodicite.toUpperCase()) {
                case "MENSUEL":
                    plafond = 10.0;  // Max 10€
                    break;
                case "TRIMESTRIEL":
                    plafond = 15.0;  // Max 15€
                    break;
                case "ANNUEL":
                    plafond = 20.0;  // Max 20€
                    break;
                default:
                    plafond = 10.0;
            }
            
            return Math.min(amendeTotale, plafond);
        }
        return 0.0;
    }
    
    // ========== REDÉFINITION DES MÉTHODES ==========
    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("Numéro : " + getProchainNumero());
        System.out.println("Périodicité : " + periodicite);
        System.out.println("Éditeur : " + editeur);
        System.out.println("Récent (< 2 ans) : " + (estRecent() ? "Oui" : "Non"));
        System.out.println("Durée emprunt : " + calculerDureeEmprunt() + " jours");
        System.out.println("===================");
    }
    
    @Override
    public String toString() {
        // ⚠️ CORRECTION : "numero=%d" pas "numero=,"
        return String.format("Magazine[titre=%s, auteur=%s, numero=%d, periodicite=%s, editeur=%s]", 
                           getTitre(), getAuteur(), numero, periodicite, editeur);
    }
}