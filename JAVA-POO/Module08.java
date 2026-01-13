// L'Héritage
// Permet d'éviter de se répéter

// La Syntaxe : extends et super
// "extends" signifie que BD récupère tout ce qu'il y a dans Livre
// public class BD extends Livre {
//     boolean enCouleur;

//     // Le constructeur doit être un peu spécial
//     public BD(String titre, String auteur, int pages, boolean enCouleur) {
//         // 1. D'abord, on construit la partie "Livre" (le parent)
//         super(titre, auteur, pages); 
        
//         // 2. Ensuite, on règle la partie spécifique à la "BD"
//         this.enCouleur = enCouleur;
//     }
// }

// extends Livre : "Je suis un Livre, mais amélioré."

                                                       // Polymorphisme
                                                       

// super(nomDeVariable) : "Envoie ces infos au constructeur du parent (Livre) pour qu'il les gère." : Herite des attributs du parent