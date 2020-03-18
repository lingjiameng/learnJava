package myjava;

//java 多态的练习
class Income{
    protected double income;

    public static void main(String [] args){
        //测试
        Income [] incomes = {
            new Income(1000),
            new Salary(25000),
            new StateConcilSpecialAllowance(15000)
        };
        double totalTax = 0;
        for (Income income:incomes){
            totalTax += income.getTax();
        }
        System.out.println("total tax is " + totalTax);

        //覆写调用super
        Person p = new Student("小明");
        System.out.println(p.toString());
    }

    public Income(double in){
        this.income = in;
    }

    public double getTax(){
        return income*0.1;
    }
}

class Salary extends Income{
    public Salary(double in){
        super(in);
    }

    @Override
    public double getTax(){
        if( income<=5000){
            return 0;
        }
        return (income-5000)*0.2;
    }
}

class StateConcilSpecialAllowance extends Income{
    public StateConcilSpecialAllowance(double in){
        super(in);
    }

    @Override
    public double getTax(){
        return 0;
    }
} 

// Object 重要方法
// toString
// equals
// hashCode

class Person{
    protected final String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "name"+name;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Person){
            Person p = (Person) o;
            return this.name.equals(p.name);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
}


class Student extends Person{
    public Student(String name){
        super(name);
    }
    @Override
    public String toString(){
        return super.toString()+"!";
    }
}


//final 关键字禁止覆写
/*
public final String hello(){
    ....
}

//final 关键字禁止继承
final class Person{
    ....
}

final String name="小明"; //实例一旦初始化后不能修改，否则会报错
*/