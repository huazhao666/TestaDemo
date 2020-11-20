/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-20
 * Time : 16:41
 */
class Node3{
    public  int data;
    public Node3 next;


    public Node3( int data){
        this.data = data;
    }
}

public class MyTry {
    public Node3 head;
//头插入
    public void addFirst(int data){
       Node3 node = new Node3(data);
       node.next = this.head;
       this.head = node;
    }
//尾插入
    public void addLast(int data){
        Node3 node = new Node3(data);
        Node3 cur = this.head;
        if (this.head == null){
            addFirst(data);
            return;
        }
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
// 任意位置插入
    public void addIndex(int index,int data){
        if (index < 0 || index > this.size()){
            System.out.println("插入不合法");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        Node3 cur = searchPrev(index);
        Node3 node = new Node3(data);
        node .next = cur.next;
        cur.next = node;
    }
//查找插入任意位置的节点
    public Node3 searchPrev(int index){
        int count = 0;
        Node3 cur = this.head;
            while (count < index - 1){
                count ++;
                cur = cur.next;
        }
        return cur;
    }
//查找关键字；
    public boolean contains(int key){
        Node3 cur = this.head;
        while (cur != null) {
            if (cur .data == key){
                return true;
            }
            cur = cur.next;
        }
      return  false;
    }
//删除第一个关键字key
    public void reMove(int key ){
        if (this.head.data == key){
            this .head = this.head.next;
            return;
        }
        Node3 prep = searchPrevNode2(key);
        if(prep == null){
            System.out.println("没有关键字");
            return;
        }
        Node3 abc = prep.next;// 假设关键字就是abc的数字
        prep.next = abc.next;
    }
//寻找关键字key的前驱
    public  Node3 searchPrevNode2(int key){
        Node3 cur = this.head;
        while (cur.next != null){
            if (cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return  null;
    }
 //打印链表长度
     public int size(){
        int count = 0;
        Node3 cur = this.head;
        while (cur != null){
            count ++;
            cur = cur.next;
        }
        return count;
 }
//打印链表
    public void display(){
        Node3 cur = this.head;
        while (cur != null){
            System.out.print( cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //删除全部关键字key；
    public  void  reMoveAll(int key){
        Node3 prev = this.head;
        Node3 cur = this.head.next;
        while (cur != null){
            if (cur.data == key){
                prev.next = cur.next;
            }else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        if (this.head.data == key){
            this.head = this.head.next;
        }
    }
// 寻找中间节点；
    public Node3 midList() {
        Node3 fast = this.head;
        Node3 slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //找到倒数第k个关键字；
    public  Node3 daoShu(int k) {
        Node3 fast = this.head;
        Node3 slow = this.head;
       if (k <= 0 ){
           System.out.println("输入错误");
           return null;
       }
       while (k -1 > 0){
           if (fast .next != null ){
               fast = fast.next;
               k --;
           }else {
               System.out.println("没有找到关键字");
               return null;
           }
       }
       while (fast.next!= null){
           fast = fast.next;
           slow =slow.next;
       }
       return slow;
    }
    //反转链表；
    public  Node3 fanZhuan(){
       Node3 perv = null;
       Node3 cur = this.head;
       Node3 newHead = null;
       while (cur != null){
           Node3 curNext = cur.next;
           if (curNext == null){
               newHead = cur;
           }
           cur.next = perv;
           perv = cur;
           cur = curNext;
       }
       return newHead;
    }
    //公共节点
    public Node3 getnetersetionNode(Node3 headA,Node3 headB){
        if(headA == null || headB == null){
            return null;
        }
        Node3 pl = headA;
        int lenA = 0;
        while (pl != null){
            lenA ++;
            pl = pl .next;
        }
        Node3 ps = headB ;
        int lenB = 0;
        while (ps != null ){
            lenB ++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA - lenB;
        if (len < 0){
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        for (int i = 0; i <len; i++) {
            pl = pl.next;
        }
        while (pl != ps && pl != null && ps !=null){
            pl = pl.next;
            ps = ps.next;
        }
        if (pl == ps && pl != null){
            return ps;
        }
        return null;
    }
    //小于x的放到前面去；不乱顺序；
    public  Node3 partition(int x){
        Node3 as = null;
        Node3 ae = null;
        Node3 bs = null;
        Node3 be = null;
        Node3 cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur =cur.next;
        }
        if(bs == null || as == null){
            return this.head;
        }else {
            be.next = as;
            as.next = null;
        }
        return bs;
    }
    //判断回文；
    public boolean chkPalindrome(){
        if (this.head == null){
            return false;
        }
        if (this.head.next == null){
            return true;
        }
        Node3 fast = this.head;
        Node3 slow = this.head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node3 cur = slow.next;
        while (cur != null){
            Node3 curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (slow != this.head){
            if (this.head.data != slow.data){
                return false;
            }
            if (this.head.next == slow){
                return  true;
            }
            this.head=this.head.next;
            slow=slow.next;
        }
        return true;
    }
    //判断是否有环；
    public boolean hasCycle(){
        Node3 fast = this.head;
        Node3 slow = this.head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next== null){
            return false;
        }
        return true;
    }

    public static void main (String[] args){
        MyTry mytry = new MyTry();
        mytry.addFirst(5);
        mytry.addFirst(3);
        mytry.addFirst(4);
        mytry.display();
        mytry.addLast(6);
        mytry.addLast(9);
        mytry.display();
        Node3 ret = mytry.midList();
        System.out.println(ret.data);
        Node3 ret2 = mytry.daoShu(2);
        System.out.println(ret2.data);
        Node3 ret3 = mytry.daoShu(5);
        System.out.println(ret3.data);
        Node3 ret4 =mytry.daoShu(1);
        System.out.println(ret4.data);
//        mytry.reMoveAll(4);
//        mytry.display();
//        System.out.println(mytry.size());
//        mytry.addIndex(6,0);
//        mytry.addIndex(0,8);
//        mytry.addIndex(4,8);
//        mytry.display();
//        System.out.println(mytry.contains(4));
//        System.out.println(mytry.contains(10));
//        mytry.reMove(3);
//        mytry.display();
//        mytry.reMove(3434);
//        mytry.display();
//        mytry.reMove(6);
//        mytry.display();

    }
}
