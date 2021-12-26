package com.mycompany.oop1.Iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode<T>{
    T val;
    public List<TreeNode<T>> children = new CustomLinkedList<>();

    public TreeNode(T data){
        val = data;
    }

    public TreeNode(T data,List<TreeNode<T>> child){
        val = data;
        children = child;
    }


}