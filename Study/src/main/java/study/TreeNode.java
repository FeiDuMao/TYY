package study;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public void setTreeNode(TreeNode left,TreeNode right){
        this.left=left;
        this.right=right;
    }
    public TreeNode(int val){
        this.val=val;
    }
}
