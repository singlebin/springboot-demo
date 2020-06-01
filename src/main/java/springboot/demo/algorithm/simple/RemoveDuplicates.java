package springboot.demo.algorithm.simple;

import java.util.Arrays;

/**
 * @description:
 * @Author: wub
 * @date 2020/5/22 11:40
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1 ,2}));
    }



    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

}
