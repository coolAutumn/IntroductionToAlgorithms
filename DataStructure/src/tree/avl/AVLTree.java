package tree.avl;

import sun.jvm.hotspot.utilities.RBTree;

/**
 * Created by LeeAutumn on 10/22/16.
 * blog: leeautumn.net
 */
public class AVLTree<T extends Comparable> implements IAVLTree<T> {

    AVLNode<T> root = null;
    int height = 0;


    public AVLTree(AVLNode<T> root, int height) {
        this.root = root;
        this.height = height;
    }

    public AVLTree() {
        this.root = new AVLNode<T>();
        this.height = 0;
    }

    public AVLTree(T data) {
        this.root = new AVLNode<T>(data);
    }



    /**
     * 往AVLTree中插入值
     * @param object
     */
    @Override
    public void insert(T object) {
        AVLNode<T> insertObject = new AVLNode<T>(object);

        if(object == null){
            throw new IllegalArgumentException("The object you insert is null.");
        }

        insert(insertObject,root);
    }

    /**
     * 计算以某个节点为树根的树的高度,若无子节点则高度=1(它自己啊)
     * @param object
     * @return
     */
    private int height(AVLNode<T> object){
        return object == null ? 0 : object.getHeight();
    }

    private void rotateWithLeftChild(AVLNode<T> rotateRoot){
        //更新子节点信息
        AVLNode<T> temp =  rotateRoot;
        rotateRoot      =  rotateRoot.getLeftChild();
        temp.setLeftChild(rotateRoot.getRightChild());
        rotateRoot.setRightChild(temp);

        //更新各节点父节点信息
        rotateRoot.setParent(temp.getParent());
        if(temp.getLeftChild() != null)
            temp.getLeftChild().setParent(temp);

        if(temp.getParent() != null) {
            if (rotateRoot.getData().compareTo(temp.getParent().getData()) == -1) {
                temp.getParent().setLeftChild(rotateRoot);
            } else {
                temp.getParent().setRightChild(rotateRoot);
            }
        }else {
            root = rotateRoot;
            rotateRoot.setParent(null);
        }

        temp.setParent(rotateRoot);

        //更新高度信息
        temp.setHeight(Math.max(height(temp.getLeftChild()),height(temp.getRightChild())) + 1);
        rotateRoot.setHeight(Math.max(height(rotateRoot.getLeftChild()),height(rotateRoot.getRightChild())) + 1);

    }

    private void rotateWithRightChild(AVLNode<T> rotateRoot){
        //更新子节点信息
        AVLNode<T> temp =  rotateRoot;
        rotateRoot      =  rotateRoot.getRightChild();
        temp.setRightChild(rotateRoot.getLeftChild());
        rotateRoot.setLeftChild(temp);

        //更新各节点父节点信息
        rotateRoot.setParent(temp.getParent());
        if(temp.getRightChild() != null)
         temp.getRightChild().setParent(temp);


        if(temp.getParent() != null) {
            if (rotateRoot.getData().compareTo(temp.getParent().getData()) == -1) {
                temp.getParent().setLeftChild(rotateRoot);
            } else {
                temp.getParent().setRightChild(rotateRoot);
            }
        }else{
            root = rotateRoot;
            rotateRoot.setParent(null);
        }

        temp.setParent(rotateRoot);

        //更新高度信息
        temp.setHeight(Math.max(height(temp.getLeftChild()),height(temp.getRightChild())) + 1);
        rotateRoot.setHeight(Math.max(height(rotateRoot.getLeftChild()),height(rotateRoot.getRightChild())) + 1);

    }

    private void doubleRotateWithLeftChild(AVLNode<T> rotateRoot){
        rotateWithRightChild(rotateRoot.getLeftChild());
        rotateWithLeftChild(rotateRoot);
    }

    private void doubleRotateWithRightChild(AVLNode<T> rotateRoot){
        rotateWithLeftChild(rotateRoot.getRightChild());
        rotateWithRightChild(rotateRoot);
    }

