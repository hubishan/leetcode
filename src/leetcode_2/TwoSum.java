package leetcode_2;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by hbs on 2019/12/1.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash_nums= new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            hash_nums.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int find=target-nums[i];
            if (hash_nums.get(find)!=null && hash_nums.get(find)!=i){
                return new int[] {i,hash_nums.get(find)};

            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
