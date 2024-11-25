import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data)
            root.left = insertRec(root.left, value);
        else if (value > root.data)
            root.right = insertRec(root.right, value);
        return root;
    }

    // Preorder traversal (root, left, right)
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Inorder traversal (left, root, right)
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Postorder traversal (left, right, root)
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Method to delete a node with a given value
    public Node delete(Node root, int del) {
        if (root == null) {
            return null;
        }
        if (root.data > del) {
            root.left = delete(root.left, del);
            return root;
        }
        if (root.data < del) {
            root.right = delete(root.right, del);
            return root;
        }
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        Node curr = root.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        curr.left = root.left;
        root = root.right;
        return root;
    }

    public List<Integer> leftview(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        leftviewer(root, 1, map);
        for(int i=1; i<map.size(); i++){
            list.add(map.get(i));
        }
        return list;
    }
    public void leftviewer(Node root, int level, HashMap<Integer, Integer> map){
        if(root == null)    return;
        map.put(level, root.data);
        leftviewer(root.right, level+1, map);
        leftviewer(root.left, level+1, map);
    }

    public List<Integer> rightview(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        rightviewer(root, 1, map);
        for(int i=1; i<map.size(); i++){
            list.add(map.get(i));
        }
        return list;
    }

    public void rightviewer(Node root, int level, HashMap<Integer, Integer> map){
        if(root == null)    return;
        map.put(level, root.data);
        rightviewer(root.left, level+1, map);
        rightviewer(root.right, level+1, map);
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            tree.insert(sc.nextInt());
        }

        System.out.println("Preorder traversal:");
        tree.preOrder(tree.root);

        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postOrder(tree.root);

        System.out.print("\nEnter the value to delete: ");
        int del = sc.nextInt();
        tree.root = tree.delete(tree.root, del);

        System.out.println("Left view of the binary tree after deletion:");
        List<Integer> leftView = tree.leftview(tree.root);
        for (int val : leftView) {
            System.out.print(val + " ");
        }

        System.out.println("Right view of the binary tree after deletion:/n");
        List<Integer> rightView = tree.rightview(tree.root);
        for (int val : rightView) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
