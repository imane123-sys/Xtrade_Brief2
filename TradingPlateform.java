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
        for(Asset ast:assets){
            System.out.println(ast);
        }


    }

    public void ajouterTrader(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Entrez l'id du Trader");
        int id=scanner.nextInt();
        System.out.println("Entrez capital du trader");

        double  capital=scanner.nextDouble();
        Trader t = new Trader(id,capital);
        traders.add(t);
        System.out.println("Trader est ajouté avec succés");





    }


}
