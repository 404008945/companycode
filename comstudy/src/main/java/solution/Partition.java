package solution;

public class Partition {
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode partition(ListNode head, int x) {
      if(head == null){
          return null;
      }
        ListNode minHead = null;
        ListNode minTail = null;
        ListNode maxHead = null;
        ListNode maxTail = null;

        while (head != null) {//遍历链表
            if(head.val<x){
                //放入min head链表
                if(minHead == null){
                    minHead = new ListNode(head.val);
                    minTail = minHead;
                }else {
                    ListNode node = new ListNode(head.val);
                    minTail.next = node;
                    minTail = node;
                }

            }else {
                //放入max head链表
                if(maxHead == null){
                    maxHead = new ListNode(head.val);
                    maxTail = maxHead;
                }else {
                    ListNode node = new ListNode(head.val);
                    maxTail.next = node;
                    maxTail = node;
                }
            }
            head = head.next;
        }
        if(minTail == null){
            return maxHead;
        }
        minTail.next = maxHead;
        return minHead;
    }

    public static void main(String[] args) {
        String str = "ABCDEFGHJHSBDHSBHBS";

        int n =3;

        char [][] arr = new  char[n][str.length()];
        for(int i=0 ;i<n;i++){
            for(int j=0;j<str.length();j++){
                arr[i][j] = ' ';
            }
        }

        int h=0,w=0;
        boolean flag = false;


        for(int i=0;i<str.length();i++){
            arr[h][w] = str.charAt(i);

            if(!flag){
                h++;
            }else {
                h--;
                w++;
            }
            if(h == 0){
                flag = false;
            }
            if(h == n-1){
                flag =true;
            }
        }
        for(int i=0 ;i<n;i++){
            for(int j=0;j<str.length();j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }
}
