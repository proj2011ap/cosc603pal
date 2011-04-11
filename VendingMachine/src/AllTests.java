import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	/* Test suite runs all the tests together, so that each test class
	 *  does not need to test separately 
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(VendingMachineItemTest.class);
		suite.addTestSuite(VendingMachineTest.class);

		//$JUnit-END$
		return suite;
	}
}