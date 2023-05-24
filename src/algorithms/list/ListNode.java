package algorithms.list;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        ListNode a3 = new ListNode(7);
        a2.next = a3;

        printList(a1);

        System.out.println("====");
        ListNode a4 = new ListNode(17);
        a3.next = a2;

        printList(a1);
    }

    private static void printList(ListNode listNode) {
        while (true) {
            System.out.println(listNode.val);
            if (listNode.next == null)
                break;
            listNode = listNode.next;
        }
    }

}
