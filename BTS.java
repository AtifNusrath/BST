import java.util.LinkedList;
import java.util.List;


class BST<T extends Comparable<T>> {
    private BSTNode<T> root;
    private int size;

    public BST() {
    }

    public BSTNode<T> root() {
        return root;
    }

    private void addRoot(T data) throws Exception {
        if (root != null) throw new Exception("Root exists is the tree.");
        root = new BSTNode<>(data);
        size++;
    }

    public void add(T data) throws Exception {
        BSTNode<T> node = find(data);
        if (node == null)
            addRoot(data);
        else if (node.getData().compareTo(data) > 0)
            addLeft(node, data);
        else if (node.getData().compareTo(data) < 0)
            addRight(node, data);
        else node.setData(data);
    }

    private void addLeft(BSTNode<T> parent, T data) {
        BSTNode<T> left = new BSTNode<>(data);
        parent.setLeftChild(left);
        left.setParent(parent);
        size++;
    }

    private void addRight(BSTNode<T> parent, T data) {
        BSTNode<T> right = new BSTNode<>(data);
        parent.setRightChild(right);
        right.setParent(parent);
        size++;
    }

    public T get(T data) {
        BSTNode<T> node = find(data);
        if (node == null || !node.getData().equals(data)) return null;
        return node.getData();
    }

    public boolean contains(T data) {
        BSTNode<T> node = find(data);
        if (node == null || !node.getData().equals(data)) return false;
        return true;
    }

    private BSTNode<T> find(T data) {
        if (root() == null) return null;
        return findRecursively(root(), data);
    }

    private BSTNode<T> findRecursively(BSTNode<T> parent, T data) {
        int comparison = data.compareTo(parent.getData());
        if (comparison == 0) return parent;
        else if (comparison < 0 && parent.getLeftChild() != null) return findRecursively(parent.getLeftChild(), data);
        else if (comparison > 0 && parent.getRightChild() != null) return findRecursively(parent.getRightChild(), data);
        return parent;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private BSTNode<T> parent(BSTNode<T> child) {
        return child.getParent();
    }


    public List<T> inOrder() {
        List<T> answer = new LinkedList<>();
        inOrder(root(), answer);
        return answer;
    }

    private void inOrder(BSTNode<T> node, List<T> list) {
        if (node == null) return;
        inOrder(node.getLeftChild(), list);
        list.add(node.getData());
        inOrder(node.getRightChild(), list);
    }

    @Override
    public String toString() {
        return inOrder().toString();
    }
}
