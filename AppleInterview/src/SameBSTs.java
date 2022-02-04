/*
Java program to determine whether two trees are identical
In this program, we need to check whether two trees are identical or not.
For two trees to be identical, they have to satisfy two conditions:
Structure of both the trees should be the same.
Nodes present in one tree should be present in another tree.
Algorithm
1. Define Node class which has three attributes namely: data left and right. Here, left represents the
left child of the node and right represents the right child of the node.
2. When a node is created, data will pass to data attribute of the node and both left and right
will be set to null.
3. Define another class which has an attribute root.
4. Root represents the root node of the tree and initializes it to null.
areIdenticalTrees() will check whether two trees are identical or not:
5.If root nodes of both the trees are null then, they are identical.
6.If the root node of only one tree is null then, trees are not identical, return false.
7. If root node of none of the tree is null, then check whether data of both the nodes are equal and
then recursively check the left subtree and right subtree of one tree is identical to another or not.

 */
public class SameBSTs {
    public static void main(String[] args) {

        //Adding nodes to the first binary tree
        SameBSTs bt1 = new SameBSTs();
        bt1.root = new Node(1);
        bt1.root.left = new Node(2);
        bt1.root.right = new Node(3);
        bt1.root.left.left = new Node(4);
        bt1.root.right.left = new Node(5);
        bt1.root.right.right = new Node(6);

        //Adding nodes to the second binary tree
        SameBSTs bt2 = new SameBSTs();
        bt2.root = new Node(1);
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);
        bt2.root.left.left = new Node(4);
        bt2.root.right.left = new Node(5);
        bt2.root.right.right = new Node(6);

        //Displays whether both the trees are identical or not
        if(areIdenticalTrees(bt1.root, bt2.root))
            System.out.println("Both the binary trees are identical");
        else
            System.out.println("Both the binary trees are not identical");
    }

    //Represent the node of the binary tree
    public static class Node {
        int data;
        Node left;
        Node right;

        //Assign data to the new node, set left and right children to null
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Represent the root of the binary tree
    public Node root;

    public SameBSTs() {
        root = null;
    }

    //areIdenticalTrees() finds whether two trees are identical or not
    public static boolean areIdenticalTrees(Node root1, Node root2) {
        //Checks if both the trees are empty
        if (root1 == null || root2 == null) {
            return true;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        //If both trees are not empty, check whether the data of the nodes is equal
        //Repeat the steps for left subtree and right subtree
        if (root1 != null && root2 != null) {

            return ((root1.data == root2.data) &&
                    (areIdenticalTrees(root1.left, root2.left)) &&
                    (areIdenticalTrees(root1.right, root2.right)));
        }
        return false;
    }
}
