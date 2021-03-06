package springboot.demo.algorithm.simple;

/**
 * @description:
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @Author: wub
 * @date 2020/5/11 10:38
 */
public class SqrtTest {

    public static void main(String[] args) {

        int i = 2 >>> 2;
        System.out.println("i=" + i);
        long t1 = System.currentTimeMillis();
        System.out.println(mySqrt(11));
        System.out.println((System.currentTimeMillis() - t1));
    }

    /**
     *
     * @param x
     * @return
     */
    private static int mySqrt(int x){
        if (x < 0) {
            return -1;
        }
        return (int) Math.floor(Math.sqrt(x));
        //二分查找 [0, x] 之间
//        int left = 0;
//        int right = x;
//        while(left < right){
//            /*
//            这里为什么使用的是 (left + right + 1) >>> 1 ， 而不是跟之前一样使用 (left + right) >>> 1 ？
//            因为我们下面需要的是 right = mid - 1 而不是 left = mid + 1，如果 (left + right) >>> 1 的话 left = mid 可能会造成死循环
//
//            为什么使用 right = mid - 1？
//            在不存在 一个整数平方等于 x 的情况下，比如 x = 8，有以下情况：
//            因为我们要求的是 相邻的两个数 x1 和 x2 ，x1 的平方比 x 小， x2 的平方比 x 大
//            比如 x = 8，那么 x1 = 2, x2 = 3
//            而我们需要返回的是 x1 = 2，即较小的值，因此，当我们遇到大值的时候，需要跳过该大值，往小值方向找
//            与以往的跳过小值，找大值不同
//            如果是以往的二分查找模板，那么当 break 找到的就会是 x2 = 3
//            */
//            int mid = (left + right + 1) >>> 1;
//            //注意：有案例是 2147395599，求得 mid 平方会超过 int ，因此需要将平方结果转为 long
//            if((long)mid * mid > x){
//                right = mid - 1;
//            }else{
//                left = mid;
//            }
//        }
//        return left;
    }
}
