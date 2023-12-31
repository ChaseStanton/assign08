package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
    private BinarySearchTree<String> stringTree;
    private BinarySearchTree<Integer> tree;
    private List<Integer> list;

	@Test
	void testContains() {
		assertTrue(tree.contains(10));
	}
	@Test
	void testContainsAll() {
		assertTrue(tree.containsAll(list));
	}
	@Test
	void remove() {
		tree.remove(1);
		assertFalse(tree.contains(1));
		tree.add(1);
		tree.remove(4);
		assertFalse(tree.contains(4));
	}
	
	
    @BeforeEach
    void setUp() throws Exception {
        tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(4);
        tree.add(10);
        tree.add(-10);
        list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(10);
        list.add(-10);
    }

    @Test
    public void testEmptyTree() {
        stringTree = new BinarySearchTree<String>();
        assertTrue(stringTree.isEmpty());
    }

    @Test
    public void addMethodString() {
        stringTree = new BinarySearchTree<String>();
        assertTrue(stringTree.add("Test"));
        assertTrue(stringTree.contains("Test"));
    }

    @Test
    public void addMethodDuplicatesString() {
        stringTree = new BinarySearchTree<String>();
        assertTrue(stringTree.add("Test"));
        assertFalse(stringTree.add("Test"));
    }

    @Test
    public void emptyTreeFirstMethod() {
        stringTree = new BinarySearchTree<String>();

        assertThrows(NoSuchElementException.class, () -> {
            stringTree.first();
        });
    }

    @Test
    public void firstMethod(){
        stringTree = new BinarySearchTree<>();
        stringTree.add("1");
        stringTree.add("2");
        stringTree.add("3");
        stringTree.add("4");
        stringTree.add("5");
        stringTree.add("6");
        stringTree.add("7");
        stringTree.add("8");
        stringTree.add("9");
        stringTree.add("10");
        assertEquals(stringTree.first(), "1");
    }
    @Test
    public void firstMethod2(){
        tree = new BinarySearchTree<Integer>();
        
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        assertEquals(tree.first(), 4);
    }

    @Test
    public void firstMethod3(){
        stringTree = new BinarySearchTree<>();
        
        stringTree.add("d");
        stringTree.add("e");
        stringTree.add("f");
        stringTree.add("g");
        stringTree.add("h");
        stringTree.add("i");
        stringTree.add("j");
        assertEquals(stringTree.first(), "d");
    }


    @Test
    public void lastMethod(){
        stringTree = new BinarySearchTree<>();
        stringTree.add("a");
        stringTree.add("b");
        stringTree.add("c");
        stringTree.add("d");
        stringTree.add("e");
        stringTree.add("f");
        stringTree.add("g");
        stringTree.add("h");
        stringTree.add("i");
        stringTree.add("j");
        
        assertEquals(stringTree.last(), "j");
    }
    @Test
    public void lastMethod2(){
        stringTree = new BinarySearchTree<>();
        stringTree.add("a");
        stringTree.add("b");
        stringTree.add("c");
        stringTree.add("d");
        stringTree.add("e");
        stringTree.add("f");
        stringTree.add("g");
        
        assertEquals(stringTree.last(), "g");
    }
    @Test
    public void lastMethod3(){
        stringTree = new BinarySearchTree<>();
        stringTree.add("1");
        stringTree.add("2");
        stringTree.add("3");
        stringTree.add("4");
        
        assertEquals(stringTree.last(), "4");
    }

    @Test
    public void removeMethod(){
        stringTree = new BinarySearchTree<>();
        stringTree.add("1");
        stringTree.add("2");
        stringTree.add("3");
        stringTree.add("4");
        stringTree.add("5");
        stringTree.add("6");
        stringTree.add("7");
        stringTree.add("8");
        stringTree.add("9");
        stringTree.add("10");

        assertTrue(stringTree.remove("5"));
        assertFalse(stringTree.contains("5"));
    }

    @Test
    public void sizeMethod(){
        stringTree = new BinarySearchTree<>();
        stringTree.add("1");
        stringTree.add("2");
        stringTree.add("3");
        stringTree.add("4");
        stringTree.add("5");
        stringTree.add("6");
        stringTree.add("7");
        stringTree.add("8");
        stringTree.add("9");
        stringTree.add("10");

        assertEquals(stringTree.size(), 10);

        stringTree.remove("5");

        stringTree.remove("3");

        stringTree.remove("10");

        assertEquals(stringTree.size(), 7);
    }

    @Test
    public void toArrayMethod(){
        tree = new BinarySearchTree<Integer>();
        ArrayList<Integer> treeInt = new ArrayList<>();
        treeInt.add(1);
        treeInt.add(2);
        treeInt.add(3);
        treeInt.add(4);
        treeInt.add(5);
        treeInt.add(6);
        treeInt.add(7);
        treeInt.add(8);
        treeInt.add(9);
        treeInt.add(10);

        assertTrue(tree.add(1));
        assertTrue(tree.add(2));
        assertTrue(tree.add(3));
        assertTrue(tree.add(4));
        assertTrue(tree.add(5));
        assertTrue(tree.add(6));
        assertTrue(tree.add(7));
        assertTrue(tree.add(8));
        assertTrue(tree.add(9));
        assertTrue(tree.add(10));

        assertEquals(treeInt, tree.toArrayList());
    }

    @Test
    public void toArrayMethodString(){
        stringTree = new BinarySearchTree<>();
        ArrayList<String> treeToString = new ArrayList<>();
        treeToString.add("a");
        treeToString.add("b");
        treeToString.add("c");
        treeToString.add("d");
        treeToString.add("e");
        treeToString.add("f");
        treeToString.add("g");
        treeToString.add("h");
        treeToString.add("i");
        treeToString.add("j");

        assertTrue(stringTree.add("a"));
        assertTrue(stringTree.add("b"));
        assertTrue(stringTree.add("c"));
        assertTrue(stringTree.add("d"));
        assertTrue(stringTree.add("e"));
        assertTrue(stringTree.add("f"));
        assertTrue(stringTree.add("g"));
        assertTrue(stringTree.add("h"));
        assertTrue(stringTree.add("i"));
        assertTrue(stringTree.add("j"));

        assertEquals(treeToString, stringTree.toArrayList());
    }

    @Test
    public void addThreeToTree() {
        stringTree = new BinarySearchTree<>();
        assertTrue(stringTree.add("1"));
        assertTrue(stringTree.add("2"));
        assertTrue(stringTree.add("3"));
        assertTrue(stringTree.contains("1"));
        assertTrue(stringTree.contains("2"));
        assertTrue(stringTree.contains("3"));
    }

    

}
