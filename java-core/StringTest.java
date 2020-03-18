import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringTest{
    public static void main(String [] args){
        //使用字符数组初始化
        String s = new String(new char []{'h','e','l','l','o','!'});
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        //等值判断使用 equals 而不是 ==
        String s1 = "hello";
        String s2 = "hello";
        System.out.println("s1.equals(s2) " + s1.equals(s2));
        System.out.println("s1 == s2 " + (s1==s2) );
        //都等于true纯属巧合，因为编译时常量放一起了

        String s3 = "HELLO".toLowerCase();
        System.out.println("s1.equals(s3) " + s1.equals(s3));
        System.out.println("s1 == s3 " + (s1==s3) );
        //忽略大小写比较
        System.out.println("hello equalsIgnoreCase Hello " + "hello".equalsIgnoreCase("Hello"));

        //子串
        System.out.println("Hello".contains("ll"));
        System.out.println("Hello".indexOf("l"));
        System.out.println("hello".lastIndexOf('l'));
        System.out.println("hello".startsWith("he"));
        System.out.println("hello".endsWith("lo"));
        
        //提取子串
        System.out.println("hello".substring(2,4)); //左闭右开

        //去除空白字符 
        //trim() 去除首尾 /r /t /n

        //输出为 "        !ello!
        //" \r 将打印头移至开头 \t 将第一个 \t 覆盖了,之后 "!" 将 "h" 覆盖
        System.out.println("\thello!\r\t!\r\n");
        
        System.out.println("\thello!\r\t!\n".trim());
        //输出为 "        !" \r 将打印头移至开头 \t 将hello覆盖了

        //strip() 去除  /r /t /n /u3000
        System.out.println("\u3000hello梦\u3000");
        System.out.println("\u3000hello\u3000".strip());
        System.out.println(" hello梦 ".stripLeading());
        System.out.println(" hello梦 ".stripTrailing());

        //判断空字符串和空白字符串
        System.out.println("".isEmpty());
        System.out.println(" \n".isBlank());

        //替换子串
        System.out.println("hello".replace("l", "m"));
        System.out.println("A,,B:C;D".replaceAll("[,:;]+", ","));

        //分割字符串
        System.out.println("A,B,C,D".split(",")[2]);

        //拼接字符串
        System.out.println(String.join("**","A","B","C" ));

        //类型转换
        //other type => String
        System.out.println(String.valueOf(34.89));
        System.out.println(String.valueOf(true));
        //String => other Type
        System.out.println(Integer.parseInt("ff",16));
        System.out.println(Boolean.parseBoolean("TrUe"));
        //特别的
        System.out.println(Integer.getInteger("java.version"));
        System.out.println(System.getProperty("java.version"));
        // System.out.println(System.getProperties());

        //转换为char[]
        char [] chars = "hello".toCharArray();
        String tmp = new String(chars);
        chars[0]='H';
        System.out.println(new String(chars) +" "+ tmp);

        //测试数组赋值
        int [] class_scores ={99,100,84,94};
        System.out.println(class_scores.toString());
        Score score_test = new Score(class_scores);
        score_test.printAll();
        class_scores[0]=95;
        score_test.printAll();

        //unicode 测试
        char zhong = '中';
        System.out.println(zhong);
        //Java中，char类型实际上就是两个字节的Unicode编码
        //可以通过getBytes转换为其他编码
        try {
            byte [] b1 = "hello".getBytes("UTF-8");
            String b1_ = new String(b1,StandardCharsets.UTF_8);
            System.out.println(b1_);
        } catch (Exception e) {
            System.out.println("coding error!");
        }

        
        
    }
}


class Score{
    private int [] scores;

    public Score(int [] scores){
        this.scores = scores.clone();
    }
    public void printAll(){
        System.out.println(Arrays.toString(this.scores));
    }
}