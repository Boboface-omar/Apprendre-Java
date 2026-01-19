// Importe la classe JFrame du package javax.swing.
// JFrame est la classe qui nous permet de créer une fenêtre.
import javax.swing.JFrame;

// Déclaration de la classe principale de notre programme.
public class Swing01 {
    
    // La méthode main est le point d'entrée de notre application Java.
    public static void main(String[] args) {
        
        // Crée une nouvelle instance de la classe JFrame.
        // C'est notre fenêtre principale.
        JFrame frame = new JFrame();
        
        // Définit le titre qui s'affichera dans la barre de titre de la fenêtre.
        frame.setTitle("Mon 1er Frame");
        
        // Définit la taille de la fenêtre en pixels (largeur, hauteur).
        frame.setSize(400, 200);
        
        // Indique à l'application de se terminer lorsque l'utilisateur ferme la fenêtre.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Rend la fenêtre visible à l'écran. Sans cette ligne, la fenêtre existe mais n'est pas affichée.
        frame.setVisible(true);
    
    }
}