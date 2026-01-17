import java.time.LocalDate;
import java.util.UUID;

public class NewConcepteExo {
    public static void main(String[] args) {
        // Génération ID unique
        String id = "USER-" + UUID.randomUUID().toString().substring(0, 6);
        
        // Date d'inscription
        LocalDate dateInscription = LocalDate.now();
        
        // Nettoyage téléphone
        String telephoneBrut = "06 12 34 56 78";
        String telephonePropre = telephoneBrut.replaceAll("\\s+", "");
        
        // Validation email
        String email = "  BOB@GMAIL.COM  ";
        String emailPropre = (email != null) ? email.trim().toLowerCase() : "";
        
        System.out.println(String.format(
            "Inscription :\nID: %s\nDate: %s\nTel: %s\nEmail: %s",
            id, dateInscription, telephonePropre, emailPropre
        ));
    }
}
