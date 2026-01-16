// ================================= Explications Simples des Nouveaux Concepts 🎯 =========================================

// 1. java.time.LocalDate - Gestion moderne des dates 📅
// Une nouvelle API (Java 8+) pour gérer les dates, beaucoup mieux que l'ancien Date.

// Cas d'utilisation simples :
// 1. Date actuelle
// LocalDate aujourdhui = LocalDate.now();

// 2. Créer une date spécifique
// LocalDate monAnniversaire = LocalDate.of(2000, 8, 23);  // 23 août 2000

// 3. Ajouter/soustraire des jours
// LocalDate dans10Jours = aujourdhui.plusDays(10);
// LocalDate ilYAMois = aujourdhui.minusMonths(1);

// 4. Comparer des dates
// if (monAnniversaire.isBefore(aujourdhui)) {
//     System.out.println("Mon anniversaire est passé");
// }

// 5. Vérifier si une date est dans le futur
// LocalDate expiration = LocalDate.of(2025, 12, 31);
// if (expiration.isAfter(LocalDate.now())) {
//     System.out.println("Valide");
// }


// 2. UUID - Identifiants uniques 🔑
// Un moyen de générer des identifiants uniques (comme un numéro de série).

// Cas d'utilisation :
// import java.util.UUID;

// Génère un ID unique comme "f47ac10b-58cc-4372-a567-0e02b2c3d479"
// UUID id = UUID.randomUUID();
// String numeroTransaction = "TXN-" + id.toString().substring(0, 8).toUpperCase();
// Résultat : "TXN-F47AC10B"

// Utilisations courantes :
// - Numéro de transaction bancaire
// - ID de session utilisateur  
// - Référence de commande
// - Token d'authentification


// 3. replaceAll("\\s+", "") - Nettoyer les espaces 🧹
// Supprime tous les espaces d'une chaîne.

// Différence avec trim() :
// String texte = "  Hello   World  ";

// trim() : enlève seulement AU DÉBUT et À LA FIN
// texte.trim() → "Hello   World"

// replaceAll("\\s+", "") : enlève TOUS les espaces
// texte.replaceAll("\\s+", "") → "HelloWorld"

// Cas pratique :
// String telephone = "06 12 34 56 78";
// telephone.replaceAll("\\s+", "") → "0612345678"


// 4. Thread.sleep() - Pause dans le programme ⏸️
// Met le programme en pause pendant un certain temps.

// Cas d'utilisation :
// Simulation d'un chargement
// System.out.println("Chargement...");
// try {
//     Thread.sleep(2000);  // Pause de 2 secondes (2000 millisecondes)
// } catch (InterruptedException e) {
//     // Gère l'interruption (si on arrête le programme pendant le sleep)
//     System.out.println("Chargement interrompu");
// }
// System.out.println("Terminé !");

// // Autre exemple : simulation de traitement
// System.out.println("Traitement en cours...");
// Thread.sleep(500);  // 0.5 seconde

// ⚠️ Important :
// Toujours mettre dans un try-catch car sleep() peut être interrompu.


// 5. Math.random() - Génération aléatoire 🎲
// Génère un nombre aléatoire entre 0.0 (inclus) et 1.0 (exclus).

// Cas d'utilisation :
// Génère un nombre entre 0.0 et 1.0
// double chance = Math.random();  // Ex: 0.456, 0.789, 0.123

// // Simulation d'une chance sur 2 (50%)
// if (Math.random() < 0.5) {
//     System.out.println("Pile !");
// } else {
//     System.out.println("Face !");
// }

// // Simulation avec 90% de réussite
// if (Math.random() > 0.1) {  // > 0.1 = 90% de chance
//     System.out.println("Réussi !");
// } else {
//     System.out.println("Échoué !");
// }

// // Générer un nombre entre 1 et 100
// int nombre = (int)(Math.random() * 100) + 1;


// 6. String.format() - Formatage de texte ✨
// Formate une chaîne de manière propre et lisible.

// Comparaison :
// ❌ Sans format (moche et compliqué)
// String message = "Bonjour " + nom + ", vous avez " + age + " ans et " + argent + "€";

// // ✅ Avec format (propre)
// String message = String.format("Bonjour %s, vous avez %d ans et %.2f€", 
//                               nom, age, argent);

