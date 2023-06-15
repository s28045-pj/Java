import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final double START_GOLD_VALUE = 1000;
    private static int playerOrder = 0;
    private boolean gameOn = true;
    private static General player1;
    private static General player2;
    private String player;

    public void start() {
        if (new File(Secretary.GAME_STATUS_TXT).exists()) {
            System.out.println("Chcesz kontynuowac poprzednia gre? Wpisz - 0");
            System.out.println("Chcesz zaczac nowa gre? Wpisz - 1");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 0:
                    try {
                        Secretary.setLines();
                        playerOrder = Secretary.getPlayerOrder();
                        player1 = Secretary.getGeneral(1);
                        player2 = Secretary.getGeneral(2);
                        startGame();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    player1 = new General(new ArrayList<>(), START_GOLD_VALUE);
                    player2 = new General(new ArrayList<>(), START_GOLD_VALUE);
                    startGame();
                    break;
                default:
                    System.out.println("Niepoprawna wartosc");
                    break;
            }
        } else {
            player1 = new General(new ArrayList<>(), START_GOLD_VALUE);
            player2 = new General(new ArrayList<>(), START_GOLD_VALUE);
            startGame();
        }
    }

    private void startGame() {
        while (gameOn) {
            showMenu();
        }
    }

    private void showMenu() {
        General currentGeneral;
        if (playerOrder % 2 == 0) {
            player = "PLAYER_1";
            currentGeneral = player1;
        } else {
            player = "PLAYER_2";
            currentGeneral = player2;
        }
        System.out.println("TERAZ GRACZ " + player + " wybierz opcje podajac numer");
        for (int i = 0; i < getMenuOptions().size(); i++) {
            System.out.println(i + " - " + getMenuOptions().get(i));
        }
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                exitAndSave();
                break;
            case 1:
                manageArmy(currentGeneral);
                break;
            case 2:
                attackOtherGeneral(currentGeneral);
                break;
            case 3:
                buySoldier(currentGeneral);
                break;
            default:
                System.out.println("NIEPOPRAWNA WARTOSC, kolejka przepadla");
                break;
        }
        checkGeneralsStatus();
        playerOrder++;
    }

    //Zalozylem ze general przegrywa jezeli nie ma zlota i armii
    private void checkGeneralsStatus() {
        if (player1.getSoldiers().isEmpty() && player1.getGold() < 0) {
            Secretary.generalWon(player1, "PLAYER1");
        } else if (player2.getSoldiers().isEmpty() && player2.getGold() < 0) {
            Secretary.generalWon(player2, "PLAYER2");
        }
    }

    private void exitAndSave() {
        Secretary.saveGame(player1, player2, player);
        gameOn = false;
    }

    private void buySoldier(General currentGeneral) {
        System.out.println("Dostepne zloto: " + currentGeneral.getGold());
        System.out.println("Wybierz typ zolnierza jaki chcesz kupic");
        for (int i = 0; i < showSoldiersToBuy().size(); i++) {
            System.out.println(i + " - " + showSoldiersToBuy().get(i));
        }
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                buySoldier(currentGeneral, Szeregowy.MILITARY_RANK * 10, new Szeregowy(1));
                break;
            case 1:
                buySoldier(currentGeneral, Kapral.MILITARY_RANK * 10, new Kapral(1));
                break;
            case 2:
                buySoldier(currentGeneral, Kapitan.MILITARY_RANK * 10, new Kapitan(1));
                break;
            case 3:
                buySoldier(currentGeneral, Major.MILITARY_RANK * 10, new Major(1));
                break;
            default:
                System.out.println("Niepoprawna wartosc");
                break;
        }
    }

    private void buySoldier(General currentGeneral, double price, Soldier soldier) {
        if (currentGeneral.getGold() >= price) {
            currentGeneral.getSoldiers().add(soldier);
            currentGeneral.setGold(currentGeneral.getGold() - price);
            System.out.println("Zolnierz zakupiony");
            Secretary.generalBoughtSoldier(currentGeneral, soldier, player);
        } else {
            System.out.println("Nie masz wystarczajcej ilosci monet");
        }
    }

    private List<String> showSoldiersToBuy() {
        return List.of("Szeregowy", "Kapral", "Kapitan", "Major");
    }

    private void attackOtherGeneral(General currentGeneral) {
        General otherGeneral;
        if (playerOrder % 2 != 0) {
            otherGeneral = player1;
        } else {
            otherGeneral = player2;
        }
        int fightStatus;
        double currentGeneralForce = currentGeneral.getTotalForce();
        double otherGeneralForce = otherGeneral.getTotalForce();
        if (currentGeneralForce > otherGeneralForce) {
            currentGeneral.setAwardForWin(otherGeneral.getPenaltyForLost());
            fightStatus = 1;
        } else if (currentGeneralForce < otherGeneralForce) {
            otherGeneral.setAwardForWin(currentGeneral.getPenaltyForLost());
            fightStatus = -1;
        } else {
            currentGeneral.shotToRandomSoldier();
            otherGeneral.shotToRandomSoldier();
            fightStatus = 0;
        }
        Secretary.generalAttackedOtherGeneral(currentGeneral, fightStatus, player);
    }

    //Zalozylem, ze ulepszamy cala armie lub czesc na ktora nas stac
    private void manageArmy(General currentGeneral) {
        System.out.println("Chcesz ulepszyc manewry calej armi? - wpisz 0");
        System.out.println("Chcesz ulepszyc manewry wybranego zolnierza? - wpisz 1");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 0:
                currentGeneral.updateAllArmy();
                Secretary.generalUpdatedArmy(currentGeneral, player);
                break;
            case 1:
                updateSingleSoldier(currentGeneral);
                Secretary.generalUpdatedSingleSoldier(currentGeneral, player);
                break;
            default:
                System.out.println("Niepoprawna wartosc");
                break;
        }
    }

    private void updateSingleSoldier(General currentGeneral) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer zolnierza ktorego chcesz ulepszyc");
        for (int i = 0; i < currentGeneral.getSoldiers().size(); i++) {
            System.out.println(i + " - " + currentGeneral.getSoldiers().get(i));
        }
        int decisionValue = scanner.nextInt();
        if (decisionValue >= 0 && decisionValue < currentGeneral.getSoldiers().size()) {
            currentGeneral.addSoldierExp(decisionValue);
        }
    }


    private List<String> getMenuOptions() {
        return List.of("Wyjdz i zapisz stan do pliku", "Zarzadz manewry armii", "Zaatakuj generala", "Kup zolnierza");
    }
}
