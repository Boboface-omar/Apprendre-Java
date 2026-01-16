import java.time.LocalDate;

public class Commerce {
    public static void main(String[] args) {
        System.out.println("🏪 === BOUTIQUE EN LIGNE ===\n");
        
        // 1. Créer une boutique
        Boutique maBoutique = new Boutique();
        
        try {
            // 2. Créer différents types de paiements
            // Carte bancaire (expiration dans 2 ans)
            PaiementCarte paiement1 = new PaiementCarte(
                125.50, 
                "1234567890123456", 
                "BOBO DIALLO", 
                LocalDate.now().plusYears(2)
            );
            
            // PayPal
            PaiementPayPal paiement2 = new PaiementPayPal(
                75.30,
                "bobo.diallo@gmail.com",
                "monMotDePasseSecret"
            );
            
            // Espèces (client donne 50€ pour un achat de 45€)
            PaiementEspece paiement3 = new PaiementEspece(
                45.00,
                50.00
            );
            
            // Autres paiements
            PaiementCarte paiement4 = new PaiementCarte(
                200.00,
                "9876543210987654",
                "ALICE MARTIN",
                LocalDate.now().plusMonths(6)
            );
            
            PaiementPayPal paiement5 = new PaiementPayPal(
                30.00,
                "client@domaine.com",
                "autreMotDePasse"
            );
            
            // 3. Les ajouter à la boutique
            maBoutique.ajouterPaiement(paiement1);
            maBoutique.ajouterPaiement(paiement2);
            maBoutique.ajouterPaiement(paiement3);
            maBoutique.ajouterPaiement(paiement4);
            maBoutique.ajouterPaiement(paiement5);
            
            // 4. Afficher les infos avant traitement
            System.out.println("\n📄 Infos avant traitement :");
            paiement1.afficherInfo();
            
            // 5. Traiter tous les paiements
            maBoutique.traiterTousLesPaiements();
            
            // 6. Afficher un rapport complet
            maBoutique.afficherRapport();
            
            // 7. Tests supplémentaires
            System.out.println("🧪 === TESTS SUPPLÉMENTAIRES ===");
            
            // Test d'erreur : carte expirée
            try {
                PaiementCarte carteExpiree = new PaiementCarte(
                    100.00,
                    "1111222233334444",
                    "TEST",
                    LocalDate.now().minusDays(1)  // Expirée hier !
                );
            } catch (IllegalArgumentException e) {
                System.out.println("Test réussi - Carte expirée détectée : " + e.getMessage());
            }
            
            // Test d'erreur : montant insuffisant en espèces
            try {
                PaiementEspece pasAssez = new PaiementEspece(
                    100.00,
                    80.00  // Pas assez !
                );
                pasAssez.traiterPaiement();
            } catch (Exception e) {
                System.out.println("Test réussi - Montant insuffisant détecté");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Erreur : " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n✅ Programme terminé avec succès !");
    }
}