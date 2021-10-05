
public class BinarySearchTree {

    public static void main(String args[]) throws Exception {
        System.out.println("Binary Search Tree");
        BST<Integer> bTree = new BST<>();
        bTree.add(56);
        bTree.add(30);
        bTree.add(70);

        System.out.println("#### Tree ####");
        System.out.println(bTree.inOrder() + " ");

    }
}
