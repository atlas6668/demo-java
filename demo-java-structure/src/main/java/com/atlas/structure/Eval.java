package com.atlas.structure;

/**
 * @author sunwenming
 * @date 2022/10/2.
 */
public class Eval {

    public static double eval(int n) {
        double[] c = new double[n + 1];
        c[0] = 1.0;
        for(int i = 1; i <= n; i++){
            double sum = 0.0;
            for(int j = 0; j < i; j++){
                sum += c[j];
            }
            c[i] = 2.0 * sum / i + i;
        }
        return c[n];
    }

    public static double eval2(int n) {
        double[] c = new double[n + 1];
        c[0] = 1.0;
        double sum = 0.0;
        for(int i = 1; i <= n; i++){
            sum += c[i - 1];
            c[i] = 2.0 * sum / i + i;
        }
        return c[n];
    }

    public static void main(String[] args) {
        System.out.println(Eval.eval(0));
        System.out.println(Eval.eval(1));
        System.out.println(Eval.eval(2));
        System.out.println(Eval.eval(3));
        System.out.println(Eval.eval(4));
        System.out.println("----------");
        System.out.println(Eval.eval2(0));
        System.out.println(Eval.eval2(1));
        System.out.println(Eval.eval2(2));
        System.out.println(Eval.eval2(3));
        System.out.println(Eval.eval2(4));
    }

}
