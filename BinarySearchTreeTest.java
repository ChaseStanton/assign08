package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
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
	
	

}
