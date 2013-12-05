package model;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import controllers.MiniProjectController;
import demonstrateur.MiniProject;

public class InventoryTest {
  
    @Before
    public void setUp() throws Exception {
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
    public void testAddBorrow() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetBorrows() {
        System.out.println(Inventory.getInstance().getBorrows().size());
    }

    @Test
    public void testGetEquipments() {
        fail("Not yet implemented");
    }

}
