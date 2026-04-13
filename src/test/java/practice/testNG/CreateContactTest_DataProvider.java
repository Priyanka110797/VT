package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_DataProvider {
@Test(dataProvider = "getData")
public void createContactTest(String firstName,String lastName,long phoneNo) {
	System.out.println("FirstName "+firstName+", LastName "+lastName+", PhoneNo "+phoneNo);
}

@DataProvider
public Object[][] getData(){
	Object arr[][]=new Object[3][3];
	arr[0][0]="Taylor";
	arr[0][1]="Swift";
	arr[0][2]=8965231474L;
	
	arr[1][0]="Allen";
	arr[1][1]="Walker";
	arr[1][2]=9874563215L;
	
	arr[2][0]="Selen";
	arr[2][1]="Gomez";
	arr[2][2]=7894563215L;
	return arr;
}
}
