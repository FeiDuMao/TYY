package study;

import Entity.TreeNode;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

public class TreeNodeStudy {

    //递归遍历二叉树
    public void visit(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root.getLeft());

        visit(root.getRight());

        System.out.println(root.getVal());

    }

    //层次交替遍历二叉树 leetcode.32
    public List<List<Integer>> visit3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        System.out.println(res);
        return res;
    }

    //层次遍历二叉树 LeetCode.31
    public void visit2(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //queue.size会改变，所以一开始应把queue.size赋值给i；
            for (int i = queue.size(); i > 0; i--) {
                TreeNode t = queue.poll();
                list.add(t.val);
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
            res.add(list);
        }
        System.out.println(res);

    }

    //二叉树每条线组成的数字之和
    public int PathSum(TreeNode root) {
        Queue<TreeNode>node=new LinkedList<>();
        Queue<Integer> sum=new LinkedList<>();
        node.add(root);
        sum.add(root.val);
        int ans=0;
        while (!node.isEmpty()){
            TreeNode tmpNode = node.poll();
            int tmpSum=sum.poll();
            if (tmpNode.left==null&&tmpNode.right==null){
                ans+=tmpSum;
                continue;
            }
            if (tmpNode.left!=null){
                node.add(tmpNode.left);
                sum.add(tmpSum*10+tmpNode.left.val);
            }
            if (tmpNode.right!=null){
                node.add(tmpNode.right);
                sum.add(tmpSum*10+tmpNode.right.val);
            }
        }

        return ans;
    }
    public int PathSum(TreeNode root,int sum){
        if (root==null)return 0;
        if (root.left==null&&root.right==null){
            return sum*10+root.val;
        }
        return PathSum(root.left,sum*10+root.val)+PathSum(root.right,sum*10+root.val);
    }

    //路径之和 leetcode 112  广度优先算法
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
    //路径之和 leetcode 112  递归
    public boolean hasPathSum2(TreeNode root, int sum){
        if (root==null)return false;
        if (root.left==null&&root.right==null){
            return sum==root.val;
        }
        return hasPathSum2(root.left,sum-root.val)||hasPathSum2(root.right,sum-root.val);
    }

    //路径之和 leetcode 113
    public List<List<Integer>> path(TreeNode root, int target){


        return null;
    }


    //lc124
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int priceNewpath = node.val + leftGain + rightGain;

            // 更新答案
            maxSum = Math.max(maxSum, priceNewpath);

            // 返回节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
        }





    @Test
    public void test() {
        TreeNode root=initTree();

        //visit(root);

        TreeNode treeNode=new TreeNode();
        try {
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass(treeNode.getClass().getName());
            Field[] declaredFields = aClass.getDeclaredFields();
            System.out.println(Arrays.toString(declaredFields));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public TreeNode initTree(){
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(5);
        TreeNode b3 = new TreeNode(6);
        root.setTreeNode(a1, a2);
        a1.setTreeNode(b1, b2);
        a2.setLeft(b3);
        return root;
    }

}
