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
    public void lastMethod(){
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
        
        assertEquals(stringTree.last(), "10");
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
        stringTree = new BinarySearchTree<>();
        ArrayList<String> treeToString = new ArrayList<>();
        treeToString.add("1");
        treeToString.add("2");
        treeToString.add("3");
        treeToString.add("4");
        treeToString.add("5");
        treeToString.add("6");
        treeToString.add("7");
        treeToString.add("8");
        treeToString.add("9");
        treeToString.add("10");

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

        assertEquals(stringTree.toArrayList(), treeToString);
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
