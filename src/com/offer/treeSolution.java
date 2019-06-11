package com.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by wh on 2019/3/28.
 */
public class treeSolution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //检查孔树
        if(root1==null||root2==null){
            return false;
        }
        boolean flag=false;
        if(root1.val==root2.val){
            flag=isTree1HaveTree2(root1,root2);
        }
        if(!flag){
            flag=HasSubtree(root1.left,root2.left);
        }
        if(!flag){
            flag=HasSubtree(root1.right,root2.right);
        }
        return flag;
    }
    public boolean isTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1!=null&&root1.val==root2.val){
            return isTree1HaveTree2(root1.left,root2.left)&&isTree1HaveTree2(root1.right,root2.right);
        }else{
            return false;
        }
    }
    public void Mirror(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return;
        }
        LinkedList<TreeNode> deque=new LinkedList<TreeNode>();
        deque.add(root);
        while(deque.size()>0){
            TreeNode node = deque.getFirst();
            deque.removeFirst();
            if(node.left==null||node.right==null){
                continue;
            }
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            deque.addLast(node.left);
            deque.addLast(node.right);
        }
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length<=0) {
            return false;
        }
        int length=sequence.length;
        int root=sequence[length-1];
        int i=0;
        for(;i<length-1;i++){
            if(sequence[i]>root){
               break;
            }
        }
        int j=i;
        for(;j<length-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left=true;
        if(i>0){
            int[] temp=new int[i];
            for(int k=0;k<i;k++){
                temp[k]=sequence[k];
            }
            left=VerifySquenceOfBST(temp);
        }
        boolean right=true;
        if(i<length-1){
            int[] temp=new int[i];
            int s=0;
            for(int k=i;k<length-1;k++){
                temp[s]=sequence[k];
            }
            right=VerifySquenceOfBST(temp);
        }
        return (left&&right);
    }
    public boolean checkSquenceOfBST(int[] a,int k,int s){
        if(a.length==0||k>a.length||k<0){
            return false;
        }
        for(int i=k;i>=0;i--){
            if(a[i]<a[a.length-1]){
                return false;
            }
        }
       return true;
    }





}
