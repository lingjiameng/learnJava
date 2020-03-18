package myjava;

import java.util.Arrays;
// import java.util.Collections;
import java.util.Scanner;

public class Hello {
    public static void main(String args[]){
        System.out.println("Hello World");
        double num1 = 15/4/1.5;
        double fnum1 = 1.0 /10;
        double fnum2 = 1.0 - 9.0/10;
        System.out.println("the result of 15/4/1.5 is " + num1);
        System.out.println("1.0/10 and 1.0 - 9.0/10 is " + fnum1 + " " + fnum2);
        if (Math.abs(fnum1-fnum2)< 1e-6){
            System.out.println("1.0/10 and 1.0 - 9.0/10 is almost same");
        }
        // System.out.print(10/0); // 报错，devide by zero
        System.out.println(10.0/0); // Infinity
        System.out.println(-10.0/0); // -Infinity
        System.out.println(0.0/0); // NaN

        // 解一元二次方程 a*x^2 + b*x + c = 0
        double a = 0.0;
        double b = 0.0;
        double c = 5.0;
        System.out.println("the Unary quadratic equation is "+ String.format("%f*x^2+%f*x+%f = 0",a,b,c));
        if(a == 0.0){
            if(b == 0.0){
                System.out.println("any solution or not meaningful!");
            }else{
                System.out.println("one solution is " + (-c/b));
            }
        }else{
            double frac = b*b - 4.0*a*c;
            if(frac < 0.0){
                System.out.println("no real solution");
            }else{
                double beta = Math.sqrt(frac)/2.0/a;
                double alpha = -b/2.0/a;
                System.out.println("two solution is " + (alpha+beta)+ ", "+(alpha-beta) );
            }
        }

        // 三元运算符

        int n = -100;
        System.out.println("reslut is "+ (n>=0?n:-n));

        //
        String s = "中国";
        String t = s;
        s = "China";
        System.out.println(s);
        System.out.println(t);

        String [] names={"abc","XYZ","zoo"};
        String ns = names[1];
        names[1]= "foo";
        System.out.println(ns);

        // 格式化输出
        System.out.printf("%f",1.);

        // 遍历数组输出
        int [] nums = {3,5,7,8,1,65,6};
        System.out.print("\n[ "+nums[0]);
        for(int i=1 ; i<nums.length;i++){
            System.out.printf(", %d",nums[i]);
        }
        System.out.print(" ]\n");
        System.out.println("arrays toString" + Arrays.toString(nums));
        
        //数组排序
        Arrays.sort(nums);
        System.out.println("arrays sort"+ Arrays.toString(nums));
        //数组降序排序 -- 直接将排序号的升序数组进行逆序操作
        for(int i=0;i<nums.length-1-i;i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
        System.out.println("reverse order:"+ Arrays.toString(nums));

        //多维数组
        int[][] multiNums = {
            {456,23,7},
            {3,5},
            {1,2,3,5}
        };
        for(int []arrs:multiNums){
            for(int num:arrs){
                System.out.print(num+", ");
            }
            System.out.println("");
        }
        System.out.println(Arrays.deepToString(multiNums));


        //读取输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("input your height (cm):");
        double height = scanner.nextInt()/100.0;
        System.out.print("input your weight(kg):");
        double weight = scanner.nextDouble();
        System.out.printf("your BMI is %f",weight/height/height);
        scanner.close();
    
    }
}