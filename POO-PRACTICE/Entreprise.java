public class Entreprise {
    public static void main(String[] args) {
        System.out.println("=== SYSTÈME DE GESTION ===\n");
        
        try {
            // 1. Création des employés
            Employe emp1 = new Employe("Alice", 2000, 3);
            Vendeur vend1 = new Vendeur("Bob", 1800, 2, 0.15);  // 15% commission
            Manager man1 = new Manager("Charlie", 3000, 5, 500, 3);
            
            // 2. Tableau polymorphe
            System.out.println("--- Tableau Polymorphe ---");
            Employe[] employes = {emp1, vend1, man1};
            
            for (Employe emp : employes) {
                // ⚠️ MAGIE du polymorphisme : chaque objet utilise sa propre version
                System.out.println(emp);  // Appelle toString() approprié
                System.out.printf("Salaire: %.2f€\n", emp.calculerSalaire());
                System.out.println("---");
            }
            
            // 3. Méthodes spécifiques
            System.out.println("\n--- Méthodes Spécifiques ---");
            // emp1.organiserReunion();  // ❌ ERREUR : Employe n'a pas cette méthode
            
            // Cast sécurisé
            if (man1 instanceof Manager) {
                ((Manager) man1).organiserReunion();  // ✅ OK après vérification
            }
            
            // 4. Tests de validation
            System.out.println("\n--- Tests de Validation ---");
            try {
                Vendeur vend2 = new Vendeur("", 1500, 1, 0.2);  // Nom vide
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur attendue: " + e.getMessage());
            }
            
            try {
                vend1.setCommission(1.5);  // Commission > 100%
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur attendue: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}