package tree.avl;

/**
 * Created by LeeAutumn on 10/22/16.
 * blog: leeautumn.net
 */
public class AVLNode<T>{
    private T data = null;
    private AVLNode<T> leftChild = null;
    private AVLNode<T> rightChind = null;
    private int height = 0;

    public AVLNode(T data, AVLNode<T> leftChild, AVLNode<T> rightChind, int height) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChind = rightChind;
        this.height = height;
    }

    public AVLNode(){

    }

    public AVLNode(T data, AVLNode<T> leftChild, AVLNode<T> rightChind){
        this(data,leftChild,rightChind,0);
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

    public AVLNode<T> getRightChind() {
        return rightChind;
    }

    public void setRightChind(AVLNode<T> rightChind) {
        this.rightChind = rightChind;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
