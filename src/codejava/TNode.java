package codejava;

public class TNode<T extends Comparable<T>> {
    T data;
    public TNode<T> left;
    public TNode<T> right;

    public TNode(T data){
        this.data = data;
    }
}