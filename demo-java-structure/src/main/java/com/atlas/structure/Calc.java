package com.atlas.structure;

import java.util.ArrayList;

/**
 * Created by sunwenming on 2017/7/14.
 */
public class Calc {




    public static boolean Find(int target, int [][] array) {
        int rows = array.length;
        int columns = array[0].length;
        if(columns < 1){
            return false;
        }
        int n = rows - 1;
        int m = 0;
        boolean out;
        do {
            int value = array[n][m];
            if(value == target){
                return true;
            } else if(value < target){
                out = (columns - 1 < ++m);
            } else {
                out = (0 > --n);
            }
        } while (!out);
        return false;
    }

    public static String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        char ca;
        for(int i = 0; i < str.length(); i++){
            ca = str.charAt(i);
            if(ca == ' '){
                sb.append("%20");
            } else {
                sb.append(ca);
            }
        }
        return sb.toString();
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list0 = new ArrayList<Integer>();
        while(null != listNode){
            list0.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(int i = list0.size() - 1; i >= 0; i--){
            list1.add(list0.get(i));
        }
        return list1;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode target = head;
        int a = k;
        int count = 0;
        while(fast != null){
            fast = fast.next;
            count++;
            if(k < 1){
                target = target.next;
            }
            k--;
        }
        if(count < a){
            return null;
        }
        return target;
    }

    public static String A(String input){
        StringBuffer sb = new StringBuffer(input);
        StringBuffer newsb = new StringBuffer();
        StringBuffer oldsb = new StringBuffer();
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '<'){
                if(oldsb.length() == 0){
                    oldsb = newsb;
                    newsb = new StringBuffer();
                }
            }
            if(sb.charAt(i) != '<' && sb.charAt(i) != '>'){
                newsb.append(sb.charAt(i));
            }
            if(sb.charAt(i) == '>'){
                newsb.append(oldsb);
                oldsb = new StringBuffer();
            }
        }
        return newsb.toString();
    }

    /**
     * 跳1级台阶，跳2级台阶都视为两种形态的单位1操作，设跳i个1级，跳j个2级，
     * 则满足关系 n = i + 2j, 0 <= j <= n / 2 (除整)
     * 只有当 n / 2 可以整除时存在 i == 0, 必存在一种 j == 0, 其余 i,j均不为0,
     * 则问题转化为 i,j 的 排列组合 C,
     * 函数 ZuHe() 计算 i,j 的 排列组合 C
     */
    public static int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        int maxJCount = target / 2;
        int i;
        int sum = 0;
        int temp;
        for(int j = 0; j <= maxJCount; j++){
            i = target - 2 * j;
            if(i == 0){
                sum += 1;
            }
            if(j == 0){
                sum += 1;
            }
            if(i != 0 && j != 0){
                temp = ZuHe(i, j);
                sum += temp;
            }
        }
        return sum;
    }

    public static int ZuHe(int i, int j){
        int l;
        if(i > j){
            l = j;
        } else {
            l = i;
        }
        int temp0;
        int temp1;
        int muilt = 1;
        int k;
        int m;
        int[] larr = new int[l];
        for(int n = 0; n < larr.length; n++){
            larr[n] = n + 1;
        }
        for(k = 0; k < l; k++){
            temp0 = i + j - k;
            muilt = muilt * temp0;
            for(m = 0; m < larr.length; m++){
                temp1 = larr[m];
                if(temp1 != 1 && muilt % temp1 == 0){
                    muilt = muilt / temp1;
                    larr[m] = 1;
                }
            }
        }
        return muilt;
    }

    public static int JumpFloor2(int target) {
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public int JumpFloorII(int target) {
        return 1 << --target;
    }

    public static int Fibonacci(int n) {
//        if(n <= 0){
//            return 0;
//        }
//        // 第一项
//        if(n == 1){
//            return 1;
//        }
//        // 第二项
//        if(n == 2){
//            return 1;
//        }
//        // 第三项开始
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int one = 1;
        int two = 1;
        int result = 0;
        for(int i = 2; i < n; i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//true
        System.out.println(g.equals((a + b)));//false
//        String s1 = "abc";
//        String s2 = "abc";
//        String s3 = new String("abc");
//        String s4 = new String("abc");
//        System.out.println(s1 == s2);//true
//        System.out.println(s3 == s4);//false

//        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
////        int[][] array = {{}};
//        System.out.println(Find(16,array));

//        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));

//        System.out.println(A("aab<hds>euo>io<oo<lkds>fewedk"));//oo lkds hds aab euo io fewedk

//        System.out.println(ZuHe(200,300));

//        Long begin = System.currentTimeMillis();
//        for(int i = 0; i < 40; i++){
//            System.out.println("JumpFloor2 : " + JumpFloor2(i));
//        }
//        Long end = System.currentTimeMillis();
//        System.out.println("JumpFloor2 耗时 ：（ms）" + (end - begin));
//
//        begin = System.currentTimeMillis();
//        for(int i = 0; i < 40; i++) {
//            System.out.println("JumpFloor : " + JumpFloor(i));
//        }
//        end = System.currentTimeMillis();
//        System.out.println("JumpFloor 耗时 ：（ms）" + (end - begin));
    }
}
