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
            e.printStackTrace();
        }
    }

    @Test
    public void testBorrow() throws Exception {

        Borrower e = new Student("Toto", "123", "pass");
        Feature c = new OperatingSystem("Windows");
        List<Feature> features = new ArrayList<>();
        features.add(c);
        Equipment m = new Equipment("Tablette",features);
        Equipment m1 = new Equipment("Tablette",features);
        Equipment m2 = new Equipment("Tablette",features);
        Equipment m3 = new Equipment("Tablette",features);
        Equipment m4 = new Equipment("Tablette",features);
        Equipment m5 = new Equipment("Tablette",features);
        Equipment m6 = new Equipment("Tablette",features);
        Equipment m7 = new Equipment("Tablette",features);
        Equipment m8 = new Equipment("Tablette",features);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2013,10,3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2013,10,6);

        Borrow return1;
        Borrow return2;

        List<String> equipmentBorrow = new ArrayList<>();
        equipmentBorrow.add(m.getId());
        equipmentBorrow.add(m1.getId());
        try{
            return1 = Finder.findBorrowById(e.borrow(equipmentBorrow, calendar, calendar2));
            return2 = Finder.findBorrowById(e.borrow(equipmentBorrow, calendar, calendar2));

        }catch(Exception exception){

            System.out.println(exception.getMessage());
            Assert.assertThat(true, CoreMatchers.equalTo(false));
            return;

        }

        Administrator administrator = new Administrator("Alain", "1", "pass");
        return1.setState(State.ACCEPT, administrator.getId());

        try{

            return2.setState(State.ACCEPT, administrator.getId());
            Assert.assertThat(true, CoreMatchers.equalTo(false));

        }catch (Exception exception){

        }

        final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(Person.getPersons()));




    }
}
