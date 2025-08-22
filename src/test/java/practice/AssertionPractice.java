package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice
{
	
	/**
	 * This method is used for the hardAssert
	 */
@Test
public void sampletest()
{

	System.out.println("step 1");
	
	System.out.println("step 2");
	
	System.out.println("step 3");
	Assert.assertEquals(1, 1);
	
	
	System.out.println("step 4");
	
	Assert.assertEquals(1, 1);
	
	System.out.println("step 5");
	

	
	   
}

@Test
public void sampletestSoft()
{

	SoftAssert sa= new SoftAssert();
	System.out.println("step 1");
	
	System.out.println("step 2");
	
	System.out.println("step 3");
	sa.assertEquals(1, 1);
	
	
	System.out.println("step 4");
	
	sa.assertEquals("a", "b");
	
	System.out.println("step 5");
//in the above code if it fails or pass it will execute if u want to know the errors then u have to use the assertAll() method
	sa.assertAll();
	
	

	
	   
}

}





