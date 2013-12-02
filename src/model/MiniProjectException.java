
package model;

/**
 * Created by draragar on 30/11/13.
 */
public class MiniProjectException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MiniProjectException( ) {
        super( );
    }

    public MiniProjectException( final String message ) {
        super( message );
    }

    public MiniProjectException( final String message, final Throwable cause ) {
        super( message, cause );
    }

    public MiniProjectException( final Throwable cause ) {
        super( cause );
    }
}
