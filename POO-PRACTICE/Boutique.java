import java.util.ArrayList;
import java.util.List;

public class Boutique {
    private List<Paiement> historiquePaiements;
    
    public Boutique() {
        this.historiquePaiements = new ArrayList<>();
    }
    
    public void ajouterPaiement(Paiement p) {
        if (p == null) {
            throw new IllegalArgumentException("Le paiement ne peut pas être null");
        }
        historiquePaiements.add(p);
        System.out.println("➕ Paiement ajouté : " + p.getNumeroTransaction());
    }
    
    public double calculerTotalVentes() {
        double total = 0;
        for (Paiement p : historiquePaiements) {
            if (p.isEstValide()) {  // Seulement les paiements valides
                total += p.getMontant();
            }
        }
        return total;
    }
    
    public double calculerTotalFrais() {
        double totalFrais = 0;
        for (Paiement p : historiquePaiements) {
            if (p.isEstValide()) {
                totalFrais += p.calculerFrais();
            }
        }
        return totalFrais;
    }
    
    public double calculerTotalNet() {
        return calculerTotalVentes() - calculerTotalFrais();
    }
    
    public void traiterTousLesPaiements() {
        System.out.println("\n🔄 Traitement de tous les paiements...");
        for (Paiement p : historiquePaiements) {
            if (!p.isEstValide()) {  // Traite seulement ceux pas encore traités
                p.traiterPaiement();
            }
        }
    }
    
    public void afficherRapport() {
        System.out.println("\n📊 === RAPPORT DE LA BOUTIQUE ===");
        System.out.println("Nombre total de paiements : " + historiquePaiements.size());
        
        // Compter par type
        int carte = 0, paypal = 0, espece = 0, valides = 0;
        for (Paiement p : historiquePaiements) {
            if (p instanceof PaiementCarte) carte++;
            else if (p instanceof PaiementPayPal) paypal++;
            else if (p instanceof PaiementEspece) espece++;
            
            if (p.isEstValide()) valides++;
        }
        
        System.out.println("\n📈 Par type :");
        System.out.println("  - Carte bancaire : " + carte);
        System.out.println("  - PayPal : " + paypal);
        System.out.println("  - Espèces : " + espece);
        
        System.out.println("\n💰 Totaux financiers :");
        System.out.printf("  - Total ventes : %.2f€\n", calculerTotalVentes());
        System.out.printf("  - Total frais : %.2f€\n", calculerTotalFrais());
        System.out.printf("  - Total net : %.2f€\n", calculerTotalNet());
        System.out.printf("  - Taux de réussite : %.1f%%\n", 
                         (historiquePaiements.size() > 0 ? 
                          (valides * 100.0 / historiquePaiements.size()) : 0));
        
        System.out.println("\n📋 Détails des paiements :");
        for (Paiement p : historiquePaiements) {
            System.out.println("  " + p.toString());
        }
        System.out.println("================================\n");
    }
    
    // Getter pour l'historique (utile pour les tests)
    public List<Paiement> getHistoriquePaiements() {
        return new ArrayList<>(historiquePaiements);  // Copie pour encapsulation
    }
}