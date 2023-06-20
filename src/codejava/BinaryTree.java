package codejava;

import codejava.TNode;
//import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
private TNode<T> root;

public TNode<T> getRoot() {
    return this.root;
}

public void insert(T data) {
    TNode<T> newNode = new TNode<T>(data);
    if (root == null) {
        root = newNode;
    } else {
        TNode<T> tempNode = root;
        TNode<T> prev = null;
        while (tempNode != null) {
            prev = tempNode;
            if (data.compareTo(tempNode.data) > 0) {
                tempNode = tempNode.right;
            } else {
                tempNode = tempNode.left;
            }
        }
        if (data.compareTo(prev.data) < 0) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }

    }
}

public boolean search(T data) {
    return search(this.root, data);
}
private boolean search(TNode<T> root, T data) {
    if (root == null) {
        return false;
    } else if (root.data == data) {
        return true;
    } else if(root.data.compareTo(data) > 0) {
        return search(root.left, data);
    }
    return search(root.right, data);
}


public void traverseInOrder(TNode<T> root, List<T> storageList) {
    if (root != null) {
        traverseInOrder(root.left, storageList);
        storageList.add(root.data);
        traverseInOrder(root.right, storageList);
    }
}

public void traversePreOrder(TNode<T> root, List<T> storageList) {
    if (root != null) {
        storageList.add(root.data);
        traversePreOrder(root.left, storageList);
        traversePreOrder(root.right, storageList);
    }
}

public void traversePostOrder(TNode<T> root, List<T> storageList) {
    if (root != null) {
        traversePostOrder(root.left, storageList);
        traversePostOrder(root.right, storageList);
        storageList.add(root.data);
    }
}

public void printList(List<T> list) {
    for (T item : list) {
        System.out.println(item);
    }
}

public T  findMaximum() {
    if(root==null){
        return null;
    }
    // processing the right sub tree
    TNode<T> current = this.root;
     while (current.right != null) {
         current = current.right;
     }
     return (current.data);
 }

public T findMinimum() {
    if(root==null){
        return null;
    }
    // processing the left sub tree
    TNode<T> current = this.root;
    while (current.left != null) {
        current = current.left;
    }
    return (current.data);
}

public TNode<T> deleteNode(TNode<T> root, T data) {
    if(root == null) return root;
    if(data.compareTo(root.data) > 0){ //move right
        root.right = deleteNode(root.right, data);
    }else if(data.compareTo(root.data) < 0){ //move left
        root.left = deleteNode(root.left, data);
    }else{ // found the target
        if(root.left == null && root.right == null){ // leaf node
            root = null;
        }else if(root.right != null){ //it has a right child
            root.data = successor(root); // successor
            root.right = deleteNode(root.right, root.data);
        }else{ 
            root.data = predecessor(root);
            root.left = deleteNode(root.left, root.data);
        }
    }
    return root;
}

public T successor(TNode<T> root){
    root = root.right;
    while(root.left != null){
        root = root.left;
    }
    return root.data;
}

public T predecessor(TNode<T> root){
    root = root.left;
    while(root.right != null){
        root = root.right;
    }
    return root.data;
}

public TNode<T> search1(T data) {
    return search1(this.root, data);
}
private TNode<T> search1(TNode<T> root, T data) {
    if (root == null) {
        return null;
    } else if (root.data == data) {
        return root;
    } else if(root.data.compareTo(data) > 0) {
        return search1(root.left, data);
    }
    return search1(root.right, data);
}
}
