// Abstraction : abstract
// Imagine que tu es le Maître du Jeu. Tu dis : "Un Personnage entre dans la taverne." Les joueurs vont immédiatement demander : "C'est quoi ? Un Guerrier ? Un Sorcier ? Un Voleur ?"

// Dans la vraie vie (et dans le code), un "Personnage" tout court, ça n'existe pas. C'est juste une idée, un concept général. On ne peut pas fabriquer un "Personnage" générique ; on est obligé de fabriquer un type précis (Guerrier, Mage, etc.).

// C'est ça, une classe abstraite.

// Pour traduire ça en Java, on utilise le mot-clé abstract :
// public abstract class Personnage {
    // ...
// }

// public class Guerrier extends Personnage {
    //...
// }

// Interdiction de créer : Si une classe est abstract, tu ne peux PAS faire new Personnage(). 

// C'est interdit. Tu pourras seulement faire new Guerrier() ou new Mage().

// Méthodes Abstraites (Le contrat) : Tu peux déclarer des actions sans dire comment elles marchent :
// public abstract void nomDeLaMethode(TypeDuParametre nomDuParametre);

// La règle du jeu : Une classe qui hérite d'un parent abstrait doit fournir le code des méthodes abstraites.