package assignment9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christinaglezil
 * 
 * A program that uses the GUI to display a Generic linked-list.
 */

public class Assignment8 <T extends Comparable <T> >{
//SimpleNode() defines the stuff needed to create a linked list
            class SimpleNode{
                 T data;
                 SimpleNode next;

                 SimpleNode(T t){
                    data = t;
                    next = null;
                 }

                SimpleNode(T number, SimpleNode nextNode){
                   data = number;
                   next = nextNode;
                 }
             }
            int size;
            SimpleNode head;
//LinkedList() is our list that makes sure if the head is null
            public Assignment8(){
                size = 0;
                head = null;
            }

 //insertItem() insert data to the list in the ascending order        
         public void insertItem(T data){
            SimpleNode previous = null, 
            root = head;
                   while(root != null){

                       if(data.compareTo(root.data) < 0)
                            break;
                        previous = root;
                        root = root.next;
                   }
            
            SimpleNode n = new SimpleNode(data, root);
               if(previous == null){ 
                   head = n;
               }
               else{
                previous.next = n;
                size++;
               }
            }
 //clearList() assigns all items in the list to null
         public void clearList(){
                size = 0;
                head = null;
           }
         
 //printList() prints the list starting from the head
         public String printList(){
            String string = "mHead->";
            
            SimpleNode root = head;
            
                if( root != null ){
                    string += root.data;
                    root = root.next;
                    
                    while( root != null ){
                        string += "->" + root.data;
                        root = root.next;
                }
            }
          return string;
       }
}
