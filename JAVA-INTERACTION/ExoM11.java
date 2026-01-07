import java.util.Scanner;

public class ExoM11 {
  public static void main(String[] args) {
    Scanner entree = new Scanner(System.in);

    System.out.print("Ecrire : ");
    int nombre1 = Integer.parseInt(entree.nextLine());

    System.out.print("Ecrire : ");
    int nombre2 = Integer.parseInt(entree.nextLine());

    System.out.println("Choix : ");
    String signe = entree.nextLine();

    if (signe.equals("+")) {
      System.out.print(nombre1 + nombre2);
    } else if (signe.equals("-")) {
      System.out.print(nombre1 - nombre2);
    } else if (signe.equals("*")) {
      System.out.print(nombre1 * nombre2);
    } else if (signe.equals("/")) {
      System.out.print(nombre1 / nombre2);
    } else if (signe.equals("%")) {
      System.out.print(nombre1 % nombre2);
    } else {
      System.out.println("Oups Signe invalide.");
    }

    entree.close();

  }
}