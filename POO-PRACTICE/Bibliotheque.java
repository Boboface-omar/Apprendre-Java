import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bibliotheque {
    private String nomBibliotheque;
    private List<Document> catalogue;
    private List<Membre> membres;
    
    public Bibliotheque(String nomBibliotheque) {
        setNomBibliotheque(nomBibliotheque);
        this.catalogue = new ArrayList<>();
        this.membres = new ArrayList<>();
        System.out.println("📚 Bibliothèque '" + nomBibliotheque + "' créée !");
    }
    
    // ========== GETTERS ==========
    public String getNomBibliotheque() {
        return nomBibliotheque;
    }
    
    public List<Document> getCatalogue() {
        // Retourne une copie pour protéger l'encapsulation
        return new ArrayList<>(catalogue);
    }
    
    public List<Membre> getMembres() {
        return new ArrayList<>(membres);
    }
    
    public int getNombreDocuments() {
        return catalogue.size();
    }
    
    public int getNombreMembres() {
        return membres.size();
    }
    
    // ========== SETTERS ==========
    public void setNomBibliotheque(String nomBibliotheque) {
        if (nomBibliotheque == null || nomBibliotheque.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la bibliothèque est obligatoire");
        }
        this.nomBibliotheque = nomBibliotheque.trim();
    }
    
    // ========== GESTION DU CATALOGUE ==========
    public void ajouterDocument(Document doc) {
        if (doc == null) {
            throw new IllegalArgumentException("Le document ne peut pas être null");
        }
        
        // Vérifier si le document n'existe pas déjà
        for (Document d : catalogue) {
            if (d.equals(doc)) {
                throw new IllegalArgumentException("Ce document existe déjà dans le catalogue");
            }
        }
        
        catalogue.add(doc);
        System.out.println("➕ Document ajouté au catalogue : " + doc.getTitre());
    }
    
    public boolean supprimerDocument(Document doc) {
        if (doc == null) return false;
        
        // Vérifier si le document n'est pas emprunté
        for (Membre m : membres) {
            if (m.getDocumentsEmpruntes().contains(doc)) {
                System.out.println("❌ Impossible de supprimer : document emprunté par " + m.getPrenom());
                return false;
            }
        }
        
        boolean removed = catalogue.remove(doc);
        if (removed) {
            System.out.println("➖ Document supprimé : " + doc.getTitre());
        }
        return removed;
    }
    
    public List<Document> rechercherDocument(String motCle) {
        if (motCle == null || motCle.trim().isEmpty()) {
            return new ArrayList<>();  // Liste vide
        }
        
        String motCleLower = motCle.trim().toLowerCase();
        List<Document> resultats = new ArrayList<>();
        
        for (Document doc : catalogue) {
            if (doc.getTitre().toLowerCase().contains(motCleLower) ||
                doc.getAuteur().toLowerCase().contains(motCleLower)) {
                resultats.add(doc);
            }
        }
        
        return resultats;
    }
    
    public List<Document> getDocumentsDisponibles() {
        // Récupère tous les documents non empruntés
        List<Document> tousDocuments = new ArrayList<>(catalogue);
        
        // Enlève les documents empruntés
        for (Membre m : membres) {
            tousDocuments.removeAll(m.getDocumentsEmpruntes());
        }
        
        return tousDocuments;
    }
    
    public List<Document> getDocumentsParType(Class<?> type) {
        return catalogue.stream()
                       .filter(type::isInstance)
                       .collect(Collectors.toList());
    }
    
    // ========== GESTION DES MEMBRES ==========
    public void inscrireMembre(Membre m) {
        if (m == null) {
            throw new IllegalArgumentException("Le membre ne peut pas être null");
        }
        
        // Vérifier si le membre n'est pas déjà inscrit
        for (Membre membre : membres) {
            if (membre.getNumeroMembre().equals(m.getNumeroMembre())) {
                throw new IllegalArgumentException("Ce membre est déjà inscrit");
            }
        }
        
        membres.add(m);
        System.out.println("👤 Membre inscrit : " + m.getPrenom() + " " + m.getNom() +
                          " (" + m.getNumeroMembre() + ")");
    }
    
    public boolean desinscrireMembre(Membre m) {
        if (m == null) return false;
        
        // Vérifier si le membre a des documents empruntés
        if (!m.getDocumentsEmpruntes().isEmpty()) {
            System.out.println("❌ Impossible de désinscrire : membre a encore " +
                             m.getDocumentsEmpruntes().size() + " document(s) emprunté(s)");
            return false;
        }
        
        boolean removed = membres.remove(m);
        if (removed) {
            System.out.println("👋 Membre désinscrit : " + m.getPrenom() + " " + m.getNom());
        }
        return removed;
    }
    
    public Membre trouverMembre(String numeroMembre) {
        for (Membre m : membres) {
            if (m.getNumeroMembre().equals(numeroMembre)) {
                return m;
            }
        }
        return null;  // Non trouvé
    }
    
    // ========== GESTION DES EMPRUNTS ==========
    public void emprunterDocument(Membre membre, Document document) {
        if (membre == null || document == null) {
            throw new IllegalArgumentException("Membre et document sont obligatoires");
        }
        
        // 1. Vérifier que le membre est inscrit
        if (!membres.contains(membre)) {
            throw new IllegalStateException("Le membre n'est pas inscrit à la bibliothèque");
        }
        
        // 2. Vérifier que le document est dans le catalogue
        if (!catalogue.contains(document)) {
            throw new IllegalStateException("Le document n'est pas dans le catalogue");
        }
        
        // 3. Vérifier que le document est disponible
        if (!getDocumentsDisponibles().contains(document)) {
            throw new IllegalStateException("Le document est déjà emprunté");
        }
        
        // 4. Procéder à l'emprunt
        try {
            membre.emprunterDocument(document);
            System.out.println("📖 Emprunt enregistré : " + membre.getPrenom() +
                             " a emprunté '" + document.getTitre() + "'");
        } catch (IllegalStateException e) {
            System.out.println("❌ Échec de l'emprunt : " + e.getMessage());
        }
    }
    
    public void retournerDocument(Membre membre, Document document) {
        if (membre == null || document == null) {
            throw new IllegalArgumentException("Membre et document sont obligatoires");
        }
        
        // 1. Vérifier que le membre a bien emprunté ce document
        if (!membre.getDocumentsEmpruntes().contains(document)) {
            System.out.println("❌ " + membre.getPrenom() + " n'a pas emprunté ce document");
            return;
        }
        
        // 2. Procéder au retour
        boolean retourne = membre.retournerDocument(document);
        
        if (retourne) {
            System.out.println("📚 Retour enregistré : " + document.getTitre() +
                             " a été retourné à la bibliothèque");
        }
    }
    
    // ========== STATISTIQUES ET RAPPORTS ==========
    public double calculerTauxEmprunt() {
        if (catalogue.isEmpty()) return 0.0;
        
        int totalDocumentsEmpruntes = 0;
        for (Membre m : membres) {
            totalDocumentsEmpruntes += m.getDocumentsEmpruntes().size();
        }
        
        return (double) totalDocumentsEmpruntes / catalogue.size() * 100;
    }
    
    public void afficherStatistiques() {
        System.out.println("\n📊 === STATISTIQUES DE '" + nomBibliotheque.toUpperCase() + "' ===");
        System.out.println("📚 Documents au catalogue : " + catalogue.size());
        System.out.println("👥 Membres inscrits : " + membres.size());
        
        // Documents par type
        int livres = getDocumentsParType(Livre.class).size();
        int dvds = getDocumentsParType(DVD.class).size();
        int magazines = getDocumentsParType(Magazine.class).size();
        
        System.out.println("\n📈 Répartition des documents :");
        System.out.println("   - Livres : " + livres + " (" + 
                         String.format("%.1f", (double)livres/catalogue.size()*100) + "%)");
        System.out.println("   - DVDs : " + dvds + " (" + 
                         String.format("%.1f", (double)dvds/catalogue.size()*100) + "%)");
        System.out.println("   - Magazines : " + magazines + " (" + 
                         String.format("%.1f", (double)magazines/catalogue.size()*100) + "%)");
        
        // Documents disponibles vs empruntés
        int disponibles = getDocumentsDisponibles().size();
        int empruntes = catalogue.size() - disponibles;
        
        System.out.println("\n📖 État des documents :");
        System.out.println("   - Disponibles : " + disponibles);
        System.out.println("   - Empruntés : " + empruntes);
        System.out.println("   - Taux d'emprunt : " + 
                         String.format("%.1f", calculerTauxEmprunt()) + "%");
        
        // Membres les plus actifs
        System.out.println("\n🏆 Membres les plus actifs :");
        membres.stream()
               .sorted((m1, m2) -> Integer.compare(
                   m2.getDocumentsEmpruntes().size(), 
                   m1.getDocumentsEmpruntes().size()))
               .limit(3)
               .forEach(m -> System.out.println("   - " + m.getPrenom() + " " + m.getNom() + 
                       " : " + m.getDocumentsEmpruntes().size() + " document(s)"));
        
        System.out.println("========================================\n");
    }
    
    public void afficherCatalogueComplet() {
        System.out.println("\n📚 === CATALOGUE COMPLET ===");
        if (catalogue.isEmpty()) {
            System.out.println("Le catalogue est vide.");
            return;
        }
        
        for (int i = 0; i < catalogue.size(); i++) {
            Document doc = catalogue.get(i);
            System.out.println((i + 1) + ". " + doc.getTitre() + 
                             " par " + doc.getAuteur() + 
                             " [" + doc.getClass().getSimpleName() + "]");
            
            // Indiquer si disponible
            if (getDocumentsDisponibles().contains(doc)) {
                System.out.println("   ✅ Disponible");
            } else {
                System.out.println("   ❌ Emprunté");
            }
        }
        System.out.println("============================\n");
    }
    
    public void afficherMembres() {
        System.out.println("\n👥 === MEMBRES INSCRITS ===");
        if (membres.isEmpty()) {
            System.out.println("Aucun membre inscrit.");
            return;
        }
        
        for (Membre m : membres) {
            System.out.println("• " + m.getNumeroMembre() + " - " + 
                             m.getPrenom() + " " + m.getNom() + 
                             " (" + m.getDocumentsEmpruntes().size() + "/5 documents)");
        }
        System.out.println("==========================\n");
    }
    
    @Override
    public String toString() {
        return String.format("Bibliotheque[nom=%s, documents=%d, membres=%d]", 
                           nomBibliotheque, catalogue.size(), membres.size());
    }
}