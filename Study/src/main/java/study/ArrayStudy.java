package study;

import org.junit.Test;

import java.util.*;

public class ArrayStudy {


    //盛水最多的容器
    public int water(int[] height) {
        //双指针思想
        int res = 0, i = 0, j = height.length - 1;

//        while (i!=j){
//            if (height[i]<height[j]){
//                if (height[i]*(j-i)>res)
//                    res=height[i]*(j-i);
//                i++;
//            }else {
//                if (height[j]*(j-i)>res)
//                    res=height[j]*(j-i);
//                j--;
//            }
//        }

        //简化版代码
        while (i != j) {
            int area = height[i] < height[j] ?
                    height[i] * (j - i++) :
                    height[j] * (j-- - i);
            res = Math.max(res, area);
        }

        return res;
    }

    //两数之和：暴力循环
    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[]{++i, ++j};
            }
        }
        return null;
    }

    //两数之和：hash表法
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            //关键：判断hash表中是否有  被减数的差 如果有则返回。
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    //最长无重复子数组的长度
    public int maxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (j < arr.length) {
            if (map.containsKey(arr[j])) {
                i = Math.max(map.get(arr[j]) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(arr[j], j);
            j++;
        }
        return ans;
    }

    //股票买卖
    public int maxProfit(int[] arr) {
        int get = 0, minPrice = arr[0];
        for (int i = 0; i < arr.length; i++) {
            //找到最低价格
            minPrice = Math.min(minPrice, arr[i]);
            //如果当天价格卖出收益更多
            get = Math.max(arr[i] - minPrice, get);
        }
        return get;
    }

    //返回斐波那契数列第n的值
    public int feibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1;
        for (int i = 0; i < n - 1; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    //二分查找
    public int halfSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                //注意细节:mid已经用过，所以high = mid - 1
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                //返回第一次出现target的下标
                while (mid != 0 && arr[mid - 1] == arr[mid]) mid--;
                return mid;
            }
        }
        return -1;
    }

    //无序数组中最长连续序列的长度
    public int MLS(int[] arr) {
        int tmp = 1;
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //if (arr[i] == arr[i + 1]) continue;
            if (arr[i] + 1 == arr[i + 1]) tmp++;
            else tmp = 1;
            ans = Math.max(tmp, ans);
        }
        return ans;

    }

    //快速排序
    public void sort1(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort1(arr, low, p - 1);
            sort1(arr, p + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int p = arr[low];
        while (low < high) {
            while (arr[high] > p && low < high) high--;
            arr[low] = arr[high];
            while (arr[low] < p && low < high) low++;
            arr[high] = arr[low];
        }
        arr[high] = p;
        return low;

    }

    //归并排序
    public int[] sort2(int[] arr) {
        if (arr.length < 2) return arr;
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        return merge(sort2(left), sort2(right));
    }

    public int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] ans = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            ans[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) ans[k++] = a[i++];
        while (j < b.length) ans[k++] = b[j++];

        return ans;
    }

    //寻找一个数组的中位数
    public double midNum(int[] a) {
        if (a.length % 2 != 0) {
            //因为数组下标从0开始，所以不用+1
            return a[(a.length / 2)];
        } else {
            return (a[a.length / 2] + a[(a.length / 2) - 1]) / 2.0;
        }
    }

    //寻找一个数第一次和最后一次出现的位置
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    //数组的下一个排列   leet.31
    public void nextPermutation(int[] nums) {
        int a = 0, b = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                a = i - 1;
                break;
            }
        }
        for (int i = nums.length - 1; i > a; i--) {
            if (nums[i] > nums[a]) {
                b = i;
                break;
            }
        }
        if (a == b) {
            reverse(nums, 0);
        } else {
            swap(nums, a, b);
            reverse(nums, a + 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reverse(int[] arr, int start) {
        int j = 0;
        for (int i = start; i < (start + arr.length) / 2; i++) {
            swap(arr, i, arr.length - j - 1);
            j++;
        }
    }


    //在二维数组中查找
    public boolean findNumberIn2DArray(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
                if (array[i][j] > target) {
                    break;
                }
            }
            if (array[i][0] > target) break;
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int target, int[][] matrix) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    //打家劫舍1，leetcode198
    public int rob(int[] nums) {
        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + dp[0];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[nums.length - 2], dp[nums.length - 1]);
    }

    public int rob2(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    //滑动窗口的最大值 nc82
    public int[] maxWindows(int[] arr, int size) {
        if (size > arr.length) return new int[1];
        int[] ans = new int[arr.length - size + 1];

        for (int i = 0; i <= arr.length - size; i++) {
            int max = arr[i];
            for (int j = i; j < i + size; j++) {
                max = Math.max(max, arr[j]);
            }
            ans[i] = max;
        }

        return ans;

    }

    //分段有序数组查找 [7,8,9,10,1,2,3,4,5,6]
    public int search2(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (target < arr[left]) {

            }

        }

        return -1;
    }

    //53. 最大子序和
    public int maxSubArray(int[] nums) {
        int pre = 0, ans = Integer.MIN_VALUE;
        for (int x : nums) {
            //动态规划，当前一个元素>0 就把前面的值累加起来，否则更新pre为当前值。
            pre = pre >= 0 ? pre + x : x;
            ans = Math.max(pre, ans);
        }
        return ans;
    }

    //56. 合并区间
    public int[][] merge2(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int left = arr[i][0];
            int right = arr[i][1];
            while (i < arr.length - 1 && right >= arr[i + 1][0]) {
                right = Math.max(right, arr[i + 1][1]);
                i++;
            }
            i++;
            ans.add(new int[]{left, right});
        }

        int[][] ints = ans.toArray(new int[ans.size()][]);
        return ints;
    }


    @Test
    public void test() {
        merge2(new int[][]{{0, 1}, {1, 3}, {4, 5}});
    }


}
