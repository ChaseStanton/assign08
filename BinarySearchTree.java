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
		if(search(item) != null){
            return true;
        }
        return false;
	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		for (Type item: items){
            if(!contains(item)){
                return false;
            }
        }
        return true;
	}

	@Override
	public Type first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Type item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Type> toArrayList() {
		// TODO Auto-generated method stub
		return null;
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
