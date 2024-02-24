package onlinebanking1;
import javax.swing.*;
 
import daopack.*;
import onlinebanking1.Demo1;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class demo3 extends JFrame implements ActionListener{
	
	JButton jb1,exitButton; // Added exitButton
    JLabel jl1, jl2,jl3,jl4, newuserlabel; // Added welcomeLabel
    static JTextField jtf1;
	static JTextField jtf2;
	static JTextField jtf3;
	static JTextField jtf4;
	static String str;
	static String str2;
	JFrame new1;
	public String accno,name;
	public int pin,amt;
	public demo3(){
		new1=new JFrame();
		setTitle("Piggy bank");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set
        setUndecorated(false); // Remove window decorations (e.g., title bar)
        setLayout(null); // Use null layout for absolute positioning
 
       newuserlabel = new JLabel("Piggy Bank Welcomes You");
        newuserlabel.setFont(new Font("Arial", Font.BOLD, 20));
        newuserlabel.setBounds(500, 50, 400, 30);
        // Set bounds for welcomeLabel
        jl1=new JLabel("Enter your Name ");
        jl2 = new JLabel("Enter your AC.NO");
        jl3 = new JLabel("Set your PINNO." );
        jl4=new JLabel("Enter Amount");
        jtf1 = new JTextField();
        jtf2=new JTextField();
        jtf3 = new JPasswordField();
        jtf4=new JTextField();
        jb1=new JButton("Submit");
      newuserlabel.setBounds(500, 50, 400, 30);
       jl1.setBounds(500, 100, 150, 30);
        jtf1.setBounds(650, 100, 150, 30);
        jl2.setBounds(500, 150, 150, 30);
        jtf2.setBounds(650, 150, 150, 30);
        jl3.setBounds(500, 200, 100, 30);
        jtf3.setBounds(650, 200, 100, 30);
        jl4.setBounds(500, 300, 100, 30);
        jtf4.setBounds(650, 300, 100, 30);
         jb1.setBounds(650, 400, 100, 30);
//        exitButton.setBounds(740, 200, 100, 30); // Set bounds for exitButton
//        jb3.addActionListener(this);
        jb1.addActionListener(this);
//        jb2.addActionListener(this);
//        exitButton.addActionListener(this); // Add ActionListener for exitButton
//
//        // Add components to the frame
       add(newuserlabel);
        add(jl1);
        add(jtf1);
       add(jl2);
        add(jtf2);
        add(jl3);
        add(jtf3);
        add(jl4);
        add(jtf4);
        add(jb1);
        
        
        setVisible(true);
	}
	public  void addUser() {
	//	demo3 obj=new demo3();
 
		ID l=new ID();
		l.setName(name);
		l.setAccno(accno);
		l.setPin(pin);
		l.setBalance(amt);
		
 
   JOptionPane.showMessageDialog(null,dao.addUser1(l)+" record inserted successfully...");
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if(str.equals("Submit")) {
			name=jtf1.getText();
			accno=jtf2.getText();
			pin=Integer.parseInt(jtf3.getText());
			amt=Integer.parseInt(jtf4.getText());
			System.out.print("executing");
			
			addUser();
			
			
			
		}
		
	}
	public static void main(String[] args) {
		new demo3();
	}
}