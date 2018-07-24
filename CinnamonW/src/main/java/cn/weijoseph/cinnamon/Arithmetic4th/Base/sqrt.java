package cn.weijoseph.cinnamon.Arithmetic4th.Base;

public class sqrt {
    public static double NewSqrt(double a) {
        double x1 = 10.0;
        int i = 0;
        double precision = 0.001;
        do{
            x1 = (a/x1 + x1)/2;

            i++;
        }while(abs(x1-a/x1) > precision);
        System.out.println("运算次数" + i);
        return x1;
    }

    public static double abs(double a) {
        if(a > 0.0)
            return a;
        else
            return -a;
    }

    public static void main(String[] args) {
        System.out.println(NewSqrt(2.0));
    }
}
