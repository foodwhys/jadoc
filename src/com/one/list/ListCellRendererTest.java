package com.one.list;


import javax.swing.*;
import java.awt.*;

public class ListCellRendererTest {

    private JFrame mainWin = new JFrame("好友列表");

    private String[] friends = {
            "李清照",
            "苏格拉底",
            "李白",
            "弄玉",
            "虎头"
    };

    //定义一个JList对象
    JList friendsList = new JList(friends);

    public void init() {
        //组装视图
        //给JList设置ListCellRenderer对象,指定列表项绘制的组件
        friendsList.setCellRenderer(new MyRenderer());

        mainWin.add(friendsList);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }

    private class MyRenderer extends JPanel implements ListCellRenderer{
        private String name;
        private ImageIcon icon;

        //记录背景色
        private Color backGround;
        //记录前景色：文字的颜色
        private Color forceGround;


        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            //重置成员变量的值
           this.name = value.toString();
           this.icon = new ImageIcon("swing\\img\\list\\"+name+".gif");

           this.backGround = isSelected? list.getSelectionBackground() : list.getBackground();
           this.forceGround = isSelected? list.getSelectionForeground() : list.getForeground();

            return this;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(60,80);
        }

        //绘制列表项的内容
        @Override
        public void paint(Graphics g) {
            int imageWidth = icon.getImage().getWidth(null);
            int imageHeight = icon.getImage().getHeight(null);

            //填充背景矩形
            g.setColor(backGround);
            g.fillRect(0,0,getWidth(),getHeight());


            //绘制头像
            g.drawImage(icon.getImage(),this.getWidth()/2 -imageWidth/2 ,10,null);

            //绘制昵称
            g.setColor(forceGround);
            g.setFont(new Font("StSong",Font.BOLD,18));
            g.drawString(this.name,this.getWidth()/2 - this.name.length()*20/2,imageHeight+30);

        }
    }


    public static void main(String[] args) {
        new ListCellRendererTest().init();
    }


}