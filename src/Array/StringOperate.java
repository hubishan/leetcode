package Array;

import BinaryTree.TreeNode;

import java.util.Random;
import java.util.TreeSet;

/**
 * Created by hbs on 2019/4/17.
 */
public class StringOperate {

    public static String removeRepeatChar(String str){
        StringBuffer str_new = new StringBuffer();

//        System.out.println("result"+new Random().nextInt(10));
        TreeSet<Character> st = new TreeSet<Character>();
        for (int i=0;i < str.length();i++)
            st.add(str.charAt(i));
        System.out.println(st.contains('a'));
        return st.toString();

    }



    public static void main(String[] args){

        TreeNode tn = new TreeNode(1);
        System.out.println(tn.right);
//        if(tn.right.left != null){
//
//        }

//        String result = StringOperate.removeRepeatChar("abcdadf");
//        System.out.println(result);
//        java.util.Random r=new java.util.Random();
//        for(int i=0;i<10;i++){
//            System.out.println(r.nextInt(10));
//            System.out.println(r.nextDouble());
//        }
//
//        int[] arr = new int[5];

//        for (int i=0;i<30;i++)
//        {
//            System.out.println((int)(1+Math.random()*10));
//        }
//        System.out.println((int)(1+Math.random()*10));

    }




}
