package Test;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.Arrays;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-17
 * Time : 18:46
 */
//public class TestShan {
//    public static void main (String[] args){
//        int[] array = {2,3,23,2543,3221,245,3212,432};
//        jiaoHuan(array);
//        System.out.println(Arrays.toString(array));
//    }
//    public static void jiaoHuan (int[] array){
//        int left = 0;
//        int right = array.length - 1 ;
//        while (left < right) {
//            while (left < right && array[left] % 2 == 0) {
//                left++;
//            }
//            while (left < right && array[right] % 2 != 0) {
//                right--;
//            }
//            int tmp = array[left];
//            array[left] = array[right];
//            array[right] = tmp;
//        }
//        return ;
//    }
//}
//交换两个数组内容；
//public  class TestShan{
//    public static void main (String[] args) {
//        int[] array = {1,2,3,4,5};
//        int[] arr = {5,6,7,8,9,};
//        huHuan(array,arr);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(arr));
//    }
//    public  static  void huHuan (int[] array,int[] arr){
//        for (int i = 0; i < array.length; i++) {
//                int tmp = array[i];
//                array[i] = arr[i];
//                arr[i] = tmp;
//        }
//    }
//}
//class Calculator{
//    public int n;
//    public int m;
//
//    public int add(int n,int m){
//        int sum = n + m ;
//        return  sum;
//    }
//    public int subtract(int n ,int m ){
//        int sum2 = n - m ;
//        return sum2;
//    }
//    public  int fac (int n ,int m ){
//        int sum3 = n * m ;
//        return  sum3;
//    }
//    public  double chuFa(double n , double m ){
//        double sum4 = n / m;
//        return sum4;
//    }
//    public int getN() {
//
//        return n;
//    }
//    public void setN(int n) {
//        this.n = n;
//    }
//    public int getM() {
//
//        return m;
//    }
//    public void setM(int m) {
//
//        this.m = m;
//    }
//}
//public  class  TestShan{
//    public static void main (String[] args){
//        Calculator num = new Calculator();
//        num.setN(3);
//        num.setM(6);
//        int m = num.getM();
//        int n = num.getN();
//        System.out.println(num.add(n,m));
//        System.out.println(num.subtract(n,m));
//        System.out.println(num.fac(n,m));
//        System.out.println(num.chuFa(n,m));
//    }
//}
//定义一个新类，实现两个属性的加减乘除
//class Calculator{
//    public int n;
//    public int m;
//
//    public int add(){
//
//        return  this.n+this. m;
//    }
//    public int subtract(){
//
//        return sum this n - this.m;
//    }
//    public  int fac ( ){
//
//        return  n % m;
//    }
//    public  double chuFa(){
////
//        return n *(1.0) / m;
//    }
//}
//public  class  TestShan{
//    public static void main (String[] args){
//        Calculator num = new Calculator();
//        int m = 6;
//        int n = 9;
//        System.out.println(num.add());
//        System.out.println(num.subtract());
//        System.out.println(num.fac());
//        System.out.println(num.chuFa());
//    }
//}
//class Shan {
//    private   int  age ;
//    private   String name;
//    private  int  high;
//    private  int wight ;
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getHigh() {
//        return high;
//    }
//
//    public void setHigh(int high) {
//        this.high = high;
//    }
//
//    public int getWight() {
//        return wight;
//    }
//
//    public void setWight(int wight) {
//        this.wight = wight;
//    }
//}
//public  class TestShan {
//    public static void main(String[] args) {
// 将一个数组拷贝到另外一个数组身上
//        int[] a = {1, 2, 3,};
//        int[] b = {4, 5, 6,7};
//       System.arraycopy(a, 0, b, 1, 3);
//       Arrays.sort(b);
//        System.out.println(Arrays.toString(b));
//
//    }
//}
//        Shan shan = new Shan();
//        shan.getName();
//        shan.getName();
//        shan.getHigh();
//        shan.getWight();
//        shan.setAge(22);
//        shan.setName("珊珊");
//        shan.setHigh(165);
//        shan.setWight(50);
//        String a = "我";
//        String b = "爱";
//        System.out.println("年龄"+ shan.getAge());
//        System.out.println("姓名" + shan.getName());
//        System.out.println("体重" + shan.getWight());
//        System.out.println("身高" + shan.getHigh());
//        System.out.println(a + b + shan.getName());
//    }
//}
