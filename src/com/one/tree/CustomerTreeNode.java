package com.one.tree;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class CustomerTreeNode {

    JFrame jf = new JFrame("定制树的结点");

    JTree tree;

    //定义几个初始结点

    DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
    DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode suge = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode libai = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode nongyu = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode hutou = new DefaultMutableTreeNode("虎头");

    public void init() {
        //组装视图
        friends.add(qingzhao);
        friends.add(suge);
        friends.add(libai);
        friends.add(nongyu);
        friends.add(hutou);

        tree = new JTree(friends);

        //TODO 设置结点绘制器
        MyRenderer renderer = new MyRenderer();
        tree.setCellRenderer(renderer);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    //自定义类，实现TreeCellRenderer接口，绘制组件
    private class MyRenderer extends JPanel implements TreeCellRenderer{
        private ImageIcon icon;
        private String name;
        private Color background;
        private Color foreground;

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //给成员变量设置值
            this.icon = new ImageIcon("swing\\img\\tree\\"+value.toString()+".gif");
            this.name = value.toString();

            this.background = hasFocus? new Color(144,200,225) : new Color(255,255,255);
            this.foreground = hasFocus? new Color(255,255,3) : new Color(0,0,0);

            return this;
        }

        //通过重写getPreferenceSize方法，指定当前Jpanel组件的大小

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(80,80);
        }

        @Override
        public void paint(Graphics g) {
            //绘制组件内容

            int iconWidth = this.icon.getIconWidth();
            int iconHeight = this.icon.getIconHeight();

            //填充背景
            g.setColor(background);
            g.fillRect(0,0,getWidth(),getHeight());

            //绘制头像
            g.drawImage(this.icon.getImage(),getWidth()/2 - iconWidth/2,10,null);

            //绘制昵称
            g.setColor(foreground);

            g.setFont(new Font("StSong",Font.BOLD,18));
            g.drawString(this.name,getWidth()/2-this.name.length()*20/2,iconHeight+30);

        }
    }

    public static void main(String[] args) {
        new CustomerTreeNode().init();
    }


}