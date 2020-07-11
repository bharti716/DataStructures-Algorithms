package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintCommonNodes {

    class Node{
        int data;
        Node left,right;
        Node (int d){
            data=d;
            left=right=null;
        }
    }

    public static ArrayList<Integer> printCommon(Node root1, Node root2)
    {
        if(root1== null || root2 == null)
            return null ;

        ArrayList<Integer> result = new ArrayList<>() ;
        helper(root1,root2,result);
        return result ;
    }

    private static void helper(Node root1,Node root2, ArrayList<Integer> result){

        Stack<Node> s1 = new Stack<>() ;
        Stack<Node> s2 = new Stack<>() ;

        while(true){

            while(root1 != null){
                s1.push(root1);
                root1 = root1.left ;
            }
            while(root2 != null){
                s2.push(root2);
                root2 = root2.left ;
            }

            if(s1.isEmpty() || s2.isEmpty()){
                break ;
            }
            Node x = s1.peek();
            Node y = s2.peek();
            if(x.data == y.data){
                result.add(x.data);
                root1 = x.right ;
                root2 = y.right ;
                s1.pop();
                s2.pop() ;
            }
            else if(x.data < y.data ){
                s1.pop();
                root1 = x.right ;
            }
            else{
                s2.pop();
                root2 = y.right ;
            }
        }

    }
}
