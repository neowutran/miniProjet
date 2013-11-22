package model;

import demonstrateur.*;
import org.junit.*;

import java.lang.reflect.*;
import java.nio.file.*;

/**
 * Created by draragar on 20/11/13.
 */
public class FinderTest {

    @Before
    public void setUp() {

        try {
            final Method m = MiniProjet.class.getDeclaredMethod("loadConfigFile",
                    Path.class);
            m.setAccessible(true);
            m.invoke(null, Paths.get(MiniProjet.FOLDER, MiniProjet.CONFIG));

        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testFindMateriel() throws Exception {

        //TODO

    }

    @Test
    public void testFindExactly() throws Exception {
        //TODO
    }

    @Test
    public void testFindExactly1() throws Exception {
        //TODO
    }

    @Test
    public void testFindExactlyAvaiable() throws Exception {
        //TODO
    }

    @Test
    public void testFind() throws Exception {
        //TODO
    }
}
