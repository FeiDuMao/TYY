package study;

import Entity.DoubleTreeNode;
import Entity.MultiTreeNode;
import com.google.common.collect.Lists;
import org.junit.Test;
import scala.util.parsing.combinator.testing.Str;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleTreeNodeStudy {

    //递归遍历二叉树
    public void visit(DoubleTreeNode root) {
        if (root == null) {
            return;
        }

        visit(root.getLeft());

        visit(root.getRight());

        System.out.println(root.getVal());

    }

    //层次交替遍历二叉树 leetcode.32
    public List<List<Integer>> visit3(DoubleTreeNode root) {
        Queue<DoubleTreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                DoubleTreeNode node = queue.poll();
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
    public void visit2(DoubleTreeNode root) {
        if (root == null) return;
        Queue<DoubleTreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //queue.size会改变，所以一开始应把queue.size赋值给i；
            // ***通过queue.size进行分层***
            for (int i = queue.size(); i > 0; i--) {
                DoubleTreeNode t = queue.poll();
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

    public List<List<String>> visit4(MultiTreeNode root) {

        Queue<MultiTreeNode> queue = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<String> tmpList = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                MultiTreeNode tmpNode = queue.poll();
                if (tmpNode != null) {
                    tmpList.add(tmpNode.getId());
                    if (tmpNode.getChildren() != null) {
                        queue.addAll(tmpNode.getChildren());
                    }
                }

            }
            res.add(tmpList);
        }

        return res;
    }


    //todo
    public List<MultiTreeNode> sortByDependence(Collection<MultiTreeNode> nodes) {

        Map<String, List<String>> depMap = nodes.stream().collect(Collectors.toMap(
                MultiTreeNode::getId,
                node -> visit4(node).stream().flatMap(Collection::stream).toList()
        ));

        List<String> result = new ArrayList<>();
        depMap.forEach((k, v) -> {
            result.add(k);


        });


        return null;

    }


    //二叉树每条线组成的数字之和
    public int PathSum(DoubleTreeNode root) {
        Queue<DoubleTreeNode> node = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();
        node.add(root);
        sum.add(root.val);
        int ans = 0;
        while (!node.isEmpty()) {
            DoubleTreeNode tmpNode = node.poll();
            int tmpSum = sum.poll();
            if (tmpNode.left == null && tmpNode.right == null) {
                ans += tmpSum;
                continue;
            }
            if (tmpNode.left != null) {
                node.add(tmpNode.left);
                sum.add(tmpSum * 10 + tmpNode.left.val);
            }
            if (tmpNode.right != null) {
                node.add(tmpNode.right);
                sum.add(tmpSum * 10 + tmpNode.right.val);
            }
        }

        return ans;
    }

    public int PathSum(DoubleTreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return PathSum(root.left, sum * 10 + root.val) + PathSum(root.right, sum * 10 + root.val);
    }

    //路径之和 leetcode 112  广度优先算法
    public boolean hasPathSum(DoubleTreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<DoubleTreeNode> queNode = new LinkedList<DoubleTreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            DoubleTreeNode now = queNode.poll();
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
    public boolean hasPathSum2(DoubleTreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    //路径之和 leetcode 113
    public List<List<Integer>> path(DoubleTreeNode root, int target) {


        return null;
    }


    //lc124
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(DoubleTreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(DoubleTreeNode node) {
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
        DoubleTreeNode root = initTree();

        visit2(root);


    }


    public DoubleTreeNode initTree() {
        DoubleTreeNode root = new DoubleTreeNode(1);
        DoubleTreeNode a1 = new DoubleTreeNode(2);
        DoubleTreeNode a2 = new DoubleTreeNode(3);
        DoubleTreeNode b1 = new DoubleTreeNode(4);
        DoubleTreeNode b2 = new DoubleTreeNode(5);
        DoubleTreeNode b3 = new DoubleTreeNode(6);
        root.setTreeNode(a1, a2);
        a1.setTreeNode(b1, b2);
        a2.setLeft(b3);
        return root;
    }

}
