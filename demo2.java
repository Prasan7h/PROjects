package onlinebanking1;

import daopack.dao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class demo2 extends JFrame implements ActionListener {
    JButton depositButton, withdrawButton, checkBalanceButton, exitButton;
    JLabel amountLabel, greetingLabel;
    JTextField amountField;
    JTable table;
    DefaultTableModel model;

    demo2() {
        setTitle("Piggy bank");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table setup
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Buttons setup
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        checkBalanceButton = new JButton("Check Balance");
        exitButton = new JButton("Exit");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Label and Text field setup
        amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);

        // Greeting Label setup
        greetingLabel = new JLabel();
        updateGreetingLabel(); 

        // Layout setup
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(greetingLabel);
        topPanel.add(Box.createVerticalStrut(10)); // Add some vertical space
        topPanel.add(amountLabel);
        topPanel.add(amountField);
      

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(checkBalanceButton);
        buttonPanel.add(exitButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
      //S  mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    // Method to update greeting label with username
    private void updateGreetingLabel() {
        String username = dao.getUsername(Demo1.acc);
        greetingLabel.setText("Hello, " + username + "! Happy banking!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String s=e.getActionCommand();
        if (e.getSource().equals(depositButton)) {
            String amountStr = amountField.getText();
            double amount = Double.parseDouble(amountStr);
            boolean depositSuccess = dao.depositAmount(Demo1.acc, amount);
           
            
        } else if (e.getSource().equals(withdrawButton)) {
            String amountStr = amountField.getText();
            double amount = Double.parseDouble(amountStr);
            boolean withdrawSuccess = dao.withdrawAmount(Demo1.acc, amount);
            if (withdrawSuccess) {
                JOptionPane.showMessageDialog(this, "Withdrawal successful");
            } else {
                double balance = dao.getCurrentBalance(Demo1.acc);
                JOptionPane.showMessageDialog(this, "Sorry, your balance is " + balance + ". Please enter a lesser amount.");
            }
            amountField.setText(""); // Clear the amount field after withdrawal
        } else if (e.getSource().equals(checkBalanceButton)) {
            double balance = dao.getCurrentBalance(Demo1.acc);
            JOptionPane.showMessageDialog(this, "Your balance is: " + balance);
        } else if (e.getSource() == exitButton) {
            dispose(); // Close the JFrame
        }
     
    }

    public static void main(String[] args) {
        new Demo1();
    }
}
