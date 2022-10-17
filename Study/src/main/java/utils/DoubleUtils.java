package utils;

import java.text.DecimalFormat;
/**
 * @Date 2022/10/13 11:21
 * @Created by taoyuanyuan
 */
public class DoubleUtils {


    private DoubleUtils() {
    }


    public static boolean isNotValid(Double d) {
        return d == null || d.isNaN() || d.isInfinite();
    }

    public static boolean isValid(Double d) {
        return !isNotValid(d);
    }

    public static boolean isSimilar(Double a, Double b, Double delta) {
        return Math.abs(a - b) < delta;
    }

    public static Double format(Double d, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        return Double.parseDouble(format.format(d));
    }


}
