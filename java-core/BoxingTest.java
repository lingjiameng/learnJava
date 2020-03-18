public class BoxingTest{
    public static void main(String [] args){
        // Wrapper Class
        // Boxing int => integer
        // integer value can be bull
        int i = 99999;
        Integer integer1 = Integer.valueOf(i); // get 10
        Integer integer2 = Integer.valueOf("101"); // get 101
        System.out.println(integer1.intValue()+integer2.intValue());
        
        // auto boxing
        // happen in build stage, just to write fewer code
        Integer integer3 = 99999; //auto boxing  valueOf()
        int int3 = integer3; // auto unboxing  intValue()
        // low effciency

        //final class 不变类
        //特别注意，所有引用类型比较使用equals 
        //equals 值比较
        //==  对象比较，包括地址之类的全部属性对比
        System.out.println(" "+ (integer1==integer3)+" | " + integer1.equals(integer3));

        //为了节省内存，Integer.valueOf()对于较小的数，始终返回相同的实例

        //Integer 解析字符串为数字和进制转换
        int x1 = Integer.parseInt("+100");
        int x2 = Integer.parseInt("10",16);
        System.out.println("0x10: " + x2 + " | +100: "+x1);

        System.out.println(Integer.toString(100));
        System.out.println(Integer.toString(38,35)); //不正常的radix使用10替代
        System.out.println(Integer.toHexString(255));
        System.out.println(Integer.toOctalString(255));
        System.out.println(Integer.toBinaryString(255));

        //常量
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        
        int i_max = Integer.MAX_VALUE;
        int i_min = Integer.MIN_VALUE;

        int sizeOfLong = Long.SIZE;
        int bytesOfLong = Long.BYTES;

        //所有的整数和浮点数继承自Number
        Number num = Integer.valueOf(9999);
        byte num_b  = num.byteValue();
        int num_i = num.intValue();
        long num_l = num.longValue();
        float num_f = num.floatValue();
        double num_d = num.doubleValue();

        //处理无符号整数
        // -1 存储时用对应正数的反码 +1 表示
        byte x = -1; // 0000,0001 -> 1111,1110 -> 1111,1111
        byte y = 127; // 0111,1111
        //相同的存储编码，不同的表示规则，进而得到不同的值
        System.out.println(Byte.toUnsignedInt(x)); // -1 -> 255
        System.out.println(Byte.toUnsignedInt(y)); // 127 -> 127


    }
}