// Spécificateurs courants :
// %s  → String           ("Bonjour %s", "Bob") → "Bonjour Bob"
// %d  → int              ("Age: %d", 23) → "Age: 23"
// %f  → float/double     ("Prix: %.2f€", 19.99) → "Prix: 19.99€"
// %04d → int avec zéros  ("N°%04d", 7) → "N°0007"


// 7. ChronoUnit - Calcul de durées ⏱️
// Calcule la différence entre deux dates.

// Cas d'utilisation :
// import java.time.LocalDate;
// import java.time.temporal.ChronoUnit;

// LocalDate debut = LocalDate.of(2024, 1, 1);
// LocalDate fin = LocalDate.of(2024, 1, 15);

// // Différence en jours
// long jours = ChronoUnit.DAYS.between(debut, fin);  // 14

// // Différence en mois
// long mois = ChronoUnit.MONTHS.between(debut, fin);  // 0

// // Différence en années
// long annees = ChronoUnit.YEARS.between(debut, fin);  // 0

// // Application : calcul d'amende
// LocalDate dateLimite = LocalDate.now().plusDays(7);
// LocalDate dateRetour = LocalDate.now().plusDays(10);

// if (dateRetour.isAfter(dateLimite)) {
//     long retard = ChronoUnit.DAYS.between(dateLimite, dateRetour);
//     double amende = retard * 0.50;  // 0.50€ par jour
// }

// 8. String.join() - Concaténation intelligente 🔗
// Réunit plusieurs chaînes avec un séparateur.

// Cas pratiques :
// Liste d'erreurs
// String[] erreurs = {"Email invalide", "Mot de passe trop court", "Nom vide"};
// String message = String.join("\n- ", erreurs);
// // Résultat :
// // Email invalide
// // - Mot de passe trop court  
// // - Nom vide

// // Création de chemin
// String dossier = String.join("/", "home", "utilisateur", "documents");
// // "home/utilisateur/documents"

// // Affichage d'options
// String[] options = {"MENSUEL", "TRIMESTRIEL", "ANNUEL"};
// System.out.println("Options: " + String.join(", ", options));
// // "Options: MENSUEL, TRIMESTRIEL, ANNUEL"


// 9. try-catch - Gestion des erreurs 🛡️
// Attrape et gère les erreurs au lieu de faire planter le programme.

// Structure :
// try {
//     // Code qui peut planter
//     int resultat = 10 / 0;  // Division par zéro !
// } catch (ArithmeticException e) {
//     // Que faire si ça plante
//     System.out.println("Erreur : division par zéro !");
//     System.out.println("Message : " + e.getMessage());
// }

// Cas pratiques :
// 1. Conversion de String en int
// try {
//     String texte = "123abc";
//     int nombre = Integer.parseInt(texte);  // ❌ Plantera
// } catch (NumberFormatException e) {
//     System.out.println("Ce n'est pas un nombre valide");
// }

// // 2. Fichier inexistant
// try {
//     File fichier = new File("inexistant.txt");
//     Scanner scanner = new Scanner(fichier);  // ❌ Plantera
// } catch (FileNotFoundException e) {
//     System.out.println("Fichier non trouvé");
// }

// // 3. Validation métier
// try {
//     if (age < 0) {
//         throw new IllegalArgumentException("L'âge ne peut pas être négatif");
//     }
// } catch (IllegalArgumentException e) {
//     System.out.println("Erreur : " + e.getMessage());
// }


// 10. ? : - Opérateur ternaire ❓
// Un if-else en une seule ligne.

// Syntaxe :
// condition ? valeurSiVrai : valeurSiFaux

// Cas pratiques :
// Vérification de null
// String nom = (input != null) ? input : "Inconnu";

// // Simplifié avec Objects.requireNonNullElse
// String nom = Objects.requireNonNullElse(input, "Inconnu");

// // Affichage conditionnel
// System.out.println("Statut : " + (estValide ? "✅ VALIDE" : "❌ INVALIDE"));

// // Calcul avec condition
// double prix = (quantite > 10) ? prix * 0.9 : prix;  // 10% de réduction si > 10



// ======================== Ces outils rendent ton code plus propre, plus fiable et plus professionnel ! 🚀 =================