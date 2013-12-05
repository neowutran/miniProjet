
package model.person.borrower;

import model.SaveLoad;

/**
 * The Class Student.
 */
public class Student extends model.person.Borrower {

    /**
     * Instantiates a new student.
     *
     * @param name the name
     * @param id the id
     * @param password the password
     */
    public Student( final String name, final String id, final String password ) {
        super( name, id, SaveLoad.PERSON_TYPE_STUDENT, password );

    }

}
