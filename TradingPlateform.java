import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TradingPlateform {
    private String plateformeName;
    private ArrayList<Trader>traders=new ArrayList<>(

    );
    private ArrayList<Asset> assets = new ArrayList<>(
            Arrays.asList(
                    new Stock(1, "apple", 1000.0, 50, "stock"),
                    new Stock(2, "google", 1500.0, 10, "stock"),
                    new Stock(3, "Amazon", 1060.0, 60, "stock"),

                    new CryptoCurrencey(4, "Bitcoin", 1000.0, 50, "crypto"),
                    new CryptoCurrencey(5, "Eutherem", 2000.0, 1, "crypto"),
                    new CryptoCurrencey(6, "Binanance coin", 2000.0, 1, "crypto"),
                    new CryptoCurrencey(7, "Binanance coin", 2000.0, 0, "crypto")
            )
    );
    private ArrayList<Transaction>transactions=new ArrayList<>();






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
    public void afficherActifs(){
        System.out.println("=====================listes des assets=================================");



//        for(Asset ast:assets){
//            System.out.println(ast);
//
//        }
    }

    public void afficherActifsDisponibles(){
        System.out.println("========Liste des actifs disponibles==========");


        if(assets.isEmpty()){
            System.out.println("aucun actif n'est trouvé");

        }

        for(Asset asset:assets){
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

    public void acheterActif(){
            Scanner scanner=new Scanner(System.in);
            System.out.println("=========================acheter Actif==========================");
            //demander l'id de trader
            System.out.println("Entrez votre id");
            int id=scanner.nextInt();
            //Trouver  trader avec ce id
            Trader trader=null;
            for(Trader tr:traders){
                if(tr.getIdTrader()==id){
                    trader=tr;
                }
            }
            //demander code d'actif
            afficherActifsDisponibles();
            System.out.print("Entrez code : ");
            int code=scanner.nextInt();

            //chercher l'actif avec ce code
            Asset asset =null;
            for(Asset ast:assets){
                if(ast.getCode()==code){
                    asset=ast;
                }
            }
        //verifier si le capital est suffisant
        if (trader.getCapital() > asset.getPrixUnitaire()) {
            if (asset.getQuantite() > 0) {
                // ajouter actif au portfolio
                trader.getProtfolio().ajouterActif(asset);
                //modifier le solde de trader
                trader.debiterSolde(asset.getPrixUnitaire());
                System.out.println("l'achat est effectué avec succés");
            }
        }




    }
    public void vendreActif(){

        Scanner scanner=new Scanner(System.in);
        //demander id de trader
        System.out.println("Entrez votre id");
        int idTrader=scanner.nextInt();



        //recuperer trader
        Trader trader =null;
        for(Trader tr:traders){
            if(tr.getIdTrader()==idTrader){
                trader=tr;
            }
        }



        //afficher les actifs
         ArrayList<Asset> assets =trader.getProtfolio().getAssets();
        for(Asset ast:assets){
            System.out.println(ast);
        }
        // demander code d'actif
        System.out.print("Entrez code d'actif : ");
        int codeActif=scanner.nextInt();
        //récupérer l'actif que nous voulons vendre(objet)
        Asset asset=null;
        for(Asset ast:assets){
            if(ast.getCode()==codeActif){
                asset=ast;
            }
        }

        //

        trader.crediterSolde(asset.getPrixUnitaire());
        trader.getProtfolio().getAssets().remove(asset);





    }
    public void historiqueTransactions(){

    }

    public void  afficherListeActif(){



    }






}
