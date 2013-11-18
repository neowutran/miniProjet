/**
 * @author Martini Didier
 */

package lib;

/**
 * The Class ArrayUtils.
 */
public final class ArrayUtils {

    /**
     * Clone2 d array.
     *
     * @param <T>
     *            the generic type
     * @param array
     *            the array
     * @return the t[][]
     */
    public static <T> T[ ][ ] clone2DArray( final T[ ][ ] array ) {

        final int rows = array.length;
        final T[ ][ ] newArray = array.clone( );
        for( int row = 0; row < rows; row++ ) {
            newArray[ row ] = array[ row ].clone( );
        }

        return newArray;
    }

    /**
     * Instantiates a new array utils.
     */
    private ArrayUtils( ) {

    }
}
