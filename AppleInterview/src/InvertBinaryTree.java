import java.util.ArrayDeque;

/*
Problem statement: You are given the root node of a binary tree and must swap the left and right
children for each node widget.
1. Recursive Solution O(n) Time and O(d) Space
This is one of the most famous interview questions and can be easily solved recursively.
The idea is to traverse the tree in a preorder fashion, and for every node encountered,
swap its left and right child before recursively inverting its left and right subtree.
2. Iterative solution using queue
Steps to invert a Binary Tree iteratively using Queue:
If root/ current node is NULL, inverting is done.
Define a queue Q.
Add root node to queue Q.
While queue Q is not empty:
4.1. Pop node N from queue Q from left side.
4.2. Swap left and right child of node N
4.3. Push new left and right child of node N to queue Q.
The Binary Tree is inverted.
Iterative solution using queue	O(n)	O(n)
 */
public class InvertBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        swapLeftAndRight(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

    }
    public static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
    }

    public static void invertBinaryTree2(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
        queue.addLast(tree);
        while (queue.size() > 0) {
            BinaryTree current = queue.pollFirst();
            swapLeftAndRight(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
