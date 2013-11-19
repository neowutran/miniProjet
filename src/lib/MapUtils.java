package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

    private MapUtils() {

    }
}
