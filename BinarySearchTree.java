package assign08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
    private BinaryNode<Type> rootNode;
    private int size;

    public BinarySearchTree() {
    	rootNode = null;
    	size = 0;
    }

	@Override
	public boolean add(Type item) {
		BinaryNode<Type> itemNode = new BinaryNode<Type>(item);
		
		if(rootNode == null) {
			rootNode = itemNode;
			size++;
			return true;
		}
		BinaryNode<Type> temp = rootNode;

		while (true) {
			if (item.compareTo(temp.getData()) == 0)
				return false;
			else if (item.compareTo(temp.getData()) > 0) {
				if (temp.getLeftChild() == null) {
					temp.setLeftChild(itemNode);
					size++;
					return true;
				}
				temp = temp.getLeftChild();

			} else {
				if (temp.getRightChild() == null) {
					temp.setRightChild(itemNode);
					size++;
					return true;
				}
				temp = temp.getRightChild();
			}
		}
	}

	@Override
	public boolean addAll(Collection<? extends Type> items) {
		
        boolean flag = false;
		for(Type item: items){
            if(add(item) == true);
            flag = true;
        }
        return flag;
	}

	@Override
	public void clear() {
        rootNode = new BinaryNode<Type>();		
	}

	@Override
	public boolean contains(Type item) {
		BinaryNode<Type> temp = rootNode;
		while(temp != null) {
			if(item.compareTo(temp.getData()) == 0)
				return true;
			else if(item.compareTo(temp.getData()) > 0)
				temp = temp.getLeftChild();
			temp = temp.getRightChild();
		}
        return false;
	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		for(Type item: items) {
			if(contains(item))
				return true;
		}
		return false;
		
	}

	@Override
	public Type first() throws NoSuchElementException {
		return rootNode.getLeftmostNode().getData();
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public Type last() throws NoSuchElementException {
		return rootNode.getRightmostNode().getData();
	}

	@Override
public boolean remove(Type item) {
    BinaryNode<Type> parent = null;
    BinaryNode<Type> current = rootNode;

    while (current != null) {
        int comparison = item.compareTo(current.getData());

        if (comparison == 0) {
            if (current.getLeftChild() == null && current.getRightChild() == null) {
                if (parent == null) {
                    rootNode = null;
                } else if (parent.getLeftChild() == current) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            } else if (current.getLeftChild() == null || current.getRightChild() == null) {

                BinaryNode<Type> child = (current.getLeftChild() != null) ? current.getLeftChild() : current.getRightChild();
                if (parent == null) {
                    rootNode = child;
                } else if (parent.getLeftChild() == current) {
                    parent.setLeftChild(child);
                } else {
                    parent.setRightChild(child);
                }
            } else {
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
            current = current.getLeftChild();
        } else {
            parent = current;
            current = current.getRightChild();
        }
    }

    return false;
}


	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		boolean flag = false;
        for (Type item : items){
            if(remove(item)){
                flag = true;
            }
        }
        return flag;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<Type> toArrayList() {
		ArrayList<Type> list = new ArrayList<>();
		inOrderTraversal(rootNode, list);
		return list;
	}
	private void inOrderTraversal(BinaryNode<Type> node, ArrayList<Type> list) {
		if(node != null) {
			inOrderTraversal(node.getLeftChild(), list);
			list.add(node.getData());
			inOrderTraversal(node.getRightChild(), list);
			
		}
	}

    private BinaryNode<Type> search(Type data){
        BinaryNode<Type> head = this.rootNode; 
        while(head.getLeftChild() != null && head.getRightChild() != null){
            if(head != null && head.getData().equals(data)){
                return head;
            }
            else if(data.compareTo(head.getData()) < 0 && head.getLeftChild() != null){
                head = head.getLeftChild();
            }
            else if(data.compareTo(head.getData()) > 0 && head.getRightChild() != null){
                head = head.getRightChild();
            }
        }
        return head;
    }
}
