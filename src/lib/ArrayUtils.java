
package lib;

import java.lang.reflect.Array;

/**
 * Created by draragar on 02/12/13.
 */
public class ArrayUtils {

    public static <T> T[ ] concatenate( final T[ ] A, final T[ ] B ) {
        final int aLen = A.length;
        final int bLen = B.length;

        @SuppressWarnings( "unchecked" )
        final T[ ] C = ( T[ ] ) Array.newInstance( A.getClass( )
                .getComponentType( ), aLen + bLen );
        System.arraycopy( A, 0, C, 0, aLen );
        System.arraycopy( B, 0, C, aLen, bLen );

        return C;
    }

    private ArrayUtils(){}
}
