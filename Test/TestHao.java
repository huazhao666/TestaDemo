package Test;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-17
 * Time : 13:12
 */
class Person {
    public int age ;
    public String name ;//实例成员变量
    public static  int count ;//J静态成员变量--存在方法区里,属于类。
    public final  int SHD = 10;//常量    对象；堆   不可修改
    public  static final  int SHD2 = 10;//静态常量；方法区  不可修改
    public void eat (){
        count = 99;//静态方法可以对静态成员变量初始化
        System.out.println( name + "吃饭");
    }
    public  void func(){ //实例成员方法
        func2(); //可以调用静态方法
    }

    public static void func2(){
       // age = 40 ;//静态无法对实例成员变量初始化；所以age 不可以
        System.out.println("静态的方法");//---属于类(用类名调用)
    }
    @Override//注解 --- 重写 override
    public String toString() { //alt + insert 键盘按键// 实现的
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


class   ShaBi {
    public int a = 10;
    public static  int count = 1;
}

public class TestHao {
    public static void main (String[] args){
        ShaBi.count ++;
        ShaBi.count ++;
        ShaBi.count ++;
        System.out.println(ShaBi.count);// 4 ----静态方法不依赖对象，而实例成员变量 需要实例化（new）才可以产生；
    }
    public static void main6(String[] args){
        ShaBi t1 = new ShaBi();
        t1.a ++;
        ShaBi.count ++;
        System.out.println(t1.a);//11
        System.out.println(ShaBi.count);//2
        System.out.println("--------");
        ShaBi t2= new ShaBi();
        t2.a ++;
        ShaBi.count ++;
        System.out.println(t2.a);//11
        System.out.println(ShaBi.count);//3

    }
    public static void main5 (String[] args){
        Person person =  new Person ();
        person.name = "hanhan" ;
        person.eat();
        System.out.println(person);

    }
    public static void main4 (String[] args){
        Person person =  new Person ();
        person.name = "hanhan" ;
        //person1 这个引用 指向/引用了person 这个引用 指向/ 引用的对象
        Person person1 = person ;
        System.out.println(person1.name);
    }
    public static void main3 (String[] args){
        Person person = null;// 不指向任何对象
        person.name = "laji";
        System.out.println(person.name);//打印结果为，空指针异常。
    }
    public static void main2 (String[] args){
        Person person =  new Person ();
        person.name = "laji";
        person.age = 34;
        System.out.println(person.name);
       //System.out.println(Person.count);
        Person.func2();
    }


    public static void main1 (String[] args){
        Person person =  new Person ();
        person.name = "laji";
        person.age = 34;
        System.out.println(person.age);
        System.out.println(person.name);
        Person person1 = new Person();
        person1.age = 45;
        person1.name = "shabi";
        System.out.println(person1.age);
        System.out.println(person1.name);
//        person.eat();
    }
}
