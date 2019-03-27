package net.adamdog.avltree;

import java.util.NoSuchElementException;

import net.adamdog.avltree.AVLDictionary;
import net.adamdog.avltree.AVLUtilities;

import java.util.ArrayList;

public class AVLTest3 {

  public static void main(String[] args) {
  
    System.out.println("");
    System.out.print("Initializing a new AVLDictionary ");
    System.out.print("with integers as keys and strings ");
    System.out.println(" as values.");
    System.out.println("");
    AVLDictionary<Integer, String> D =
                        new AVLDictionary<Integer, String>();
                        
    System.out.println("Inserting key 5 and value five.");
    D.set(5, "five");
    System.out.println("Inserting key 18 and value eighteen.");
    D.set(18, "eighteen");
    System.out.println("Inserting key 10 and value ten.");
    D.set(10, "ten");
    System.out.println("Inserting key 13 and value thirteen.");
    D.set(13, "thirteen");
    System.out.println("Inserting key 14 and value fourteen.");
    D.set(14, "fourteen");
    System.out.println("Inserting key 11 and value eleven.");
    D.set(11, "eleven");
    System.out.println("Inserting key 3 and value three.");
    D.set(3, "three");
    System.out.println("Inserting key 15 and value fifteen.");
    D.set(15, "fifteen");
    System.out.println("Inserting key 16 and value sixteen.");
    D.set(16, "sixteen");
    System.out.println("Inserting key 9 and value nine.");
    D.set(9, "nine");
    System.out.println("Inserting key 12 and value twelve.");
    D.set(12, "twelve");
    System.out.println("Inserting key 4 and value four.");
    D.set(4, "four");
    System.out.println("Inserting key 8 and value eight.");
    D.set(8, "eight");
    System.out.println("Inserting key 6 and value six.");
    D.set(6, "six");
    System.out.println("Inserting key 2 and value two.");
    D.set(2, "two");
    System.out.println("Inserting key 1 and value one.");
    D.set(1, "one");
    System.out.println("Inserting key 19 and value nineteen.");
    D.set(19, "nineteen");
    System.out.println("Inserting key 17 and value seventeen.");
    D.set(17, "seventeen");
    System.out.println("Inserting key 7 and value seven.");
    D.set(7, "seven");
    System.out.println("Inserting key 20 and value twenty.");
    D.set(20, "twenty");
    System.out.println("");
    
    System.out.println("Checking whether result is an AVL tree.");
    AVLUtilities<Integer, String> tester = 
           new AVLUtilities<Integer, String>();
    boolean isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");

  };

}
  