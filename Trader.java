public class Trader extends Person{
    private int idTrader;
    private double capital;
    private Protfolio protfolio;
    public Trader(String nom,String email,int idTrader,double capital,Protfolio protfolio){
        super(nom,email);
        this.idTrader=idTrader;
        this.capital=capital;
        this.protfolio=protfolio;
    }

    public Protfolio getProtfolio() {
        return protfolio;
    }

    public void setProtfolio(Protfolio protfolio) {
        this.protfolio = protfolio;
    }

    public int getIdTrader() {
        return idTrader;
    }

    public void setIdTrader(int idTrader) {
        this.idTrader = idTrader;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }
    public double  crediterSolde( double montant ){
        capital+=montant;
        return capital;

    }
    public double debiterSolde(double montant) {
        if (capital >= montant) {
            capital -= montant;


        } else {
            System.out.println("montant insuffisantt");
        }
        return capital;
    }


    @Override
    public String toString() {
        return "Trader{" +
                "idTrader=" + idTrader +
                ", capital=" + capital +
                ", protfolio=" + protfolio +
                '}';
    }
}
