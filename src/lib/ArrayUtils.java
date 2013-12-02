package lib;

import java.lang.reflect.*;

/**
 * Created by draragar on 02/12/13.
 */
public class ArrayUtils {

    public static <T> T[] concatenate (T[] A, T[] B) {
        int aLen = A.length;
        int bLen = B.length;

        @SuppressWarnings("unchecked")
        T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(A, 0, C, 0, aLen);
        System.arraycopy(B, 0, C, aLen, bLen);

        return C;
    }
}
