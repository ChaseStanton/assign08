package assign08;


public class BinaryNode <Type> {
    private Type data;
    private BinaryNode<Type> leftChild, rightChild;

    public BinaryNode(){
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryNode(Type data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryNode(Type data, BinaryNode<Type> leftChild, BinaryNode<Type> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setData(Type data){
        this.data = data;
    }

    public void setLeftChild(BinaryNode<Type> leftChild){
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryNode<Type> rightChild){
        this.rightChild = rightChild;
    }

    public BinaryNode<Type> getLeftChild(){
        return this.leftChild;
    }

    public BinaryNode<Type> getRightChild(){
        return this.rightChild;
    }
    public BinaryNode<Type> getLeftmostNode() {
		if(this.leftChild == null)
			return this;
		
		
		return this.leftChild.getLeftmostNode();

	}
    public BinaryNode<Type> getRightmostNode() {
		if(this.rightChild == null)
			return this;
		
		return rightChild.getRightmostNode();
		
	}
    
    public Type getData(){
        return this.data;
    }
}
