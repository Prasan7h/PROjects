package daopack;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beanpack.bean;
import onlinebanking1.ID;

public class dao {

		    public static Connection con=getCon();
		    public static PreparedStatement ps;
		    public static ResultSet rs;
		    public static Connection getCon()
		    {
		        try
		        {
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   
		     con=DriverManager.getConnection("jdbc:sqlserver://192.168.134.164:1433;databaseName=db177;encrypt=true;trustServerCertificate=true","user177","db177");
		       System.out.println("hello bro");
		        }
		        catch(ClassNotFoundException|SQLException cnf)
		        {
		            System.out.println(cnf);
		        }
		        return con;
		    }  
		    
		    public static boolean checkCredentials(String accno, int pin) {
		        String query = "SELECT * FROM bank WHERE accno = ? AND pin = ?";
		        try {
		            ps = con.prepareStatement(query);
		            ps.setString(1, accno);
		            ps.setInt(2, pin);
		            rs = ps.executeQuery();
		            return rs.next(); // If ResultSet has at least one row, credentials are valid
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false; // Return false in case of exception
		        } finally {
		            // Close resources
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		    
		    public static double getCurrentBalance(String accno) {
		        double balance = 0.0;
		        String query = "SELECT balance FROM bank WHERE accno = ?";
		        try {
		            ps = con.prepareStatement(query);
		            ps.setString(1, accno);
		            rs = ps.executeQuery();
		            if (rs.next()) {
		                balance = rs.getDouble("balance");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        return balance;
		    }
		    public static boolean depositAmount(String accno, double amount) {
		        String query = "SELECT name FROM bank WHERE accno = ?";
		        String username = null;
		        try {
		            // Retrieve username associated with the account number
		            ps = con.prepareStatement(query);
		            ps.setString(1, accno);
		            rs = ps.executeQuery();
		            if (rs.next()) {
		                username = rs.getString("name");
		            } else {
		                // Account not found
		                return false;
		            }
		            
		            // Update balance in the bank table
		            query = "UPDATE bank SET balance = balance + ? WHERE accno = ?";
		            ps = con.prepareStatement(query);
		            ps.setDouble(1, amount);
		            ps.setString(2, accno);
		            int rowsAffected = ps.executeUpdate();
		            if (rowsAffected > 0) {
		                // Deposit successful
		                JOptionPane.showMessageDialog(null, "Hi, " + username + ". Deposit successful");
		                return true;
		            } else {
		                // Deposit failed
		                return false;
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false; // Return false in case of exception or failure
		        } finally {
		            // Close resources
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    
		    public static boolean withdrawAmount(String accno, double amount) {
		        String query = "SELECT name, balance FROM bank WHERE accno = ?";
		        String username = null;
		        double balance = 0.0;
		        try {
		            // Retrieve username and balance associated with the account number
		            ps = con.prepareStatement(query);
		            ps.setString(1, accno);
		            rs = ps.executeQuery();
		            if (rs.next()) {
		                username = rs.getString("name");
		                balance = rs.getDouble("balance");
		            } else {
		                // Account not found
		                return false;
		            }
		            
		            // Check if the withdrawal amount is less than or equal to the balance
		            if (amount <= balance) {
		                // Update balance in the bank table
		                query = "UPDATE bank SET balance = balance - ? WHERE accno = ?";
		                ps = con.prepareStatement(query);
		                ps.setDouble(1, amount);
		                ps.setString(2, accno);
		                int rowsAffected = ps.executeUpdate();
		                if (rowsAffected > 0) {
		                    // Withdrawal successful
		                    JOptionPane.showMessageDialog(null, "Hi, " + username + ". Withdrawal successful");
		                    return true;
		                } else {
		                    // Withdrawal failed
		                    return false;
		                }
		            } else {
		                // Insufficient balance
		                JOptionPane.showMessageDialog(null, "Sorry, your balance is " + balance + ". Please enter a lesser amount.");
		                return false;
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return false; // Return false in case of exception or failure
		        } finally {
		            // Close resources
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		    
		    public static String getUsername(String accno) {
		        String username = null;
		        String query = "SELECT name FROM bank WHERE accno = ?";
		        try {
		            ps = con.prepareStatement(query);
		            ps.setString(1, accno);
		            rs = ps.executeQuery();
		            if (rs.next()) {
		                username = rs.getString("name");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        return username;
		    }
		    public static int addUser1(ID e) {
		    	int i=0;
		    	try
		    	{
		    		ps=con.prepareStatement("insert into Bank values (?,?,?,?)");
		    		ps.setString(1, e.getAccno());
		    		ps.setInt(2,e.getPin() );
		    		ps.setString(3,e.getName());
		    		ps.setInt(4, e.getBalance());
		    		
		    		 i=ps.executeUpdate(); // whenever insertion occurs it return 1;
		        }
		        catch(SQLException sql)
		        {
		            
		        }
		        return i;
		    	}




		    
		    
}
		
