package myjava;

class StaticField{
    public static void main(String [] args){
        Person hong = new Person("小红",18);
        Person ming = new Person("小明",20);
        System.out.println("there are "+Person.getCount()+" persons");
    }
}


class Person{
    public String name;
    public int age;

    public static int count = 0;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        count+=1;
    }

    public static int getCount(){
        return count;
    }
}

// interface 只能有 public static final 字段  
interface hello{
    int COUNT = 0; //等效于前面有public static final
    public static final int FLAG = 1;
}