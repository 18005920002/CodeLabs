package com.labs.datastruct;


/**
 * @Description: 二叉树
 * @Author: tanyun.zheng
 * @Date: 2019/10/7 16:20
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;

        public Node(Key key,Value value,int n){
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node node){
        if(null==node){
            return 0;
        }else{
            return node.n;
        }
    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node node,Key key){
        if(null==node){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp<0) {
            return get(node.left,key);
        } else if(cmp>0){
            return get(node.right,key);
        } else {
            return node.value;
        }
    }

    public void put(Key key,Value value){
        put(root,key,value);
    }

    public void put(Node node,Key key,Value value){
        
    }



}
