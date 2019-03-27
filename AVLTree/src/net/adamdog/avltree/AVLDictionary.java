package net.adamdog.avltree;

import java.util.NoSuchElementException;

public class AVLDictionary<K extends Comparable<K>, V> implements Dictionary<K, V> {

	class AVLNode {
		private K key;
		private V value;
		private int height;

		private AVLNode left;
		private AVLNode right;
		private AVLNode parent;

		AVLNode(K k, V v) {
			key = k;
			value = v;
			height = 0;
			left = null;
			right = null;
			parent = null;
		}

		K key() {
			return this.key;
		}

		V value() {
			return this.value;
		}

		int height() {
			return this.height;
		}

		AVLNode left() {
			return this.left;
		}

		AVLNode right() {
			return this.right;
		}

		AVLNode parent() {
			return this.parent;
		}

		int balanceFactor() {
			int leftHeight;
			int rightHeight;
			if (this.left == null) {
				leftHeight = -1;
			} else {
				leftHeight = (this.left).height;
			}
			if (this.right == null) {
				rightHeight = -1;
			} else {
				rightHeight = (this.right).height;
			}
			return leftHeight - rightHeight;
		}
	}

	private AVLNode root;

	public AVLDictionary() {
		root = null;
	}

	AVLNode root() {
		return this.root;
	}

	public V get(K key) throws NoSuchElementException {
		return search(key, root);
	}

	private V search(K key, AVLNode x) throws NoSuchElementException {
		if (x == null || key == null)
			throw new NoSuchElementException();
		int c = key.compareTo(x.key);
		if (c < 0)
			return search(key, x.left);
		else if (c > 0)
			return search(key, x.right);
		else
			return x.value;
	}

	private void allSubNodeHeight(AVLNode x, int i) {
		if (x != null) {
			x.height = x.height + i;
			if (x.left != null)
				allSubNodeHeight(x.left, i);
			if (x.right != null)
				allSubNodeHeight(x.right, i);
		}
	}

	private void rotateLeft(AVLNode x) {
		if (x == null)
			return;
		String r = "";
		AVLNode p = x.parent;
		if (p != null) {
			if (p.left == x)
				r = "left";
			if (p.right == x)
				r = "right";
		}
		AVLNode n = x.right;
		// x.height = x.height + 1;
		allSubNodeHeight(x, -1);
		allSubNodeHeight(x.right, +1);
		x.parent = n;
		if (n != null) {
			n.parent = p;
			if (n.left != null) {
				n.left.parent = x;
			}
			x.right = n.left;
			n.left = x;
		}
		if (r == "left")
			p.left = n;
		if (r == "right")
			p.right = n;
	}

	private void rotateRight(AVLNode x) {
		if (x == null)
			return;
		String r = "";
		AVLNode p = x.parent;
		if (p != null) {
			if (p.left == x)
				r = "left";
			if (p.right == x)
				r = "right";
		}
		AVLNode n = x.left;
		// x.height = x.height + 1;
		allSubNodeHeight(x.left, +1);
		allSubNodeHeight(x, -1);
		x.parent = n;
		if (n != null) {
			n.parent = p;
			if (n.right != null) {
				n.right.parent = x;
			}
			x.left = n.right;
			n.right = x;
		}
		if (r == "left")
			p.left = n;
		if (r == "right")
			p.right = n;
	}

	public void set(K k, V v) {
		if (root == null) {
			root = new AVLNode(k, v);
		} else {
			change(k, v, root);
		}
	}

	public void print() {
		AVLNode x = root;
		while (x != null && x.parent != null)
			x = x.parent;
		print(x);
	}

	private void updateHight(AVLNode x) {
		if (x.left != null)
			updateHight(x.left);
		if (x.right != null)
			updateHight(x.right);
		x.height = 1 + Math.max(x.left == null ? -1 : x.left.height, x.right == null ? -1 : x.right.height);
	}

	public void print(AVLNode x) {
		if (x == null)
			System.out.println("Node: Null");
		else {
			System.out.println("Node:" + x.key + " | " + x.value + " | " + x.height + " | "
					+ (x.parent == null ? null : x.parent.key));
			if (x.left != null) {
				System.out.print("<-");
				print(x.left);
			}
			if (x.right != null) {
				System.out.print("->");
				print(x.right);
			}
		}
	}

	private void change(K k, V v, AVLNode x) {
		change2(k, v, x);
		while (root.parent != null)
			root = root.parent;
		root.height = 0;
		updateHight(root);
	}

	private void change2(K k, V v, AVLNode x) {
		if (x == null) {
			x = new AVLNode(k, v);
			return;
		}
		int c = k.compareTo(x.key);
		if (c < 0) {
			if (x.left == null) {
				x.left = new AVLNode(k, v);
				x.left.parent = x;
			} else
				change(k, v, x.left);
		} else if (c > 0) {
			if (x.right == null) {
				x.right = new AVLNode(k, v);
				x.right.parent = x;
			} else
				change(k, v, x.right);
		} else {
			x.value = v;
		}
		x.height = 1 + Math.max(x.left == null ? -1 : x.left.height, x.right == null ? -1 : x.right.height);
		balance(x);
	}

	private void balance(AVLNode x) {
		if (x.balanceFactor() < -1) {
			if (x.right != null && x.right.balanceFactor() > 0)
				rotateRight(x.left);
			rotateLeft(x);
		} else if (x.balanceFactor() > 1) {
			if (x.left != null && x.left.balanceFactor() < 0)
				rotateLeft(x.right);
			rotateRight(x);
		}
		x.height = 1 + Math.max(x.left == null ? -1 : x.left.height, x.right == null ? -1 : x.right.height);
	}

	public V remove(K k) throws NoSuchElementException {
		return deleteFromSubtree(k, root);
	}

	private V deleteFromSubtree(K k, AVLNode x) throws NoSuchElementException {
		AVLNode v = deleteFromSubtree2(k, x);
		if (root != null) {
			while (root.parent != null)
				root = root.parent;
			root.height = 0;
			updateHight(root);
		}
		if (v.parent != null) {
			balance(v.parent);
			if (root != null) {
				while (root.parent != null)
					root = root.parent;
				root.height = 0;
				updateHight(root);
			}
		}
		return v.value;
	}

	private AVLNode deleteFromSubtree2(K k, AVLNode x) throws NoSuchElementException {
		if (x == null || k == null) {
			throw new NoSuchElementException();
		}
		int c = k.compareTo(x.key);
		if (c < 0)
			return deleteFromSubtree2(k, x.left);
		else if (c > 0)
			return deleteFromSubtree2(k, x.right);
		else {
			deleteNode(x);
			return x;
		}
	}

	private void deleteNode(AVLNode x) {
		AVLNode tmp = null;
		if (x.left == null && x.right == null) {
			tmp = null;
		} else if (x.left == null) {
			tmp = x.right;
			tmp.parent = x.parent;
		} else if (x.right == null) {
			tmp = x.left;
			tmp.parent = x.parent;
		} else {
			tmp = findMinFromRight(x);
			tmp.parent = x.parent;
		}
		if (x.parent != null) {
			if (x.parent.left == x)
				x.parent.left = tmp;
			if (x.parent.right == x)
				x.parent.right = tmp;
		} else
			root = tmp;
	}

	private AVLNode findMinFromRight(AVLNode x) {
		AVLNode tmp = x.right;
		while (tmp.left == null)
			tmp = x.left;
		return tmp;
	}
}