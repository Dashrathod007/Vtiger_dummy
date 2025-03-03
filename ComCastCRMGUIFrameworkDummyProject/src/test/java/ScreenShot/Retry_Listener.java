package ScreenShot;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.copy.BaseClass;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)
public class Retry_Listener extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListenersImp.class)
	public void ActivateSim() {
		System.out.println("Execute the createInvoiceTest");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	
}
