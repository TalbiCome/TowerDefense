package org.example;

import javax.swing.JFrame;
public class TestJframe extends JFrame{

    private TestJPanel jpanel;

    public TestJframe(){
        setSize(640,640);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jpanel = new TestJPanel();
        add(jpanel);


    }

    public static void main(String[] args){
        TestJframe jframe = new TestJframe();

    }

}
