package springboot.demo.algorithm.simple;

/**
 * @description:
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 * @Author: wub
 * @date 2020/5/18 11:13
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    /** 1211
     *  输入一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
     * @param n
     * @return
     */
    private static String countAndSay(int n){
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j ++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count ++;
                } else {
                    stringBuilder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            StringBuilder append = stringBuilder.append(count).append(pre);
            str = append.toString();
        }
        return str;
    }



}
