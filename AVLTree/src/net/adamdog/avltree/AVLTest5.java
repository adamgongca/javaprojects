package net.adamdog.avltree;

import java.util.NoSuchElementException;

import net.adamdog.avltree.AVLDictionary;

// A simple class to test AVLDictionary

public class AVLTest5 {

  public static void main(String[] args) {

    System.out.println();
    System.out.println("Constructing new AVLDictionary");
    AVLDictionary<Integer, String> D
      = new AVLDictionary<Integer, String>();
    System.out.println();
    
    System.out.println("Checking whether a value is defined for 5");
    if (D.defined(5)) {
      System.out.print("The defined method incorrectly reported");
      System.out.println(" that a value is defined.");
    } else {
      System.out.print("The defined method correctly reported");
      System.out.println(" that no such value is defined.");
    };
    System.out.println();
    
    System.out.println("Defining a value for 5.");
    D.set(5, "cinq");
    try {
      String fiveValue = D.get(5);
      if (fiveValue.equals("cinq")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 5 is \"cinq\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 5 is not \"cinq\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();

    System.out.println("Defining a value for 3.");
    D.set(3, "troix");
    try {
      String threeValue = D.get(3);
      if (threeValue.equals("troix")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 3 is \"troix\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 3 is not \"troix\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();

    System.out.println("Defining a new value for 3.");
    D.set(3, "trois");
    try {
      String threeValue = D.get(3);
      if (threeValue.equals("trois")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 3 is \"trois\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 3 is not \"trois\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();
    
    System.out.println("Defining a value for 7.");
    D.set(7, "sept");
    try {
      String sevenValue = D.get(7);
      if (sevenValue.equals("sept")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 7 is \"sept\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 7 is not \"sept\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();
  
    System.out.println("Checking whether value is defined for 4.");
    if (D.defined(4)) {
      System.out.print("defined incorrectly reported that a value");
      System.out.println(" for 4 is defined.");
    } else {
      System.out.print("defined correctly reported that no value");
      System.out.println(" for 4 is defined.");
    };
    System.out.println();
    
    System.out.print("Attempting to remove nonexistent value");
    System.out.println(" for 4.");
    try {
      D.remove(4);
      System.out.print("removed incorrectly failed to throw a");
      System.out.println(" NoSuchElementException.");
    } catch (NoSuchElementException e) {
      System.out.print("removed correctly threw a");
      System.out.println(" NoSuchElementException.");
    };
    System.out.println();
  
    System.out.println("Defining a value for 1.");
    D.set(1, "un");
    try {
      String oneValue = D.get(1);
      if (oneValue.equals("un")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 1 is \"un\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 1 is not \"un\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();
  
    System.out.println("Defining a value for 4.");
    D.set(4, "quatre");
    try {
      String fourValue = D.get(4);
      if (fourValue.equals("quatre")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 4 is \"quatre\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 4 is not \"quatre\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();

    System.out.println("Defining a value for 6.");
    D.set(6, "six");
    try {
      String sixValue = D.get(6);
      if (sixValue.equals("six")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 6 is \"six\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 6 is not \"six\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();
    
    System.out.println("Defining a value for 9.");
    D.set(9, "neuf");
    try {
      String nineValue = D.get(9);
      if (nineValue.equals("neuf")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 9 is \"neuf\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 9 is not \"neuf\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();
 
    System.out.println("Defining a value for 2.");
    D.set(2, "deux");
    try {
      String twoValue = D.get(2);
      if (twoValue.equals("deux")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 2 is \"deux\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 2 is not \"deux\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();   

    System.out.println("Defining a value for 8.");
    D.set(8, "huit");
    try {
      String eightValue = D.get(8);
      if (eightValue.equals("huit")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 8 is \"huit\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 8 is not \"huit\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();
    
    System.out.println("Checking values in order.");

    try {
      String oneValue = D.get(1);
      if (oneValue.equals("un")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 1 is \"un\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 1 is not \"un\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String twoValue = D.get(2);
      if (twoValue.equals("deux")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 2 is \"deux\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 2 is not \"deux\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String threeValue = D.get(3);
      if (threeValue.equals("trois")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 3 is \"trois\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 3 is not \"trois\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String fourValue = D.get(4);
      if (fourValue.equals("quatre")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 4 is \"quatre\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 4 is not \"quatre\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    
    try {
      String fiveValue = D.get(5);
      if (fiveValue.equals("cinq")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 5 is \"cinq\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 5 is not \"cinq\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String sixValue = D.get(6);
      if (sixValue.equals("six")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 6 is \"six\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 6 is not \"six\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String sevenValue = D.get(7);
      if (sevenValue.equals("sept")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 7 is \"sept\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 7 is not \"sept\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String eightValue = D.get(8);
      if (eightValue.equals("huit")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 8 is \"huit\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 8 is not \"huit\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String nineValue = D.get(9);
      if (nineValue.equals("neuf")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 9 is \"neuf\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 9 is not \"neuf\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();

    System.out.println("Deleting values for 1, 5, 6 and 9.");
    
    try {
      D.remove(1);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 1.");
    };

    try {
      D.remove(5);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 5.");
    };

    try {
      D.remove(6);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 6.");
    };

    try {
      D.remove(9);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 9.");
    };
    System.out.println();
    
    System.out.println("Checking values in order.");

    try {
      String oneValue = D.get(1);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };

    try {
      String twoValue = D.get(2);
      if (twoValue.equals("deux")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 2 is \"deux\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 2 is not \"deux\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String threeValue = D.get(3);
      if (threeValue.equals("trois")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 3 is \"trois\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 3 is not \"trois\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String fourValue = D.get(4);
      if (fourValue.equals("quatre")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 4 is \"quatre\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 4 is not \"quatre\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    
    try {
      String oneValue = D.get(5);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 5.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 5.");
    };

    try {
      String oneValue = D.get(6);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 6.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 6.");
    };

    try {
      String sevenValue = D.get(7);
      if (sevenValue.equals("sept")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 7 is \"sept\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 7 is not \"sept\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String eightValue = D.get(8);
      if (eightValue.equals("huit")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 8 is \"huit\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 8 is not \"huit\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String oneValue = D.get(9);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };
    System.out.println();

    System.out.println("Reintroducing value for 5.");
    D.set(5, "cinq");
    try {
      String fiveValue = D.get(5);
      if (fiveValue.equals("cinq")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 5 is \"cinq\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 5 is not \"cinq\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    System.out.println();

    System.out.println("Checking values in order.");

    try {
      String oneValue = D.get(1);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };

    try {
      String twoValue = D.get(2);
      if (twoValue.equals("deux")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 2 is \"deux\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 2 is not \"deux\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String threeValue = D.get(3);
      if (threeValue.equals("trois")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 3 is \"trois\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 3 is not \"trois\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String fourValue = D.get(4);
      if (fourValue.equals("quatre")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 4 is \"quatre\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 4 is not \"quatre\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String fiveValue = D.get(5);
      if (fiveValue.equals("cinq")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 5 is \"cinq\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 5 is not \"cinq\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String oneValue = D.get(6);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 6.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 6.");
    };

    try {
      String sevenValue = D.get(7);
      if (sevenValue.equals("sept")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 7 is \"sept\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 7 is not \"sept\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String eightValue = D.get(8);
      if (eightValue.equals("huit")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 8 is \"huit\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 8 is not \"huit\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };

    try {
      String oneValue = D.get(9);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };
    System.out.println();
    
    System.out.println("Deleting all keys and values except for 8.");
    
    try {
      D.remove(2);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 2.");
    };
    
    try {
      D.remove(3);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 3.");
    };
    
    try {
      D.remove(4);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 4.");
    };

    try {
      D.remove(5);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 5.");
    };

    try {
      D.remove(7);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 7.");
    };
    System.out.println();
    
    System.out.println("Checking values in order.");
    
    try {
      String oneValue = D.get(1);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };
    
    try {
      String oneValue = D.get(2);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 2.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 2.");
    };
    
    try {
      String oneValue = D.get(3);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 3.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 3.");
    };
    
    try {
      String oneValue = D.get(4);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 4.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 4.");
    };
    
    try {
      String oneValue = D.get(5);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 5.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 5.");
    };
    
    try {
      String oneValue = D.get(6);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 6.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 6.");
    };
    
    try {
      String oneValue = D.get(7);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 7.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 7.");
    };
    
    try {
      String eightValue = D.get(8);
      if (eightValue.equals("huit")) {
       System.out.print("get correctly reported that the value");
       System.out.println(" for 8 is \"huit\".");
      } else {
       System.out.print("get incorrectly reported that the value");
       System.out.println(" for 8 is not \"huit\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.println(" noSuchElementException.");
    };
    
    try {
      String oneValue = D.get(9);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 9.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 9.");
    };
    System.out.println();
    
    System.out.print("Removing value for 8 and reintroducing");
    System.out.println(" value for 2.");
    
    try {
      D.remove(8);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 8.");
    };

    D.set(2, "deux");
    System.out.println(); 
    
    System.out.println("Checking values in order.");
    
    try {
      String oneValue = D.get(1);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };
    
    try {
      String twoValue = D.get(2);
      if (twoValue.equals("deux")) {
        System.out.print("get correctly reported that the");
        System.out.println(" value for 2 is \"deux\".");
      } else {
        System.out.print("get incorrectly reported that the");
        System.out.println(" value for 2 is not \"deux\".");
      };
    } catch (NoSuchElementException e) {
      System.out.print("get incorrectly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 2.");
    };
    
    try {
      String oneValue = D.get(3);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 3.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 3.");
    };
    
    try {
      String oneValue = D.get(4);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 4.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 4.");
    };
    
    try {
      String oneValue = D.get(5);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 5.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 5.");
    };
    
    try {
      String oneValue = D.get(6);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 6.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 6.");
    };
    
    try {
      String oneValue = D.get(7);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 7.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 7.");
    };
    
    try {
      String oneValue = D.get(8);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 8.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 8.");
    };
    
    try {
      String oneValue = D.get(9);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 9.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 9.");
    };
    System.out.println();
    
   System.out.println("Removing value for 2.");

    try {
      D.remove(2);
    } catch (NoSuchElementException e) {
      System.out.println("remove incorrectly threw a");
      System.out.print(" NoSuchELementException when deleting");
      System.out.println(" value for 2.");
    };
    System.out.println();
    
    System.out.println("Checking values in order.");
    
    try {
      String oneValue = D.get(1);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 1.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 1.");
    };
    
    try {
      String oneValue = D.get(2);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 2.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 2.");
    };
    
    try {
      String oneValue = D.get(3);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 3.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 3.");
    };
    
    try {
      String oneValue = D.get(4);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 4.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 4.");
    };
    
    try {
      String oneValue = D.get(5);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 5.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 5.");
    };
    
    try {
      String oneValue = D.get(6);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 6.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 6.");
    };
    
    try {
      String oneValue = D.get(7);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 7.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 7.");
    };
    
    try {
      String oneValue = D.get(8);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 8.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 8.");
    };
    
    try {
      String oneValue = D.get(9);
      System.out.print("get failed to throw a NoSuchElementException");
      System.out.println(" when checking for 9.");
    } catch (NoSuchElementException e) {
      System.out.print("get correctly threw a");
      System.out.print(" noSuchElementException when checking");
      System.out.println(" for 9.");
    };
    System.out.println();
    
  }
  
}