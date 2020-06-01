package springboot.demo.algorithm.simple;

import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedList;

/**
 * @description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807

 * @Author: wub
 * @date 2020/5/12 11:30
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        int a = 11/10;
        System.out.println(a);
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(3);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(4);

        //初始化 进位为0
        int carry = 0;
        //初始化 p为list1的第一个节点
        int p = CollectionUtils.isEmpty(list1) ? 0 : list1.get(0);
        //初始化 q为list2的第一个节点
        int q = CollectionUtils.isEmpty(list2) ? 0 : list1.get(0);

//        while ()

    }

}
