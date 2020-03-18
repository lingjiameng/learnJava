package myjava;

class AbstractClass{
    public static void main(String [] args){
        // Person p = new Person();  //不能编译
        Income [] incomes = {
            new NormalIncome(5000),
            new Salary(25000),
            new StateConcilAllowance(15000)
        };
        double total = 0;
        for(int i=0;i<incomes.length;i++){
            total += incomes[i].getTex();
        }
        System.out.println("total income tex is " + total);
    }
}

abstract class Person{
    public abstract void run();
}

class Strudent extends Person{
    @Override
    public void run(){
        System.out.println("Student.run");
    }
}



abstract class Income{
    protected double income;
    public Income(double in){
        this.income = in;
    }
    public abstract double getTex();
}

class NormalIncome extends Income{
    public NormalIncome(double in){
        super(in);
    }
    @Override
    public double getTex(){
        return this.income*0.1;
    }
}

class Salary extends Income{
    public Salary(double in){
        super(in);
    }
    @Override
    public double getTex(){
        if(this.income <=5000){
            return 0;
        }
        return (this.income-5000)*0.2;
    }
}

class StateConcilAllowance extends Income{
    public StateConcilAllowance(double in){
        super(in);
    }
    @Override
    public double getTex(){
        return 0;
    }
}


abstract class SpecialIncome extends Income{
    public SpecialIncome(double in){
        super(in);
    }
}


