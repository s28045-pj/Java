import java.util.ArrayList;
import java.util.List;

public class General {
    private List<Soldier> soldiers;
    private double gold;

    public General(List<Soldier> army, double gold) {
        this.soldiers = army;
        this.gold = gold;
    }

    public double getTotalForce() {
        double forceSum = 0;
        for (Soldier soldier : soldiers) {
            forceSum += soldier.getForce();
        }
        return forceSum;
    }

    public void shotToRandomSoldier() {
        if (soldiers.isEmpty()) {
            return;
        }
        int min = 0;
        int max = soldiers.size();
        int randomValue = (int) ((Math.random() * (max - min)) + min);
        soldiers.remove(randomValue);
    }

    public double getPenaltyForLost() {
        double goldToReturn = gold * 0.1;
        gold -= goldToReturn;
        removeSoldiersExp();
        return goldToReturn;
    }

    public void setAwardForWin(double wonGold) {
        gold += wonGold;
        addSoldiersExp();
    }

    public void updateAllArmy() {
        List<Soldier> updatedSoldiers = new ArrayList<>();
        for (Soldier soldier : soldiers) {
            if (gold >= soldier.getMilitaryRankValue()) {
                gold -= soldier.getMilitaryRankValue();
                updatedSoldiers.add(soldier.addExperience());
            } else {
                updatedSoldiers.add(soldier);
            }
        }
        soldiers = updatedSoldiers;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public void addSoldierExp(int soldierIndex) {
        Soldier soldier = soldiers.get(soldierIndex);
        Soldier boostedSoldier = soldier.addExperience();
        soldiers.remove(soldierIndex);
        soldiers.add(boostedSoldier);
    }

    private void addSoldiersExp() {
        List<Soldier> updatedSoldiers = new ArrayList<>();
        for (Soldier soldier : soldiers) {
            updatedSoldiers.add(soldier.addExperience());
        }
        soldiers = updatedSoldiers;
    }

    private void removeSoldiersExp() {
        List<Soldier> soldiersToRemove = new ArrayList<>();
        for (Soldier soldier : soldiers) {
            if (soldier.minusExperience() == null) {
                soldiersToRemove.add(soldier);
            }
        }
        soldiers.removeAll(soldiersToRemove);
    }

    @Override
    public String toString() {
        return "General{" +
            "soldiers=" + soldiers +
            ", gold=" + gold +
            '}';
    }
}
