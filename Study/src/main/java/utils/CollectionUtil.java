package utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2022/8/9 18:33
 * @Created by taoyuanyuan
 */
public class CollectionUtil {

    /**
     * @param originMap r->(g->v)
     * @param <R>       type r
     * @param <G>       type g
     * @param <V>       type v
     * @return g->(r->v)
     */
    public static <R, G, V> Map<G, Map<R, V>> transformMap(Map<R, Map<G, V>> originMap) {
        Map<G, Map<R, V>> result = new HashMap<>();
        originMap.forEach((r, gv) -> {
            gv.forEach((g, v) -> {
                if (result.containsKey(g)) {
                    result.get(g).put(r, v);
                } else {
                    Map<R, V> tmp = new HashMap<>();
                    tmp.put(r, v);
                    result.put(g, tmp);
                }
            });
        });
        return result;
    }


    public static <T> Collection<T> unio(Collection<T> collection) {
        return null;
    }


}
