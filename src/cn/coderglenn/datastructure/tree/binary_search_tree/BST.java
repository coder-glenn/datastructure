package cn.coderglenn.datastructure.tree.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Glenn.Zheng
 * @date 2018/8/16 15:01
 */
public class BST<E extends Comparable<E>> {


    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    // add new element into bst
    public void add(E e) {
        root = add(root, e);
    }

    // add an new element into an binary search tree, its root is node, return the new tree
    private Node add(Node node, E e) {

        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    // contains e or not.
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 以node为根的二分搜索树中是否包含元素e
    public boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {//(e.compareTo(node.e) > 0)
            return contains(node.right, e);
        }
    }

    // Preorder traversal
    public void preTraverse() {
        preTraverse(root);
    }

    private void preTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preTraverse(node.left);
        preTraverse(node.right);

//        if (node != null) {
//            System.out.println(node.e);
//            preTraverse(node.left);
//            preTraverse(node.right);
//        }
    }

    public void preTraverseNonRecursion() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.e);

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
    }

    //Middle order traverse
    public void middleTraverse() {
        middleTraverse(root);
    }

    private void middleTraverse(Node node) {
        if (node == null) {
            return;
        }
        middleTraverse(node.left);
        System.out.println(node.e);
        middleTraverse(node.right);
    }

    // Post order traversal
    public void postTraverse() {
        postTraverse(root);
    }

    private void postTraverse(Node node) {
        if (node == null) {
            return;
        }

        postTraverse(node.left);
        postTraverse(node.right);
        System.out.println(node.e);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 二分搜索树的广度优先遍历
    public void levelOrder(){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right == null)
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {

        if ( node == null )
            return null;

        if ( e.compareTo(node.e) < 0 ) {
            node.left = remove(node.left , e);
            return node;
        } else if (e.compareTo(node.e) > 0 ) {
            node.right = remove(node.right, e);
            return node;
        } else {   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        generateBSTTree(root, 0, builder);
        return builder.toString();
    }

    private void generateBSTTree(Node node, int depth, StringBuilder builder) {
        if (node == null) {
            builder.append(generateDepthString(depth) + "NULL\n");
            return;
        }

        builder.append(generateDepthString(depth) + node.e + "\n");
        generateBSTTree(node.left, depth + 1, builder);
        generateBSTTree(node.right, depth + 1, builder);
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }
        return builder.toString();
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}
