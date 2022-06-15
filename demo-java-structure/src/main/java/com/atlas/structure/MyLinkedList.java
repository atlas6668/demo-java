package com.atlas.structure;

import java.util.Iterator;

/**
 * Created by sunwenming on 2017/12/8.
 */
public class MyLinkedList<E> implements Iterable<E> {
    //
    private int size;
    //
    private int modCount = 0;
    //
    private Node<E> beginMarker;
    //
    private Node<E> endMarker;

    private static class Node<E>{
        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(E d, Node<E> p, Node<E> n){
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;

        size = 0;
        modCount++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean add(E val){
        add(size(), val);
        return true;
    }

    public void add(int idx, E val){
        addBefore(getNode(idx, 0, size()), val);
    }

    public E get(int idx){
        return getNode(idx).data;
    }

    public E set(int idx, E newVal){
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public E remove(int idx){
        return remove(getNode(idx));
    }

    public void addBefore(Node<E> p, E val){
        Node<E> newNode = new Node<E>(val, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        size++;
        modCount++;
    }

    public E remove(Node<E> p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        modCount++;
        return p.data;
    }

    public Node<E> getNode(int idx){
        return getNode(idx, 0, size() - 1);
    }

    private Node<E> getNode(int idx, int lower, int upper){
        Node<E> p;
        if(idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }
        if(idx < size() / 2){
            p = beginMarker.next;
            for(int i = 0; i < idx; i++){
                p = p.next;
            }
        } else {
            p = endMarker;
            for(int i = size(); i > idx; i--){
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            E nextElement = current.data;
            current = current.next;
            okToRemove = true;
            return nextElement;
        }

        public void remove(){
            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

}
