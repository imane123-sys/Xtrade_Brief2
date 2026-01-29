public class CryptoCurrencey extends Asset{
    private int currencyId;
    public CryptoCurrencey(int code ,String nom, double prixUnitaire,int quantite,String typeActif){
        super( code , nom,  prixUnitaire, quantite, typeActif);
        this.currencyId=currencyId;

    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }
}
