package study;


import org.junit.Test;

import java.util.Arrays;
import java.util.Queue;

/**
 * 稳定：排序后，相等的元素的相对位置没有变则稳定
 * 时间复杂度：
 * 空间复杂度：
 */
public class Sort {

    //交换数组中的两个元素
    public void exchange(int[] arr, int from, int to) {
        int tmp = arr[to];
        arr[to] = arr[from];
        arr[from] = tmp;
    }


    /**
     * 冒泡排序：平均时间复杂度：n^2  稳定
     * 最好情况：n
     * 最坏情况：n^2
     */
    public void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * 插入排序：平均时间复杂度：n^2 稳定
     * 最好情况：n
     * 最坏情况：n^2
     * 适用于总体有序的情况
     */
    public int[] InsertSort(int[] arr) {
        //抽牌
        for (int i = 1; i < arr.length; i++) {
            //插入
            for (int j = i; j > 0; j--) {
                if (arr[j] <= arr[j - 1]) {
                    //交换
                    exchange(arr, j, j - 1);
                }
            }
        }
        return arr;
    }


    /**
     *选择排序：平均时间复杂度：n^2 不稳定
     * 最好情况：n^2
     * 最坏情况：n^2
     * 每次找到一个元素的正确位置（比较暴力）
     */
    public void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = i;
            //一轮循环后得到当前最小元素的下标
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j]<arr[tmp]){
                    tmp=j;
                }
            }
            exchange(arr,i,tmp);

        }
    }


    /**
     * 快速排序，平均时间复杂度：n*log(n) 不稳定
     * 空间复杂度：log(n)
     * 最好情况：n*log(n):每次分解时选取的元素为中间值
     * 最坏情况：n^2:每次分解时选取的元素为最大值或最小值
     * 每次递归找到一个元素的正确位置
     */
    public void QuickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int i = low, j = high;
        //选取标针
        int tmp = arr[low];
        while (i < j) {
            while (arr[j] >= tmp && i < j) j--;
            arr[i] = arr[j];
            while (arr[i] <= tmp && i < j) i++;
            arr[j] = arr[i];
        }

        arr[i] = tmp;
        QuickSort(arr, low, i - 1);
        QuickSort(arr, i + 1, high);
    }


    /**
     * 归并排序，时间复杂度: nlog(n) 稳定
     * 空间复杂度：n：每轮merge后空间会回收
     * 最好情况与最坏情况一样
     */
    public int[] MergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        //讲数组拆分为两半
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        //进行递归 归并
        return merge2(MergeSort(left), MergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public int[] merge2(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            //因为left[i] <= right[j]，相对位置没有改变，所以是稳定排序
            result[k++] = left[i] <= right[j] ?
                    left[i++] : right[j++];
        }
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];

        return result;
    }

    //二分查找
    public int midSearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = arr.length / 2;
        while (left <= right) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] a = new int[]{7, 4, 1, 8, 5, 5, 2, 9, 6, 3, 10};

        System.out.println("排序前：" + Arrays.toString(a));

        SelectionSort(a);

        System.out.println("排序后：" + Arrays.toString(a));


    }


}
