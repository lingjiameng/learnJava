public class StringBuilderTest{
    public static void main(String [] args){
        //StringBuilder Test
        StringBuilder sb = new StringBuilder(1024);
        for(int i=0;i<10;i++){
            sb.append(',');
            sb.append(i);
        }
        String s_sb = sb.toString();
        System.out.println(s_sb);

        //链式操作
        StringBuilder sb_chain = new StringBuilder();
        sb_chain.append("he").append("o").insert(2,"ll");
        System.out.println(sb_chain.toString());

        Adder adder_chain = new Adder();
        adder_chain.add(8).inc().add(9);
        System.out.println(adder_chain.value());

        //构造SQL语句
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        long start_time = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            buildInsertSql_loop(table, fields);
        }
        long end_time = System.currentTimeMillis();
        System.out.println("running time: " + (end_time-start_time)+" ms" );
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields){
        StringBuilder sql_builder = new StringBuilder(128);
        StringBuilder value_builder = new StringBuilder(128);
        sql_builder.append("INSERT INTO ").append(table).append(" (");
        for(int i=0;i<fields.length;i++){
            sql_builder.append(fields[i]);
            value_builder.append("?");
            if(i<fields.length-1){
                sql_builder.append(", ");
                value_builder.append(", ");
            }
        }
        sql_builder.append(") VALUES (").append(value_builder).append(")");
        return sql_builder.toString();
    }
    static String buildInsertSql_loop(String table, String[] fields){
        // little better
        StringBuilder sql_builder = new StringBuilder(128);
        sql_builder.append("INSERT INTO ").append(table).append(" (");
        for(int i=0;i<fields.length;i++){
            sql_builder.append(fields[i]);
            if(i<fields.length-1){
                sql_builder.append(", ");
            }
        }
        sql_builder.append(") VALUES (");
        for(int i=0;i<fields.length;i++){
            sql_builder.append("?");
            if(i<fields.length-1){
                sql_builder.append(", ");
            }
        }
        sql_builder.append(")");
        return sql_builder.toString();
    } 
}

class Adder{
    private int sum=0;

    public Adder add(int i){
        this.sum+=i;
        return this;
    }

    public Adder inc(){
        this.sum++;
        return this;
    }

    public int value(){
        return this.sum;
    }

}