package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
    private BinarySearchTree<String> stringTree;
    private BinarySearchTree<Integer> tree;
    private List<Integer> list;

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
    public void addThreeToTree() {
        stringTree = new BinarySearchTree<>();
        assertTrue(stringTree.add("1"));
        assertTrue(stringTree.add("2"));
        assertTrue(stringTree.add("3"));
        assertTrue(stringTree.contains("1"));
        assertTrue(stringTree.contains("2"));
        assertTrue(stringTree.contains("3"));
    }

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
        assertTrue(tree.contains(10));
    }

}
