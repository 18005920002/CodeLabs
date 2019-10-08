package com.labs.datastruct;

/**
 * @Description: 节点
 * @Author: tanyun.zheng
 * @Date: 2019/10/7 16:21
 */
public class TNode {
    private TNode parent;
    private TNode left;
    private TNode right;
    private Comparable key;
    private Object value;
    private int n;

    public TNode(Comparable key){
        this.key = key;
        value = key;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public Comparable getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString(){
        return key.toString();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
