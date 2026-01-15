// Interface
// Si une Classe Abstraite est un "moule incomplet" (identité : ce que je suis), 
// une Interface est un "contrat de capacité" (comportement : ce que je peux faire).

// En Java : Une interface est une liste de méthodes vides. Si une classe décide d'utiliser ("implémenter") cette interface, 
// elle signe un contrat : elle est obligée de coder toutes les méthodes de la liste.

// La Syntaxe
// On remplace class par interface.
// public interface NomDeLInterface {
//     void uneMethode(); // Pas de code, juste le nom !
// }

// La Règle : Quand une classe implémente une interface, elle doit écrire le code de la méthode promise.
// comportement : ce que je peux faire

// public class Personnage implements Soignable {}