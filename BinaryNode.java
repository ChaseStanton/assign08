package assign08;

/**
 * This class represents a generic binary node
 * @author Chase Stanton and Reece Kalmar
 *
 * @param <Type> - The type of BinaryNode
 */
public class BinaryNode <Type> {
    private Type data;
    private BinaryNode<Type> leftChild, rightChild;
/**
 * This constructor sets the data and children of the node to null
 */
    public BinaryNode(){
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }
/**
 * This constructor sets the data of the node to the data specified in the parameter
 * @param data - The data to be put in the node
 */
    public BinaryNode(Type data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
/**
 * This constructor sets the data of the node to the data specified in the parameter and the children to the children 
 * specified in the parameter
 * @param data - the data to be put in the node
 * @param leftChild - the left child to add to the node
 * @param rightChild - the right child to add to the node
 */
    public BinaryNode(Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
/**
 * This method sets the data of the node to data
 * @param data - the data to be set to the node
 */
    public void setData(Type data){
        this.data = data;
    }
/**
 * This method sets the left child to leftChild
 * @param leftChild - the left child to be set to the node
 */
    public void setLeftChild(BinaryNode<Type> leftChild){
        this.leftChild = leftChild;
    }
    /**
     * This method sets the right child to rightChild
     * @param rightChild - the right child to be set to the node
     */
    public void setRightChild(BinaryNode<Type> rightChild){
        this.rightChild = rightChild;
    }
    /**
     * This method retrieves the left child node of this node
     * @return the left child node
     */
    public BinaryNode<Type> getLeftChild(){
        return this.leftChild;
    }
    /**
     * This method retrieves the right child node of this nod
     * @return the right child node
     */
    public BinaryNode<Type> getRightChild(){
        return this.rightChild;
    }
    /**
     * This method retrieves the leftmost node of this node
     * @return the leftmost node
     */
    public BinaryNode<Type> getLeftmostNode() {
		if(this.leftChild == null)
			return this;
		
		
		return this.leftChild.getLeftmostNode();

	}
    /**
     * This method retrieves the rightmost node of this node
     * @return the rightmost node
     */
    public BinaryNode<Type> getRightmostNode() {
		if(this.rightChild == null)
			return this;
		
		return rightChild.getRightmostNode();
		
	}
    /**
     * This method retrieves the data from this node
     * @return The data of this node
     */
    public Type getData(){
        return this.data;
    }
}
