import java.util.ArrayList;
import java.util.Scanner;

public class TradingPlateform {
    private String plateformeName;
    private ArrayList<Trader>traders=new ArrayList<>();
    private ArrayList<Asset>assets=new ArrayList<>();




    public TradingPlateform(String plateformeName) {
        this.plateformeName = plateformeName;
    }

    public String getPlateformeName() {
        return plateformeName;
    }

    public void setPlateformeName(String plateformeName) {
        this.plateformeName = plateformeName;
    }

    public void ajouterActif(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ajouter Code d'actif");
         int code=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ajouter le nom d'actif ");
        String nom=scanner.nextLine();
        System.out.println("Entrez le prix unitaire d'actif");
        double prixUnitaire=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Entrez la quantité d'actif");
        int quantite=scanner.nextInt();
        scanner.nextLine();

        System.out.println("entrez le type d'actif: (stock/crypto)");
        String typeActif=scanner.nextLine().toLowerCase();


        Asset asset;
        if(typeActif.equals("stock")){
            asset= new Stock(code,nom,prixUnitaire,quantite,typeActif);




        }else if(typeActif.equals("crypto")){
            asset=new CryptoCurrencey(code,nom,prixUnitaire,quantite,typeActif);
        }
        else{
            System.out.println("ce type d'actif n'existe pas");
            return;

        }
        assets.add(asset);
//        assets.stream().forEach(System.out::println);

    }

    public void afficherActifsDisponibles(){

        if(assets.isEmpty()){
            System.out.println("aucun actif n'est trouvé");

        }

        for(Asset asset:assets){
            System.out.println("========Liste des actifs disponibles==========");
            if(asset.getQuantite()>0){
            System.out.println(asset);
        }
        }
    }




    public void ajouterTrader(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Entrez le nom du Trader :");
        String nom = scanner.nextLine();

        System.out.println("Entrez l'email du Trader :");
        String email = scanner.nextLine();

        System.out.println("Entrez l'id du Trader :");
        int id = scanner.nextInt();

        System.out.println("Entrez le capital du Trader :");
        double capital = scanner.nextDouble();
        Protfolio portfolio = new Protfolio(1);

        Trader t = new Trader(nom,email,id,capital,portfolio);
        //assigner portefeuille au trader:
        portfolio.setTrader(t);
        //donne au trader son portfolio
        t.setProtfolio(portfolio);



        traders.add(t);

        System.out.println("Trader est ajouté avec succès!");

    }
    public void consulterPortfolio(){
        System.out.println("Afficher les actifs détenus");
        for(Asset ast:assets){
            System.out.println("le nom d'actif:"+ast.getNom()+"\n");
//            System.out.println("le prix d'actif:"+ast.getPrixUnitaire()+"\n");
//            System.out.println("la quantité d'actif"+ast.getQuantite()+"\n");
            System.out.println(" le type d'actif:"+ast.getTypeActif()+"\n");
            System.out.println("valeur totale:"+ast.calculerValeur());

        }


    }

    public void afficherTrader(){
        System.out.println("==================les traders qui s'existent=============");
        for(Trader tr:traders){
            System.out.println(tr);
        }
    }





}
