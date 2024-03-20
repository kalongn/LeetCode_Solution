class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int suba = a - 1, addb = b + 1;
        ListNode subaNode = list1, addbNode = list1;
        while (suba > 0) {
            subaNode = subaNode.next;
            suba--;
        }
        while (addb > 0) {
            addbNode = addbNode.next;
            addb--;
        }
        ListNode endOfListTwo = list2;
        while (endOfListTwo != null && endOfListTwo.next != null) {
            endOfListTwo = endOfListTwo.next;
        }
        subaNode.next = list2;
        endOfListTwo.next = addbNode;
        return list1;
    }
}
