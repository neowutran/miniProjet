package model.personne;

import demonstrateur.*;
import org.junit.*;

import java.lang.reflect.*;
import java.nio.file.*;

/**
 * Created by draragar on 20/11/13.
 */
public class EmprunteurTest {

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
    public void testEmprunter() throws Exception {

    }
}
