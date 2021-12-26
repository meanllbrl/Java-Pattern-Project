package com.mycompany.oop1.Iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {
    // inner class
    class Node<T> {

        private T data;// Diğer projelerle uyum sağlaması açısından T kullanıldı
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            data = newData;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> newNext) {
            next = newNext;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int currentSize;

    public LinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addNode(Object data) {
        Node newNode = new Node(data);
        // listenin boş olup olmadığını kontrol etme
        if (head == null) {
            // eğer boş ise head ve tail newNode' a point edecek
            head = newNode;
            tail = newNode;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode will become new tail of the list
            tail = newNode;
        }
    }
    /*
     * public int size() { int count = 0; Node currNode = head; while (currNode !=
     * null) { count++; currNode = currNode.next; } return count; }
     */

    // display() metodu ile düğümde yer alan tüm dataları yazdırma işlemi yapılacak
    public void display() {
        // current düğümü ilk olarak head'i point edecek

        Node current = head;

        if (head == null) {
            System.out.println("Liste boş.");
            return;
        }
        System.out.println("Linked List'in düğümleri : ");
        while (current != null) {
            // Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(T e) {
        if (isEmpty()) {
            head = new Node(e, null);
            tail = head;
        } else {
            tail.setNext(new Node(e, null));
            tail = tail.getNext();
        }
        currentSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        currentSize = 0;

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
       
        if (index < size() - 1) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
        return tail.getData();
    }

    @Override
    public T set(int index, T element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size()) {
            add(element);
            return;
        }
        if (index == 0) {
            head = new Node<T>(element, head);

        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            // current is now the node before the index where we want to add
            current.setNext(new Node<T>(element, current.getNext()));

        }
        currentSize++;

    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return currentSize;
    }

}
