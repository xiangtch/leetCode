package resolve;

import com.google.gson.Gson;
import resolve.common.ListNode;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2023/3/22 17:46
 */
public class AddTwoNumbers0002 {

    public static void main(String[] args) {
        /*
        * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        *
        * */
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4, l13);
        ListNode l12 = new ListNode(2, l14);

        ListNode l24 = new ListNode(4);
        ListNode l26 = new ListNode(6, l24);
        ListNode l25 = new ListNode(5, l26);

        /*
        * 同事遍历两个链表 l1,l2 对应节点值相加，进位记为 carry。当l1,l2 同时遍历借宿，并且 carry 为 0 时，结束遍历
        * 时间复杂度为O(max(m,n))，空间复杂度为 O(1)
        * */
        System.out.println(new Gson().toJson(addTwoNumbers(l12, l25)));

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = s / 10;
            cur.next = new ListNode(s % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
