package study;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ListNodeStudy {


    //反转链表，双指针思想
    public ListNode ReverseList(ListNode head) {

        if (head == null)
            return null;

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }

    //两数之和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //两数之和2
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ans = null;

        while (!stack1.empty() || !stack2.empty() || carry != 0) {
            int a = stack1.empty() ? 0 : stack1.pop();
            int b = stack2.empty() ? 0 : stack2.pop();

            ListNode l = new ListNode((a + b + carry) % 10);
            l.next = ans;
            ans = l;

            carry = (a + b + carry) / 10;
        }
        return ans;

    }

    //返回倒数第n个节点
    public ListNode getNode(ListNode l, int n) {
        ListNode cur = l, pre = l;
        while (n-- > 0) {
            cur = cur.next;
        }
        //此时，前后两个执政相差n，等后指针移到末尾，前指针就为倒数第n个节点。
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }

    //删除倒数第N个节点
    public ListNode delNode(ListNode head, int n) {
        //因为需要倒数第n个节点的前一个节点指向被删节点的后一个节点，那么，pre需要少移动一次
        ListNode tmp = new ListNode(0, head);
        ListNode cur = head, pre = tmp;
        while (n-- > 0) {
            cur = cur.next;
        }
        //两个指针一起移动，使pre指向被删节点的前一个节点
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return tmp.next;
    }

    //合并两个有序链表
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, tail = new ListNode();
        head = tail;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        return head.next;
    }

    //合并多个有序链表
    public ListNode mergerList(ListNode[] lists) {
        ListNode l = null;
        for (int i = 0; i < lists.length; i++) {
            l = merge(l, lists[i]);
        }
        return l;
    }

    //链表排序(1)
    public ListNode ListMergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        //利用快慢指针拆分链表
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        return merge(ListMergeSort(head), ListMergeSort(tmp));
    }

    //链表排序(2)
    public ListNode ListMergeSort2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        //利用快慢指针拆分链表
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        //递归分割
        ListNode left = ListMergeSort(head);
        ListNode right = ListMergeSort(tmp);

        //归并排序

        ListNode res, cur = new ListNode(-1);
        res = cur;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }
        cur.next = left != null ? left : right;
        return res.next;
    }

    //判断链表是否为回文结构
    public Boolean isPail(ListNode head) {
        ListNode tmp = head;
        //第一次遍历，将值入栈
        Stack<Integer> stack = new Stack<>();
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = head;
        //第二次遍历。如果出栈的值与当前值不同，则返回false
        while (tmp != null) {
            if (tmp.val != stack.pop()) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }

    //删除有序链表中（多余）的重复值（1）
    public ListNode delRepeat1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    //删除有序链表中的重复值       （2）
    public ListNode delRepeat2(ListNode head) {
        if (head == null || head.next == null) return head;

        //这样可以解决head处有重复的情况
        ListNode res = new ListNode(-1, head);
        ListNode cur = res;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                //记录下重复的值，并将指针移到非重复处
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }

    //判断链表中是否有环1    hash表
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return true;
    }

    //判断链表中是否有环2    快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    //Y形相交链表的第一个节点    *A和B如果没有公共节点则会死循环
    public ListNode isRep(ListNode head1,ListNode head2){
        ListNode A=head1,B=head2;
        while (A!=B){
            A= A==null? head2:A.next;
            B= B==null? head1:B.next;
        }
        return A;
    }

    //两两交换节点
    public ListNode swapPairs(ListNode head) {
        ListNode ans=new ListNode(0,head);
        ListNode tmp=ans;
        while (tmp.next!=null&&tmp.next.next!=null){
            ListNode left=tmp.next;
            ListNode right=tmp.next.next;

            tmp.next=right;
            left.next=right.next;
            right.next=left;

            tmp=left;
        }
        return ans.next;
    }

    //链表重排
    public void reorderList(ListNode head) {
        ListNode cur=head;
        while (cur.next!=null&&cur.next.next!=null){
            ListNode tmp=cur.next;
            //if (tmp.next==null)return;
            ListNode tail=tmp;
            while (tail.next.next!=null){
                tail=tail.next;
            }
            ListNode node=tail.next;
            tail.next=null;

            node.next=tmp;
            cur.next=node;
            cur=tmp;
        }
    }

    public ListNode solve(ListNode[] a){
        ListNode ans=new ListNode(-1);
        ListNode cur=ans;
        int out=a.length;
        if (out==0)return null;
        if (out==1)return a[0];
        Set<Integer>set=new HashSet<>();
        while (out>0){
            for (int i = 0; i < a.length; i++) {
                if (a[i]!=null){
                    ListNode tmp=a[i].next;
                    a[i].next=null;
                    cur.next=a[i];
                    cur=cur.next;
                    a[i]=tmp;
                }else {
                    if (!set.contains(i)){
                        out--;
                        set.add(i);
                    }
                }
            }
        }
        return ans.next;
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(6);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(null);

        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(9);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(null);


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(null);

        l3.next=n1;

        System.out.println(isCycle(l1));

//        ListNode l=l1;
//        while (l != null) {
//            System.out.print(l.val);
//            l = l.next;
//        }


    }


    public boolean isCycle(ListNode head){
        ListNode slow=head,fast=head;
        while (fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)return true;
        }
        return false;
    }

}
