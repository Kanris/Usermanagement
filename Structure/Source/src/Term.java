/**
 * <p>This class describes the object term.</p>
 * @author Alexey Hlukhov
 * @version 1.0
 */
public class Term {
	
	private String name; //it contains the term name
	private String transcription; //it contains the term transcription
	private String description; //it contains the term description
	
	/**
	 * <p>The main constructor to create an object of the term</p>
	 * @param name           term name
	 * @param transcription  term transcription
	 * @param description    term description
	 * @since 1.0
	 */
	public Term(String name, String transcription, String description) {
		
		this.name = name;
		this.transcription = transcription;
		this.description = description;
		
	}

	/**
	 * <p>Returns the name field.</p>
	 * @return this.name
	 * @since  1.0
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>It allows you to change the value of the field name.</p>
	 * @param name a new value for this.name
	 * @since 1.0
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Returns the transcription field.</p>
	 * @return this.transcription
	 * @since  1.0
	 */
	public String getTranscription() {
		return transcription;
	}

	/**
	 * <p>It allows you to change the value of the field transcription.</p>
	 * @param transcription a new value for this.transcription
	 * @since 1.0
	 */
	public void setTranscription(String transcription) {
		this.transcription = transcription;
	}

	/**
	 * <p>Returns the description field.</p>
	 * @return this.description
	 * @since  1.0
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>It allows you to change the value of the field description.</p>
	 * @param description a new value for this.description
	 * @since 1.0
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}