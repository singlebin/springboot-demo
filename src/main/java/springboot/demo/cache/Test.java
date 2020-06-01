package springboot.demo.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 *
 * @Author: wub
 * @date 2020/3/23 15:04
 */
public class Test {
    public static void main(String[] args) {

//        String big = "mississippi";
//        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
//        Arrays.stream(smalls).forEach(it ->{
//            Map<String, List<Integer>> finder = finder(big, it);
//            System.out.println("finder=" + JSON.toJSONString(finder));
//        });

        String a1 = "AA" + "BB";//在常量池上创建常量AA、BB和AABB，并返回AABB
        System.out.println("a1=" + a1);

    }

    public static Map<String, List<Integer>> finder(String source, String regexStr) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> position = new ArrayList<>();
        String regex = "[a-zA-Z]+";
        if (regexStr != null && !regexStr.equals("")) {
            regex = regexStr;
        }
        Pattern expression = Pattern.compile(regex);
        Matcher matcher = expression.matcher(source);

        int n = 0;
        //这个字符出现的次数
        int sum = 0;
        while (matcher.find()) {
            int i = source.indexOf(regexStr, n);
            position.add(i);
            //System.out.println("regexStr=" + regexStr + ",出现的位置i=" + ",  " + i);
            if(i != -1){
                n = n + i + 1;
            }
            sum ++;
        }
        map.put(regexStr, position);
        return map;
    }


}
