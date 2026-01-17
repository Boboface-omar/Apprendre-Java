// Les fichiers en JAVA 
// L'outil : FileWriter ✍️
// En Java, on utilise souvent la classe FileWriter pour écrire du texte. 
// C'est un peu comme ouvrir un bloc-notes et écrire dedans via le code.

// N'oublie pas ces imports tout en haut du fichier !
// import java.io.FileWriter;
// import java.io.IOException;

// try {
//             // 1. On crée le "stylo" pour écrire dans un fichier nommé "sauvegarde.txt"
//             FileWriter writer = new FileWriter("sauvegarde.txt", true); // "true" permet d'ajouter à la suite sans écraser

//             // 2. On écrit les infos (C'est ici que tu joues !)
//             // La méthode s'appelle writer.write("le texte à écrire");
//             // Essaie d'écrire : "Nom : [nom] - Vie : [vie] \n"
//             // (le \n permet de sauter une ligne)
//             _________________________________________________________

//             // 3. On ferme le fichier (Très important !)
//             writer.close();
//             System.out.println("Personnage sauvegardé !");

//         } catch (IOException e) {
//             System.out.println("Erreur lors de l'écriture : " + e.getMessage());
//         }
//     }