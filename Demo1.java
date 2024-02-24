package onlinebanking1;

import javax.swing.*;

import daopack.dao;

import java.awt.*;
import java.awt.event.*;

public class Demo1 extends JFrame implements ActionListener {
   public static JButton jb1, jb2,jb3, exitButton; // Added exitButton
    JLabel jl1, jl2, welcomeLabel; // Added welcomeLabel
  public  static JTextField jtf1;
public	static JTextField jtf2;
public static String acc;

    Demo1() {
        setTitle("Piggy bank");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set 
      //  setUndecorated(true); // Remove window decorations (e.g., title bar)
        setLayout(null); // Use null layout for absolute positioning

        welcomeLabel = new JLabel("Piggy Bank Welcomes You");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBounds(500, 50, 400, 30); // Set bounds for welcomeLabel
        
        jl1 = new JLabel("Enter your AC.NO");
        jl2 = new JLabel("Enter password" );
        jtf1 = new JTextField();
       
        jtf2 = new JPasswordField();
        jb1 = new JButton("SUBMIT");
        jb2 = new JButton("RESET");
        jb3 = new JButton("New User");
        exitButton = new JButton("EXIT"); // Initialize exitButton
        
        // Set bounds for components
        jl1.setBounds(500, 100, 150, 30);
        jtf1.setBounds(650, 100, 150, 30);
        jl2.setBounds(500, 150, 150, 30);
        jtf2.setBounds(650, 150, 150, 30);
        jb1.setBounds(500, 200, 100, 30);
        jb2.setBounds(620, 200, 100, 30);
        jb3.setBounds(590, 250, 100, 30);
        exitButton.setBounds(740, 200, 100, 30); // Set bounds for exitButton
        
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        exitButton.addActionListener(this); // Add ActionListener for exitButton

        // Add components to the frame
        add(welcomeLabel);
        add(jl1);
        add(jtf1);
        add(jl2);
        add(jtf2);
        add(jb1);
        add(jb2);
        add(jb3);
        add(exitButton); // Add exitButton

        setVisible(true);
    }
    
   
   

  

	@Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("SUBMIT")) {
        	//System.out.println("Under Submit");
            acc=jtf1.getText().toString();

        	String accountNumber = jtf1.getText();
             int pin = Integer.parseInt(jtf2.getText());
           //  new demo2();
             // Check credentials using DAO method
             boolean isValidCredentials = dao.checkCredentials(accountNumber, pin);
             System.out.println(isValidCredentials);
             if (isValidCredentials==true) {
                 // Move to the next window (assuming you have a method to do so)
                 // For example:
            	//System.out.println(jtf1.getText());
            	// System.out.println(jtf1.getText());
            	 new demo2();
             } else {
                 // Display invalid credentials message
                 JOptionPane.showMessageDialog(this, "Invalid credentials!");
                 // create a user reg window
             }
            
        } else if (s.equals("RESET")) {
            // Handle reset button actions
        	   jtf1.setText(""); // Clear account number field
               jtf2.setText(""); // Clear PIN field
        } else if (s.equals("EXIT")) { // Check if the exitButton is clicked
            dispose(); // Close the JFrame
        }
        else if (s.equals("New User")) {
        	  
               	new demo3();
               	
               }
        
        }
    
}
