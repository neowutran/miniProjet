package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FinderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindActualBorrowByBorrower() {
       System.out.println(Finder.findActualBorrowByBorrower("123").size());
    }

    @Test
    public void testFindAvailable() {
       
    }

    @Test
    public void testFindBorrowByBorrower() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindBorrowById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindBorrowWaitingForAdministrator() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindEquipmentById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindLateBorrow() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindPersonById() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsBorrowed() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsBorrower() {
        fail("Not yet implemented");
    }

}
