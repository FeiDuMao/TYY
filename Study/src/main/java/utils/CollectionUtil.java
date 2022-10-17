package utils;

import lombok.NonNull;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Date 2022/8/9 18:33
 * @Created by taoyuanyuan
 */
public class CollectionUtil {


    private CollectionUtil() {
    }


    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }


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


    public static <T> Collection<T> union(Collection<T>... collections) {
        if ((collections.length <= 1)) {
            return collections[0];
        } else {

            for (Collection<T> collection : collections) {

            }
        }

        return null;

    }


    public static <T> Collection<T> union(Collection<T> c1, Collection<T> c2) {

        List<T> l1 = c1.stream().toList();
        l1.addAll(c2);
        return l1;
    }


    public static <T> Collection<T> intersection(@NonNull Collection<T> c1, Collection<T> c2) {
        Set<T> result = new HashSet<>();
        result.addAll(c1);
        result.addAll(c2);
        return result;
    }


    public static <K, V> Map<V, List<K>> groupMapByValue(Map<K, V> originMap) {
        return originMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        en -> en.getValue().stream().map(Map.Entry::getKey).toList()
                ));
    }


}
