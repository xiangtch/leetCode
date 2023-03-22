package resolve.common;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2023/3/22 17:48
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
