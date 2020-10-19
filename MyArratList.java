import java.util.Arrays;

class MyArratList {
    public int[] elem ;
    public int usedSize;


    public  MyArratList(){
        this.elem = new int[6];
        this.usedSize = 0;
    }
    public void add(int pos ,int data){
        if (pos < 0 || pos > this.usedSize){
            System.out.println("插入数据不合法");
            return;
        }
        if (this.usedSize == this.elem.length){
            System.out.println("满了，无法插入");
            return;
        }
        for (int i = pos; i < this.usedSize -1; i++) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    public void disPlay () {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + "");
        }
        System.out.println();
    }
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    public int search(int toFind){
        for (int i = 0; i <this.usedSize ; i++) {
            if (this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos){
        if (pos < 0 || pos > this.usedSize){
            System.out.println("找不到");
            return -1;
        }
        return this.elem[pos];
    }
    public void setPos(int pos,int value){
        if (pos < 0 || pos > this.usedSize){
            System.out.println("不合法");
            return ;
        }
        this.elem[pos] = value;
    }
    public void remove(int toRemove){
        int index = search(toRemove);
        if (index == -1){
//            System.out.println("没找到");
            return;
        }
        for (int i = index; i <this.usedSize - 1 ; i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.usedSize --;
    }
    public int size(){
        if (this.usedSize == 0){
            return 0;
        }
        return this.usedSize;
    }
    public void clear(){
        this.usedSize = 0;
    }
    public void reMoveAll(int toRemove ){
        for (int i = 0; i < this.elem.length; i++) {
            remove(toRemove);
        }
    }
}
class ShuaiQi{
    public static void main (String[] args){
        MyArratList myArratList = new MyArratList();
        myArratList.add(0,1);
        myArratList.add(1,2);
        myArratList.add(2,1);
        myArratList.add(3,6);
        myArratList.add(4,1);
        myArratList.add(5,3);
        myArratList.disPlay();
        System.out.println(myArratList.contains(5));
        System.out.println(myArratList.search(9));
        System.out.println(myArratList.search(2));
        System.out.println(myArratList.getPos(4));
        myArratList.setPos(3,5);
        myArratList.disPlay();
//        myArratList.remove(5);
//        myArratList.disPlay();
        System.out.println("--------");
        myArratList.reMoveAll(1);
        myArratList.disPlay();
        System.out.println("-----------");
        System.out.println(myArratList.size());
        System.out.println("-----------");
        myArratList.clear();
        myArratList.disPlay();
    }
}
