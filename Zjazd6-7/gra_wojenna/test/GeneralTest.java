import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GeneralTest {

    @Test
    void shouldReturnCorrectGeneralForce() {
        //given
        Szeregowy szeregowy = new Szeregowy(4);
        General general = new General(List.of(szeregowy), 100);
        //when
        double result = general.getTotalForce();
        //then
        double expectedResult = 4;
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void shouldRemoveRandomSoldier() {
        //given
        Szeregowy szeregowy = new Szeregowy(4);
        Major major = new Major(5);
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(szeregowy);
        soldiers.add(major);
        General general = new General(soldiers, 100);
        //when
        general.shotToRandomSoldier();
        //then
        Assertions.assertTrue(general.getSoldiers().size() == 1);
    }

    @Test
    void shouldCorrectGetPenaltyForLost() {
        //given
        Szeregowy szeregowy = new Szeregowy(4);
        Major major = new Major(5);
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(szeregowy);
        soldiers.add(major);
        General general = new General(soldiers, 100);
        //when
        general.getPenaltyForLost();
        //then
        double expectedGold = 90;
        Assertions.assertTrue(general.getGold() == expectedGold);
        Assertions.assertEquals(general.getSoldiers().get(0), new Szeregowy(3));
        Assertions.assertEquals(general.getSoldiers().get(1), new Major(4));
    }

    @Test
    void shouldCorrectRemoveSoldierAfterLose() {
        //given
        Szeregowy szeregowy = new Szeregowy(4);
        Major major = new Major(1);
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(szeregowy);
        soldiers.add(major);
        General general = new General(soldiers, 100);
        //when
        double penaltyForLost = general.getPenaltyForLost();
        //then
        double expectedGold = 90;
        Assertions.assertTrue(10 == penaltyForLost);
        Assertions.assertTrue(general.getGold() == expectedGold);
        Assertions.assertTrue(general.getSoldiers().size() == 1);
        Assertions.assertEquals(general.getSoldiers().get(0), new Szeregowy(3));
    }

    @Test
    void shouldCorrectSetAwardForWin(){
        //given
        Szeregowy szeregowy = new Szeregowy(4);
        Major major = new Major(5);
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(szeregowy);
        soldiers.add(major);
        General general = new General(soldiers, 100);
        //when
        general.setAwardForWin(10);
        //then
        double expectedGold = 110;
        Assertions.assertTrue(general.getGold() == expectedGold);
        Assertions.assertEquals(general.getSoldiers().get(0), new Kapral(1));
        Assertions.assertEquals(general.getSoldiers().get(1), new Major(6));
    }
}