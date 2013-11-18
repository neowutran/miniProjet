package lib;

import java.util.*;
import java.util.Map.*;

/**
 * Created by draragar on 18/11/13.
 */
public final class MapUtils {

    public static List MapKeyToList(Map map) {

        List list = new ArrayList();
        for (Entry entry : (Set<Entry>) map.entrySet()) {

            list.add(entry.getKey());

        }
        return list;
    }

    private MapUtils(){}
}
