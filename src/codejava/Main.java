package codejava;

import java.util.ArrayList;
import java.util.List;

import codejava.BinaryTree;;

public class Main {

	public static void main(String args[]) {
	    BinaryTree<Integer> bTree = new BinaryTree<>();
	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);

	    System.out.println("Inorder Traversal");
	    List<Integer> inOrderList = new ArrayList<>();
	    bTree.traverseInOrder(bTree.getRoot(), inOrderList);
	    bTree.printList(inOrderList);

	    System.out.println("Pre Traversal");
	    List<Integer> preOrderList = new ArrayList<>();
	    bTree.traversePreOrder(bTree.getRoot(), preOrderList);
	    bTree.printList(preOrderList);
	    
        bTree.deleteNode(bTree.getRoot(), 30);

	    System.out.println("Post Traversal");
	    List<Integer> postOrderList = new ArrayList<>();
	    bTree.traversePostOrder(bTree.getRoot(), postOrderList);
	    bTree.printList(postOrderList);
	    
	    System.out.println(bTree.search(70));
        System.out.println(bTree.findMaximum());
        System.out.println(bTree.findMinimum());
        System.out.println(bTree.successor(bTree.search1(60)));
        System.out.println(bTree.predecessor(bTree.search1(50)));
        

	}

}
