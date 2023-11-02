
package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Reece Kalmar and Chase Stanton
 * @version 11/27/2023
 * 
 *          BinarySearchTree is a class that implements a binary search tree
 *          data structure to store and manage a collection of elements. It
 *          provides various methods for adding, removing, and querying elements
 *          within the tree.
 *
 * @param <Type> The type of elements stored in the tree, which must implement
 *               the Comparable interface to support comparison operations.
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	private BinaryNode<Type> rootNode; // The root node of the binary search tree.
	private int size;// The number of elements in the tree.

	/**
	 * Constructs an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		rootNode = null;
		size = 0;
	}

	/**
	 * The add function adds an item to a binary search tree, ensuring that the item
	 * is not already present in the tree.
	 * 
	 * @param item The item parameter represents the element that you want to add to
	 *             the binary search tree.
	 * @return Whether the item was added to the tree.
	 */
	@Override
	public boolean add(Type item) {
		BinaryNode<Type> itemNode = new BinaryNode<Type>(item);

		if (rootNode == null) {
			rootNode = itemNode;
			size++;
			return true;
		}
		BinaryNode<Type> temp = rootNode;

		while (true) { // Sets an infinite loop until something is returned.
			if (item.compareTo(temp.getData()) == 0) // If items already in tree, returns false
				return false;
			else if (item.compareTo(temp.getData()) > 0) {
				if (temp.getRightChild() != null) { // If right child isn't null, set temp to the right child
					temp = temp.getRightChild();
				} else {
					temp.setRightChild(itemNode); // if right child is null, set right child to the item
					size++;
					return true;
				}

			} else {
				if (temp.getLeftChild() != null) { // if left child isn't null, set temp to left child
					temp = temp.getLeftChild();
				} else {

					temp.setLeftChild(itemNode); // if left child is null, set left child to the item
					size++;
					return true;
				}
			}
		}
	}

	/**
	 * The function adds all items from a collection to a tree and returns true if
	 * at least one item was added.
	 * 
	 * @param items A collection of items to be added to the current tree. The items
	 *              can be of any type.
	 * @return The method is returning a boolean value, which indicates whether or
	 *         not the items were successfully added to the tree.
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {

		boolean flag = false;
		for (Type item : items) {
			if (add(item) == true)
				;
			flag = true;
		}
		return flag;
	}

	/**
	 * The clear() function sets the rootNode to null and size to 0, effectively
	 * clearing the data structure.
	 */
	@Override
	public void clear() {
		rootNode = null;
		size = 0;
	}

	/**
	 * The function checks if a binary search tree contains a specific item.
	 * 
	 * @param item The "item" parameter is of type "Type", which is a generic type.
	 *             It represents the item that we are checking for containment in
	 *             the binary tree.
	 * @return Returns whether or not the item was found in the tree.
	 */
	@Override
	public boolean contains(Type item) {
		BinaryNode<Type> temp = rootNode;
		while (temp != null) {
			if (item.compareTo(temp.getData()) == 0)
				return true;
			else if (item.compareTo(temp.getData()) < 0)
				temp = temp.getLeftChild();
			else {
				temp = temp.getRightChild();
			}
		}
		return false;
	}

	/**
	 * The function checks if a collection contains all the items in a tree.
	 * 
	 * @param items A collection of items of generic type.
	 * @return The method is returning a boolean value. It returns true if all the
	 *         items in the given collection are present in the current tree, and
	 *         false otherwise.
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		for (Type item : items) {
			if (!contains(item)) {
				return false;
			}
		}
		return true;

	}

	/**
	 * The function returns the data of the leftmost node in a binary tree, or
	 * throws an exception if the tree is empty.
	 * 
	 * @return The method is returning the data of the leftmost node in the tree.
	 */
	@Override
	public Type first() throws NoSuchElementException {
		if (rootNode == null) {
			throw new NoSuchElementException("The tree is empty");
		}
		return rootNode.getLeftmostNode().getData();
	}

	/**
	 * The function checks if the size variable is equal to 0 and returns true if it
	 * is, otherwise it returns false.
	 * 
	 * @return The method is returning a boolean value. If the size is 0, it will
	 *         return true, indicating that the tree is empty. Otherwise, it will
	 *         return false, indicating that the tree is not empty.
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * The `last()` function returns the data of the rightmost node in a binary
	 * tree.
	 * 
	 * @return The method is returning the data of the rightmost node in the tree.
	 */
	@Override
	public Type last() throws NoSuchElementException {
		if (rootNode == null) {
			throw new NoSuchElementException("The tree is empty");
		}
		return rootNode.getRightmostNode().getData();
	}

	/**
	 * The remove function removes a specified item from a binary search tree.
	 * 
	 * @param item The "item" parameter represents the element that needs to be
	 *             removed from the binary tree.
	 * @return The method is returning a boolean value.
	 */

	@Override
	public boolean remove(Type item) {
		BinaryNode<Type> parent = null;
		BinaryNode<Type> current = rootNode;

		while (current != null) { // traverse the tree until item is found
			int comparison = item.compareTo(current.getData());

			if (comparison == 0) {
				if (current.getLeftChild() == null && current.getRightChild() == null) {
					if (parent == null) { // if the root is the only node, set the root node to null
						rootNode = null;
					} else if (parent.getLeftChild() == current) {
						parent.setLeftChild(null);
					} else {
						parent.setRightChild(null);
					}
				} else if (current.getLeftChild() == null || current.getRightChild() == null) {

					BinaryNode<Type> child = (current.getLeftChild() != null) ? current.getLeftChild()
							: current.getRightChild();
					if (parent == null) {
						rootNode = child;
					} else if (parent.getLeftChild() == current) {
						parent.setLeftChild(child);
					} else {
						parent.setRightChild(child);
					}
				} else {
					//Find the successor node, replace current node, and adjust links
					BinaryNode<Type> successor = current.getRightChild();
					BinaryNode<Type> successorParent = current;
					while (successor.getLeftChild() != null) {
						successorParent = successor;
						successor = successor.getLeftChild();
					}
					if (successorParent != current) {
						successorParent.setLeftChild(successor.getRightChild());
						successor.setRightChild(current.getRightChild());
					}
					successor.setLeftChild(current.getLeftChild());
					if (parent == null) {
						rootNode = successor;
					} else if (parent.getLeftChild() == current) {
						parent.setLeftChild(successor);
					} else {
						parent.setRightChild(successor);
					}
				}
				size--;
				return true;
			} else if (comparison < 0) {
				parent = current;
				current = current.getLeftChild(); // Change current to the left child
			} else {
				parent = current;
				current = current.getRightChild(); // Change current to the right child
			}
		}

		return false;
	}

	/**
	 * The function removes all the specified items from a tree and returns true if
	 * at least one item was removed.
	 * 
	 * @param items A collection of items of type "Type" that need to be removed
	 *              from the current collection.
	 * @return Returns if anyone of the items from the collection were removed from
	 *         the tree
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		boolean flag = false;
		for (Type item : items) {
			if (remove(item)) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * The function returns how many nodes are in the tree.
	 * 
	 * @return The size of the nodes
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * The function converts a binary tree into an ArrayList by performing an
	 * in-order traversal.
	 * 
	 * @return The method is returning an ArrayList of Type objects.
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> list = new ArrayList<>();
		inOrderTraversal(rootNode, list);
		return list;
	}

	/**
	 * The function performs an in-order traversal of a binary tree and adds the
	 * data of each node to an ArrayList.
	 * 
	 * @param node The parameter "node" is of type BinaryNode<Type> and represents
	 *             the current node being visited during the traversal.
	 * @param list The list parameter is an ArrayList that will store the data from
	 *             the binary tree in the order of an in-order traversal.
	 */
	private void inOrderTraversal(BinaryNode<Type> node, ArrayList<Type> list) {
		if (node != null) {
			inOrderTraversal(node.getLeftChild(), list);
			list.add(node.getData());
			inOrderTraversal(node.getRightChild(), list);

		}
	}

}
