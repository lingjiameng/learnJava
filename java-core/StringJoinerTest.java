import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String [] args){
        String [] names = {"Bob","Jam","Grace"};
        StringJoiner sj = new StringJoiner(", ","hello ","!");
        for(String name:names){
            sj.add(name);
        }
        System.out.println(sj.toString());
        System.out.println("hello "+String.join(", ",names)+"!");

        //select query
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }
    static String buildSelectSql(String table, String[] fields){
        return "SELECT "+String.join(", ",fields)+" FROM "+table;
    }
}