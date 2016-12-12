import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TermTestCase {

	private String name, transcription, description;
	private Term testingTerm;
	
	@Before
	public void setUp() throws Exception {
		
		this.name = "termName";
		this.transcription = "transcriptionN";
		this.description = "descriptionN";
		
		testingTerm = new Term(name, transcription, description);
	}

	@Test
	public void createNewTerm() {
		
		Assert.assertNotNull(testingTerm);
		
	}
	
	@Test
	public void getTermName() {
		
		String actual = testingTerm.getName();
		
		String expected = this.name;
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void getTermTranscription() {
		
		String actual = testingTerm.getTranscription();
		
		String expected = this.transcription;
		
		Assert.assertEquals(expected, actual);		
		
	}

	
	@Test
	public void getTermDescription() {
		
		String actual = testingTerm.getDescription();
		
		String expected = this.description;
		
		Assert.assertEquals(expected, actual);	
		
	}
	
	@Test
	public void setTermName() {
		
		String expected = "new term name";
		
		testingTerm.setName(expected);
		
		String actual = testingTerm.getName();
		
		Assert.assertEquals(expected, actual);
		
	}


	@Test
	public void setTermDescription() {
		
		String expected = "new description";
		
		testingTerm.setDescription(expected);
		
		String actual = testingTerm.getDescription();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void setTermTranscription() {
		
		String expected = "new transcription";
		
		testingTerm.setTranscription(expected);
		
		String actual = testingTerm.getTranscription();
		
		Assert.assertEquals(expected, actual);
		
	}
}
