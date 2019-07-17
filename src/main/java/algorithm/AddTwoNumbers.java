package algorithm;

import com.google.gson.Gson;

import java.util.List;

/**
 *   两数相加
 *
 * @author xiangtch
 * @date 2019/7/17 23:41
 * @email xiangtch6@gmail.com
 */
public class AddTwoNumbers {

    /*
    *  题目：给出两个非空的链表表示两个非负的整数。其中它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字，
    *       如果我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    *  可以假设除了数字 0 外，这两个数都不会以 0 开头
    *
    *  示例：
    *    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    *    输出：7 -> 0 -> 8
    *    原因：342 + 465 = 807
    *
    * */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = findAddTwoNumbers(l1, l2);
        System.out.println(new Gson().toJson(result));
    }

    private static ListNode findAddTwoNumbers(ListNode l1, ListNode l2) {
       // 遍历 l1 和 l2，将对应位置的数进行求和运算，注意是否需要进位，进位只能为 0 或 1
        // 创建一个返回节点
        ListNode result = new ListNode(0);
        // 初始化进位值
        int carry = 0;
        // 定义两个遍历节点
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        // 定义新 ListNode 的交换节点
        ListNode temp = result;
        while (listNode1 != null || listNode2 != null){
            int val1 = listNode1 != null ? listNode1.val : 0;
            int val2 = listNode2 != null ? listNode2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (listNode1 != null){
                listNode1 = listNode1.next;
            }
            if (listNode2 != null){
                listNode2 = listNode2.next;
            }
        }
        if (carry > 0){
            temp.next = new ListNode(carry);
        }
        return result.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
