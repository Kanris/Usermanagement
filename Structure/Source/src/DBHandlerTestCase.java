import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

/**
 * <p>This class consists exclusively of test methods that tests DBHandler class methods.</p>
 * @author Alexey Hlukhov
 * @version 1.0
 * @see DBHandler
 */
public class DBHandlerTestCase {

	private String name, transcription, description; //testingTerm fields
	private Term testingTerm; //object of Term for testing database methods
	
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
	 * <p>Check whether you can get a list of terms from the database.</p>
	 * @throws SQLException если переменная rs содержит null
	 * @since  1.0
	 */
	@Test
	public void testGetTermList() throws SQLException {
		
		
		ResultSet rs = DBHandler.getTermList(); //get rows from database
		
		boolean hasRow = rs.next(); //check is there any row
		
		Assert.assertTrue(hasRow); //if rs has some rows it will return true and if rs hasn't any rows it will return false
		
	}

	/**
	 * <p>Checks whether it is possible to add a new term to the database.</p>
	 * @since 1.0
	 */
	@Test
	public void testAddNewTerm() {
		
		DBHandler.addNewTerm(testingTerm); //add testing term to database
		
		boolean isAdded = DBHandler.isExist(name); //check that testingTerm was added to database
		DBHandler.deleteTerm(testingTerm.getName()); //remove testing term from database
		
		Assert.assertTrue(isAdded); //if testingTerm was added to database it will return true, and if testingTerm wasn't added to database - return false
		
	}

	/**
	 * <p>Check whether you can delete an existing term from the database.</p>
	 * @since 1.0
	 */
	@Test
	public void testDeleteTerm() {
		
		DBHandler.addNewTerm(testingTerm); //add testing term to database
		DBHandler.deleteTerm(testingTerm.getName()); //remove testing term from database
		
		boolean isDeleted = !(DBHandler.isExist(testingTerm.getName())); //check that testingTerm was deleted from database
		 
		Assert.assertTrue(isDeleted); //if testingTerm was removed from database it will return true, if testingTerm is still in database - return false
	}

	/**
	 * <p>Check whether you can change the value of an existing term in the database.</p>
	 * @since 1.0
	 */
	@Test
	public void testUpdateTerm() {
		
		DBHandler.addNewTerm(testingTerm); //add testing term to database
		testingTerm.setName("newTermName"); //change Name field of testingTerm object
		DBHandler.updateTerm(testingTerm, name); //update testingTerm in database
		
		boolean isEdited = DBHandler.isExist(testingTerm.getName()); //check that testingTerm in database was updated
		DBHandler.deleteTerm(testingTerm.getName()); //remove testing term from database
		
		Assert.assertTrue(isEdited); //if testingTerm was updated it will return true, and if testingTerm wasn't updated - return false
		
	}

}
