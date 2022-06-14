package com.one.tree;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class ChangeAllCellRender {

    JFrame jf = new JFrame("改变所有结点外观");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    public void init(){
        //通过add()方法建立父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        //设置非选定结点的背景颜色
        renderer.setBackgroundNonSelectionColor(new Color(220,220,220));
        //设置选中结点的背景色
        renderer.setBackgroundSelectionColor(new Color(140,140,140));
        //设置选中状态下结点的边框颜色
        renderer.setBorderSelectionColor(Color.BLACK);
        //设置处于折叠状态下非叶子结点的图标
        renderer.setClosedIcon(new ImageIcon("swing\\img\\tree\\close.gif"));
        //设置结点文本的字体
        renderer.setFont(new Font("StSong",Font.BOLD,16));
        //设置叶子结点图标
        renderer.setLeafIcon(new ImageIcon("swing\\img\\tree\\leaf.png"));
        //设置处于展开状态下非叶子结点图标
        renderer.setOpenIcon(new ImageIcon("swing\\img\\tree\\open.gif"));
        //设置绘制非选中状态下结点文本颜色
        renderer.setTextNonSelectionColor(new Color(255,0,0));
        //设置选中状态下结点的文本颜色
        renderer.setTextSelectionColor(new Color(0,0,255));


        //把结点绘制器设置给树对象
        tree.setCellRenderer(renderer);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }


    public static void main(String[] args) {
        new ChangeAllCellRender().init();
    }

}