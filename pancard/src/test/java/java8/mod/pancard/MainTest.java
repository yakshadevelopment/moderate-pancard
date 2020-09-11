package java8.mod.pancard;

import static org.junit.Assert.*;

import org.junit.Test;
import static java8.mod.pancard.TestUtils.*
;public class MainTest {

	@Test
	public void testInputValidation() throws Exception {
      yakshaAssert(currentTest(),Main.inputValidation("ATR724S3P5")?"true":"false",businessTestFile);
	  yakshaAssert(currentTest(),Main.inputValidation("ATR28SP5")?"true":"false",businessTestFile);
	  yakshaAssert(currentTest(),Main.inputValidation("TAKYNMOPQE")?"true":"false",businessTestFile);
	  yakshaAssert(currentTest(),Main.inputValidation("5712963210")?"true":"false",businessTestFile);
	  yakshaAssert(currentTest(),Main.inputValidation("ATR2#8SP57")?"true":"false",businessTestFile);
	}

	@Test
	public void testArrangeAlphanumerics() throws Exception {
		yakshaAssert(currentTest(), Main.arrangeAlphanumerics("ATR724S3P5").equals("23457TSRPA")?"true":"false",businessTestFile);
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }


}
