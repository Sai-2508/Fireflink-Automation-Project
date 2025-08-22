package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGHelperAttributes 
{
	
	
/**
 * This method is used to execute based on the priority
 * 
 * 	@Test(priority = 3)
 */
//	public void create()
//	{
//		System.out.println("create");
//	}
//	@Test(priority = 1)
//	public void modify()
//	{
//		System.out.println("Modify");
//	}
//
//	@Test(priority = 2)
//	public void delete()
//	{
//		System.out.println("delete");
//	}
	
	
	
	
//	/**
//	 * This method is used to run the methods how many times you want
//	 */
//	
//	
//	@Test(invocationCount = 2)
//	public void create()
//	{
//		System.out.println("create");
//	}
//	@Test(invocationCount = 1)
//	public void modify()
//	{
//		System.out.println("Modify");
//	}
//
//	@Test(invocationCount = 3)
//	public void delete()
//	{
//		System.out.println("delete");
//		}
//	
//	

	
	
	/**
	 * This method is used to run whatever you want if u give false it does not run
	 * By default it is true
	 */
	
	@Test(enabled=true)
	public void create()
	{
		System.out.println("create");
	}
	@Test(enabled=false)
	public void modify()
	{
		System.out.println("Modify");
	}

	@Test(enabled=true)
	public void delete()
	{
		System.out.println("delete");
		}
	

	
	
	
	
	//it is for the dependsonmethods
	
//		@Test
//		public void create()
//		{
//			System.out.println("create");
//		}
//		@Test(dependsOnMethods = "create")
//		public void modify()
//		{
//			System.out.println("Modify");
//		}
//	
//		@Test(dependsOnMethods = "create")
//		public void delete()
//		{
//			System.out.println("delete");
//		}
	
	
	
	
	
	
	
//	
//	/**
//	 * This method is used to provide the multiple data
//	 * @param name
//	 * @param id
//	 */
//	@Test(dataProvider = "customerinfo")
//	public void create(String name,int id)  //customer name ,id
//	{
//		System.out.println(name+"and"+id+"created");
//	}
//	@DataProvider(name="customerinfo")
//	public Object[][] getData()
//	                
//	{
//		Object[][] data= new Object[4][2];
//		                         //4 datasets and 2 colomuns are created
//		data[0][0]="Spiderman";
//		data[0][1]=1;
//		
//		data[1][0]="Robo";
//		data[1][1]=2;
//		
//		data[2][0]="Chitti";
//		data[2][1]=3;
//		
//		data[3][0]="IronMan";
//		data[3][1]=4;
//		
//		
//		
//		return data;
//		
//		
//	}
//	
	
	
	
	
	
	
	
	
	
}
