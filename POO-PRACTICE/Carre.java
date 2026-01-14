// ⚠️ Un carré EST un rectangle particulier (où longueur = largeur)
public class Carre extends Rectangle {
    
    // ⚠️ Constructeur simplifié : seulement côté
    public Carre(String couleur, double cote) {
        super(couleur, cote, cote);  // ⚠️ Passe cote comme longueur ET largeur
    }
    
    // Getter pour le côté
    public double getCote() {
        return getLongueur();  // ⚠️ Utilise le getter du parent
    }
    
    // Setter pour le côté
    public void setCote(double cote) {
        // ⚠️ Modifie longueur ET largeur
        setLongueur(cote);
        setLargeur(cote);
    }
    
    // ⚠️ PAS BESOIN de redéfinir calculerAire() et calculerPerimetre()
    // Rectangle les calcule déjà correctement !
    
    // ========== REDÉFINITION toString() ==========
    @Override
    public String toString() {
        return String.format("Carre[couleur=%s, cote=%.2f, aire=%.2f]", 
                           getCouleur(), getCote(), calculerAire());
    }
}