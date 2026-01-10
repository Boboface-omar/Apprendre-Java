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
//  ou     setTitre(titre);    // Utilise le setter pour validation
//     }
// }

//                       ENCAPSULATION : cacher les détails internes, exposer seulement ce qui est nécessaire.
// Analogie Simple :
// Imagine une boîte de médicaments :

// ✅ Tu vois : Le nom, la posologie, la date d'expiration

// ❌ Tu ne vois pas : La formule chimique exacte, le processus de fabrication

// ✅ Tu peux : Prendre un comprimé (méthode publique)

// ❌ Tu ne peux pas : Modifier la formule (variables privées)

// Étape 1 : Rendre les variables PRIVÉES
 // PRIVATE = accessible SEULEMENT dans cette classe
    // private String titre;

// Étape 2 : Ajouter des GETTERS (lire)
// Getters - permettent de LIRE les valeurs
// public String getTitre() {
//     return titre;
// }

// Étape 3 : Ajouter des SETTERS avec validation (modifier)
// Setters - permettent de MODIFIER avec contrôle
// public void setTitre(String titre) {
//     if (titre != null && titre.length() > 0) {
//         this.titre = titre;
//     } else {
//         System.out.println("Erreur : titre invalide");
//     }
// }








// C'est parfait. Tu viens de faire ce qu'on appelle du Refactoring : améliorer la structure du code sans changer son résultat visible. 
// C'est une compétence clé ! 🛠️