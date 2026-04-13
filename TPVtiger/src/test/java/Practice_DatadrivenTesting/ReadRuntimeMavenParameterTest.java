package Practice_DatadrivenTesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {

	@Test
	public void runtimeParameterTest() {
		String url=System.getProperty("url");
		System.out.println("Environment Data ======> URL====>"+url);
	}
}
