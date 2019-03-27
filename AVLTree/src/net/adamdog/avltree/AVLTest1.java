package net.adamdog.avltree;

import java.util.NoSuchElementException;

import net.adamdog.avltree.AVLDictionary;
import net.adamdog.avltree.AVLUtilities;

import java.util.ArrayList;

public class AVLTest1 {

  public static void main(String[] args) {
  
    System.out.println("");
    System.out.print("Initializing a new AVLDictionary ");
    System.out.print("with integers as keys and strings ");
    System.out.println(" as values.");
    System.out.println("");
    AVLDictionary<Integer, String> D =
                        new AVLDictionary<Integer, String>();
                        
    System.out.println("Inserting key 1 and value one.");
    D.set(1, "one");
    System.out.println("Inserting key 2 and value two.");
    D.set(2, "two");
    System.out.println("Inserting key 3 and value three.");
    D.set(3, "three");
    System.out.println("Inserting key 4 and value four.");
    D.set(4, "four");
    System.out.println("Inserting key 5 and value five.");
    D.set(5, "five");
    System.out.println("Inserting key 6 and value six.");
    D.set(6, "six");
    System.out.println("Inserting key 7 and value seven.");
    D.set(7, "seven");
    System.out.println("Inserting key 8 and value eight.");
    D.set(8, "eight");
    System.out.println("Inserting key 9 and value nine.");
    D.set(9, "nine");
    System.out.println("Inserting key 10 and value ten.");
    D.set(10, "ten");
    System.out.println("Inserting key 11 and value eleven.");
    D.set(11, "eleven");
    System.out.println("Inserting key 12 and value twelve.");
    D.set(12, "twelve");
    System.out.println("Inserting key 13 and value thirteen.");
    D.set(13, "thirteen");
    System.out.println("Inserting key 14 and value fourteen.");
    D.set(14, "fourteen");
    System.out.println("Inserting key 15 and value fifteen.");
    D.set(15, "fifteen");
    System.out.println("Inserting key 16 and value sixeen.");
    D.set(16, "sixteen");
    System.out.println("Inserting key 17 and value seventeen.");
    D.set(17, "seventeen");
    System.out.println("Inserting key 18 and value eighteen.");
    D.set(18, "eighteen");
    System.out.println("Inserting key 19 and value nineteen.");
    D.set(19, "nineteen");
    System.out.println("Inserting key 20 and value twenty.");
    D.set(20, "twenty");
    System.out.println("");
    
    System.out.println("Getting the value with key 1.");
    try {
      String value = D.get(1);
      if (value == "one") {
        System.out.println("Value was correctly reported to be one.");
      } else {
        System.out.println("Value was incorrectly reported.");
      };
    
    } catch (NoSuchElementException e) {
      System.out.println("get incorrectly threw a NotFoundException.");
    };
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
  
    System.out.println("Removing the node with key 20.");
    try {
      String value = D.remove(20);
      if (value == "twenty") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was twenty.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" twenty.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 19.");
    try {
      String value = D.remove(19);
      if (value == "nineteen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was nineteen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" nineteen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");

    System.out.println("Removing the node with key 18.");
    try {
      String value = D.remove(18);
      if (value == "eighteen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was eighteen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" eighteen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 17.");
    try {
      String value = D.remove(17);
      if (value == "seventeen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was seventeen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" seventeen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");
    
   System.out.println("Removing the node with key 16.");
    try {
      String value = D.remove(16);
      if (value == "sixteen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was sixteen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" sixteen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 15.");
    try {
      String value = D.remove(15);
      if (value == "fifteen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was fifteen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" fifteen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");

   System.out.println("Removing the node with key 14.");
    try {
      String value = D.remove(14);
      if (value == "fourteen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was fourteen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" fourteen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 13.");
    try {
      String value = D.remove(13);
      if (value == "thirteen") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was thirteen.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" thirteen.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");
    
   System.out.println("Removing the node with key 12.");
    try {
      String value = D.remove(12);
      if (value == "twelve") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was twelve.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" twelve.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 11.");
    try {
      String value = D.remove(11);
      if (value == "eleven") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was eleven.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" eleven.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");

   System.out.println("Removing the node with key 10.");
    try {
      String value = D.remove(10);
      if (value == "ten") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was ten.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" ten.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 9.");
    try {
      String value = D.remove(9);
      if (value == "nine") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was nine.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" nine.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");

   System.out.println("Removing the node with key 8.");
    try {
      String value = D.remove(8);
      if (value == "eight") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was eight.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" eight.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 7.");
    try {
      String value = D.remove(7);
      if (value == "seven") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was seven.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" seven.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");

   System.out.println("Removing the node with key 6.");
    try {
      String value = D.remove(6);
      if (value == "six") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was six.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" six.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 5.");
    try {
      String value = D.remove(5);
      if (value == "five") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was five.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" five.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");
    
   System.out.println("Removing the node with key 4.");
    try {
      String value = D.remove(4);
      if (value == "four") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was four.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" four.");
      }
    } catch (NoSuchElementException e) {
    	e.printStackTrace();
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 3.");
    try {
      String value = D.remove(3);
      if (value == "three") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was three.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" three.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");
    
   System.out.println("Removing the node with key 2.");
    try {
      String value = D.remove(2);
      if (value == "two") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was two.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" two.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");
    
    System.out.println("Removing the node with key 1.");
    try {
      String value = D.remove(1);
      if (value == "one") {
        System.out.print("remove correctly reported that the");
        System.out.println(" associated value was one.");
      } else {
        System.out.print("remove incorrectly reported that the");
        System.out.print(" associated value was different than");
        System.out.println(" one.");
      }
    } catch (NoSuchElementException e) {
      System.out.println("Remove incorrectly threw an exception.");
    };
    System.out.println("");

    System.out.println("Checking whether result is an AVL tree.");
    isAVL = tester.isAVLTree(D, true);
    if (isAVL) {
      System.out.println("This is an AVL tree.");
    } else {
      System.out.println("This is not an AVL tree.");
    };
    System.out.println("");
    
    System.out.println("Checking whether this is now an empty tree.");
    if (D.root() == null) {
      System.out.println("The tree is now empty, as required.");
    } else {
      System.out.println("The tree is, incorrectly, still nonempty.");
    };
    System.out.println("");

  }
  
}