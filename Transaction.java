import java.time.LocalDateTime;

public class Transaction {
    private String typeTransaction;
    private int quantite;
    private double prixUnitaire;
    private LocalDateTime dateOperation ;
    public Transaction(String typeTransaction, int quantite, double prixUnitaire){
        this.typeTransaction=typeTransaction;
        this.quantite =quantite;
        this.prixUnitaire=prixUnitaire;
        this.dateOperation=LocalDateTime.now();


    }


    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }




}
