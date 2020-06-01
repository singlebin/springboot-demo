package springboot.demo.algorithm.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]

 * @Author: wub
 * @date 2020/5/11 16:18
 */
public class SolutionTest {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 6, 7}, 10)));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
