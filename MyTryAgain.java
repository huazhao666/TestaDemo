/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-20
 * Time : 18:41
 */
class Node4{
    public int data;
    public Node4 next;
    public Node4 (int data){
        this.data = data;
    }
}
public class MyTryAgain {
    public Node4 head;
//头插法
    public void addFirst(int data){
        Node4 node = new Node4(data) ;
        node.next= this.head;
        this.head = node ;
    }
//尾插法
    public void addLast (int data){
        Node4 node = new Node4(data);
        Node4 cur =  this.head;
        if (cur == null ){
            addFirst(data);
            return;
        }
        while (cur.next != null){
            cur = cur.next;
        }
      cur.next = node;
    }
//打印链表
    public void display (){
        Node4 cur = this.head;
        while ( cur != null){
            System.out.print(cur.data + " ");
            cur = cur .next;
        }
        System.out.println();
    }
//打印链表长度；
    public int size(){
        int count = 0;
        Node4 cur = this.head;
        while (cur != null){
            count ++;
            cur = cur.next;
        }
        return count ;
    }
//    任意位置插入数字；
    public void addIndex(int index ,int data){
        Node4 node = new Node4(data);
        if (index < 0 || index > this.size() ){
            System.out.println("插入不合法");
            return;
        }
        if (index == 0 ){
            addFirst(data);
            return;
       }
        Node4 cur = reseachPrev(index);
        node.next = cur.next;
        cur.next = node;
    }
//寻找插入数字的节点
    public Node4 reseachPrev(int index ){
        int count = 0;
        Node4 cur = this.head;
        while ( count < index -1 ){
            count ++ ;
            cur = cur .next;
        }
        return cur;
    }
//寻找关键元素key是否存在；
    public  boolean contains (int key ){
        Node4 cur = this.head;
        while (cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return  false;
    }
//删除遇到的第一个关键字key
    public void reMove(int key){
        if(this.head == null){
            System.out.println("找不到关键字");
            return;
        }
        Node4 cur = searachPrev(key);
        if (cur == null  ){
            return;
        }
        Node4 sos = cur.next;
        cur.next = sos.next;
    }
    //寻找key的前驱
    public Node4 searachPrev(int key){
        Node4 cur = this.head;
        while (cur.next != null){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除所有为key的值
    public void   reMoveAll(int key ){
        Node4 prev = this.head;
        Node4 cur = this.head.next;
        if (this.head == null){
            System.out.println("错误");
            return  ;
        }
        while (cur != null){
            if (cur.data == key){
                prev.next = cur.next;
            }else{
              prev = prev.next;
            }
            cur =cur.next;
        }
        if (this.head.data == key){
            this.head = this.head.next;
        }
    }
    //寻找中间节点
    public  Node4 midList(){
        Node4 fast = this.head;
        Node4 slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //寻找倒数第k个节点；
    public Node4 daoShuK(int k){
        if (k <= 0 || this.head == null){
            return null;
        }
        Node4 fast = this.head;
        Node4 slow = this.head;
        while (k-1 > 0){
            if (fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有该节点");
                return null;
            }
        }
        while (fast.next != null){
            fast = fast.next;
            slow =slow.next;
        }
        return  slow;
    }
    //反转链表；
    public Node4 fanZhuan(){
        Node4 prev = null;
        Node4 cur = this.head;
        Node4 newHead = null;
        while (cur != null){
            Node4 curNext = cur.next;
            if (curNext == null){
                newHead = cur;
            }
            cur.next = prev ;
            prev = cur ;
            cur = curNext;
        }
        return newHead;
    }
    public void display2 ( Node4 newHead){
        Node4 cur = newHead;
        while ( cur != null){
            System.out.print(cur.data + " ");
            cur = cur .next;
        }
        System.out.println();
    }
    //小于

    public static void main (String[] args){
        MyTryAgain myTryAgain = new MyTryAgain();
        myTryAgain.addFirst(4);
        myTryAgain.addFirst(9);
        myTryAgain.addFirst(6);
        myTryAgain.display();
        myTryAgain.addLast(5);
        myTryAgain.addLast(0);
        myTryAgain.display();
        Node4 ret = myTryAgain.fanZhuan();
        myTryAgain.display2(ret);
//        myTryAgain.reMoveAll(8);
//        myTryAgain.display();
//        Node4 ret = myTryAgain.midList();
//        System.out.println(ret.data);
//        Node4 ret2 = myTryAgain.daoShuK(3);
//        System.out.println(ret2.data);
//
//        System.out.println(myTryAgain.size());
//        myTryAgain.addIndex(0,10);
//        myTryAgain.addIndex(2,7);
//        myTryAgain.addIndex(7,99);
//        myTryAgain.display();
//        System.out.println(myTryAgain.contains(200));
//        System.out.println(myTryAgain.contains(99));
//        myTryAgain.reMove(4);
//        myTryAgain.reMove(3);
//        myTryAgain.display();

    }

















}
