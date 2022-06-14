package com.one.basic;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JToolBarTest {

    JFrame jf = new JFrame("测试工具条");
    JTextArea jta = new JTextArea(6,35);

    //声明工具条相关内容

    JToolBar jToolBar = new JToolBar("播放工具条",SwingConstants.HORIZONTAL);

    //创建3个Action对象
    //传递的参数，name和icon，最终在添加到工具条中时，会被拿出来作为按钮的名称和图标
    Action pre = new AbstractAction("上一曲",new ImageIcon("swing\\img\\component\\pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("上一曲.\n");
        }
    };

    Action pause = new AbstractAction("暂停",new ImageIcon("swing\\img\\component\\pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("暂停播放.\n");
        }
    };

    Action next = new AbstractAction("下一曲",new ImageIcon("swing\\img\\component\\next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("下一曲.\n");
        }
    };


    public void init(){
        //组装视图

        //通过Action对象来创建JButton

        JButton preBtn = new JButton(pre);
        JButton pauseBtn = new JButton(pause);
        JButton nextBtn = new JButton(next);


        /*jToolBar.add(pre);
        jToolBar.addSeparator();
        jToolBar.add(pause);
        jToolBar.addSeparator();
        jToolBar.add(next);*/

        jToolBar.add(preBtn);
        jToolBar.addSeparator();
        jToolBar.add(pauseBtn);
        jToolBar.addSeparator();
        jToolBar.add(nextBtn);

        //让工具条可以拖动
        jToolBar.setFloatable(true);

        jf.add(jToolBar,BorderLayout.NORTH);

        //文本框默认不支持滚动条

        //把一个组件设置到JScrollPane中，那么该组件就支持滚动条了

        JScrollPane jScrollPane = new JScrollPane(jta);


        jf.add(jScrollPane);



        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JToolBarTest().init();
    }
}