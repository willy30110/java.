package com.hsy.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.hsy.game.tt12;
import com.hsy.game.t1;

public class menu {

  JFrame frame;

  public menu() {

    ImageIcon img = new ImageIcon("aimlab.png");
    JLabel lab = new JLabel(img);
    lab.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

    JButton button = new JButton("SpiderShot");
    // container.add(button);
    button.setBounds(10, 10, 100, 100);
    button.setVisible(true);
    button.addActionListener(new Action1());
    JButton button2 = new JButton("ReflexShot");

    button2.setBounds(120, 10, 100, 100);
    button2.setVisible(true);

    button2.addActionListener(new Action2());

    JFrame frame = new JFrame("Final Project");
    frame.setLayout(null);
    Container container = frame.getLayeredPane();
    container.add(button);
    container.add(button2);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setBounds(250, 100, img.getIconWidth(), img.getIconHeight());
    frame.getContentPane().add(lab);
    // frame.add(button);
    // frame.add(button2);
    container.setVisible(true);
    
  }

  public static void main(String[] args) {
    menu me = new menu();
  }

  static class Action1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      tt12 newone = new tt12();
    }
  }

  static class Action2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      t1 t = new t1();
    }
  }
}