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

            System.out.println("5. Quitter");
            System.out.print("Entrez un choix entre 1 et 5 : ");
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
                    System.out.println("Vous avez quitté le menu Admin");

                    break;
                default:
                    System.out.println("Entrez un choix valide");
            }
        } while (choix != 5);
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









