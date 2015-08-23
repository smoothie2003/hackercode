package com.company.trees;

/**
 * Created by Varun on 6/28/2015.
 */
public class TraversalsPreInPost {

    void PreOrder(Node root) {
        System.out.println(root.data);

        if(root.left != null) {
            PreOrder(root.left);
        }

        if(root.right != null) {
            PreOrder(root.right);
        }

    }

    void Postorder(Node root) {

        if(root.left != null) {
            Postorder(root.left);
        }

        if(root.right != null) {
            Postorder(root.right);
        }

        System.out.print(root.data + " ");

    }

    void Inorder(Node root) {
        if(root.left != null) {
            Inorder(root.left);
        }

        System.out.print(root.data + " ");

        if(root.right != null) {
            Inorder(root.right);
        }
    }


    class Node {
        int data;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

}
