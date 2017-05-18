package com.omenroman.set;

import com.omenroman.common.Node;

import java.util.Iterator;
import java.util.Stack;


/**
 * Created by roman on 15.05.17.
 */

public class Set implements Iterable {
    private Node elements;
    private int size;

    public Set() {
        size = 0;
    }

    public boolean add(String value) {

        if (contains(value) || value == null) return false;
        elements = insert(elements, value);
        return true;
    }

    private Node insert(Node elem, String value) {
        if (elem == null) {
            elem = new Node(value);
            size++;
        } else {

            if (elem.getValue().compareTo(value) > 0) {
                elem.setLeft(insert(elem.getLeft(), value));
                elem.getLeft().setParent(elem);


            } else if (elem.getValue().compareTo(value) < 0) {
                elem.setRight(insert(elem.getRight(), value));
                elem.getRight().setParent(elem);


            }
        }
        return elem;
    }


    public boolean remove(String value) {
        if (!contains(value) || value == null) return false;
        elements = remove(elements, value);
        size--;
        return true;
    }


    private Node remove(Node node, String value) {
        Node element = find(node, value);
        if (element == null) {
            return node;
        }
        boolean hasParent = element.getParent() != null;
        boolean isLeft = hasParent && element.getParent().getValue().compareTo(element.getValue()) > 0;
        if (element.getLeft() == null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(null);
                } else {
                    element.getParent().setRight(null);
                }
            }
        } else if (element.getLeft() != null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getLeft());
                } else {
                    element.getParent().setRight(element.getLeft());
                }
            } else {
                node = element.getLeft();
            }
        } else if (element.getLeft() == null && element.getRight() != null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getRight());
                } else {
                    element.getParent().setRight(element.getRight());
                }
            } else {
                node = element.getRight();
            }
        } else {
            Node rightMin = findMin(element.getRight());
            element.setValue(rightMin.getValue());
            remove(rightMin, rightMin.getValue());
        }

        return node;
    }

    public boolean contains(String value) {
        if (find(elements, value) != null) return true;
        return false;
    }

    private Node findMin(Node min) {

        if (min == null) return null;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }

    private Node find(Node node, String value) {
        if (node == null)
            return null;
        if (node.getValue().compareTo(value) == 0)
            return node;
        if (node.getValue().compareTo(value) > 0) {
            return find(node.getLeft(), value);
        } else {
            return find(node.getRight(), value);
        }
    }

    public int size() {
        return size;
    }

    public int depth() {
        return depth(elements);
    }

    private int depth(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.getRight()), depth(node.getLeft()));
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            private Stack<Node> stack = new Stack<>();
            private Node current = elements;

            @Override
            public String next() {
                while (current != null) {
                    stack.push(current);
                    current = current.getLeft();
                }
                current = stack.pop();
                Node node = current;
                current = current.getRight();

                return node.getValue();
            }

            @Override
            public boolean hasNext() {
                return (!stack.isEmpty() || current != null);
            }
        };
        return iterator;
    }
}
