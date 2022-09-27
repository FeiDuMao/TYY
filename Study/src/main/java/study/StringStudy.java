package study;

import org.junit.Test;
import scala.util.parsing.combinator.testing.Str;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Stream;

public class StringStudy {

    //字符串反转
    public String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    //最长无重复字串的长度
    public int maxLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //双指针，i为前指针，遇到重复值之后，i向前移动的重复的值的后一位处
        int i = 0, j = 0, ans = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                //防止出现多次相同值的时候，i向前移动
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
            j++;
        }
        return ans;
    }

    //判断一个数是否为回文数
    public boolean ishuiwen(int num) {
        if (num < 0) return false;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //字符串的数相加
    public String strAdd(String a, String b) {
        if (a == null) return b;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            s.insert(0, (x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            i--;
            j--;
        }
        if (carry > 0) s.insert(0, carry);
        return s.toString();
    }

    //字符串相乘
    public String multiply(String a, String b) {
        if (a.equals("0") || b.equals("0")) return "0";
        //n位数×m位数的结果不超过n+m位，不少于n+m-1位
        int[] ans = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int tmp = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                //加上之前的进位；
                tmp += ans[i + j + 1];
                ans[i + j + 1] = tmp % 10;
                ans[i + j] += tmp / 10;
            }
        }
        //将数组转化为String，并去掉前面多余的0
        int i;
        StringBuilder sb = new StringBuilder();
        if (ans[0] == 0) i = 1;
        else i = 0;
        while (i < ans.length) {
            sb.append(ans[i]);
            i++;
        }
        return sb.toString();
    }

    //最长回文字串长度
    public String maxLength2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0, right = 0, maxLen = 1;
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                //如果左右不等则不是回文。  左右边界相差小于2不用判断。 当前是否回文还要看内部是否也为回文。
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    //保存最长字串的位置
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        left = l;
                        right = r;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    //最长重复子串
    public int maxRepStr(String a) {
        if (a == null || a.length() == 1) {
            return 0;
        }
        int len = a.length();
        int count = 0;
        for (int i = len / 2; i > 0; --i) {
            for (int j = 0; j < len / 2; ++j) {
                if (a.charAt(j) == a.charAt(j + i)) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == i) {
                    return 2 * count;
                }
            }
        }
        return 0;

    }

    //整数反转
    public int numRev(int num) {
        int x = 0;
        while (num != 0) {
            if (x < Integer.MIN_VALUE / 10 || x > Integer.MAX_VALUE / 10) return 0;
            x = x * 10 + num % 10;
            num = num / 10;
        }
        return x;
    }

    //有效括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                switch (ch) {
                    case ')':
                        if (stack.peek() != '(') return false;
                        break;
                    case '}':
                        if (stack.peek() != '{') return false;
                        break;
                    case ']':
                        if (stack.peek() != '[') return false;
                        break;
                }
                stack.pop();
            } else stack.add(ch);
        }
        return stack.isEmpty();
    }

    //压缩字符串，返回字符串的长度，将压缩后的内容写回原数组
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        for (; i < chars.length; ) {
            sb.append(chars[i]);
            int count = 1;
            for (j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    count++;
                } else break;
            }
            if (count != 1)
                sb.append(count);
            i = j;
        }
        char[] tmp = sb.toString().toCharArray();
        System.arraycopy(tmp, 0, chars, 0, tmp.length);
        chars = tmp;
        return tmp.length;
    }

    //反转字符串，以单词为最小单位
    public void reverse2(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append(s1[i] + " ");
        }
        System.out.println(sb);
    }

    public void replace(String s, String o, String n) {
        s.indexOf(0);
    }

    /**
     * 打印一个三角形，用N控制层数
     */
    public void printTriangle() {
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
    public void test() {
        String s = "this is a duck";
        System.out.println(s.indexOf("is"));

    }


    public static Double getResult(String str) {

        // 递归头
        if (str.isEmpty() || str.matches("-?\\d+(\\.\\d+)")) {
            return str.isEmpty() ? 0 : Double.parseDouble(str);
        }

        //递归体
        if (str.contains(")")) {
            // 最后一个左括号
            int lIndex = str.lastIndexOf("(");
            // 对于的右括号
            int rIndex = str.indexOf(")", lIndex);
            return getResult(str.substring(0, lIndex) + getResult(str.substring(lIndex + 1, rIndex)) + str.substring(rIndex + 1));
        }
        if (str.contains("+")) {
            int index = str.lastIndexOf("+");
            return getResult(str.substring(0, index)) + getResult(str.substring(index + 1));
        }
        if (str.contains("-")) {
            int index = str.lastIndexOf("-");
            return getResult(str.substring(0, index)) - getResult(str.substring(index + 1));
        }
        if (str.contains("*")) {
            int index = str.lastIndexOf("*");
            return getResult(str.substring(0, index)) * getResult(str.substring(index + 1));
        }
        if (str.contains("/")) {
            int index = str.lastIndexOf("/");
            return getResult(str.substring(0, index)) / getResult(str.substring(index + 1));
        }

        // 出错
        return Double.NaN;
    }

    /**
     * 正则表达式
     */

    @Test
    public void regexStudy() throws ScriptException {

        String str = "0.8*(0.1*(0.1*1+0.9)+0.9*(0.3+0.7*1))+0.2";

        System.out.println(getResult(str));


    }


    private void validateParam(String str) {
        if (str.contains("(")) {
            String next = str.substring(str.lastIndexOf("(") + 1, str.indexOf(")"));
            validateParam(next);
            validateParam(str.replace("(" + next + ")", "1"));
        }
        System.out.println(getResult(str));

    }

    private static boolean validateCoefficientSum(String str) {
        if (!str.contains("(")) {
            return getResult(str) == 1;
        }
        String next = str.substring(str.lastIndexOf("(") + 1, str.indexOf(")"));

        return validateCoefficientSum(next) && validateCoefficientSum(
                str.substring(0, str.indexOf(next) - 2) + str.substring(str.indexOf(next) + next.length() + 1)
        );

    }




    @Test
    public void test55() throws ScriptException {

        Double d1=0.99999;
        Double d2=1.00001d;


        System.out.println(NumberFormat.getInstance().format(d1));
        System.out.println(NumberFormat.getInstance().format(d2));


    }





}
