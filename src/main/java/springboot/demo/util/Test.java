package springboot.demo.util;

import com.alibaba.fastjson.JSON;
import springboot.demo.bean.StoreInfo;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author: wub
 * @date 2019/12/27 9:54
 */
public class Test {


    static /*volatile*/ OutputStream out;
    public static void main(String[] args) {
//        char s = 'a';
//        System.out.println(String.format("文件名不合法: [%c]", s));

//        Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());

        //仅在对流内元素进行操作时，peek才会被调用，当不对元素做任何操作时，peek自然也不会被调用了
//        Stream.of("one", "two", "three", "four")
//                .peek(System.out::println);
//

//        List<User> list = new ArrayList<>();
//        list.add(new User(1, "zz1", "1", 19));
//        list.add(new User(2, "zz2", "0", 17));
//        list.add(new User(3, "zz3", "0", 18));
//        list.add(new User(4, "zz4", "1", 20));
//
//        //String.format的应用
//        list.forEach(it -> System.out.println(String.format("名字：%s, 性别：%s, 年龄：%d", it.getName(), it.getSex(), it.getAge())));
//        String s = "{\"productCode\":\"DF18X60301\",\"name\":\"2018夏大东时尚女包\",\"brandCoce\":\"DD\",\"brandName\":\"大东\",\"yearCode\":\"2018\",\"yearName\":\"2018\",\"seasonCode\":\"X\",\"seasonName\":\"夏季\",\"costPrice\":31.00,\"sapCategoryCode1\":\"11\",\"sapCategoryCode2\":\"1102\",\"sapCategoryCode3\":\"110202\",\"sapCategoryCode4\":\"110202007\"},{\"productCode\":\"DF18X62334\",\"name\":\"2018夏大东时尚女包\",\"brandCoce\":\"DD\",\"brandName\":\"大东\",\"yearCode\":\"2018\",\"yearName\":\"2018\",\"seasonCode\":\"X\",\"seasonName\":\"夏季\",\"costPrice\":24.00,\"sapCategoryCode1\":\"11\",\"sapCategoryCode2\":\"1104\",\"sapCategoryCode3\":\"110401\",\"sapCategoryCode4\":\"110401002\"}";
//        byte[] compress = ZLibUtils.compress(s.getBytes(StandardCharsets.UTF_8));
//        System.out.println("压缩后的数据：" + new String(compress, StandardCharsets.UTF_8));
//        byte[] decompress = ZLibUtils.decompress(compress);
//        System.out.println("解压后的数据：" + new String(decompress, StandardCharsets.UTF_8));




//        String s = "1f8b0800000000000013ab562a28ca4f294d2e71ce4f4955b252727133b488303330363054d251ca4bcc05891919185a3c5dd2ff74c9f2273be63c9bbeede986594f976e7edad30a549254949897e29c9f0cd6eb0213f0836884e8000a56a62616412d00190615f143180f14294e4d2ccecf83aa8a800bc08dea7fba7631503439bfb824a0281364a1b1a19e8101505d62817362496a7a7e512548b72150b521c8f568e246607103234c1963a80c363913b89c8181b952ad4e35d6f03232363619fce1656442467899e00c2f13032cba4ce07206c0e0ac0500fa4be9d25f020000";
//        byte[] bytes = GZipUtils.hexStr2ByteArr(s);
//        byte[] uncompress = GZipUtils.uncompress(bytes);
//        System.out.println("解压后为：" + new String(uncompress, StandardCharsets.UTF_8));

        /*String s = "{\"productCode\":\"DF18X60301\",\"name\":\"2018夏大东时尚女包\",\"brandCoce\":\"DD\",\"brandName\":\"大东\",\"yearCode\":\"2018\",\"yearName\":\"2018\",\"seasonCode\":\"X\",\"seasonName\":\"夏季\",\"costPrice\":31.00,\"sapCategoryCode1\":\"11\",\"sapCategoryCode2\":\"1102\",\"sapCategoryCode3\":\"110202\",\"sapCategoryCode4\":\"110202007\"},{\"productCode\":\"DF18X62334\",\"name\":\"2018夏大东时尚女包\",\"brandCoce\":\"DD\",\"brandName\":\"大东\",\"yearCode\":\"2018\",\"yearName\":\"2018\",\"seasonCode\":\"X\",\"seasonName\":\"夏季\",\"costPrice\":24.00,\"sapCategoryCode1\":\"11\",\"sapCategoryCode2\":\"1104\",\"sapCategoryCode3\":\"110401\",\"sapCategoryCode4\":\"110401002\"}";
        byte[] compress = GZipUtils.compress(s, "UTF-8");
        //String s1 = GZipUtils.byteArr2HexStr(compress);
        System.out.println("先转16进制再压缩" + new String(compress));*/

//        String s = "ebd67747bc075c68a7ff8761bedebe5da6f3aa4b898b6dc265dca17af0b4b868d866d6b78af2953787cd4d037883969bcd60a8832006f657ffacbead6c021bdd80784a04fce398f69a77285b70d982cedc7861042bcc8f02a9e948963d4fc54b58f26829b33dcbd4ac706c0796d146378dc561f21a034de49991848b6c1bfa55b84b24de0b69a5259f0e6274252af8fc2b579fb751f42b322508225ec31be48c54f993ce22e0e3b08518a52709fae2ef5e4a2a987ca3080413d1eef06248bbf49518709214bfd0ce4d958a59b3e1642ca3ea2b400700f0c86cfd2ad60edf79c5b84a5a0418cb61a1e75caf8034c29e15";
//        byte[] bytes = ParseSystemUtil.parseHexStr2Byte(s);
//        System.out.println("bytes长度："+bytes.length);
//        int written = 0;
//
//        String s = "04";
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            int v = s.charAt(i);
//            try {
//                out.write((v >>> 0) & 0xFF);
//                out.write((v >>> 8) & 0xFF);
//            } catch (IOException e) {
//            }
//        }
//
//        int temp = written + len * 2;
//        if (temp < 0) {
//            temp = Integer.MAX_VALUE;
//        }
//        written = temp;
        List<StoreInfo> storeInfos = new ArrayList<>();
        storeInfos.add(new StoreInfo("8080", "V022"));
        storeInfos.add(new StoreInfo("8080", "8010"));
        storeInfos.add(new StoreInfo("8080", "8010"));
        storeInfos.add(new StoreInfo("8080", "8010"));
        Map<String, List<String>> map = new HashMap<>();
        List<String> storeCodes = new ArrayList<>();
        List<String> companyCodes = storeInfos.stream().filter(distinctByKey(StoreInfo::getCompanyCode)).map(StoreInfo::getCompanyCode).collect(Collectors.toList());
        //Map<String, String> collect = storeInfos.stream().collect(Collectors.toMap(storeInfo -> storeInfo.getCompanyCode(), StoreInfo::getStoreCode));
        storeInfos.forEach(it->{
            if(companyCodes.contains(it.getCompanyCode())){
                storeCodes.add(it.getStoreCode());
            }
        });
        companyCodes.forEach(it ->{
            map.put(it, storeCodes);
        });
        System.out.println("map=" + JSON.toJSONString(map));
    }
    /**
     * 去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
