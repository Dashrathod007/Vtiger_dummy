package ScreenShot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseClassUtility.copy.BaseClass;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("Execute the createInvoiceTest");
		String title=driver.getTitle();
		System.out.println(title);
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
@Test
public void createInvoiceWithConatctsTest() {
	System.out.println("Execute the createInvoiceWithConatctsTest");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
	
}
}
