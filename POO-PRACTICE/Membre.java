import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Membre {
    private static int compteurMembres = 0;  // ⚠️ Static pour générer des IDs uniques
    
    private String numeroMembre;
    private String nom;
    private String prenom;
    private LocalDate dateInscription;
    private List<Document> documentsEmpruntes;  // ⚠️ Convention : pluriel
    
    // ⚠️ CONSTRUCTEUR simplifié : on ne passe pas le numéro, il est généré
    public Membre(String nom, String prenom) {
        this.numeroMembre = genererNumeroMembre();  // Généré automatiquement
        setNom(nom);
        setPrenom(prenom);
        this.dateInscription = LocalDate.now();  // Date du jour
        this.documentsEmpruntes = new ArrayList<>();  // ⚠️ ArrayList, pas List
    }
    
    // ========== GETTERS ==========
    public String getNumeroMembre() {
        return numeroMembre;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public LocalDate getDateInscription() {
        return dateInscription;
    }
    
    public List<Document> getDocumentsEmpruntes() {
        // ⚠️ Retourne une COPIE pour protéger l'encapsulation
        return new ArrayList<>(documentsEmpruntes);
    }
    
    // ========== SETTERS ==========
    // ⚠️ Pas de setter pour numeroMembre (généré une seule fois)
    // ⚠️ Pas de setter pour dateInscription (fixée à la création)
    
    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom est requis");
        }
        if (nom.trim().length() < 2) {
            throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");
        }
        this.nom = nom.trim();
    }
    
    public void setPrenom(String prenom) {  // ⚠️ Paramètre "prenom" pas "nom"
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom est requis");
        }
        if (prenom.trim().length() < 2) {
            throw new IllegalArgumentException("Le prénom doit faire au moins 2 caractères");
        }
        this.prenom = prenom.trim();
    }
    
    // ========== MÉTHODES UTILITAIRES ==========
    private String genererNumeroMembre() {
        compteurMembres++;  // Incrémente le compteur
        int annee = LocalDate.now().getYear();
        // Format : MEM-2024-001, MEM-2024-002, etc.
        return String.format("MEM-%04d-%03d", annee, compteurMembres);
    }
    
    public int getAnciennete() {
        return (int) java.time.temporal.ChronoUnit.YEARS.between(
            dateInscription, LocalDate.now());
    }
    
    // ========== GESTION DES EMPRUNTS ==========
    public boolean peutEmprunter() {
        // Maximum 5 documents par membre
        return documentsEmpruntes.size() < 5;
    }
    
    public boolean aDejaEmprunte(Document doc) {
        if (doc == null) return false;
        
        // Vérifie si le membre a déjà emprunté ce document
        for (Document d : documentsEmpruntes) {
            if (d.equals(doc)) {
                return true;
            }
        }
        return false;
    }
    
    public void emprunterDocument(Document doc) {
        if (doc == null) {
            throw new IllegalArgumentException("Le document ne peut pas être null");
        }
        
        // 1. Vérifier si le membre peut encore emprunter
        if (!peutEmprunter()) {
            throw new IllegalStateException(
                "Le membre a déjà atteint la limite de 5 documents empruntés");
        }
        
        // 2. Vérifier si le membre n'a pas déjà emprunté ce document
        if (aDejaEmprunte(doc)) {
            throw new IllegalStateException(
                "Le membre a déjà emprunté ce document: " + doc.getTitre());
        }
        
        // 3. Ajouter le document à la liste
        documentsEmpruntes.add(doc);
        System.out.println("✅ " + prenom + " a emprunté : " + doc.getTitre());
    }
    
    public boolean retournerDocument(Document doc) {
        if (doc == null) {
            throw new IllegalArgumentException("Le document ne peut pas être null");
        }
        
        // Retirer le document de la liste
        boolean removed = documentsEmpruntes.remove(doc);
        
        if (removed) {
            System.out.println("✅ " + prenom + " a retourné : " + doc.getTitre());
            
            // Calculer l'amende si le retour est en retard
            LocalDate dateRetour = LocalDate.now();
            double amende = doc.calculerAmende(dateRetour);
            
            if (amende > 0) {
                System.out.println("⚠️  Amende à payer : " + amende + "€");
            }
        } else {
            System.out.println("❌ Ce document n'était pas emprunté par " + prenom);
        }
        
        return removed;
    }
    
    public double calculerTotalAmendes(LocalDate dateRetour) {
        double total = 0.0;
        for (Document doc : documentsEmpruntes) {
            total += doc.calculerAmende(dateRetour);
        }
        return total;
    }
    
    // ========== AFFICHAGE ==========
    public void afficherInfo() {
        System.out.println("\n=== FICHE MEMBRE ===");
        System.out.println("Numéro : " + numeroMembre);
        System.out.println("Nom : " + nom.toUpperCase() + " " + prenom);
        System.out.println("Inscription : " + dateInscription);
        System.out.println("Ancienneté : " + getAnciennete() + " an(s)");
        System.out.println("Documents empruntés : " + documentsEmpruntes.size() + "/5");
        System.out.println("Peut encore emprunter : " + (peutEmprunter() ? "Oui" : "Non"));
    }
    
    public void afficherDocumentsEmpruntes() {
        if (documentsEmpruntes.isEmpty()) {
            System.out.println(prenom + " n'a aucun document emprunté.");
            return;
        }
        
        System.out.println("\n=== DOCUMENTS EMPRUNTÉS PAR " + prenom.toUpperCase() + " ===");
        for (int i = 0; i < documentsEmpruntes.size(); i++) {
            Document doc = documentsEmpruntes.get(i);
            System.out.println((i + 1) + ". " + doc.getTitre() + 
                             " (" + doc.getClass().getSimpleName() + ")");
            
            // Afficher la date de retour limite
            LocalDate dateLimite = LocalDate.now().plusDays(doc.calculerDureeEmprunt());
            System.out.println("   Retour avant : " + dateLimite);
            
            // Afficher amende prévisionnelle
            double amende = doc.calculerAmende(dateLimite.plusDays(5));  // Si 5 jours de retard
            if (amende > 0) {
                System.out.println("   Amende si 5 jours de retard : " + amende + "€");
            }
        }
    }
    
    @Override
    public String toString() {
        return String.format("Membre[%s - %s %s - Documents: %d/5]", 
                           numeroMembre, nom, prenom, documentsEmpruntes.size());
    }
}