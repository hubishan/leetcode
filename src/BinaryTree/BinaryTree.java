package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by hbs on 2019/3/16.
 */

/**
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  轻松搞定面试中的二叉树题目
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  算法大全（3） 二叉树
 *
 * TODO: 一定要能熟练地写出所有问题的递归和非递归做法！
 *
 * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）
 * 2. 求二叉树的深度: getDepthRec（递归），getDepth
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！）
 * 5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL
 * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel
 * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf
 * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec
 * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec
 * 10.1 判断两个树是否互相镜像：isMirrorRec
 * 11. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2
 * 12. 求二叉树中节点的最大距离：getMaxDistanceRec
 * 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec
 * 14.判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
 *
 */


public class BinaryTree {

    /*
              1
           /    \
         2       3
      /   \       \
     4    5       6

     */



    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }

    public static int getNumNodeRec(TreeNode root){
        if(root == null){
           return 0;
        }
        else
            return 1 + getNumNodeRec(root.left) + getNumNodeRec(root.right);
    }

    public static int getNumNode(TreeNode root){
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count=0;

        while(!queue.isEmpty()){
            count++;
            TreeNode tn=queue.remove();
            if (tn.left!=null){
                queue.add(tn.left);
            }
            if (tn.right!=null){
                queue.add(tn.right);
            }
        }

        return count;
    }

    public static int getDepthRec(TreeNode root){
       if (root==null){
           return 0;
       }else{
           return 1 + Math.max(getDepthRec(root.left),getDepthRec(root.right));
       }

    }

    public static int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        Queue <TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue <TreeNode> queue2 = new LinkedList<TreeNode>();
        Queue <TreeNode> tmp;
        int count=0;
        queue1.add(root);
        while(!queue1.isEmpty()){
            TreeNode tn =  queue1.remove();
            if(tn.left!=null){
                queue2.add(tn.left);
            }
            if(tn.right!=null){
                queue2.add(tn.right);
            }
            if(queue1.isEmpty()){
                count++;
                tmp=queue1;
                queue1=queue2;
                queue2=tmp;
            }
        }

        return count;

    }

    public static int getDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count=0;
        int current_num = 1;
        int next_num = 0;
        while(!queue.isEmpty()){
            TreeNode tn =  queue.remove();
            current_num--;
            if(tn.left!=null){
                queue.add(tn.left);
                next_num++;
            }
            if(tn.right!=null){
                queue.add(tn.right);
                next_num++;
            }
            if(current_num==0){
                count++;
                current_num=next_num;
                next_num=0;
            }
        }
        return count;
    }

    public static void preorderTraversalRec(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.val + ",");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);

    }
    public static void preorderTraversal(TreeNode root){
        if (root==null){
            return;
        }
        Stack <TreeNode> sk = new Stack<TreeNode>();
        sk.push(root);
        while (!sk.isEmpty()){
            TreeNode tn = sk.pop();
            System.out.print(tn.val + " ");

            if (tn.right != null){
                sk.push(tn.right);
            }
            if (tn.left != null){
                sk.push(tn.left);
            }
        }


    }

    public static void inorderTraversalRec(TreeNode root){
        if (root==null){
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + ",");
        inorderTraversalRec(root.right);

    }

    public static void inorderTraversal(TreeNode root){
        if (root==null){
            return;
        }
        Stack <TreeNode> sk = new Stack<TreeNode>();
        TreeNode cur=root;
//        sk.push(root);
        while (true){
            while (cur != null){
                sk.push(cur);
                cur=cur.left;
            }
            if(sk.isEmpty())
                break;

            cur = sk.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }

    }
    public static void postorderTraversalRec(TreeNode root){
        if (root==null){
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + ",");

    }

    public static void levelTraversal(TreeNode root){
        if (root==null){
            return;
        }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode td = queue.remove();
            System.out.print(td.val + " ");
            if(td.left != null){
                queue.add(td.left);
            }
            if(td.right != null){
                queue.add(td.right);
            }

        }

    }

    public static int getNodeNumKthLevel(TreeNode root,int k){
        if (root==null || k < 1){
            return 0;
        }
        if(root != null && k==1)
            return 1;

        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count=1;
        int current_num=1;
        int next_num=0;

        while (!queue.isEmpty()){
            TreeNode tn = queue.remove();
            current_num--;
            if(tn.left != null ) {
                queue.add(tn.left);
                next_num++;
            }
            if(tn.right != null ) {
                queue.add(tn.right);
                next_num++;
            }
            if(current_num==0){
                count++;
                current_num=next_num;
                next_num=0;
            }
            if(count == k){
                break;
            }

        }
        return current_num;
    }

    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1); 		// 求root左子树的k-1层节点数
        int numRight = getNodeNumKthLevelRec(root.right, k - 1); 	// 求root右子树的k-1层节点数
        return numLeft + numRight;
    }

    public static int getNodeNumLeafRec(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);


    }

    /**
     * 找出最大的节点
     * @param root
     * @return
     */
    public static int getMaxNode(TreeNode root){
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
            return root.val;
        return Math.max(root.val,Math.max(getMaxNode(root.left),getMaxNode(root.right)));

    }
