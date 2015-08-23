package com.company;

import java.util.Scanner;

/**
 * Created by Varun on 6/8/2015.
 */
public class InsertIntoTailNode {

    public class Node {
        Node next;
        int data;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InsertIntoTailNode insert = new InsertIntoTailNode();
        Node output = null;
        while(input.hasNext()) {
            output = insert.Insert(output, input.nextInt());
            System.out.println("Inserted : " + output.data);
        }

        input.close();


    }

    public Node Insert(Node head, int x) {

        if(head == null) {
            Node last = new Node();
            last.data = x;
            head = last;
            return head;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        Node last = new Node();
        last.data = x;
        temp = last;

        return head;

    }


}
