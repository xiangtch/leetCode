package algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * 删除链表的倒数第 N 个节点
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2022/10/31 11:40
 */
public class RemoveNthFromEnd0019 {

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(Arrays.asList(1, 2, 3, 4, 5), 2));
    }

    private static List<Integer> removeNthFromEnd(List<Integer> head, int n) {

        return null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
