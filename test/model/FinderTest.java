package model;

import static org.junit.Assert.*;

import controllers.*;
import demonstrateur.*;
import org.junit.*;

import java.lang.reflect.*;
import java.nio.file.*;

public class FinderTest {

    @BeforeClass
    public static void onlyOnce() {

        try {
            final Method m = MiniProject.class.getDeclaredMethod("loadConfigFile",
                    Path.class);
            m.setAccessible(true);
            m.invoke(null, Paths.get(MiniProject.FOLDER, MiniProject.CONFIG));

        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }

        try {

            SaveLoad.load( SaveLoad.DATA );
        } catch( final MiniProjectException e ) {
            MiniProjectController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );
        }
    }



    @Test
    public void testFindActualBorrowByBorrower() {
        System.out.println("test:");
       System.out.println(Finder.findActualBorrowByBorrower("123").size());
    }

    @Test
    public void testFindAvailable() {

    }

    @Test
    public void testFindBorrowByBorrower() {
     //   fail("Not yet implemented");
    }

    @Test
    public void testFindBorrowById() {
    //    fail("Not yet implemented");
    }

    @Test
    public void testFindBorrowWaitingForAdministrator() {
       // fail("Not yet implemented");
    }

    @Test
    public void testFindEquipmentById() {
      //  fail("Not yet implemented");
    }

    @Test
    public void testFindLateBorrow() {
       // fail("Not yet implemented");
    }

    @Test
    public void testFindPersonById() {
      //  fail("Not yet implemented");
    }

    @Test
    public void testIsBorrowed() {
     //   fail("Not yet implemented");
    }

    @Test
    public void testIsBorrower() {
     //   fail("Not yet implemented");
    }

}
