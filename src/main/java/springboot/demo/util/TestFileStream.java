package springboot.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

/**
 * @description:
 * @Author: wub
 * @date 2020/4/29 9:20
 */
public class TestFileStream {



    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ObjectMapper objectMapper = new ObjectMapper();
        //输出流
//        List<String> list = Arrays.asList("小明", "2", "3");
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\a.txt"));
//        try {
//            fileOutputStream.write(objectMapper.writeValueAsBytes(list));
//            fileOutputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //输入流

//        List<String> strList = new ArrayList<>();
//        strList.add("1");
//        strList.add("2");
//        // jdk8 使用lambda表达式
//        List<String> map = map(strList, it -> it + "1");
//        List<Integer> intList = map(strList, s -> Integer.parseInt(s) * 10);
        // strList["1","2"]
        // intList[10,20]

        int a = 1 << 4;
        System.out.println(a);

    }
    
        /**
         * 定义一个接口,它接收一个类型,返回另一个类型.
         *
         * @param <T> 一个类型的方法参数
         * @param <R> 一个类型的返回
         */
        interface Func_TR<T, R> {
            // 接收一个类型,返回另一个类型.
            R apply(T t);
        }

        /**
         * 定义mapping函数
         *
         * @param src    提供数据,因此这里使用(get) 上边界通配符
         * @param mapper mapping 函数的具体实现
         * @param <?     extends R> 提供数据,这里是作为apply的返回值, 因此使用 上边界通配符
         * @param <?     super T>接收数据,这里作为 apply的传入参数
         * @return 返回值不要使用 通配符来定义
         */
        public static <R, T> List<R> map(List<? extends T> src, Func_TR<? super T, ? extends R> mapper) {
            if (src == null)
                throw new IllegalArgumentException("List must not be not null");
            if (mapper == null)
                throw new IllegalArgumentException("map func must be not null");
            // coll 既需要接收数据(add),又需要提供数据(return),所以不使用通配符
            List<R> coll = new ArrayList<>();
            for (T t : src) {
                coll.add(mapper.apply(t));
            }
            return coll;
        }

        /**
         *
         * @param map
         * @param <K>
         * @param <V>
         * @return
         */
        public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
            List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

            list.sort((o1, o2)-> o2.getValue().compareTo(o1.getValue()));

            Map<K, V> result = new LinkedHashMap<>();
            list.stream().forEach(entry -> result.put(entry.getKey(), entry.getValue()));

            return result;
        }




}
