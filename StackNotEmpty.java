/*
 * Matthew White
 * CMSC 350 - Spring '21
 * Contains the custom exception for handling purposes
 */
package prePostConvert;

public class StackNotEmpty extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long serialID=314159;
	public StackNotEmpty() {
		System.out.println(serialID);
	}
}
