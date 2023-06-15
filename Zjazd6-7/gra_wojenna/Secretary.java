import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Secretary {


    public static final String GAME_STATUS_TXT = "gameStatus.txt";
    private static List<String> lines;

    public static void generalAttackedOtherGeneral(General currentGeneral, int fightStatus, String player) {
        System.out.println("Zaatakowal gracz: " + player);
        System.out.println("Zaatakowal general: " + currentGeneral);
        switch (fightStatus) {
            case 1:
                System.out.println("Walka zakonczona wygrana atakujacego");
                break;
            case -1:
                System.out.println("Walka zakonczona przegrana atakujacego");
                break;
            case 0:
                System.out.println("Walka zakonczona remisem");
                break;
        }
    }

    public static void generalUpdatedArmy(General currentGeneral, String player) {
        System.out.println("Gracz: " + player + " ulepsza cala armie");
        System.out.println("General ulepsza cala armie");
        System.out.println("Armia po ulepszeniu: " + currentGeneral);
    }

    public static void generalUpdatedSingleSoldier(General currentGeneral, String player) {
        System.out.println("Gracz: " + player + " ulepsza cala armie");
        System.out.println("General ulepsza jednego zolnierza armie");
        System.out.println("Armia po ulepszeniu: " + currentGeneral);
    }

    public static void generalBoughtSoldier(General currentGeneral, Soldier soldier, String player) {
        System.out.println("Gracz: " + player + " kupuje zolnierza");
        System.out.println("General kupuje zolnierza");
        System.out.println("Zakupiony zolnierz: " + soldier);
        System.out.println("Armia po zakupach: " + currentGeneral);
    }

    public static void generalWon(General general, String player) {
        System.out.println("Wygral gracz: " + player);
        System.out.println("Jako general: " + general);
    }

    public static void saveGame(General player1, General player2, String player) {
        File file = new File(GAME_STATUS_TXT);
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(player);
            bw.newLine();
            bw.write(player1.toString());
            bw.newLine();
            bw.write(player2.toString());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getPlayerOrder() throws IOException, IncorrectFileFormatException {
        String player = lines.get(0);
        if (player.equals("PLAYER_1")) {
            return 0;
        } else if (player.equals("PLAYER_2")) {
            return 1;
        }
        throw new IncorrectFileFormatException("Niepoprawny format danych");
    }

    public static void setLines() throws IOException, IncorrectFileFormatException {
        lines = Files.readAllLines(Path.of(GAME_STATUS_TXT));
        if (lines.size() < 3) {
            throw new IncorrectFileFormatException("Niepoprawny format danych");
        }
    }

    public static General getGeneral(int generalNumber) throws IncorrectFileFormatException {
        String generalAsText = lines.get(generalNumber);
        if (!generalAsText.startsWith("General")) {
            throw new IncorrectFileFormatException("Niepoprawny format danych");
        }
        int startSoldiersIndex = generalAsText.indexOf("[");
        int endSoldiersIndex = generalAsText.indexOf("]");
        String soldiersText = generalAsText.substring(startSoldiersIndex + 1, endSoldiersIndex);
        List<Soldier> soldiers = new ArrayList<>();
        String[] soldiersArray = soldiersText.split(", ");

        for (int i = 0; i < soldiersArray.length; i += 2) {
            String[] firstLine = soldiersArray[i].split(" ");

            //Wycinam "{"
            String soldierType = firstLine[0].substring(0, firstLine[0].length() - 1);
            //Wycinam "}"
            String expAsText = soldiersArray[i + 1].split("=")[1];
            double exp = Double.parseDouble(expAsText.substring(0,expAsText.length()-1));
            switch (soldierType) {
                case "Szeregowy":
                    soldiers.add(new Szeregowy(exp));
                    break;
                case "Kapral":
                    soldiers.add(new Kapral(exp));
                    break;
                case "Kapitan":
                    soldiers.add(new Kapitan(exp));
                    break;
                case "Major":
                    soldiers.add(new Major(exp));
                    break;
                default:
                    throw new IncorrectFileFormatException("Niepoprawny format danych");
            }
        }

        //+5 bo dlugosc gold= ma 5
        int startGoldIndex = generalAsText.indexOf("gold=") + 5;
        int endGoldIndex = generalAsText.length()-1;
        double gold = Double.parseDouble(generalAsText.substring(startGoldIndex, endGoldIndex));
        General general = new General(soldiers, gold);
        return general;
    }
}
