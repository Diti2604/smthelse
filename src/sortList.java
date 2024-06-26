public class sortList {
    public ListNode sortList(ListNode head) {
        ListNode curr = head, next = null;
        ListNode l = new ListNode(0);
        while (curr != null) {
            next = curr.next;
            ListNode p = l;
            while (p.next != null && p.next.val < curr.val)
                p = p.next;
            curr.next = p.next;
            p.next = curr;
            curr = next;
        }
        return l.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
