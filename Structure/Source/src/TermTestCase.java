import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>This class consists exclusively of test methods that tests Term class methods.</p>
 * @author Alexey Hlukhov
 * @version 1.0
 * @see Term
 */

public class TermTestCase {

	private String name, transcription, description; //testingTerm fields
	private Term testingTerm; //object of Term for testing Term fields
	
	/**
	 * <p>Prepares testingTerm field for testing before each test method launch.</p>
	 * @since 1.0
	 */
	@Before
	public void setUp() {
		
		this.name = "termName";
		this.transcription = "transcriptionN";
		this.description = "descriptionN";
		
		testingTerm = new Term(name, transcription, description);
	}
	
	/**
	 * <p>Checks whether the Term class object is created.</p>
	 * @since 1.0
	 */
	@Test
	public void createNewTerm() {
		
		Assert.assertNotNull(testingTerm); //return true if testingTerm is not null and return false if testingTerm is null 
		
	}
	
	/**
	 * <p>Checks whether the getName method returns the class Term Name field.</p>
	 * @since 1.0
	 */
	@Test
	public void getTermName() {
		
		String actual = testingTerm.getName(); //get Name field from testingTerm object
		
		String expected = this.name; //expected term Name
		
		Assert.assertEquals(expected, actual); //returns true if expected and actual variables are equals
		
	}
	
	/**
	 * <p>Checks whether the getTranscription method returns the class Term Transcription field.</p>
	 * @since 1.0
	 */
	@Test
	public void getTermTranscription() {
		
		String actual = testingTerm.getTranscription(); //get Transcription field from testingTerm object
		
		String expected = this.transcription; //expected term Transcription
		
		Assert.assertEquals(expected, actual); //returns true if expected and actual variables are equals
		
	}

	/**
	 * <p>Checks whether the getDescription method returns the class Term Description field.</p>
	 * @since 1.0
	 */	
	@Test
	public void getTermDescription() {
		
		String actual = testingTerm.getDescription(); //get Transcription field from testingTerm object
		
		String expected = this.description; //expected term Description
		
		Assert.assertEquals(expected, actual); //returns true if expected and actual variables are equals	
		
	}
	
	/**
	 * <p>Checks to whether the class Term setName method allows
	 *  to change the value of the field Name.</p>
	 *  @since 1.0
	 */
	@Test
	public void setTermName() {
		
		String expected = "new term name"; //expected term Name
		
		testingTerm.setName(expected); //set new Name to the testingTerm
		
		String actual = testingTerm.getName(); //get Name field from tetingTerm object
		
		Assert.assertEquals(expected, actual); //returns true if expected and actual variables are equals
		
	}

	/**
	 * <p>Checks to whether the class Term setDescription method allows
	 *  to change the value of the field Description.</p>
	 *  @since 1.0
	 */
	@Test
	public void setTermDescription() {
		
		String expected = "new description"; //expected term Description
		
		testingTerm.setDescription(expected); //set new Description to the testingTerm
		
		String actual = testingTerm.getDescription(); //get Desrciption field from tetingTerm object
		
		Assert.assertEquals(expected, actual); //returns true if expected and actual variables are equals
		
	}
	/**
	 * <p>Checks to whether the class Term setTranscription method allows
	 *  to change the value of the field Transcription.</p>
	 *  @since 1.0
	 */
	@Test
	public void setTermTranscription() {
		
		String expected = "new transcription"; //expected term Transcription
		
		testingTerm.setTranscription(expected); //set new Transcription to the testingTerm
		
		String actual = testingTerm.getTranscription(); //get Transcription field from tetingTerm object
		
		Assert.assertEquals(expected, actual); //returns true if expected and actual variables are equals
		
	}
}
