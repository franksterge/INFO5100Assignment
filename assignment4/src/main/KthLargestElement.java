package main;

import java.util.*;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(kthLargestElement(nums, k));
    }

    public static int kthLargestElement(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private static int partitionArr(int[] nums, int startIndex, int endIndex) {
        int pivot = nums[endIndex];
        int wall = startIndex;
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, wall);
                wall += 1;
            }
        }
        swap(nums, wall, endIndex);
        return wall;
    }

    public static int findKthLargest(int[] nums, int startIndex, int endIndex, int k) {
        int wall = partitionArr(nums, startIndex, endIndex);
        if (wall - startIndex == k - 1) {
            return nums[wall];
        }
        if (wall - startIndex > k - 1) {
            return findKthLargest(nums, startIndex, wall - 1, k);
        }
        return findKthLargest(nums, wall + 1, endIndex, k - wall + startIndex - 1);
    }

    private static void swap(int[]nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
