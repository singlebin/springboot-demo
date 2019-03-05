package springboot.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * List拆分多份
 *
 * @author LiFengGu
 */
public class ListUtil {

    /**
     * 把list平分成n份
     *
     * @param source
     * @param n
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remaider = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remaider > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    /**
     * 把list按照size拆分
     *
     * @param source
     * @param size
     * @return
     */
    public static <T> List<List<T>> averageAssignBySize(List<T> source, int size) {
        if (size == 0) {
            return new ArrayList<List<T>>();
        }
        if (!(source != null && source.size() > 0)) {
            return new ArrayList<List<T>>();
        }
        List<List<T>> result = new ArrayList<List<T>>();
        int listSize = source.size();
        int pages = 0;
        pages = listSize / size;
        if (listSize % size != 0) {
            pages++;
        }

        for (int i = 0; i < pages; i++) {
            List<T> value = null;
            int max = (i + 1) * size;
            int start = i * size;
            if (max > listSize) {
                value = source.subList(start, listSize);
            } else {
                value = source.subList(start, max);
            }
            result.add(value);
        }
        return result;
    }


    /**
     * 将 ls 根据 num 大小拆分多份并返回
     *
     * @param ls  ls
     * @param num 大小
     * @param <T> T
     * @return .
     */
    public static <T> List<List<T>> splitList(List<T> ls, int num) {
        List<List<T>> lists = new ArrayList<>();
        int iMax = ls.size() / num;
        if (iMax > 0) {
            for (int i = 0; i < iMax; i++) {
                lists.add(ls.subList(i * num, (i + 1) * num));
            }
            int sInt = iMax * num;
            if (sInt < ls.size()) {
                lists.add(ls.subList(sInt, ls.size()));
            }
        } else {
            lists.add(ls);
        }
        return lists;
    }
}
