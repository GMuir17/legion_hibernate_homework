package models;

import models.soldiers.Centurion;
import models.soldiers.EquipmentType;
import models.units.Cohort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralTest {

    General general;
    Legion legion;
    Centurion centurion;
    Cohort cohort;

    @Before
    public void before() {
        this.cohort = new Cohort();
        this.centurion = new Centurion("Tester", EquipmentType.PILLA, 10, 90, cohort);
        this.legion = new Legion("The 10th");
        this.general = new General("Agrippa", legion, 100);
    }

    @Test
    public void hasId() {
        assertEquals(0, general.getId());
    }

    @Test
    public void canSetId() {
        general.setId(25);
        assertEquals(25, general.getId());
    }

    @Test
    public void hasName() {
        assertEquals("Agrippa", general.getName());
    }

    @Test
    public void canSetName() {
        general.setName("Brutus");
        assertEquals("Brutus", general.getName());
    }

    @Test
    public void hasLegion() {
        assertEquals(legion, general.getLegion());
    }

    @Test
    public void canSetLegion() {
        Legion legion2 = new Legion("Banana");
        general.setLegion(legion2);
        assertEquals(legion2, general.getLegion());
    }

    @Test
    public void hasBudget() {
        assertEquals(100, general.getBudget());
    }

    @Test
    public void canSetBudget() {
        general.setBudget(90);
        assertEquals(90, general.getBudget());
    }

    @Test
    public void canAddToBudget() {
        general.addToBudget(100);
        assertEquals(200, general.getBudget());
    }

    @Test
    public void canRemoveFromBudget() {
        general.removeFromBudget(50);
        assertEquals(50, general.getBudget());
    }

    @Test
    public void canPaySoldier() {
        general.paySoldier(20, centurion);
        assertEquals(80, general.getBudget());
        assertEquals(20, centurion.getPurse());
    }

}
