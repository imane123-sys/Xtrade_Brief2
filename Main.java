import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TradingPlateform p = new TradingPlateform("Xtrade");
        Scanner scanner = new Scanner(System.in);

        menuPrincipale(p, scanner);


    }

    public static void menuPrincipale(TradingPlateform p, Scanner scanner) {
        int choix = 0;
        do {
            System.out.println("=========== Menu Principal ===========");
            System.out.println("1. Menu Admin");
            System.out.println("2. Menu Trader");
            System.out.println("3. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    menuAdmin(p, scanner);
                    break;
                case 2:
                    menuTrader(p, scanner);
                    break;
                case 3:
                    System.out.println("Programme terminé");
                    break;
                default:
                    System.out.println("Entrez un nombre entier entre 1 et 3");
            }
        } while (choix != 3);
    }

    public static void menuAdmin(TradingPlateform p, Scanner scanner) {
        int choix = 0;
        do {
            System.out.println("=========== Menu Admin ===========");
            System.out.println("1. Ajouter Actif");
            System.out.println("2. Modifier Prix Actifs");
            System.out.println("====================Stream===================");
            System.out.println("3.Afficher toutes les transactions d’un trader donné");
            System.out.println("4.Filtrer les transactions par : type,actif,intervalle date");
            System.out.println("5.Calculer : le volume total échangé par actif");
            System.out.println("6.Calculer Total des Achats Et des Ventes()");
            System.out.println("7.Calcul du volume total échangé par trader");
            System.out.println("8.Calcul du nombre total d’ordres passés");
            System.out.println("9.Classement des traders par volume (top N traders)");
            System.out.println("10.Calcul du volume total échangé par instrument financier");
            System.out.println("11.Identification de l’instrument le plus échangé");
            System.out.println("12.Calcul du montant total des BUY et des SELL séparément");


            System.out.println("13. Quitter");
            System.out.print("Entrez un choix entre 1 et 6 : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    p.ajouterActif();
                    break;
                case 2:
                    p.modifierPrixActifs();
                    break;
                case 3:
                    p.afficherTransactionsTrader();
                    break;

                case 4:
                    p.filtrerTransactions();
                case 5:
                    p.calculerVolumeActif();
                    break;
                case 6:
                    p.calculerTotalAchatsEtVentes();
                    break;
                case 7:
                    p.VolumeTotalTrader();
                    break;
                case 8:
                    p.NombreTotalOrders();
                    break;
                case 9:
                    p.ClassementTraderVolume();
                    break;
                case 10:
                    p.totalInstrumentFinancier();

                    break;
                case 11:
                    p.InstrumentPlusEchange();
                    break;
                case 12:
                    p.CalculAchatsVentesMarche();
                    break;
                case 13:
                    System.out.println("Vous avez quitté le menu Admin");

                    break;
                default:
                    System.out.println("Entrez un choix valide");
            }
        } while (choix != 13);
    }

    public static void menuTrader(TradingPlateform p, Scanner scanner) {
        int choix = 0;
        do {
            System.out.println("=========== Menu Trader ===========");
            System.out.println("1. Afficher les actifs disponibles");
            System.out.println("2. ajouter Trader");
            System.out.println("3. Acheter Actif");
            System.out.println("4. Vendre Actif");
            System.out.println("5. Afficher Transactions");
            System.out.println("6. Consulter Portefeuille");
            System.out.println("7. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    p.afficherActifsDisponibles();
                    break;
                case 2:
                    p.ajouterTrader();
                    break;
                case 3:
                    p.acheterActif();
                    break;
                case 4:
                    p.vendreActif();
                    break;
                case 5:
                    p.afficherTransactions();
                    break;
                case 6:
                    p.consulterPortfolio();
                    break;
                case 7:
                    System.out.println("Quitter le programme !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer");
            }
        } while (choix != 7);
    }







}









