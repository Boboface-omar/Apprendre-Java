public class PaiementPayPal extends Paiement {
    private String email;
    private String motDePasse;
    
    public PaiementPayPal(double montant, String email, String motDePasse) {
        super(montant);
        setEmail(email);
        setMotDePasse(motDePasse);
    }
    
    // ========== GETTERS ==========
    public String getEmail() {
        return email;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }
    
    // ========== SETTERS ==========
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email est obligatoire");
        }
        
        // Regex email basique
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Format d'email invalide");
        }
        
        this.email = email.trim().toLowerCase();
    }
    
    public void setMotDePasse(String motDePasse) {
        if (motDePasse == null || motDePasse.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe est obligatoire");
        }
        
        if (motDePasse.length() < 6) {
            throw new IllegalArgumentException("Le mot de passe doit faire au moins 6 caractères");
        }
        
        // ⚠️ En réalité, on ne stockerait JAMAIS le mot de passe en clair !
        // C'est juste pour l'exercice
        this.motDePasse = motDePasse;
    }
    
    // ========== IMPLÉMENTATION DES MÉTHODES ABSTRAITES ==========
    @Override
    public void traiterPaiement() {
        System.out.println("\n🏦 Traitement du paiement PayPal...");
        
        // Simulation de connexion à PayPal
        System.out.println("🔗 Connexion à PayPal avec l'email: " + email);
        System.out.println("📡 Vérification du compte...");
        
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Simulation (95% de réussite)
        double chance = Math.random();
        if (chance > 0.05) {  // 95% de chance de réussite
            System.out.println("✅ Paiement PayPal accepté");
            setEstValide(true);
        } else {
            System.out.println("❌ Échec de l'authentification PayPal");
        }
    }
    
    @Override
    public double calculerFrais() {
        // Frais fixes de 1€ pour PayPal
        return 1.0;
    }
    
    @Override
    public String toString() {
        // Masquer partiellement l'email pour la sécurité
        String emailMasque = email.replaceAll("(.).*@(.*)", "$1***@$2");
        return String.format("PayPal[%s - %s - %.2f€]", 
                           getNumeroTransaction(), emailMasque, getMontant());
    }
}