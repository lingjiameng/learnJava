public class EnumTest{
    public static void main(String []args){
        Weekday day = Weekday.MON;
        System.out.println(day.name()); //变量转换为名字
        System.out.println(day.ordinal()); //返回序号

        switch(day){
            case MON:
                System.out.println("this is monday");
                break;
            case FRI:
                System.out.println("this friday");
            default:
                System.out.println("hello");
        }

        ArgWeekday aday = ArgWeekday.FRI;
        System.out.println(aday.name()+" is "+aday);
    }
}

enum Weekday{
    MON,TUE,WED,THU,FRI,SAT,SUN;
}

enum ArgWeekday{
    MON(0,"星期一"),TUE(1,"星期二"),WED(2,"星期三"),THU(3,"星期四"),FRI(4,"星期五"),SAT(5,"星期六"),SUN(6,"星期日");
    
    final private int order;
    final private String name;

    private ArgWeekday(int i, String s){
        this.order = i;
        this.name = s;
    }
    public int toInt(){
        return this.order;
    }

    @Override
    public String toString(){
        return this.name;
    }
}