
public class Lecteur {
    public static void main(String[] args) {
        System.out.println("🏛️ === SYSTÈME DE GESTION DE BIBLIOTHÈQUE ===\n");
        
        try {
            // 1. Création de la bibliothèque
            Bibliotheque bibliotheque = new Bibliotheque("Bibliothèque Municipale de Paris");
            
            // 2. Création et ajout de documents
            System.out.println("\n📥 === AJOUT DES DOCUMENTS ===");
            
            Livre livre1 = new Livre("Le Petit Prince", "Saint-Exupéry", 1943, 96, "ROMAN");
            Livre livre2 = new Livre("1984", "George Orwell", 1949, 328, "SCIENCE-FICTION");
            Livre livre3 = new Livre("Java pour les nuls", "Barry Burd", 2020, 450, "DOCUMENTAIRE");
            
            DVD dvd1 = new DVD("Inception", "Christopher Nolan", 2010, 148, 
                              "Christopher Nolan", "FILM");
            DVD dvd2 = new DVD("Planète Terre", "BBC", 2006, 600, 
                              "Alastair Fothergill", "DOCUMENTAIRE");
            
            Magazine mag1 = new Magazine("Science et Vie", "Rédaction", 2023, 1250, 
                                        "MENSUEL", "Excelsior Publications");
            Magazine mag2 = new Magazine("National Geographic", "Rédaction", 2022, 789, 
                                        "MENSUEL", "National Geographic Society");
            
            // Ajout au catalogue
            bibliotheque.ajouterDocument(livre1);
            bibliotheque.ajouterDocument(livre2);
            bibliotheque.ajouterDocument(livre3);
            bibliotheque.ajouterDocument(dvd1);
            bibliotheque.ajouterDocument(dvd2);
            bibliotheque.ajouterDocument(mag1);
            bibliotheque.ajouterDocument(mag2);
            
            // 3. Inscription des membres
            System.out.println("\n👤 === INSCRIPTION DES MEMBRES ===");
            
            Membre membre1 = new Membre("Diallo", "Bobo");
            Membre membre2 = new Membre("Martin", "Alice");
            Membre membre3 = new Membre("Dupont", "Jean");
            
            bibliotheque.inscrireMembre(membre1);
            bibliotheque.inscrireMembre(membre2);
            bibliotheque.inscrireMembre(membre3);
            
            // 4. Gestion des emprunts
            System.out.println("\n📖 === GESTION DES EMPRUNTS ===");
            
            // Bobo emprunte 2 documents
            bibliotheque.emprunterDocument(membre1, livre1);
            bibliotheque.emprunterDocument(membre1, dvd1);
            
            // Alice emprunte 1 document
            bibliotheque.emprunterDocument(membre2, livre2);
            
            // Tentative d'emprunt d'un document déjà emprunté
            try {
                bibliotheque.emprunterDocument(membre3, livre1);
            } catch (IllegalStateException e) {
                System.out.println("✅ Test réussi : " + e.getMessage());
            }
            
            // 5. Recherche de documents
            System.out.println("\n🔍 === RECHERCHE DE DOCUMENTS ===");
            System.out.println("Recherche 'Java' :");
            bibliotheque.rechercherDocument("Java").forEach(doc -> 
                System.out.println("   - " + doc.getTitre()));
            
            System.out.println("\nRecherche 'Science' :");
            bibliotheque.rechercherDocument("Science").forEach(doc -> 
                System.out.println("   - " + doc.getTitre()));
            
            // 6. Affichage des statistiques
            bibliotheque.afficherStatistiques();
            
            // 7. Affichage du catalogue
            bibliotheque.afficherCatalogueComplet();
            
            // 8. Affichage des membres
            bibliotheque.afficherMembres();
            
            // 9. Test de retour
            System.out.println("\n📚 === TEST DE RETOUR ===");
            
            // Simulation d'un retour avec retard
            System.out.println("Simulation d'un retour avec 10 jours de retard...");
            
            // On ne peut pas simuler facilement le temps dans ce test,
            // mais la logique est prête dans les classes
            
            bibliotheque.retournerDocument(membre1, livre1);
            
            // 10. Statistiques après retour
            System.out.println("\n📊 === STATISTIQUES APRÈS RETOUR ===");
            bibliotheque.afficherStatistiques();
            
            // 11. Tests de validation
            System.out.println("\n🧪 === TESTS DE VALIDATION ===");
            
            try {
                // Test : document avec titre vide
                Livre livreInvalide = new Livre("", "Auteur", 2020, 100, "ROMAN");
            } catch (IllegalArgumentException e) {
                System.out.println("✅ Test 1 réussi : " + e.getMessage());
            }
            
            try {
                // Test : membre avec nom vide
                Membre membreInvalide = new Membre("", "Test");
            } catch (IllegalArgumentException e) {
                System.out.println("✅ Test 2 réussi : " + e.getMessage());
            }
            
            try {
                // Test : DVD avec type invalide
                DVD dvdInvalide = new DVD("Test", "Réalisateur", 2020, 120, 
                                         "Réalisateur", "INVALIDE");
            } catch (IllegalArgumentException e) {
                System.out.println("✅ Test 3 réussi : " + e.getMessage());
            }
            
            // 12. Test des limites
            System.out.println("\n⚠️ === TEST DES LIMITES ===");
            
            // Essayer d'emprunter plus que la limite
            System.out.println("Tentative d'emprunter 6 documents...");
            
            // Créer plus de documents
            for (int i = 1; i <= 6; i++) {
                Livre livre = new Livre("Livre Test " + i, "Auteur " + i, 
                                       2000 + i, 200, "ROMAN");
                bibliotheque.ajouterDocument(livre);
            }
            
            // Bobo essaie d'emprunter 6 documents (limite 5)
            int documentsEmpruntes = 0;
            for (int i = 3; i <= 8; i++) {
                try {
                    Document doc = bibliotheque.rechercherDocument("Test " + i).get(0);
                    bibliotheque.emprunterDocument(membre1, doc);
                    documentsEmpruntes++;
                } catch (IllegalStateException e) {
                    System.out.println("✅ Limite atteinte au " + documentsEmpruntes + "ème document : " + e.getMessage());
                    break;
                }
            }
            
            System.out.println("\n🎉 === PROGRAMME TERMINÉ AVEC SUCCÈS ! ===");
            System.out.println("Résumé : " + bibliotheque.toString());
            
        } catch (Exception e) {
            System.out.println("\n❌ ERREUR : " + e.getMessage());
            e.printStackTrace();
        }
    }
}