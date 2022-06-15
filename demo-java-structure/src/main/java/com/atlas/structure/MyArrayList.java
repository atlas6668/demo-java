package com.atlas.structure;

/**
 * Created by sunwenming on 2017/12/8.
 */
public class MyArrayList<E> implements Iterable<E> {
    //
    private static final int DEFAULT_CAPACITY = 10;
    //
    private int size;
    //
    private Object[] elementData;

    public MyArrayList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void trimToSize(){
        ensureCapacity(size());
    }

    public Object get(int idx){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[idx];
    }

    public Object set(int idx, E newVal){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Object old = elementData[idx];
        elementData[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity < size){
            return;
        }
        Object[] old = elementData;
        elementData = new Object[newCapacity];
        for(int i = 0; i < size(); i++){
            elementData[i] = old[i];
        }
    }

    public boolean add(E val){
        add(size(), val);
        return true;
    }

    public void add(int idx, E val){
        if(elementData.length == size()){
            ensureCapacity(size() * 2 + 1);
        }
        for(int i = size; i > idx; i--){
            elementData[i] = elementData[i - 1];
        }
        elementData[idx] = val;
        size++;
    }

    public Object remove(int idx){
        Object removedElement = elementData[idx];
        for(int i = idx; i < size() - 1; i++){
            elementData[i] = elementData[i + 1];
        }
        size--;
        return removedElement;
    }


    @Override
    public java.util.Iterator<E> iterator() {
        return null;
    }

    private class ArrayListIterator implements java.util.Iterator<E>{
        private int curret = 0;

        @Override
        public boolean hasNext() {
            return curret < size();
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return (E) elementData[curret++];
        }

        public void remove(){
            MyArrayList.this.remove(--curret);
        }
    }

}
