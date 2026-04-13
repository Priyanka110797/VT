package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SqlSample {

	public static void main(String[] args) throws SQLException {
		// Step 1:load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		
		//Step 2:connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		System.out.println("======Done=============");
		
		//Step 3:create SQL statement
		Statement stat=conn.createStatement();
		
		//Step 4:execute select query and get result
		ResultSet resultset=stat.executeQuery("select * from project");
		while(resultset.next()) {
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"
					+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getString(6));
		}
		//Step 5:close the connection
		conn.close();
		
		

	}

}
