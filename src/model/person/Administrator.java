
package model.person;

import model.SaveLoad;

/**
 * The Class Administrator.
 */
public class Administrator extends model.Person {

    /**
     * Instantiates a new administrator.
     *
     * @param name the name
     * @param id the id
     * @param password the password
     */
    public Administrator( final String name, final String id,
            final String password ) {
        super( name, id, password );
        this.setType( SaveLoad.PERSON_TYPE_ADMINISTRATOR );
    }

    /**
     * Sets the borrow stat.
     *
     * @param borrow the borrow
     * @param state the state
     * @return true, if successful
     */
    public boolean setBorrowStat( final Borrower.Borrow borrow,
            final model.State state ) {

        try {
            borrow.setState( state, this.getId( ) );
        } catch( final Exception e ) {
            return false;
        }

        return true;
    }

}
