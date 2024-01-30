/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Yuna
 */


public class Calculator implements ActionListener{
    
    JFrame frame;
    JTextField textField;
    JButton[] numberBtn = new JButton[10];
    JButton[] functionBtn = new JButton[10];
    JButton addBtn, subBtn, multiBtn, divBtn;
    JButton decBtn, equalBtn, delBtn, clearBtn;
    JPanel panel;
    
    //font of buttons
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    char operator;
    

    Calculator()
    {
        
    }
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
    }
}
