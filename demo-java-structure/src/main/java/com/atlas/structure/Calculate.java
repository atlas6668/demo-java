package com.atlas.structure;


/**
 * Created by sunwenming on 2017/12/8.
 * 科学计算器
 *
 * a + b * c / d + (e * f + g - h) * i - j
 *
 * 中缀:a+b*c/d+(e*f+g-h)*i-j
 * stack0 : 中缀转后缀
 * 后缀（逆波兰）:abc*d/+ef*g+h-i*+j-
 * stack1 : 顺序执行
 *
 */
public class Calculate {

    /**
     * 中缀:a+b*c/d+(e*f+g-h)*i-j
     * stack0 : 中缀转后缀
     * 后缀（逆波兰）:abc*d/+ef*g+h-i*+j-
     * stack1 : 顺序执行
     * @param stringBuffer
     * @return
     */
    public static double calc(StringBuffer stringBuffer){

        return 0d;
    }

    public static void main(String[] args){
        StringBuffer stringBuffer = new StringBuffer("a+b*c/d+(e*f+g-h)*i-j");
        System.out.println(stringBuffer + " = " + Calculate.calc(stringBuffer));

    }

}
