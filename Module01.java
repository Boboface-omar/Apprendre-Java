// 🧠 Concept clé : Comment ton ordinateur comprend Java ?
// Ton ordinateur ne comprend que les 0 et les 1. Le Java est lisible par les humains. Pour faire le lien, Java utilise un processus en deux étapes :
// Compilation : Un traducteur (le javac) transforme ton code (.java) en un code intermédiaire appelé Bytecode (.class).
// Exécution : La JVM (Java Virtual Machine), que tu as installée avec le JDK, lit ce Bytecode et l'exécute sur ton Ubuntu.
// C'est grâce à cette JVM que le slogan de Java existe : "Write Once, Run Anywhere" (Écris une fois, exécute partout).
public class Module01 {
    public static void main(String[] args) {
        System.out.println("Hello, Ubuntu !");
    }
}

// 1. public class Main { ... } :
// Tout code Java vit dans une Classe. Vois la classe comme un conteneur ou un dossier qui regroupe ton code.
// Règle : Le nom de la classe (Main) doit être identique au nom du fichier (Main.java).

// 2. public static void main(String[] args) { ... } :
// C'est la Porte d'entrée. Quand tu lances un programme, 
// Java cherche toujours cette méthode spécifique pour savoir par où commencer. Si elle n'est pas là, rien ne se passe.

// 3. System.out.println("..."); :
// C'est la commande magique pour afficher du texte à l'écran.
// ln à la fin de println signifie "Line New" (Nouvelle ligne). Ça veut dire "Affiche le texte et passe à la ligne suivante".

// 4. ; (Point-virgule) :
// Super Important : En Java, chaque instruction se termine par un point-virgule. 
// C'est comme le point à la fin d'une phrase. L'oublier est l'erreur n°1 des débutants.

// 🛡️ Les Bonnes Pratiques du Professeur
// PascalCase pour les Classes : Une classe commence toujours par une Majuscule (ex: Main, MonProjet, Calculatrice).

// L'indentation : Le code à l'intérieur des accolades { } doit être décalé vers la droite (IntelliJ le fait automatiquement, mais garde-le en tête). Cela rend le code lisible.

// Les accolades : Chaque accolade ouverte { doit être fermée }.