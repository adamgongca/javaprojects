package net.adamdog.avltree;

import java.util.NoSuchElementException;

import net.adamdog.avltree.AVLDictionary;

import java.util.ArrayList;

public class AVLUtilities<K extends Comparable<K>, V> {

	public boolean isAVLTree(AVLDictionary<K, V> D, boolean verbose) {
		boolean isBST = isBST(D, verbose);
		boolean isBalanced = isBalanced(D, verbose);
		return (isBST && isBalanced);
	}

	public boolean isBST(AVLDictionary<K, V> D, boolean verbose) {
		ArrayList<K> A = makeArray(D, verbose);
		int length = A.size();
		int i = 0;
		while (i < length - 1) {
			int result = (A.get(i)).compareTo(A.get(i + 1));
			if (result >= 0) {
				return false;
			}
			i = i + 1;
		}
		return true;
	}

	private ArrayList<K> makeArray(AVLDictionary<K, V> D, boolean verbose) {
		ArrayList<K> A = new ArrayList<K>();
		if (D.root() != null) {
			addToArray(D.root(), A, verbose);
		}
		return A;
	}

	private void addToArray(AVLDictionary<K, V>.AVLNode x, ArrayList<K> A, boolean verbose) {
		if (x.left() != null) {
			addToArray(x.left(), A, verbose);
			int length = A.size();
			int leftResult = (x.key()).compareTo(A.get(length - 1));
			if ((leftResult <= 0) && verbose) {
				System.out.print((A.get(length - 1)).toString());
				System.out.print(" is in the left subtree of ");
				System.out.println(x.key().toString());
			}
		}

		A.add(x.key());
		int length = A.size();

		if (x.right() != null) {
			addToArray(x.right(), A, verbose);
			int rightResult = (x.key()).compareTo(A.get(length));
			if ((rightResult >= 0) && verbose) {
				System.out.print(A.get(length).toString());
				System.out.print(" is in the right subtree of ");
				System.out.println(x.key().toString());
			}
		}
	}

	public boolean isBalanced(AVLDictionary<K, V> D, boolean verbose) {

		if (D.root() == null) {
			return true;
		} else {
			return isSubtreeBalanced(D.root(), verbose);
		}

	}

	private int correctHeight(AVLDictionary<K, V>.AVLNode x) {

		int leftHeight = -1;
		if (x.left() != null) {
			leftHeight = correctHeight(x.left());
		}

		int rightHeight = -1;
		if (x.right() != null) {
			rightHeight = correctHeight(x.right());
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}

	private int correctBalance(AVLDictionary<K, V>.AVLNode x) {

		int leftHeight = -1;
		if (x.left() != null) {
			leftHeight = correctHeight(x.left());
		}

		int rightHeight = -1;
		if (x.right() != null) {
			rightHeight = correctHeight(x.right());
		}

		return leftHeight - rightHeight;

	}

	private boolean isSubtreeBalanced(AVLDictionary<K, V>.AVLNode x, boolean verbose) {

		boolean leftBalanced = true;
		if (x.left() != null) {
			leftBalanced = isSubtreeBalanced(x.left(), verbose);
		}
		boolean rightBalanced = true;
		if (x.right() != null) {
			rightBalanced = isSubtreeBalanced(x.right(), verbose);
		}
		boolean correctHeight = true;
		if (correctHeight(x) != x.height()) {
			correctHeight = false;
		}
		if ((!correctHeight) && verbose) {
			System.out.print("Height of node with key ");
			System.out.print(x.key().toString());
			System.out.println(" is incorrect.");
		}

		int balanceFactor = correctBalance(x);
		boolean nodeBalanced = ((balanceFactor == 1) || (balanceFactor == 0) || (balanceFactor == -1) || correctHeight);

		if ((!nodeBalanced) && verbose) {
			System.out.print("Node with key ");
			System.out.print(x.key().toString());
			System.out.print(" has balance factor ");
			System.out.println(balanceFactor);
		}

		return (leftBalanced && rightBalanced && nodeBalanced);

	}

}