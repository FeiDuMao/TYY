package study;


import org.junit.Test;

import java.util.Arrays;

public class Sort {


    /**
     * 快速排序，时间复杂度：n*log(n) 不稳定
     * 最好情况：每次分解时选取的元素为中间值
     * 最坏情况：每次分解时选取的元素为最大值或最小值
     */
    public void QuickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int i = low, j = high;
        int tmp = arr[low];
        while (i < j) {
            while (arr[j] >= tmp && i < j) j--;
            arr[i] = arr[j];
            while (arr[i] <= tmp && i < j) i++;
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);
    }


    //插入排序
    public int[] InsertSort(int[] array) {
        //抽牌
        for (int i = 1; i < array.length; i++) {
            //插入
            for (int j = i; j > 0; j--) {
                if (array[j] <= array[j - 1]) {
                    //交换
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }

    //归并排序，时间复杂度：n*log(n) 稳定
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

        //Arrays.sort(a);
        //QuickSort(a,0,a.length-1);
        //t1(a,0,a.length-1);



        sort2(a, 0, a.length - 1);
        System.out.println("排序后：" + Arrays.toString(a));


    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int i = low, j = high;
        int tmp = arr[low];
        while (i < j) {
            while (arr[j] >= tmp && i < j) j--;
            arr[i] = arr[j];
            while (arr[i] <= tmp && i < j) i++;
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);
    }


    public void sort2(int arr[],int low,int high){
        if (low>=high)return;
        int i=low,j=high,tmp=arr[low];
        while (i<j){
            while (i<j&&arr[j]>=tmp)j--;
            arr[i]=arr[j];
            while (i<j&&arr[i]<=tmp)i++;
            arr[j]=arr[i];
        }
        arr[i]=tmp;

        sort2(arr,low,i-1);
        sort2(arr,i+1,high);
    }




}
