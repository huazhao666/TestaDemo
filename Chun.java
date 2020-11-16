import org.omg.CORBA.BAD_OPERATION;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-23
 * Time : 20:25
 */

class  ListNodea {
    int val;
    ListNodea next;

    public ListNodea(int val) {
        this.val = val;
    }
}
public class Chun {
    public static void main (String[] args){
        ListNodea n1 = new ListNodea(9);
        ListNodea n2 = new ListNodea(9);
        ListNodea n3 = new ListNodea(9);
        n1.next = n2;
        n2.next = n3;
        ListNodea newHead = fun(n1);
        for (ListNodea cur = newHead; cur != null; cur = cur.next) {
            System.out.print(cur.val);
        }
        System.out.println();
    }

    public static ListNodea fun(ListNodea head) {
        ListNodea newHead = reverse(head);
        int val = newHead.val + 1;
        if (val < 10) {
            newHead.val = val;
            return reverse(newHead);
        }
        boolean flag = true;
        newHead.val = 0;
        ListNodea cur = newHead.next;
        while (cur != null) {
            if (flag) {
                cur.val++;
            }
            if (cur.val == 10) {
                cur.val = 0;
                flag = true;
            } else {
                flag = false;
            }
            cur = cur.next;
        }
        return reverse(newHead);
    }
    public static ListNodea reverse(ListNodea head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNodea pre = null;
        ListNodea cur = head;
        while (cur != null) {
            ListNodea curNext = cur.next;
            if (curNext == null){
                head = cur;
            }
            cur.next =pre;
            pre =cur;
            cur = curNext;
        }
        return head;
    }
}
