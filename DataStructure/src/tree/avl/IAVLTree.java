package tree.avl;

/**
 * Created by LeeAutumn on 10/22/16.
 * blog: leeautumn.net
 */
public interface IAVLTree<T> {
    public void insert(T object);
    public void remove(T object);
    public void get(T object);
    public void ge(T object);


}
