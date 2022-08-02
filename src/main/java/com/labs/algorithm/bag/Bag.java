package com.labs.algorithm.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Bag.java
 * Description 背包的定义
 *
 * @param <T> 节点元素类型
 * @author win
 * @version v1.0 2018/10/9 21:09
 */
public class Bag<T> implements Iterable<T> {

    private Node<T> first; //背包的元素

    private int n;  //背包的长度

    /**
     * Link List 用来作为背包的存储结构
     *
     * @param <T>
     */
    private class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isEmpty() {
        return null == first;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node old = first;
        first = new Node<>();
        first.item = item;
        first.next = old;
        n++;
    }
}
