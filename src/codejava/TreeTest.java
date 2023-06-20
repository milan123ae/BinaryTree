package codejava;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Test class for a tree.
 */
public class TreeTest{
    @Rule public Timeout globalTimeout = Timeout.seconds(5);

    @Before
    public void setUp() {
    }

    @Test
    public void validInsertAndSearchMethod() {

	    BinaryTree<Integer> bTree = new BinaryTree<>();
	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);

        // Assert
        assertTrue(bTree.search(70));
        assertFalse(bTree.search(71)); 
        assertTrue(bTree.search(65)); 
 
    }

 
    @Test
    public void testOrderTraversal() {
	    BinaryTree<Integer> bTree = new BinaryTree<>();

	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);
	    
	    List<Integer> inOrderList = new ArrayList<>();
	    bTree.traverseInOrder(bTree.getRoot(), inOrderList);
        int[] correctInorder = { 25, 30, 35, 40, 50, 60, 65, 70};
        int i = 0;
        for (int el : inOrderList) 
        {
            assertEquals(correctInorder[i], el);
            i++;
        }
        
	    List<Integer> preOrderList = new ArrayList<>();
	    bTree.traversePreOrder(bTree.getRoot(), preOrderList);
        int[] correctPreorder = { 50, 30, 25, 40, 35, 60, 70, 65};
        int j = 0;
        for (int ele : preOrderList) 
        {
            assertEquals(correctPreorder[j], ele);
            j++;
        }
        
	    List<Integer> postOrderList = new ArrayList<>();
	    bTree.traversePostOrder(bTree.getRoot(), postOrderList);
        int[] correctPostorder = {25, 35, 40, 30, 65, 70, 60, 50};
        int l = 0;
        for (int elem : postOrderList) 
        {
            assertEquals(correctPostorder[l], elem);
            l++;
        }

    }

    @Test
    public void testDelete() {
	    BinaryTree<Integer> bTree = new BinaryTree<>();

	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);


        bTree.deleteNode(bTree.getRoot(), 30);
        
	    List<Integer> inOrderList = new ArrayList<>();
	    bTree.traverseInOrder(bTree.getRoot(), inOrderList);
        int[] correctInorder = { 25,35, 40, 50, 60, 65, 70};
        int i = 0;
        for (int el : inOrderList) 
        {
            assertEquals(correctInorder[i], el);
            i++;
        }

    }

    @Test
    public void testMinValue() {
	    BinaryTree<Integer> bTree = new BinaryTree<>();

	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);
	    
	    int min = bTree.findMinimum();

        assertEquals(25, min);
    }

    @Test
    public void testMaxValue() {
	    BinaryTree<Integer> bTree = new BinaryTree<>();

	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);
	    
	    int max = bTree.findMaximum();

        assertEquals(70, max);
    }
    
    @Test
    public void testSuccessor() {
	    BinaryTree<Integer> bTree = new BinaryTree<>();

	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);
	    
	    int succ = bTree.successor(bTree.search1(60));

        assertEquals(65, succ);
    }
    
    @Test
    public void testPredecessor() {
	    BinaryTree<Integer> bTree = new BinaryTree<>();

	    bTree.insert(50);
	    bTree.insert(30);
	    bTree.insert(60);
	    bTree.insert(25);
	    bTree.insert(40);
	    bTree.insert(35);
	    bTree.insert(70);
	    bTree.insert(65);
	    
	    int pred = bTree.predecessor(bTree.search1(50));

        assertEquals(40, pred);
    }
}