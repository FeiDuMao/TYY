package Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public void setTreeNode(TreeNode left,TreeNode right){
        this.left=left;
        this.right=right;
    }
    public TreeNode(int val){
        this.val=val;
    }
}
