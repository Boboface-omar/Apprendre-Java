// Pour Arrays
import java.util.Arrays;

public class ExoM10 {
  public static void main(String[] args) {
    char tableau[] = new char[4]; // Ou char tableau[] = {'a', 'b', 'c', 'd'};

    tableau[0] = 'a';
    tableau[1] = 'b';
    tableau[2] = 'c';
    tableau[3] = 'd';

    System.out.println(Arrays.toString(tableau));
    System.out.println(tableau);

    for (char tab : tableau) {
        System.out.println("-" + tab);
    }
  }
}


// Pour ArrayList
// import java.util.ArrayList;

// public class Main {
//     public static void main(String[] args) {
//         ArrayList<String> eleves = new ArrayList<>();
        
//         eleves.add("Thierno");
//         eleves.add("Djiby");
//         eleves.add("Amadou");
//         eleves.add("Ibou");
        
//         System.out.println(eleves);
//         System.out.println(eleves.get(2));
//         System.out.println(eleves.remove(2));
        
//         String update = eleves.set(0, "Toto");
//         System.out.println(update);
        
//         for (String eleve : eleves) {
//             System.out.println("- " + eleve);
//         }
        
//     }
// }

