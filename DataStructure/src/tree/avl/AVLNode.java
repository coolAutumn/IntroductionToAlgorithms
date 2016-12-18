package tree.avl;

/**
 * Created by LeeAutumn on 10/22/16.
 * blog: leeautumn.net
 */
public class AVLNode<T extends Comparable>{
    private T data = null;
    private AVLNode<T> parent = null;
    private AVLNode<T> leftChild = null;
    private AVLNode<T> rightChild = null;
    private int sameObjectNumber = 1;
    private int height = 0;

    public AVLNode(T data, AVLNode<T> leftChild, AVLNode<T> rightChild, int height) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.height = height;
    }

    public AVLNode(){

    }

    public AVLNode(T data, AVLNode<T> leftChild, AVLNode<T> rightChild){
        this(data,leftChild, rightChild,0);
    }

    public AVLNode(T data) {
        this(data,null,null,0);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode<T> getParent() {
        return parent;
    }

    public void setParent(AVLNode<T> parent) {
        this.parent = parent;
    }

    public int getSameObjectNumber() {
        return sameObjectNumber;
    }

    public void setSameObjectNumber(int sameObjectNumber) {
        this.sameObjectNumber = sameObjectNumber;
    }

    @Override
    public String toString() {
        return "["+data+" "+height+"]";
    }
}
