package leetcode_2;

/**
 * Created by hbs on 2019/12/1.
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Example:
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String l1_str="";
        ListNode tmp=l1;
        while(tmp!=null){
            l1_str+=tmp.val;
            tmp=tmp.next;

        }
        System.out.println(l1_str);

        String l2_str="";
        tmp=l2;
        while(tmp!=null){
            l1_str+=tmp.val;
            tmp=tmp.next;

        }
        System.out.println(l2_str);
        System.out.println(Integer.parseInt(l1_str.trim())+Integer.parseInt(l2_str.trim()));

//        ListNode list=new ListNode();
        return null;
    }



    }


