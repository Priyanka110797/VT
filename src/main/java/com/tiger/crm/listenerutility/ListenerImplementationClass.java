package com.tiger.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tiger.crm.baseclassutility.BaseClassUtilityTest;
import com.tiger.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener,ISuiteListener{

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onStart(ISuite suite) {
	System.out.println("Report configuaration");	//Spark report Config
	String time=new Date().toString().replace(" ", "_").replace(":", "_");
	
	spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
	spark.config().setDocumentTitle("CRM Test Suite Results");
	spark.config().setReportName("CRM Reprot");
	spark.config().setTheme(Theme.DARK);
	
	//add Env information & create test
	report =new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "Windows-10");
	report.setSystemInfo("BROWSER", "CHROME-10");
	
	
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"==START==");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====Started==== ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"==END==");
		test.log(Status.INFO, result.getMethod().getMethodName()+"====Completed==== ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
//		TakesScreenshot ts=(TakesScreenshot)(BaseClassUtilityTest.sdriver);
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./ScreenshotFolder/"+testName+"+"+time+".png");
//		
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		TakesScreenshot ts=(TakesScreenshot)BaseClassUtilityTest.sdriver;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(filePath,testName+" "+time);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====Failed==== ");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	

}
