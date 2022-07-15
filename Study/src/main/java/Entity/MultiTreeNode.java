package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scala.util.parsing.combinator.testing.Str;

import java.util.List;

/**
 * @Date 2022/7/15 14:43
 * @Created by taoyuanyuan
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MultiTreeNode {
    private String id;
    private Integer val;
    private List<MultiTreeNode> children;

}
