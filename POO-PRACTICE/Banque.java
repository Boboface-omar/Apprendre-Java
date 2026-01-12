public class Banque {
    public static void main(String[] args) {
        try {
            // Création des comptes avec validation
            CompteBancaire client1 = new CompteBancaire("1738", 5000.50, "Bobo Diallo");
            CompteBancaire client2 = new CompteBancaire("2000", 1000.00, "Alice Martin");
            
            // Test des fonctionnalités
            System.out.println("=== Initialisation ===");
            client1.afficherInfo();
            
            System.out.println("=== Opérations ===");
            client1.deposer(500.25);
            client1.retirer(200.75);
            
            // Tentative de retrait trop important
            client1.retirer(10000.00);
            
            System.out.println("=== Virement ===");
            client1.virerVers(client2, 300.00);
            client2.afficherInfo();
            
            System.out.println("=== Tests de validation ===");
            // Test des setters avec validation
            client1.setProprietaire("Bobo Diallo Jr.");  // OK
            System.out.println("Nouveau propriétaire: " + client1.getProprietaire());
            
            // Test d'erreur
            try {
                client1.setSolde(-100);  // ERREUR!
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur attendue: " + e.getMessage());
            }
            
            // Test création invalide
            try {
                CompteBancaire compteInvalide = new CompteBancaire("", -100, "A");
            } catch (IllegalArgumentException e) {
                System.out.println("Création bloquée: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}