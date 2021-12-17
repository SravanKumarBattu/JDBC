import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Connect
{
	public static void main()
	{
		try	
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306/database1","username","password");
			
			Statement stmnt = con.createStatement();
			
			//table create
			String q1="Create Table student(id integer,name varchar2(10))";
			
			stmnt.executeQuery(q1);
			
			System.out.println("Created");
			
			
			//insert values
			
			String q2="insert into student values(1,'s')";
			
			stmnt.executeUpdate(q2);
			
			//retrival
			
			String q3= "Select id from students";
			
			ResultSet rs1= stmnt.executeQuery(q3);
			
			while(rs1.next())
			{
				System.out.println("Id"+rs1.getInt("id"));
				System.out.println("NAME:"+rs1.getString("name"));
			}
			
			//deletion
			String q4="delete from student where id=1 ";
			stmnt.executeUpdate(q4);
			
			//retrival
			String q5="Select id,name from students";
			
			ResultSet rs2= stmnt.executeQuery(q5);
			
			while(rs2.next())
			{
				System.out.println("ID"+rs2.getInt("id"));
				System.out.println("Name"+rs2.getString("name"));
			}
			 
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			}
			
	}
}
