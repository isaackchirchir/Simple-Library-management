
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19j01acs036
 */
public class DBConnection {
     //create the connection string
    String host="jdbc:mysql://localhost:3306/nazlib";
    String user="root";
    String pass="";
    //declare connection object
    Connection conn;
    
    //initialize the connection object
    public Connection getConnection(){ 
        try{
           conn=DriverManager.getConnection(host, user, pass);
           //JOptionPane.showMessageDialog(null,"Connection successfully");
            return conn;
        }
        
        
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
                return null;
        }
    }
public void insertBooks(String studentid,String studentname,String bookid,String booktitle,String dateissue,String returndate){
String q ="INSERT INTO books (studentid,studentname,bookid,booktitle,dateissue,returndate) VALUES (?,?,?,?,?,?)";
int k=0;
try{
PreparedStatement st=getConnection().prepareStatement(q);
st.setString(1,studentid);
st.setString(2,studentname);
st.setString(3,bookid);
st.setString(4,booktitle);
st.setString(5,dateissue);
st.setString(6,returndate);

  if(st.executeUpdate()>k){
         JOptionPane.showMessageDialog(null," successfull");
}
}
catch(SQLException ex)
{
JOptionPane.showMessageDialog(null,ex.getMessage()); 
}
}
 public ResultSet getBookss()
{
    String q="SELECT * FROM books";
 try{
Statement st=getConnection().createStatement();
//create resultset collection
ResultSet rs=st.executeQuery(q);
   return rs;
 }
catch(SQLException x)
{ 
JOptionPane.showMessageDialog(null,x.getMessage());
return null;
}
}
  public void updateBooks(String studentid,String studentname,String bookid,String booktitle,String dateissue,String returndate)
    {
String q="UPDATE books SET studentname=?,bookid=?,booktitle=?,dateissue=?,returndate=? WHERE studentid=?";

try{
    int k=0;
PreparedStatement st=getConnection().prepareStatement(q);
st.setString(1,studentname);
st.setString(2,bookid);
st.setString(3,booktitle);
st.setString(3,dateissue);
st.setString(3,returndate);
if(st.executeUpdate()>k)
{
JOptionPane.showMessageDialog(null,studentid+" reg updated");
}
}
catch(SQLException ex)
{
JOptionPane.showMessageDialog(null,ex.getMessage());
}
}
  public void Books(String studentid)
{
String q="DELETE FROM books WHERE studentid=?";
 int k=0;
try 
{
PreparedStatement st=getConnection().prepareStatement(q);
st.setString(1,studentid);
if(st.executeUpdate()>k)
{
JOptionPane.showMessageDialog(null,studentid+" book issued");
}
}
catch(SQLException ex)
{
JOptionPane.showMessageDialog(null,ex.getMessage());
}
}

    void deleteBooks(String studentid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }

    
    