    /**
     * 利用递归向AVLTree中插入值,并进行旋转使得树满足AVLTree的性质
     *
     * 在写的时候主要注意节点的父节点的设置
     * @param object
     * @param insertRoot
     */
    private void insert(AVLNode<T> object,AVLNode<T> insertRoot){



        int compareResult = object.getData().compareTo(insertRoot.getData());

        if(compareResult == -1) {
            //新节点的设置有两种方案 1.判断接下来的insertRoot.left是否为空,空就设置当前insertRoot为父节点 2.一直设下去,知道设到叶子节点的父节点
            //object.setParent(insertRoot.getLeftChild());
            //找到最终的叶子节点
            if (insertRoot.getLeftChild() == null) {
                insertRoot.setLeftChild(object);
                object.setParent(insertRoot);
                object.setHeight(1);

                //更新节点高度信息
                insertRoot.setHeight(Math.max(height(insertRoot.getLeftChild()),height(insertRoot.getRightChild())) + 1);
                return;
            }

            //接下去进行insert
            insert(object, insertRoot.getLeftChild());

            //判断插入后是否违反了AVLTree的性质
            if (height(insertRoot.getLeftChild()) - height(insertRoot.getRightChild()) == 2) {
                if (object.getData().compareTo(insertRoot.getData()) == -1) {
                    //插到了insertRoot的左支的左支上
                    rotateWithLeftChild(insertRoot);
                } else {
                    doubleRotateWithLeftChild(insertRoot);
                }
            }
        }else if(compareResult == 1) {

            //找到最终的叶子节点
            if (insertRoot.getRightChild() == null) {
                insertRoot.setRightChild(object);
                object.setParent(insertRoot);
                object.setHeight(1);

                //更新节点高度信息
                insertRoot.setHeight(Math.max(height(insertRoot.getLeftChild()),height(insertRoot.getRightChild())) + 1);
                return;
            }

            //接下去进行insert
            insert(object, insertRoot.getRightChild());

            if (height(insertRoot.getLeftChild()) - height(insertRoot.getRightChild()) == -2) {
                if (object.getData().compareTo(insertRoot.getData()) == 1) {
                    //插到了insertRoot的右支的右支上
                    rotateWithRightChild(insertRoot);
                } else {
                    doubleRotateWithRightChild(insertRoot);
                }
            }
        }
        //更新节点高度信息
        insertRoot.setHeight(Math.max(height(insertRoot.getLeftChild()),height(insertRoot.getRightChild())) + 1);
    }



    @Override
    public void remove(T object) {

    }

    @Override
    public void get(T object) {

    }



    @Override
    public void printTree() {
        printTree(root,0);
    }

    /**
     * 利用递归找到将要被插入位置的父节点
     * @param treeRoot
     * @param object
     * @return
     */
    private AVLNode<T> getInsertPosition(AVLNode<T> treeRoot , AVLNode<T> object){
        int compare = object.getData().compareTo(treeRoot.getData());      //在类中而不是局部变量中声明有助于减小栈帧大小,防止OOM ~~

        //基准情形,应为被插入的地方一定是个叶子,so当==null时,返回叶子的父节点
        if(treeRoot == null){
            return treeRoot.getParent();
        }
        if(compare == -1){
            return getInsertPosition(treeRoot.getLeftChild(),object);
        }else if(compare == 1){
            return getInsertPosition(treeRoot.getRightChild(),object);
        }else{
            treeRoot.setSameObjectNumber(treeRoot.getSameObjectNumber()+1);
            return null;
        }
    }


    int temp = 0;
    private void printTree(AVLNode<T> root,int tabs){
        temp = tabs;
        while(temp-- > 0){
            System.out.print("  ");
        }
        System.out.println(root+"-"+root.getParent());

        if(root.getLeftChild() != null){
            printTree(root.getLeftChild(),1+tabs);
        }
        if(root.getRightChild() != null){
            printTree(root.getRightChild(),1+tabs);
        }
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<Integer>(0);
        avlTree.insert(1);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(2);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(9);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(7);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(10);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(12);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(3);
        avlTree.printTree();
        System.out.println();
        avlTree.insert(5);
        avlTree.printTree();

    }
}
