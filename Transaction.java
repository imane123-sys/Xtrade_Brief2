import java.time.LocalDateTime;

public class Transaction {
    private String typeTransaction;
    private int quantite;
    private double prixUnitaire;
    private LocalDateTime dateOperation ;
    private Trader trader;
    private Asset asset;
    public Transaction(String typeTransaction, int quantite, double prixUnitaire, Trader trader,Asset asset){
        this.typeTransaction=typeTransaction;
        this.quantite =quantite;
        this.prixUnitaire=prixUnitaire;
        this.dateOperation=LocalDateTime.now();
        this.trader=trader;
        this.asset=asset;


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


    public LocalDateTime getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDateTime dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "typeTransaction='" + typeTransaction + '\'' +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", dateOperation=" + dateOperation +
                ", trader=" + trader +
                ", asset=" + asset +
                '}';
    }
}
