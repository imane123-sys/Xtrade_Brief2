import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
// T extends Asset => pour limiter les entrées
public class Protfolio <T extends Asset> {
    private int  idProtfolio;
    private Trader trader;
    private ArrayList<T> assets;


    public Protfolio(int  idProtfolio ){
        this.idProtfolio=idProtfolio;
        this.trader=trader;
        this.assets=new ArrayList<>();
    }

    public int getIdProtfolio() {
        return idProtfolio;
    }

    public void setIdProtfolio(int idProtfolio) {
        this.idProtfolio = idProtfolio;
    }

    public ArrayList<T> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<T> assets) {
        this.assets = assets;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public void ajouterActif(T asset){
        assets.add(asset);
    }
    public void retirerActif(T asset){
        assets.remove(asset);

    }
//    public double calculerValeurTotale(){
//        //calcul valeur totale
//
//        double total=0;
//        for(T asset:assets){
//            total+=asset.getPrixUnitaire()*asset.getQuantite();
//        }
//        return total;
//
//    }
   public double calculerValeurTotale(){
       double total=0;
        for (T asset:assets){
            total+=asset.calculerValeur();

        }
        return total;

}
    @Override
    public String toString() {
        return "Protfolio{" +
                "idProtfolio=" + idProtfolio +
               ", nombreActifs=" + assets.size() +
                '}';
    }



}
