import com.revature.App;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {

	@Test
	public void DepositTest(){
		App a = new App("FirstName", "fName", "fName", "fName", "fName", 0);
		int expectedSum = 5;
		a.Deposit();
		
	}
	/*
	@Test
	public WithdrawTest{
		
	}
	
	@Test
	public TransferTest{
		
	}
	
	@Test
	public JointAccountTest{
		
	}
	
	@Test
	public CancelTest{
		
	}*/
}
