public class Stock extends Asset{
    private int StockId;
    public Stock(int code , String nom, double prixUnitaire,int StockId,String typeActif){
        super(code,nom,prixUnitaire,typeActif);
    }

    public int getStockId() {
        return StockId;
    }

    public void setStockId(int stockId) {
        StockId = stockId;
    }
}
