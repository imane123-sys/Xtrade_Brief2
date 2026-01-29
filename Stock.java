public class Stock extends Asset{
    private int StockId;
    public Stock(int code ,String nom, double prixUnitaire,int quantite,String typeActif){
        super( code , nom,  prixUnitaire, quantite, typeActif);
        this.StockId=StockId;
    }

    public int getStockId() {
        return StockId;
    }

    public void setStockId(int stockId) {
        StockId = stockId;
    }
}
