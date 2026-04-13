package Practice_DatadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUntiTestCheckProjectInBackend {

	@Test
	public void projectCheckTest() throws SQLException {
		String expectedProjectName="FB_1";
		boolean flag=false;
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
		Statement stat=conn.createStatement();
		ResultSet result=stat.executeQuery("select * from project;");
		while(result.next()) {
			String actualProjectName=result.getString(4);
			if(actualProjectName.equals(expectedProjectName)) {
				flag=true;
				System.out.println(expectedProjectName+"  is  available====PASS");
			}
		}
		if(flag==false) {
			System.out.println(expectedProjectName+"  is not available====FAIL");
			Assert.fail();
		}
		
		conn.close();
		
	}
}
