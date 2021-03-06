package com.yui;

public class TT {    
	
	public static void qSort(int[] arr, int head, int tail) {
    if (head >= tail || arr == null || arr.length <= 1) {
        return;
    }
    int i = head, j = tail, pivot = arr[(head + tail) / 2];
    while (i <= j) {
        while (arr[i] < pivot) {
            ++i;
        }
        while (arr[j] > pivot) {
            --j;
        }
        if (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            ++i;
            --j;
        } else if (i == j) {
            ++i;
        }
    }
    qSort(arr, head, j);
    qSort(arr, i, tail);
}

public static void main(String[] args) {
    int[] arr = new int[]{3,7,8,5,2,1,9,5,4};
    qSort(arr, 0, arr.length - 1);
    String out = "";
    for (int digit : arr) {
        out += (digit + ",");
    }
    System.out.println(out);
}
}
