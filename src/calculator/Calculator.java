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
    JButton addBtn, subBtn, multiBtn, divBtn, negativeBtn;
    JButton decBtn, equalBtn, delBtn, clearBtn;
    JPanel panel;
    
    //font of buttons
    Font myFont = new Font("Ariel", Font.BOLD, 30);
    
    //variables 
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    

    Calculator()
    {
        //visible frame 
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 520);
        frame.setLayout(null);
        
        //creating new text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false); //cannot change text box
        
        //adding buttons - opeartors
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        multiBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equalBtn = new JButton("=");
        negativeBtn = new JButton("(-)");
        delBtn = new JButton("Del");
        clearBtn = new JButton("AC");
        
        //setting buttons to functionBtn array
        functionBtn[0] = addBtn;
        functionBtn[1] = subBtn;
        functionBtn[2] = multiBtn;
        functionBtn[3] = divBtn;
        functionBtn[4] = decBtn;
        functionBtn[5] = equalBtn;
        functionBtn[6] = delBtn;
        functionBtn[7] = clearBtn;
        functionBtn[8] = negativeBtn;
                
        //loop 9 times
        for(int index = 0; index < 9; index++)
        {
            functionBtn[index].addActionListener(this);
            functionBtn[index].setFont(myFont);
            functionBtn[index].setFocusable(false);
        }
        
        //iterate 10 times
        for(int index = 0; index < 10; index++)
        {
            numberBtn[index] = new JButton(String.valueOf(index));
            numberBtn[index].addActionListener(this);
            numberBtn[index].setFont(myFont);
            numberBtn[index].setFocusable(false);
        }
        
        //location of delete and clear button (including size of buttons) -> x, y,width, height
        delBtn.setBounds(150,430,100,50);
        clearBtn.setBounds(250,430,100,50);
        negativeBtn.setBounds(50,430,100,50);
        
        //jpanel
        panel = new JPanel();
        panel.setBounds(50,100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        //adding buttons 1-3
        panel.add(numberBtn[1]);
        panel.add(numberBtn[2]);
        panel.add(numberBtn[3]);
        panel.add(addBtn); 
                
        //adding buttons 4-6
        panel.add(numberBtn[4]);
        panel.add(numberBtn[5]);
        panel.add(numberBtn[6]);
        panel.add(subBtn);
        
        //adding buttons 7-9
        panel.add(numberBtn[7]);
        panel.add(numberBtn[8]);
        panel.add(numberBtn[9]);
        panel.add(multiBtn);
        panel.add(decBtn);
        panel.add(numberBtn[0]);
        panel.add(equalBtn);
        panel.add(divBtn);

        //adding components to frame
        frame.add(panel);
        frame.add(delBtn);
        frame.add(clearBtn);
        frame.add(textField); 
        frame.add(negativeBtn);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
    }
    
    //action event 
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //functionality 
        for(int index = 0; index < 10; index++)
        {
            if(e.getSource() == numberBtn[index])
            {
                //enables numbers to appear on text field when pressing on buttons
                textField.setText(textField.getText().concat(String.valueOf(index)));
            }
        }
        //enables user to click on operators 
            if(e.getSource() == decBtn)
            {
                //enables user to use decimal button 
                textField.setText(textField.getText().concat(String.valueOf(".")));
            }
            if(e.getSource() == addBtn)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if(e.getSource() == subBtn)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if(e.getSource() == multiBtn)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if(e.getSource() == divBtn)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if(e.getSource() == equalBtn)
            {
                num2 = Double.parseDouble(textField.getText());
               
                //switch case is used to determine to help calculator detect which operator is used and how to correctly calculate numbers 
                switch(operator)
                {
                    case'+':
                        result = num1+num2;
                        break;
                        
                    case '-':
                        result = num1- num2;
                        break;
                        
                    case '/':
                        result = num1 / num2;
                        break;
                        
                    case '*':
                        result = num1 * num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            //clear button
            if(e.getSource() == clearBtn)
            {
              textField.setText("");
            }
            //delete button
            if(e.getSource() == delBtn)
            {
                String delete = textField.getText();
                textField.setText("");
                
                for(int index =0; index < delete.length() - 1; index++)
                {
                    textField.setText(textField.getText() + delete.charAt(index));
                }
            }
            //negative button
            if(e.getSource() == negativeBtn)
            {
                //retrive the value that is in the box text
                double number = Double.parseDouble(textField.getText());
                number*= -1;
                //set text to number value
                textField.setText(String.valueOf(number));
            }
    }
}
