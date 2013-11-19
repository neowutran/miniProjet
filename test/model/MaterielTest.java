package model;

import demonstrateur.*;
import model.caracteristique.*;
import org.hamcrest.*;
import org.junit.*;

import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;

/**
 * Created by draragar on 18/11/13.
 */
public class MaterielTest {

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
    public void testSetAttributs() throws Exception {

    }

    @Test
    public void testConstructor() throws Exception {

        Materiel materiel;
        try {
            materiel = new Materiel("tablette", null, 1, 1);
            //BON
        } catch (Exception e) {
            //PAS BON
            Assert.assertThat(true, CoreMatchers.equalTo(false));
        }

        try {
            materiel = new Materiel("tablette", null, null, null);
            Assert.assertThat(true, CoreMatchers.equalTo(false));
            //PAS BON
        } catch (Exception e) {
            //BON
        }

        try{
        materiel = new Materiel("tablettte", null, 0, 0);
            Assert.assertThat(true, CoreMatchers.equalTo(false));
            //PAS BON
        }catch (Exception e){

        }

        List<ICaracteristique> caracteristiques = new ArrayList<>();
        caracteristiques.add(new OperatingSystem("Windows", "tablette"));

        try{
            materiel = new Materiel("tablette", caracteristiques, 1, 0);
        }catch (Exception e){
            Assert.assertThat(true, CoreMatchers.equalTo(false));
            //PAS BON

        }

    }
}
