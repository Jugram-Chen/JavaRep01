import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Donglin Chen
 */
public class MyCalculator extends JFrame{
    JTextField t=new JTextField("");
    double ans;
    public MyCalculator(){
        super("Stevens Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,800);
        Container c=this.getContentPane();
        c.setBackground(Color.YELLOW);
        JButton bb=new JButton("ReStart");
        c.add(bb,BorderLayout.SOUTH);
        //JTextField t=new JTextField("whatever");
        c.add(t,BorderLayout.NORTH);
        JPanel p= new JPanel();
        GridLayout g=new GridLayout(4,4,10,10);
        p.setLayout(g);
        JButton b1=new JButton("1");
        p.add(b1);
        JButton b2=new JButton("2");
        p.add(b2);
        JButton b3=new JButton("3");
        p.add(b3);
        JButton b4=new JButton("4");
        p.add(b4);
        JButton b5=new JButton("5");
        p.add(b5);
        JButton b6=new JButton("6");
        p.add(b6);
        JButton b7=new JButton("7");
        p.add(b7);
        JButton b8=new JButton("8");
        p.add(b8);
        JButton b9=new JButton("9");
        p.add(b9);
        JButton b0=new JButton("0");
        p.add(b0);
        JButton b_dot=new JButton(".");
        p.add(b_dot);
        JButton b_add=new JButton("+");
        p.add(b_add);
        JButton b_sub=new JButton("-");
        p.add(b_sub);
        JButton b_mul=new JButton("*");
        p.add(b_mul);
        JButton b_div=new JButton("/");
        p.add(b_div);
        JButton b_eql=new JButton("=");
        p.add(b_eql);
        c.add(p,BorderLayout.CENTER);

        b1.addActionListener(new MyButton1Listener());
        b2.addActionListener(new MyButton2Listener());
        b3.addActionListener(new MyButton3Listener());
        b4.addActionListener(new MyButton4Listener());
        b5.addActionListener(new MyButton5Listener());
        b6.addActionListener(new MyButton6Listener());
        b7.addActionListener(new MyButton7Listener());
        b8.addActionListener(new MyButton8Listener());
        b9.addActionListener(new MyButton9Listener());
        b0.addActionListener(new MyButton0Listener());
        bb.addActionListener(new MyButtonREListener());
        b_add.addActionListener(new MyButtonADDListener());
        b_sub.addActionListener(new MyButtonSUBListener());
        b_mul.addActionListener(new MyButtonMULListener());
        b_div.addActionListener(new MyButtonDIVListener());
        b_eql.addActionListener(new MyButtonEQLListener());

        setVisible(true);
    }

    class MyButton1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello1");
            //int bi1=1;
            String bs1="1";
            t.setText(t.getText() + bs1);
            //ans=ans+1;
        }
    }

    class MyButton2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello2");
            t.setText(t.getText() + "2");
        }
    }

    class MyButton3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello3");
            t.setText(t.getText() + "3");
        }
    }

    class MyButton4Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello4");
            t.setText(t.getText() + "4");
        }
    }

    class MyButton5Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello5");
            t.setText(t.getText() + "5");
        }
    }

    class MyButton6Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello6");
            t.setText(t.getText() + "6");
        }
    }

    class MyButton7Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello7");
            t.setText(t.getText() + "7");
        }
    }

    class MyButton8Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello8");
            t.setText(t.getText() + "8");
        }
    }

    class MyButton9Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello9");
            t.setText(t.getText() + "9");
        }
    }

    class MyButton0Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello0");
            t.setText(t.getText() + "0");
        }
    }

    class MyButtonREListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("helloRE");
            t.setText("");
        }
    }

    class MyButtonADDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("helloADD");
            t.setText(t.getText() + "+");
        }
    }

    class MyButtonSUBListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("helloSUB");
            t.setText(t.getText() + "-");
        }
    }

    class MyButtonMULListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("helloMUL");
            t.setText(t.getText() + "*");
        }
    }

    class MyButtonDIVListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("helloDIV");
            t.setText(t.getText() + "/");
        }
    }

    class MyButtonEQLListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("helloEQL");
            String bseql="=";
            String expression=t.getText();
            ExpressionCalculate c=new ExpressionCalculate();
            String ans=c.stringToCalculate(expression);
            t.setText(t.getText() + bseql+ans);

        }
    }
    public static void main(String[] args) {
        new MyCalculator();
    }

}
class ExpressionCalculate {
    public String stringToCalculate(String a){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        String expression = a;
        try {
            String result = String.valueOf(scriptEngine.eval(expression));
            //System.out.println(result);
            return result;
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return "1";
    }
}