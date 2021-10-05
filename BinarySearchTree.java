
public class BinarySearchTree {

    public static void main(String args[]) throws Exception {
        System.out.println("Binary Search Tree");
        BST<Integer> bTree = new BST<>();
        bTree.add(56);
        bTree.add(30);
        bTree.add(70);
        bTree.add(22);
        bTree.add(40);
        bTree.add(60);
        bTree.add(95);
        bTree.add(11);
        bTree.add(65);
        bTree.add(3);
        bTree.add(16);
        bTree.add(63);
        bTree.add(67);


        System.out.println("Size of BST: "+bTree.size());
        System.out.println("#### Tree ####");
        System.out.println(bTree.inOrder() + " ");

    }
}
