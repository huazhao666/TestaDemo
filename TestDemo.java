class ListNode {
    public int val;
    public ListNode next ;
    public ListNode prev;


    public  ListNode(int val){

        this.val = val;
    }
}


public  class TestDemo{
    public ListNode head;
    public ListNode last;
    // 头插法
    public void addFirst (int val){
        ListNode node = new ListNode(val);
        if (this.head == null){
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插；
    public void addLast (int val){
        ListNode node = new ListNode(val);
        if(this.head == null){
            this.head = node ;
            this.last = node;
        }
         this .last.next = node;
        node.prev = this.last;
        this.last = node;
    }
    //链表长度；
    public int size() {
        if (this.head == null) {
            return 0;
        }
            ListNode cur = this.head;
            int count = 0;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
       return count ;
    }
    //打印链表；
    public  void disPlay(){
        if (this.head == null){
            return ;
        }
        ListNode cur = this.head;
        while ( cur != null){
            System.out.println( cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //寻找关键字；
    public boolean contains (int key){
        if (this.head == null){
            return false;
        }
        ListNode cur = this.head;
        while ( cur != null){
            if(cur.val == key){
                return true;
            }
            cur= cur.next;
        }
        return  false;
    }
    //任意位置插入；
    public void addIndex (int index,int val){
        if (index == 0){
            addFirst(val);
            return ;
        }
        if (index == size()){
            addLast(val);
            return ;
        }
        ListNode node = new ListNode(val);
        ListNode cur = find(index);
        if (cur == null){
            return;
        }
        node.next= cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    //找到index
    public ListNode find(int index) {
        if (index < 0 || index > size()) {
            return null;
        }
            ListNode cur = this.head;
            while (index != 0) {
                cur = cur.next;
                index--;
            }
            return cur;
        }
// 删除第一个关键字key；
    public void reMove(int key){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.val == key){
                if(this.head.val == key){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null){
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
    //删除全部关键字；
    public void reMoveAllkey(int key){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.val == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next!= null){
                       cur .next.prev = cur.prev;
                    }else{
                        this.last = this.last.prev;
                    }
                }
            }

                cur =cur.next;
        }
    }
}
