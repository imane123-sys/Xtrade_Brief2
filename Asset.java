public abstract class Asset {
    private int code;
    private String nom;
    private double prixUnitaire;
    private int quantite;
    private String typeActif;

    public Asset(int code , String nom, double prixUnitaire,String typeActif){
        this.code=code;
        this.nom =nom;
        this.prixUnitaire=prixUnitaire;

    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public String getTypeActif() {
        return typeActif;
    }

    public void setTypeActif(String typeActif) {
        this.typeActif = typeActif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double calculerValeur(){
        return prixUnitaire*quantite;
    }


    @Override
    public String toString() {
        return "Asset{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", quantite=" + quantite +
                ", typeActif='" + typeActif + '\'' +
                '}';
    }
}
