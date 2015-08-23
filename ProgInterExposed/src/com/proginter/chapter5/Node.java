package com.proginter.chapter5;

public class Node {

    public Node leftNode;
    public Node rightNode;
    public int value = 0;

    public Node(Node leftNode, Node rightNode, int value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

}
