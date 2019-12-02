package java_base;

import leetcode_2.AddTwoNumbers;
import leetcode_2.ListNode;

/**
 * Created by hbs on 2019/12/1.
 */
public class Solution {



    public static void main(String[] args){

        int[] arr= new int[]{2,4,3};
        int[] arr2= new int[]{5,6,4};
//        System.out.println(arr.toString());
        ListNode l1=null;
        for (int i = arr.length-1; i >=0; i--) {
            ListNode node=new ListNode(arr[i]);
            node.next=l1;
            l1=node;
        }
        ListNode l2=null;
        for (int i = arr.length-1; i >=0; i--) {
            ListNode node=new ListNode(arr[i]);
            node.next=l2;
            l2=node;
        }

        new AddTwoNumbers().addTwoNumbers(l1,l2);

    }




}
