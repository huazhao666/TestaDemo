/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-20
 * Time : 21:20
 */
class Node5{
    public  int  data;
    public Node5 next;

    public  Node5 (int data){
        this.data = data;
    }
}
public class MyTryTry {
    public Node5 head ;
    //头插入；
    public void addFrist(int data){
        Node5 node = new Node5(data);
        node .next = this .head;
        this.head = node;
    }
    //打印链表
    public void disPlay (){
        Node5 cur = this.head;
        while (cur != null){
            System.out.print( cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //尾插入
    public void addLast(int data){
        Node5 node = new Node5(data);
        if(this.head == null){
            addFrist(data);
            return;
        }
        Node5 cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    //打印链表长度
    public int size(){
        int count = 0;
        Node5 cur = this.head;
        while (cur != null){
            count ++;
            cur = cur.next;
        }
        return count ;
    }
    //任意位置插入元素
    public void  addIndex (int index , int data){
        Node5 note = new Node5(data);
        if (index < 0 || index > this.size()){
            System.out.println("插入错误");
            return;
        }
        if (index == 0){
            addFrist(data);
        }
        Node5 cur = reaschPrev(index);
        note.next = cur .next;
        cur.next = note;
    }
    // 寻找插入数字的节点；
    public Node5  reaschPrev( int index){
        Node5 cur = this.head;
        int count = 0;
        while (count < index - 1){
            cur = cur.next;
            count ++ ;
        }
        return cur;
    }
    //寻找关键字key是否存在；
    public  boolean contains(int key){
        Node5 cur = this.head;
        while (cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return  false;
    }
    //删除第一个关键字key
    public void reMove(int key){
        if(this.head.data == key){
            this.head = this.head.next;//删除头数字，这个数字的next就是ta的头
            return;
        }
        Node5 cur = reasechPrmv2(key);
        if(cur == null){
            return;
        }
        Node5 asc = cur.next;
        cur.next = asc.next;
    }
    //寻找key的前驱
    public Node5 reasechPrmv2(int key){
        Node5 cur = this.head;
        while (cur.next != null){
            if (cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public static void main (String[] args){
        MyTryTry myTryTry = new MyTryTry();
        myTryTry.addFrist(1);
        myTryTry.addFrist(4);
        myTryTry.addFrist(5);
        myTryTry.disPlay();
        myTryTry.addLast(6);
        myTryTry.addLast(9);
        myTryTry.disPlay();
        System.out.println(myTryTry.size());
        myTryTry.addIndex(3,5);
        myTryTry.addIndex(0,7);
        myTryTry.addIndex(10,5);
        myTryTry.disPlay();
        System.out.println(myTryTry.contains(10));
        System.out.println(myTryTry.contains(9));
        myTryTry.reMove(9);
        myTryTry.reMove(5);
        myTryTry.reMove(20);
        myTryTry.disPlay();
    }
}
