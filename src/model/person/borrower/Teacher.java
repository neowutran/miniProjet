
package model.person.borrower;

import model.SaveLoad;

// TODO: Auto-generated Javadoc
/**
 * The Class Teacher.
 */
public class Teacher extends model.person.Borrower {

    /**
     * Instantiates a new teacher.
     *
     * @param name the name
     * @param id the id
     * @param password the password
     */
    public Teacher( final String name, final String id, final String password ) {
        super( name, id, SaveLoad.PERSON_TYPE_TEACHER, password );

    }

}
