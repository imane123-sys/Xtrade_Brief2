public class Main {
    public static void main( String[] args){
        TradingPlateform p1= new TradingPlateform("Xtrade");
//        p1.ajouterActif();
//        p1.afficherActifsDisponibles();

        p1.ajouterTrader();
        p1.afficherTrader();
        p1.consulterPortfolio();



    }
}
