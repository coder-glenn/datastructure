package cn.coderglenn.datastructure.tree.binary_search_tree;

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
