package myjava;


class City{
    public String name;
    public double latitude;
    public double longtitude;

    public static void main(String[] args) {
        City peking = new City();
        peking.name = "北京";
        peking.latitude = 39.903;
        peking.longtitude = 116.401;
        System.out.println(peking.name);
        System.out.println("location:"+peking.latitude+","+peking.longtitude);

        Person ming = new Person();
        System.out.println(ming.getName()==null && ming.getAge()==0);
        ming.setName("小明");
        ming.setAge(-99);
        System.out.println("name:"+ming.getName()+" age:"+ming.getAge());

        Person hong = new Person("小红",22);
        hong.setName("红", "小小");
        System.out.println("name:"+hong.getName()+" age:"+hong.getAge());

        //向上转型
        //Student > Person > Object
        System.out.println("casting in class");
        Student s = new Student("小黑", 20, 119);
        Person p = s; //upcasting ok
        Object o = p; //upcasting ok

        //向下转型
        System.out.println(p instanceof Student);
        Student s1 = (Student) p; //downcasting
        Person p2 = new Person();
        System.out.println(p2 instanceof Student);
        //Student s2 = (Student) p2; //failed

        //instanceof 语法糖不能用，只能用下列方式
        Object obj ="hello";
        if(obj instanceof String){
            String tmp = (String) obj;
            System.out.println(tmp.toUpperCase());
        }
        
        //继承是is关系，继承是has关系
        System.out.println("primary student ");
        Student ps = new PrimaryStudent("小军", 25, 140, 9);
        System.out.println(ps.getScore());
    }   
}

class Person{
    protected String name;
    protected int age;
    
    public Person(){
    }

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Person(String name){
        this(name,18);  //调用之前的默认方法
    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        newName = newName.trim();
        if(newName==null || newName.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name=newName;
    }
    public void setName(String firstName,String lastName){
        this.name = lastName+firstName; //姓+名
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
}
/*
1、整数、浮点数、字符是基本类型。
2、字符串、数组是引用类型（内存数据的索引）

3、基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
4、引用类型参数的传递，调用方的变量和接收方的参数变量，指向的是同一个对象。
                            双方任意一方对这个对象的修改，都会影响对方。

字符串赋新值是新开内存，新指向。
字符串变量之间赋值只调整指向。
*/



//继承，有且只有一个父类，除了object
//private只能本类访问
//protected 可以在继承树内访问
//

class Student extends Person{
    protected double score;

    public Student(String name, int age, double score){
        //任何class的构造方法，第一行语句必须是调用父类的构造方法。
        //如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();
        super(name, age); //显式的调用构造方法
        this.score = score;
    }
    public String hello(){
        return "hello."+name;
    }
    public double getScore(){
        return score;
    }
}

class PrimaryStudent extends Student{
    protected int grade;
    public PrimaryStudent(String name, int age, double score,int grade){
        super(name,age,score);
        this.grade = grade;
    }

    //polymorphic
    @Override  //重写 或者 覆写
    public double getScore(){
        return score+5;
    }
}