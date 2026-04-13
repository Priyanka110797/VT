package Practice_DatadrivenTesting;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
    Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
	Statement stat=conn.createStatement();
	
	int result=stat.executeUpdate("insert into project values('TY_PROJ_2200','Anushka','23/01/2026','FB_Project','created','02');");
	System.out.println(result);
	
	conn.close();
	
	

	}

}
