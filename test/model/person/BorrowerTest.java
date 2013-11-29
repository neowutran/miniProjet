package model.person;

import com.google.gson.*;
import demonstrateur.*;
import model.*;
import model.feature.*;
import model.person.Borrower.*;
import model.person.borrower.*;
import org.hamcrest.*;
import org.junit.*;

import java.lang.reflect.*;
import java.nio.file.*;
import java.util.*;

/**
 * Created by draragar on 20/11/13.
 */
public class BorrowerTest {

    @Before
    public void setUp() {

        try {
            final Method m = MiniProject.class.getDeclaredMethod("loadConfigFile",
                    Path.class);
            m.setAccessible(true);
            m.invoke(null, Paths.get(MiniProject.FOLDER, MiniProject.CONFIG));

        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testEmprunter() throws Exception {

        Borrower e = new Student("Toto", "123", "pass");
        Feature c = new OperatingSystem("Windows");
        List<Feature> caracteristiques = new ArrayList<>();
        caracteristiques.add(c);
        Equipment m = new Equipment("Tablette",caracteristiques);
        Equipment m1 = new Equipment("Tablette",caracteristiques);
        Equipment m2 = new Equipment("Tablette",caracteristiques);
        Equipment m3 = new Equipment("Tablette",caracteristiques);
        Equipment m4 = new Equipment("Tablette",caracteristiques);
        Equipment m5 = new Equipment("Tablette",caracteristiques);
        Equipment m6 = new Equipment("Tablette",caracteristiques);
        Equipment m7 = new Equipment("Tablette",caracteristiques);
        Equipment m8 = new Equipment("Tablette",caracteristiques);


        List<Equipment> materiels = new ArrayList<>();
        materiels.add(m);
        materiels.add(m1);

        Inventory.getInstance().setEquipments(materiels);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2013,10,3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2013,10,6);

        Borrow retour = null;
        Borrow retour2 = null;

        List<String> materielEmprunt1 = new ArrayList<>();
        materielEmprunt1.add(m.getId());
        materielEmprunt1.add(m1.getId());
        try{
            retour = Finder.findBorrowById(e.borrow(materielEmprunt1, calendar, calendar2));

            SaveLoad.save("data.json");
            retour2 = Finder.findBorrowById(e.borrow(materielEmprunt1, calendar, calendar2));

        }catch(Exception exception){

            System.out.println(exception.getMessage());
            Assert.assertThat(true, CoreMatchers.equalTo(false));
            return;

        }

        Administrator gestionnaire = new Administrator("Alain", "1", "pass");
        retour.setState(State.ACCEPT, gestionnaire.getId());

        try{

            retour2.setState(State.ACCEPT, gestionnaire.getId());
            Assert.assertThat(true, CoreMatchers.equalTo(false));

        }catch (Exception exception){

        }

        final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(Person.getPersons()));




    }
}