//    public static TreeNode getLastCommonNode(TreeNode root,TreeNode n1,TreeNode n2){
//
//        if(root == null)
//            return root;
//        if(root.left == null && root.right == null)
//            return root;
//        return root;
//
//    }
    public static int getMaxDistanceRec(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 1 + getDepthRec(root.left ) + getDepthRec(root.right );

    }

    public TreeNode getKthNode(TreeNode root,int k){
        if(root == null){
            return null;
        }
        Stack <TreeNode> sk = new Stack<TreeNode>();
        TreeNode cur = root;
        int count = 0;
        while (true){
            while(cur!=null){
                sk.push(cur);
                cur=cur.left;
            }
            if (sk.isEmpty())
                break;
            if (!sk.isEmpty()){
                cur = sk.pop();
//                System.out.print(cur.val + " ");
                count ++ ;
                if (count == k)
                    return cur;
                cur = cur.right;
            }

        }

        return null;

    }

    public static void Heap(int[] arr,int start,int end){

        int index = start;

        int i = 2*index;
        int temp = arr[index-1];
        while(i <= end){
            if(i+1 <= end && arr[i-1] < arr[i]){
                i++;
            }
            if(temp < arr[i-1]){
                arr[i/2-1] = arr[i-1];
                i = i*2;
            }else {
                break;
            }

        }
        arr[i/2-1]=temp;

    }

    public static void HeapSort(int[] arr){
        int len = arr.length;
        if(arr.length == 0)
            return;


        for (int i = len / 2; i > 0; i--) {
            Heap(arr,i,len);
        }
        System.out.println("大顶堆：");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        int temp;
        for (int i = len; i > 0; i--) {
            temp=arr[i-1];
            arr[i-1]=arr[0];
            arr[0]=temp;
            Heap(arr,1,i-1);
        }

        return;
    }

    /**
     * n个整数的无序数组，找到每个元素后面比它大的第一个数，要求时间复杂度为O(N)，用栈+栈底指针
     * @param arr
     * @return
     */

    public static int[] searchFirstLargerValue(int [] arr){
        int[] result = new int[arr.length];
        Stack<Integer> sk = new Stack<Integer>();
        sk.push(0);
//        {4,5,9,1,8,7,2}
        for(int i=1;i<arr.length;i++){
            while(!sk.isEmpty() && arr[i]>arr[sk.peek()]){
                result[sk.pop()] =arr[i];
            }
            sk.push(i);
        }
        while(!sk.isEmpty()){
            result[sk.pop()] = -1;
        }

        return result;

    }

    public static void main(String[] args){

        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);

        t1.left  = t2;
        t1.right = t3;
        t2.left  = t4;
        t2.right  = t5;
        t3.right  = t6;

//        BinaryTree bt = new BinaryTree();
//        System.out.println(bt.getNumNodeRec(t1));

//        System.out.println(BinaryTree.getNumNodeRec(t1));
//        System.out.println(BinaryTree.getNumNode(t1));
//        System.out.println(BinaryTree.getDepth(t1));
//        System.out.println(BinaryTree.getDepth2(t1));
//        System.out.println(BinaryTree.getDepth2(t6));
//        System.out.println(BinaryTree.getDepth2(null));

//        preorderTraversalRec(t1);
//        preorderTraversal(t1);
//        System.out.println();
//        inorderTraversalRec(t1);
//        System.out.println();
//        inorderTraversal(t1);
//        System.out.println();
//        postorderTraversalRec(t1);
//        System.out.println();

//        levelTraversal(t1);

//        System.out.println(getNodeNumKthLevel(t1,3));
//        System.out.println(getNodeNumLeafRec(t3));
//        System.out.println(getMaxNode(t4));
//        System.out.println(getMaxDistanceRec(t1));
//        BinaryTree bt = new BinaryTree();
//        TreeNode KthNode = bt.getKthNode(t1,2);
//        System.out.println(KthNode.val);

        int a = 3;
        System.out.println(++a);
        int[] arr =  {4,5,9,1,8,7,2,10};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");

        }
        System.out.println();
        int[] result=BinaryTree.searchFirstLargerValue(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");

        }
//        System.out.println();
//
//        HeapSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//
//        }

    }

}
