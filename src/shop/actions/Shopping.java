package shop.actions;

import shop.domain.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import shop.db.*;
import shop.domain.Product;


/**
 * Created by lukas on 03.11.2017.
 */
public class Shopping extends JFrame {


    int x, p;
    float cost;

    String list[] = {"Product List", "Apple iPhone", "Apple iPad", "Microsoft Surface", "Xbox", "Microsoft Lumia", "Lenowo Yoga", "Samsung Galaxy", "Sony Cyber-shot", "Sony Playstation", "Sony Xperia", "\nWyczyść Koszyk"};
    JComboBox<String> box = new JComboBox<String>(list);
    JPanel upperPanel = new JPanel(new BorderLayout());
    JTextField heading = new JTextField("\t\t   Basket");
    JPanel lowerPanel = new JPanel(new BorderLayout());
    JTextArea costBox = new JTextArea();
    JTextArea textarea = new JTextArea();
    JButton payment = new JButton("Pay");

    Shopping() {
        cost = 0;
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 10));
        setTitle("Best shop...");

        box.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                x = box.getSelectedIndex();

                switch (x)

                {
                    case 0:
                        break;
                    case 1:
                        cost += 1000;
                        textarea.append("\n\tApple Iphone\t:   1000");
                        break;
                    case 2:
                        cost += 2500;
                        textarea.append("\n\tApple IPad\t:   2500");
                        break;
                    case 3:
                        cost += 2200;
                        textarea.append("\n\tMicrosoft Surface\t:   2200");
                        break;
                    case 4:
                        cost += 800;
                        textarea.append("\n\tXbox\t:   800");
                        break;
                    case 5:
                        cost += 600;
                        textarea.append("\n\tMicrosoft Lumia\t:   600");
                        break;
                    case 6:
                        cost += 450;
                        textarea.append("\n\tLenovo Yoga\t:   450");
                        break;
                    case 8:
                        cost += 200;
                        textarea.append("\n\tSony Cyber-shot\t:   200");
                        break;
                    case 9:
                        cost += 950;
                        textarea.append("\n\tSony Playstation\t:   950");
                        break;
                    case 7:
                        cost += 300;
                        textarea.append("\n\tSamsung Galaxy\t:   300");
                        break;
                    case 10:
                        cost += 550;
                        textarea.append("\n\tSony Xperia\t:   550");
                        break;
                    case 11:
                        cost = 0;
                        textarea.setText("");
                }
                costBox.setText("\tNet\t\t:  " + cost + "\n\tVAT 23%\t\t:  " + (cost * 0.23) + "\n\tFinal Price\t\t:  " + (cost + (cost * 0.23)));
            }


        });


        upperPanel.add(box, BorderLayout.NORTH);
        Font f = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 19);
        heading.setFont(f);
        heading.setEditable(false);
        upperPanel.add(heading, BorderLayout.CENTER);
        add(upperPanel, BorderLayout.NORTH);
        textarea.setEditable(false);
        add(textarea, BorderLayout.CENTER);
        costBox.setEditable(false);
        lowerPanel.add(costBox, BorderLayout.NORTH);

        payment.addActionListener(new ActionListener() {

                                      public void actionPerformed(ActionEvent e) {
                                          p = JOptionPane.showConfirmDialog(null, "Confirm your Payment of " + (cost + (cost * 0.23)) + " PLN ?", "Payment Gateway", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                                          if (p == JOptionPane.YES_OPTION) {
                                              cost = 0;
                                              textarea.setText("");


                                              JOptionPane.showMessageDialog(null, "Payment Successful");
                                          } else if (p == JOptionPane.NO_OPTION) {

                                              JOptionPane.showMessageDialog(null, "Payment Aborted!");
                                          }
                                      }

                                  }

        );


        lowerPanel.add(payment, BorderLayout.SOUTH);
        payment.setBackground(Color.GREEN);
        add(lowerPanel, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)

    {
        new Shopping();
    }

}
