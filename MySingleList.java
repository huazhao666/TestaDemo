/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-20
 * Time : 9:42
 */
class Node {
    public int data;
    public  Node next ;//存储对象的应用

    public Node(int data){
        this.data = data;
    }


}
public class   MySingleList{
    public Node head ;//定位头节点；
    // 头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head==null){//第一次插入
            this.head = node; //head保存了node的值；
        }else {
            node.next = this.head;
            this.head = node ;
        }
    }
 //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this .head;
        while(cur .next != null ){
           cur = cur.next;
        }
        cur.next =node;
    }
    //找到index的节点；
    public  Node searchPrev(int index){
        int count = 0;
        Node cur = this.head ;
        while (count < index -1){
            cur = cur.next;
            count ++ ;
        }
        return cur;
    }
  //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        Node node = new Node(data);
        if (index < 0 || index > this.size()){
            System.out.println("插入位置不合法");
        }
        if(index == 0){
            addFirst(data);
            return;
        }
            Node cur = searchPrev(index);
            node .next= cur.next;
            cur.next = node ;
    }
  //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if(cur.data == key){
                return  true ;
            }
            cur = cur.next;
        }
        return  false ;
    }
    //找到需要删除节点的前驱
    public  Node searchPrevNode(int key){
        Node cur = this.head;
        while (cur.next != null ) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return  null;//找不到key的前驱；
    }
  //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (this.head.data ==key ){//头节点
            this.head= this.head.next;
            return;
        }
        Node prev = searchPrevNode(key);
        if (prev == null){
            return;
        }
        prev.next = prev.next.next;
    }
 //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev  =  this .head;
        Node  cur = this.head.next;
        while (cur != null){
            if(cur.data == key){
                prev.next = cur.next;
            }else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }
   // 反转链表
    public  Node  reverselL () {
        Node prev = null;
        Node cur = this.head;
        Node newHead = null;
        while (cur != null) {
            Node curNext =  cur.next;
            if (curNext ==null ){
                newHead =cur;
            }
            cur.next=prev;
            prev= cur;
            cur = curNext;
        }
        return newHead;
    }

//找出中间节点；
    public  Node  middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null ){
                fast = fast.next.next;
                slow = slow .next;
        }
        return slow;
     }
//倒数第k个节点；
    public  Node findKthToTail(int key ){
        if (key <= 0 || this.head == null ){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (key - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                key--;
            }else{
                System.out.println("没有这个节点");
                return  null;
            }
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


  //得到单链表的长度
    public int size(){
        Node cur = this .head;
        int count = 0;
        while (cur != null ){
            count ++ ;
            cur = cur .next;
        }
        return count ;
    }
    //打印单链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
//打印反转链表；
    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        this.head= null;

  }
  //将小于x的节点放到前面去，不破坏顺序；
  public Node partition(int x) {
      // write code here
      Node bs = null;
      Node be = null;
      Node as = null;
      Node ae = null;
      Node cur = this.head;

      while (cur != null) {
          if(cur.data < x) {
              if(bs == null) {
                  bs = cur;
                  be = cur;
              }else {
                    be.next =cur;
                    be = be.next;
              }
          }else {
              if(as == null) {
                    as = cur;
                    ae = cur;
              }else {
                   ae.next =cur;
                   ae= ae.next;
              }
          }
          cur = cur.next;
      }
        /*
        把新的链表串起来
        1、两个段内 可能有一个是空的
           如果as不等于空，ae.next = null;
        2、如果两个段都有数据
           be.next = as;
         */
        if (bs == null || as ==null ){
            return  this.head;
        }
        be.next = as;
        as .next= null;
        return bs;
  }
//排序的列表种，删除重复的节点；
    public Node deleteDuplication (){
        Node cur = this.head;
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (cur != null){
            if (cur .next!= null && cur.data == cur.next.data){ //判断第一个是否和第二个相等
                while (cur.next != null && cur.data == cur.next.data){ //判断第二个和后面的是否相等
                    cur =cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }

//判断是不是回文；
    public boolean chkPalindrome() {
        if (this.head == null){
            return false;
        }
        if (this.head.next== null){
            return true;
        }
        //1、找到中间位置
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow就是中间位置。开始进行第2步
        //2、进行反转
        Node cur = slow.next;
        while (cur != null ){
            Node curNext = cur.next;
            cur.next =slow;
            slow = cur;
            cur = curNext;
        }
        //3、开始判断  注释原因，干扰到我的新东西了
//        while (this.head != slow) {
//            if (this.head.data != slow.data) {
//                return false;
//            }
//            if (this.head.next == slow){ //偶数情况下
//                return  true;
//            }
//            this.head = this.head.next;
//            slow =slow.next;
//        }
       return true;
    }
//判断有环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
// 寻找环的第一个节点
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
    //相遇的地方然后重新跑，一个从相遇点，一个从头
    slow = this.head;
        while (slow!= fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //合二为一
    public Node mergeTwoList(Node headA ,Node headB){
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while(headA != null && headB != null  ){
            if (headA .data < headB .data){
                tmp.next  = headA;
                tmp = tmp.next;
                headA = headA.next;
            }else{
                tmp.next = headB;
                tmp = tmp.next;
                headB =headB.next;
            }
        }
        if (headA != null){
            tmp.next = headA;
        }else {
            tmp.next =headB;
        }
        return  newHead.next;
    }

    //判断相交
    public Node  getlntersectionNode(Node headA ,Node headB){
        if(headA == null || headB == null ){
            return  null;
        }
        Node pl = headA ;
        Node ps = headB ;
        int lenA = 0;
        while (pl != null){
            lenA ++ ;
            pl = pl.next;
        }
        int lenB = 0;
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        pl = headA ;
        ps = headB;
        int len = lenA - lenB;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        for (int i = 0; i < len; i++) {
            pl = pl .next;
        }
        while (pl != ps && pl != null && ps != null){
            pl = pl.next;
            ps = ps.next;
        }
        if(pl == ps && pl != null){
            return pl;
        }
       return null;
    }
    public static void main (String[] args){
      MySingleList mySingleList = new MySingleList();
      mySingleList.addFirst(4);
      mySingleList.addFirst(3);
      mySingleList.addFirst(6);
      mySingleList.addFirst(7);
      mySingleList.addFirst(23);
      mySingleList.addFirst(74);
      mySingleList.addFirst(5);
      mySingleList.addFirst(57);
      //mySingleList.reverseBetween()
      mySingleList.display();
     // mySingleList.reverseBetween(3,6);
      mySingleList.display();
//      Node ret = mySingleList.reverselL();
//      mySingleList.display2(ret);

//      mySingleList.addLast(4);
//      mySingleList.display();
//      mySingleList.addIndex(3,7);
//      mySingleList.display();
//      System.out.println(" ----------");
//      System.out.println(mySingleList.contains(6));
//      System.out.println("-----------");
//      mySingleList.remove(6);
//      mySingleList.remove(0);
//      mySingleList.display();
//      System.out.println("------------");
//      System.out.println(mySingleList.size());
//      System.out.println("------------");
//      mySingleList.clear();
//      System.out.println(" ffffffffffffff");
//        mySingleList.removeAllKey(7);
//        mySingleList.display();
  }




}
