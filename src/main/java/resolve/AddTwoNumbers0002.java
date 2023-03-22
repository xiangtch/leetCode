package resolve;

import com.google.gson.Gson;
import resolve.common.ListNode;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2023/3/22 17:46
 */
public class AddTwoNumbers0002 {

    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4, l13);
        ListNode l12 = new ListNode(2, l14);

        ListNode l24 = new ListNode(4);
        ListNode l26 = new ListNode(6, l24);
        ListNode l25 = new ListNode(5, l26);

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
