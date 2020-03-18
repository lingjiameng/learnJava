//interface 没有字段，所有方法都为抽象方法的抽象类
package myjava;

class InterfaceTest{
    public static void main(String [] args){
        Person p = new Student("小小");
        p.run();
    }
}

//接口
interface Hello{
    void hello();
}

interface Person extends Hello{
    //默认都为 public abstract
    default void run(){
        System.out.println("Person.run " + getName());
    }
    String getName();
}

//实现接口
class Student implements Person{
    private String name;
    public Student(String n){
        this.name = n;
    }
    @Override
    public void hello(){
        System.out.println("Student.hello "+this.name);
    }
    // @Override
    // public void run(){
    //     System.out.println("Student.run "+this.name);
    // }
    @Override
    public String getName(){
        return this.name;
    }
}

