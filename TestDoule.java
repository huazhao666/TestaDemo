/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-23
 * Time : 16:12
 */
class ListNode1{
    public int val;
    public ListNode1 next ;
    public ListNode1 prev;
    public ListNode1 (int val){
        this.val = val;
    }
}

public class TestDoule {
    public ListNode1 head;
    public ListNode1 last;
    //头插法；
    public void addFirst(int val){
        ListNode1 node = new ListNode1(val);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法；
    public void addList (int val){
        ListNode1 node = new ListNode1(val);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev =this.last;
            this.last = node;
        }
    }
    //打印长度;
    public int size(){
        ListNode1 cur = this.head;
        int count = 0;
        while (cur != null){
            count ++ ;
            cur = cur.next;
        }
        return count ;
    }

    //打印链表；
    public void display(){
        ListNode1 cur = this.head;
        while (cur != null){
            System.out.print( cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //寻找关键字key；
    public boolean contains(int key){
        ListNode1 cur = this.head;
        if (this.head == null){
            return false;
        }
        while (cur != null){
            if(cur.val == key){
                return true;
            }
            cur= cur.next;
        }
        return false;
    }
    // 寻找节点插入位置；
    public ListNode1 find(int index){
        if (index < 0 || index > size()){
            return null;
        }
        ListNode1 cur = this.head;
        while (index > 0 ){
            cur = cur.next;
            index --;
        }
        return cur;
    }
    //插入一个节点；
    public void  addIndex(int index,int val){
        if(this.head == null){
            return;
        }
        if (index == 0){
            addFirst(val);
        }
        ListNode1 cur = find(index);
        ListNode1 node = new ListNode1(val);
        if (cur == null){
            return;
        }
        node.next= cur;
        cur.prev.next= node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    //删除第一个关键字k；
    public void  remove(int key){
        ListNode1 cur = this.head;
        while (cur!= null) {
            if (cur.val == key){
                if(this.head.val == key){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = this.last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除全部关键字key
    public void removeAll(int key){
        ListNode1 cur = this.head;
        while (cur != null){
            if (cur.val == key){
                if (cur == this.head){
                    this.head=this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next!=null){
                        cur.next.prev = cur.prev;
                    }else {
                      this.last =this.last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    public static void main (String[] args){
        TestDoule testDouble = new TestDoule();
        testDouble.addFirst(3);
        testDouble.addFirst(4);
        testDouble.addFirst(5);
        testDouble.addList(5);
        testDouble.addList(5);
        testDouble.display();
        System.out.println(testDouble.size());
        System.out.println(testDouble.contains(9));
        System.out.println(testDouble.contains(6));
        testDouble.addIndex(1,10);
        testDouble.addIndex(5,11);
        testDouble.display();
//        testDouble.remove(5);
//        testDouble.display();
        testDouble.removeAll(5);
        testDouble.display();
    }
}
