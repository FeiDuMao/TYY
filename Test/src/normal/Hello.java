package normal;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Hello {
    public static void main(String[] args) {

        String s = "fd6507a5-561b-471d-9c59-7d3c7c238c6b?_t=1639559238257";
        String substring = s.substring(0, s.indexOf('?'));
        System.out.println(substring);


    }


    @Test
    public void test() {

        LocalDate parse = LocalDate.parse("2004-01-01");
        LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        parse.plusDays(3);
        System.out.println(parse);


        LocalDate start = LocalDate.parse("2020-01-01");
        LocalDate now = LocalDate.now();

        long year, month, day;
        long days = Duration.between(start.atStartOfDay(), now.atStartOfDay()).toDays();

        days = 375;

        long l = Long.parseLong("1102176000000");
        LocalDate date = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault()).toLocalDate();
        System.out.println(date);

        System.out.println(parse.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

    }


    @Test
    public void test2() {
        ArrayList<String> list = Lists.newArrayList("123", "321", "222", "123", "321", "222", "123", "321", "222", "1244");
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("111", "111");
        multimap.put("111", "111");
        multimap.put("111", "333");

        Collection<String> strings = multimap.get("111");


        List<List<String>> partition = Lists.partition(list, list.size());


        int size = list.size();
        int p = size / 3;
        List<List<String>> partList = new ArrayList<>();
        int i = 0;
        for (; i < 3; i++) {
            partList.add(list.subList(i * p, (i + 1) * p));
        }
        partList.add(list.subList(i * p, size));

        String join = String.join(",", list);

        System.out.println(join);

    }

    @Test
    public void test3() {

        ArrayList<String> list = Lists.newArrayList("111", "444", "111");


        Collections.reverse(list);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("2021-01-01", 1);
        map2.put("2021-01-05", -5);
        map2.put("2021-01-03", 3);
        map2.put("2021-01-04", 4);
        map2.put("2021-01-02", -2);
        map2.put("2021-01-06", 6);


        List<Integer> collect4 = map2.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getValue).collect(Collectors.toList());

        Collections.reverse(collect4);


        ArrayList<Map.Entry<String, Integer>> entries1 = new ArrayList<>(map2.entrySet());


        List<String> collect2 = entries1.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> collect3 = entries1.stream().map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println("xxx");

    }

    private String getQueryCode(Double code) {

        while (code % 10 == 0) {
            code /= 10;
        }
        return String.valueOf(code.longValue());

    }

    public static Double calculate(Collection<Double> params) {
        if (params == null || params.isEmpty()) {
            return Double.NaN;
        }

        DescriptiveStatistics stats = new DescriptiveStatistics();
        params.stream().filter(param -> param != null && !param.isNaN()).forEach(stats::addValue);

        return stats.getStandardDeviation();
    }

    public static Double Calculate(List<Double> dailyReturns) {

        List<Double> negativeReturns = dailyReturns.stream().filter(aDouble -> aDouble < 0).collect(toList());

        return calculate(negativeReturns) * Math.sqrt(250);

    }

    public static Double calcAvg(Collection<Double> params) {

        double sum = params.stream().flatMapToDouble(aDouble -> DoubleStream.of(aDouble.doubleValue())).sum();
        return sum / params.size();

    }

    public static Double Calculate2(List<Double> dailyReturns, List<Double> riskFreeRatios) {

        Double dailyReturnAvg = calcAvg(dailyReturns);
        Double riskFreeRatioAvg = calcAvg(riskFreeRatios);
        Double downwardVolatility = Calculate(dailyReturns);

        return ((dailyReturnAvg - riskFreeRatioAvg) / downwardVolatility) * Math.sqrt(250);

    }


    @Test
    public void test4() {

        ArrayList<Double> d1 = Lists.newArrayList(0.0095356535166502, -0.024503765627741814, -0.008560201153159142, 0.013729652389883995, -0.006003906484693289, 0.01053518708795309, -0.011259382590651512, -0.016870519146323204, -0.0035750034730881453, 0.0070321448147296906, 0.001995154656469822, 0.003982364200055599, 0.0016999590443447232, 0.000848537078127265, -0.011162923648953438, 0.015147184953093529, -0.017595719546079636, 0.007164349779486656);
        ArrayList<Double> d2 = Lists.newArrayList(0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202, 0.00004079155041836202);

        Double aDouble = Calculate2(d1, d2);
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();

        double []x={1,3,4,5};
        double[][]y={{1,2},{3,4},{5,6},{7,8}};


        ols.newSampleData(x,y);
        double[] doubles1 = ols.estimateRegressionParameters();



        ArrayList<Double> doubles = Lists.newArrayList(1d, 2d, 3d, 4d, 5d);
        Double aDouble1 = calcAvg(doubles);

        System.out.println(aDouble);
    }

    public static Double getAlpha(List<Double> fundReturnList, List<Double> marketReturnList, List<Double> riskFreeRate) {
        SimpleRegression simR = new SimpleRegression();
        IntStream.range(0, fundReturnList.size()).
                forEach(s -> simR.addData(marketReturnList.get(s) - riskFreeRate.get(s), fundReturnList.get(s) - riskFreeRate.get(s)));
        return simR.getIntercept();
    }



    /**
     * @Description 组合统计区间内实际贝塔
     * @Return java.lang.Double
     */
    public static Double getBeta(List<Double> fundReturn, List<Double> benchmarkReturn, List<Double> riskFreeRatio) {
        List<Double> fundSubFreer = getASubB(fundReturn, riskFreeRatio);
        List<Double> benchSubFreer = getASubB(benchmarkReturn, riskFreeRatio);
        return getBeta(fundSubFreer, benchSubFreer);

    }


    /**
     * 计算两组数据的差值
     *
     * @param one 日收益率组1
     * @param two 日收益率组n
     * @return 返回List
     */
    private static List<Double> getASubB(List<Double> one, List<Double> two) {

        return IntStream.range(0, one.size()).boxed().map(i -> one.get(i) - two.get(i)).collect(toList());

    }


    /**
     * 根据两组数据计算beta系数
     *
     * @param one
     * @param two
     * @return beta系数
     */

    public static Double getBeta(List<Double> one, List<Double> two) {
        return getCovariance(one, two) / getSampleVariance(two);
    }


    /**
     * 根据两组数据计算协方差
     *
     * @param one
     * @param two
     * @return 协方差
     */

    public static Double getCovariance(List<Double> one, List<Double> two) {
        Double covariance = 0.0;
        Double avg_one = calcAvg(one);
        Double avg_two = calcAvg(two);
        for (int i = 0; i < one.size(); i++) {
            covariance += (one.get(i) - avg_one) * (two.get(i) - avg_two);
        }
        covariance = covariance / (one.size() - 1);
        return covariance;
    }

    /**
     * 根据两组数据计算方差
     *
     * @param dates
     * @return 方差
     */

    public static Double getSampleVariance(List<Double> dates) {
        Double avg = calcAvg(dates);
        double variance = 0.0;
        for (Double data : dates) {
            variance += Math.pow((data - avg), 2);
        }
        return variance / (dates.size() - 1);
    }


}
