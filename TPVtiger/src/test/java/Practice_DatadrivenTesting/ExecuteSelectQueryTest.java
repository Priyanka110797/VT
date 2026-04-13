package Practice_DatadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
	
		Connection conn=null;
		
		try {
    //register to database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		
		//connection to database
		conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
		Statement stat=conn.createStatement();
		ResultSet result= stat.executeQuery("select * from project1");
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+
					result.getString(4)+"\t  "+result.getString(5)+"\t  "+result.getString(6)+"\t");
		}
		}
		catch(Exception e) {
			System.out.println("handle the exception");
		}
		finally {
		conn.close();
		System.out.println("=========close the connection===========");
		}

	}

}
