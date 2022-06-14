package com.one.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class SimpleJTree2 {
    JFrame jf = new JFrame("简单树");


    public void init(){

        //创建DefaultMutableTreeNode对象代表结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode guangDong = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangXi = new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode foShan = new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode shanTou = new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode guiLin = new DefaultMutableTreeNode("桂林");
        DefaultMutableTreeNode nanNing = new DefaultMutableTreeNode("南宁");

        //组装结点之间的关系
        root.add(guangDong);
        root.add(guangXi);

        guangDong.add(foShan);
        guangDong.add(shanTou);

        guangXi.add(guiLin);
        guangXi.add(nanNing);


        //创建JTree对象
        JTree tree = new JTree(root);

        //tree.putClientProperty( "JTree.lineStyle", "None"):设置结点之间没有连接线
        //tree.putClientProperty("JTree.lineStyle" , "Horizontal")：设置结点之间只有水平分割线

        //tree.putClientProperty( "JTree.lineStyle", "None");
        //tree.putClientProperty("JTree.lineStyle" , "Horizontal");




        //把JTree放入到窗口中进行展示
        jf.add(tree);

        //DefaultMutableTreeNode getNextSibling(): 返回此结点的下一个兄弟结点 。
        //TreeNode getParent(): 返回此结点的父结点 。 如果此结点没有父结点，则返回null 。
        //boolean isLeaf(): 返回该结点是否是叶子结点
        //boolean isRoot(): 返回当前结点是否是根结点 。

        /*DefaultMutableTreeNode nextNode = guangDong.getNextSibling();
        System.out.println(nextNode);*/
       /* TreeNode parent = guangDong.getParent();
        System.out.println(parent);*/
       /* System.out.println(guangDong.isLeaf());
        System.out.println(foShan.isLeaf());*/
        System.out.println(guangDong.isRoot());
        System.out.println(root.isRoot());


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }


    public static void main(String[] args) {
        new SimpleJTree2().init();
    }
}
