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
        for(Trader tr:traders){
            System.out.println("les traders existés sont:"+tr);
        }

    }
//    public void consulterPortfolio(){
//        System.out.println("Afficher les actifs détenus");
//        for(Asset ast:assets){
//            System.out.println("le nom d'actif:"+ast.getNom()+"\n");
////            System.out.println("le prix d'actif:"+ast.getPrixUnitaire()+"\n");
////            System.out.println("la quantité d'actif"+ast.getQuantite()+"\n");
//            System.out.println(" le type d'actif:"+ast.getTypeActif()+"\n");
//            System.out.println("valeur totale:"+ast.calculerValeur());
//
//        }
//
//
//    }
//
//    public void afficherTrader(){
//        System.out.println("==================les traders qui s'existent=============");
//        for(Trader tr:traders){
//            System.out.println(tr);
//        }
//    }

    public void consulterPortfolio() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("================= Consulter le portefeuille =================");

        // demander id trader
        System.out.print("Entrez votre id : ");
        int idTrader = scanner.nextInt();

        // chercher trader
        Trader trader = null;
        for (Trader tr : traders) {
            if (tr.getIdTrader() == idTrader) {
                trader = tr;
                break;
            }
        }

        if (trader == null) {
            System.out.println("Trader introuvable !");
            return;
        }

        // récupérer portefeuille
        ArrayList<Asset> assets = trader.getProtfolio().getAssets();

        if (assets.isEmpty()) {
            System.out.println("Portefeuille vide !");
            return;
        }

        double valeurTotale = 0;

        System.out.println("------------- Actifs détenus -------------");

        for (Asset ast : assets) {
            double valeurActif = ast.getPrixUnitaire() * ast.getQuantite();
            valeurTotale += valeurActif;

            System.out.println("Nom d'actif      : " + ast.getNom());
            System.out.println("Type d'actif     : " + ast.getTypeActif());
            System.out.println("Prix unitaire    : " + ast.getPrixUnitaire());
            System.out.println("Quantité         : " + ast.getQuantite());
            System.out.println("Valeur de l'actif: " + valeurActif);
            System.out.println("------------------------------------------");
        }

        System.out.println("💰 Valeur totale du portefeuille : " + valeurTotale);
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
                    break;
                }
            }
            if(trader == null){
                System.out.println("Trader introuvable");
                return;
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
                    break;
                }
            }
            if(asset == null){
                System.out.println("actif ne se trouve pas");
                return;
            }
        //verifier si le capital est suffisant
        if (trader.getCapital() > asset.getPrixUnitaire()) {
            if (asset.getQuantite() > 0) {
                // ajouter actif au portfolio
//                trader.getProtfolio().ajouterActif(asset);
//                //modifier le solde de trader
//                trader.debiterSolde(asset.getPrixUnitaire());
                trader.debiterSolde(asset.getPrixUnitaire());
                trader.getProtfolio().ajouterActif(asset);
                asset.setQuantite(asset.getQuantite() - 1);
                System.out.println("l'achat est effectué avec succés");
            }
        }
        Transaction transaction =new Transaction(
                "Achat",
                asset.getQuantite(),
                asset.getPrixUnitaire(),
                trader,
                asset
        );
        transactions.add(transaction);




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
                break;
            }
        }
        if(trader==null){
            System.out.println("trader ne se trouve pas");
            return;
        }



        //afficher les actifs
         ArrayList<Asset> assets =trader.getProtfolio().getAssets();
        if(assets.isEmpty()){
            System.out.println("votre portefeuille est vide");
            return;
        }
        //afficher les actifs
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
                break;
            }
        }
        if(asset==null){
            System.out.println("aucun actif trouvé de code");
            return;
        }

        //demander quantité a vendre
        System.out.println("Entrez la quantité a vendre");
        int quantiteVendue=scanner.nextInt();
        if(quantiteVendue <=0 || quantiteVendue >asset.getQuantite()){
            System.out.println("quantité invalide");
            return;
        }
        double montant= quantiteVendue * asset.getQuantite();
        trader.crediterSolde(montant);
        asset.setQuantite(asset.getQuantite() -quantiteVendue);
        if(asset.getQuantite()==0){
            trader.getProtfolio().getAssets().remove(asset);
        }


        Transaction transaction = new Transaction(
                "Vente",
                asset.getQuantite(),
                asset.getPrixUnitaire(),
                trader,
                asset

                );
        transactions.add(transaction);
        System.out.println("Vente effectué avec succés");


    }

    public void afficherTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("Aucune transaction enregistrée.");
            return;
        }

        System.out.println("===== HISTORIQUE DES TRANSACTIONS =====");

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    public void modifierPrixActifs(){
        Scanner scanner =new Scanner(System.in);

        afficherActifsDisponibles();
        System.out.println("Entrez code d'actif ty peux changer");
        int code =scanner.nextInt();
        Asset asset =null;
        for(Asset ast:assets){
            if(ast.getCode()== code) {
                asset=ast;
            }
        }
        if(asset == null){
            System.out.println("actif ne se trouve pas");
        }
        System.out.println("Entrez le nouveau prix");
        double prix=scanner.nextDouble();
        asset.setPrixUnitaire(prix);
        System.out.println("prix moddifié avec succés");








    }







}
