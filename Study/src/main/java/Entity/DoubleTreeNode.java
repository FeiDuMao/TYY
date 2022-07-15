package Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoubleTreeNode {
    public int val = 0;
    public DoubleTreeNode left = null;
    public DoubleTreeNode right = null;

    public void setTreeNode(DoubleTreeNode left, DoubleTreeNode right){
        this.left=left;
        this.right=right;
    }
    public DoubleTreeNode(int val){
        this.val=val;
    }
}
