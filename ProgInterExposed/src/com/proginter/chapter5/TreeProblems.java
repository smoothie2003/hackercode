package com.proginter.chapter5;

public class TreeProblems {

    public static void main(String[] args) {

        Node node = createTree();

        System.out.println("Height of the Tree : " + heightOfTree(node));

        System.out.println("\nPreOrder Traversal Of the Tree is : " + preOrderTraversal(node));

        System.out.println("\nPreOrder Traversal of The Tree no recursion : " + preOrderTraversalNoRec(node));


    }

    public static String preOrderTraversalNoRec(Node node) {

        if (node == null) {
            return "";
        }

        Node tempNode = node;
        String result = tempNode.value + ", ";

        while(tempNode.leftNode != null) {

        }

        return null;
    }

    public static String preOrderTraversal(Node node) {

        if (node == null) {
            return "";
        }

        String root = node.value + ", ";
        String result = root + preOrderTraversal(node.leftNode);
        result = result + preOrderTraversal(node.rightNode);

        return result;
    }

    public static int heightOfTree(Node node) {

        if(node == null) {
            return 0;
        }

        int rightHeight = heightOfTree(node.rightNode);
        int leftHeight = heightOfTree(node.leftNode);

        if(rightHeight > leftHeight) {
            return rightHeight+1;
        } else if (leftHeight > rightHeight) {
            return leftHeight+1;
        } else {
            return rightHeight+1;
        }
    }

    public static Node createTree() {

        Node node = new Node(5);
        node.rightNode = new Node(new Node(6), new Node(9), 8);
        node.leftNode = new Node(null, null, 4);

        return node;
    }
}
