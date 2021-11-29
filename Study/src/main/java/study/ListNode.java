package study;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
      int val;
      public ListNode next;

      public ListNode(int val){
            this.val=val;
      }
}
