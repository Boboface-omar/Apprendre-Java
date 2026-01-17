// ================================ UTILISATION DES DATES ET CHRONOS ============================
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class TempsDate {
    public static void main(String[] args) {
        LocalDate dateLimite = LocalDate.of(2024, 3, 1);
        LocalDate dateRetour = LocalDate.now();  // Aujourd'hui
        
        if (dateRetour.isAfter(dateLimite)) {
            long joursRetard = ChronoUnit.DAYS.between(dateLimite, dateRetour);
            double penalite = joursRetard * 2.5;  // 2.5€ par jour
            
            System.out.println(String.format(
                "⚠️ Retard de %d jours\n💰 Pénalité : %.2f€",
                joursRetard, penalite
            ));
        } else {
            System.out.println("✅ Retour dans les temps");
        }
    }
}