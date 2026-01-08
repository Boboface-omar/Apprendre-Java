// La Boîte à Outils (Les Collections) : ArrayList
// En programmation, quand on veut stocker une liste d'objets sans savoir à l'avance combien il y en aura, on utilise une Collection. 
// La plus célèbre est l'ArrayList.

// Contrairement à un tableau classique (qui a une taille fixe), l'ArrayList est élastique : 
// elle grandit au fur et à mesure que tu ajoutes des choses.

// La Syntaxe
// Pour l'utiliser, il faut d'abord l'importer (c'est un outil qui n'est pas ouvert par défaut).

// import java.util.ArrayList; // À mettre tout en haut du fichier Main.java

// ... dans le main :
// Création d'une liste vide capable de contenir des objets 'Livre'
// ArrayList<Livre> maBibliotheque = new ArrayList<>();

// Les commandes principales sont :

// maBibliotheque.add(unLivre) : Ajouter un livre.

// maBibliotheque.size() : Connaitre la taille de la liste.

// maBibliotheque.get(0) : Récupérer le premier livre (l'index commence à 0).

// maBibliotheque.remove(0) : Supprime le premier livre (l'index commence à 0).

// maBibliotheque.set(0, Toto) : Met a jour le premier livre (l'index commence à 0).

// Parcourir la liste
        // System.out.println("\nTous les livres :");
        // for (String livre : maBibliotheque) {
        //     System.out.println("- " + livre);
        // }

// Tableaux : 1. import java.util.Arrays; Importer
//            2. int tableau[] = new int[4] ou int tableau[] = {1, 2, 3}  ; Creer
//            3. tableau[0] = 1 ; Affecter
//            4. System.out.println(tableau[0]); Afficher un element du tableau par son index
//            5. Methodes : Arrays.toString(tableau); Arrays.sort(tableau) : Trier; Arrays.binarySearch(tableau, valeurRechercher) : Chercher 
//               un element dans un tableau. Cette méthode nécessite deux arguments : le tableau ET l'élément à rechercher.; 
//               IMPORTANT : binarySearch nécessite un tableau TRIÉ
//            6. tableau.length : Donne la taille du tableau
// Les tableaux en Java ne peuvent pas être affichés directement avec println(), il faut utiliser Arrays.toString(nomduTableau);