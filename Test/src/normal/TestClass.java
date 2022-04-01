package normal;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname TestClass
 * @Date 2022/1/26 15:02
 * @Created by taoyuanyuan
 */
public class TestClass {


    DecimalFormat df = new DecimalFormat("#.00000000");

    public List<String> MyCalculateStockResult(Map<String, Double> tracingErrorMap,
                                               Map<String, Double> dailyReturnAvgDiffMap,
                                               Map<String, Double> factorValueVarianceMap,
                                               Map<String, Double> absStockWeightDiffMap,
                                               Map<String, Double> industryWeightVarianceMap) {
        int poolSize = tracingErrorMap.size();

        // 计算追踪误差的得分
        List<Double> tracingErrorScoreSort = tracingErrorMap.values().stream().sorted().collect(Collectors.toList());
        Map<String, Double> tracingErrorScore = tracingErrorMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    double tmp = tracingErrorMap.get(k);
                    return 100 * ((double) (poolSize - tracingErrorScoreSort.indexOf(tmp)) / poolSize);
                }
        ));

        // 计算日收益差的得分
        List<Double> dailyReturnAvgDiffScoreSort = dailyReturnAvgDiffMap.values().stream().sorted().collect(Collectors.toList());
        Map<String, Double> dailyReturnAvgDiffScore = dailyReturnAvgDiffMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    double tmp = dailyReturnAvgDiffMap.get(k);
                    return 100 * ((double) (poolSize - dailyReturnAvgDiffScoreSort.indexOf(tmp)) / poolSize);
                }
        ));

        List<Double> absStockWeightDiffMapSort = absStockWeightDiffMap.values().stream().sorted().collect(Collectors.toList());
        Map<String, Double> absStockWeightDiffMapScore = absStockWeightDiffMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    double tmp = absStockWeightDiffMap.get(k);
                    return 100 * ((double) (poolSize - absStockWeightDiffMapSort.indexOf(tmp)) / poolSize);
                }
        ));

        List<Double> factorValueVarianceMapSort = factorValueVarianceMap.values().stream().sorted().collect(Collectors.toList());
        Map<String, Double> factorValueVarianceMapScore = factorValueVarianceMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    double tmp = factorValueVarianceMap.get(k);
                    return 100 * ((double) (poolSize - factorValueVarianceMapSort.indexOf(tmp)) / poolSize);
                }
        ));

        List<Double> industryWeightVarianceMapSort = industryWeightVarianceMap.values().stream().sorted().collect(Collectors.toList());
        Map<String, Double> industryWeightVarianceMapScore = industryWeightVarianceMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    double tmp = industryWeightVarianceMap.get(k);
                    return 100 * ((double) (poolSize - industryWeightVarianceMapSort.indexOf(tmp)) / poolSize);
                }
        ));

        Map<String, Double> finalScoreMap = tracingErrorMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    Double d0 = tracingErrorScore.get(k);
                    Double d00 = dailyReturnAvgDiffScore.get(k);
                    Double d1 = absStockWeightDiffMapScore.get(k);
                    Double d2 = industryWeightVarianceMapScore.get(k);
                    Double d3 = factorValueVarianceMapScore.get(k);
                    return Double.valueOf(df.format((d00 + 5 * d0 + 4 * d1 + d2 + d3) / 12));
                }
        ));
        List<Map.Entry<String, Double>> finalScoreList = finalScoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        return finalScoreList.stream().skip(finalScoreList.size() - 3).map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }


    public static List<String> calculateStockResult(Map<String, Double> tracingErrorMap,
                                                    Map<String, Double> dailyReturnAvgDiffMap,
                                                    Map<String, Double> factorValueVarianceMap,
                                                    Map<String, Double> absStockWeightDiffMap,
                                                    Map<String, Double> industryWeightVarianceMap) {
        //计算最终得分,因为factorValueVarianceMap过滤了一些基金，所以用它的keySet
        Map<String, Double> finalScoreMap = factorValueVarianceMap.keySet().stream().collect(Collectors.toMap(
                k -> k,
                k -> {
                    Double d0 = tracingErrorMap.get(k);
                    Double d00 = dailyReturnAvgDiffMap.get(k);
                    Double d1 = absStockWeightDiffMap.get(k);
                    Double d2 = industryWeightVarianceMap.get(k);
                    Double d3 = factorValueVarianceMap.get(k);
                    return (d00 + 5 * d0 + 4 * d1 + d2 + d3) / 12;
                }
        ));

        //排序
        List<Map.Entry<String, Double>> finalScoreList = finalScoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        //这里是从小到大排序，值越小，得分越高，所以取前三名
        int end = Math.max(finalScoreList.size() - 3, 0);
        return finalScoreList.subList(0, end).stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }


    @Test
    public void test() {

//        d0 [6.54260495863553, 5.8276626787474255, 7.530436937891162, 6.723942134438576, 7.447381138171787, 4.702689832495027]
        Map<String, Double> tracingErrorMap = new HashMap<>() {
            {
                put("Fund1", 6.54260495863553);
                put("Fund2", 5.8276626787474255);
                put("Fund3", 7.530436937891162);
                put("Fund4", 6.723942134438576);
                put("Fund5", 7.447381138171787);
                put("Fund6", 4.702689832495027);
            }
        };

//        [0.00186744, 0.00112916, 0.00229416, 0.0013706, 0.00153836, 0.00694308]
        Map<String, Double> dailyReturnAvgDiffMap = new HashMap<>() {
            {
                put("Fund1", 0.00186744);
                put("Fund2", 0.00112916);
                put("Fund3", 0.00229416);
                put("Fund4", 0.0013706);
                put("Fund5", 0.00153836);
                put("Fund6", 0.00694308);
            }
        };
//        [0.13999999999999999, 0.43, 0.07, 0.019999999999999997, 0.12, 0.07]
        Map<String, Double> absStockWeightDiffMap = new HashMap<>() {
            {
                put("Fund1", 0.13999999999999999);
                put("Fund2", 0.43);
                put("Fund3", 0.07);
                put("Fund4", 0.019999999999999997);
                put("Fund5", 0.12);
                put("Fund6", 0.07);
            }
        };
//          [0.18083, 0.06708, 0.21772, 0.17378, 0.17088, 0.14491]
        Map<String, Double> industryWeightVarianceMap = new HashMap<>() {
            {
                put("Fund1", 0.18083);
                put("Fund2", 0.06708);
                put("Fund3", 0.21772);
                put("Fund4", 0.17378);
                put("Fund5", 0.17088);
                put("Fund6", 0.14491);
            }
        };

//        [0.59161, 1.28841, 0.91104, 0.8775, 0.9, 1.10905]
        Map<String, Double> factorValueVarianceMap = new HashMap<>() {
            {
                put("Fund1", 0.59161);
                put("Fund2", 1.28841);
                put("Fund3", 0.91104);
                put("Fund4", 0.8775);
                put("Fund5", 0.9);
                put("Fund6", 1.10905);
            }
        };

        List<String> result = calculateStockResult(
                tracingErrorMap,
                dailyReturnAvgDiffMap,
                factorValueVarianceMap,
                absStockWeightDiffMap,
                industryWeightVarianceMap
        );

        List<String> expect = MyCalculateStockResult(tracingErrorMap,
                dailyReturnAvgDiffMap,
                factorValueVarianceMap,
                absStockWeightDiffMap,
                industryWeightVarianceMap);


        Set<String> expectSet = new HashSet<>(expect);
        Set<String> resultSet = new HashSet<>(result);

        Assertions.assertTrue(expectSet.containsAll(resultSet));

    }


    @Test
    public void test3() {

        int N = 10;
        int step = 1 + 2 * N;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < step / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 1 + 2 * i; j++) {
                System.out.print("*");
            }
            for (int j = i; j < step / 2; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    @Test
    public void test4() {

        int[] arr = new int[]{2, 1, 5, 4, 2, 8};




    }


}
