import java.beans.*;

public class JavaBeanTest{
    public static void main(String []args) throws Exception{
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for(PropertyDescriptor pd : info.getPropertyDescriptors()){
            System.out.println(pd.getName());
            System.out.println(" "+pd.getReadMethod());
            System.out.println(" "+pd.getWriteMethod());
        }
    }
}

class Person{
    private String name;
    private int age;

    //name 属性的一组getter 和 setter
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    //age属性的一组setter和getter
    public int getAge(){
        return this.age;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
    //child属性的getter，注意child属性并没有字段，只有getter
    //同时child属性是布尔类型，因此getter使用isXyz的格式
    public boolean isChild(){
        return this.age < 12;
    }

}