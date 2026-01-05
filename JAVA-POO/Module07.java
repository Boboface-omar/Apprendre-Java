// 🏗️ Le Constructeur
// Le constructeur est une méthode spéciale qui s'active automatiquement au moment où tu fais new. 
// C'est comme remplir le bon de commande à l'usine : tu donnes toutes les infos d'un coup, et l'objet sort tout prêt.

// Règle d'or :
// Il porte exactement le même nom que la classe.

// Il n'a pas de type de retour (pas même void).

// 🔑 Le mot-clé this
// Quand on écrit un constructeur, on donne souvent aux paramètres le même nom que les attributs (ex: titre et titre). 
// Pour que Java ne s'embrouille pas, on utilise this.

// this.titre = L'attribut de cet objet (la variable de la classe).

// titre = Le paramètre qu'on vient de te passer (la valeur temporaire).

// public class Voiture {
//     String couleur;

//     // Le Constructeur
//     public Voiture(String couleur) {
//         this.couleur = couleur; // Je mets la couleur reçue dans l'attribut de la voiture
//     }
// }

// C'est parfait. Tu viens de faire ce qu'on appelle du Refactoring : améliorer la structure du code sans changer son résultat visible. 
// C'est une compétence clé ! 🛠️