public class DuplicateISBNException extends Exception{
        
    //default constructor
    public DuplicateISBNException() {        
        super("Duplicated ISBN number");
    }
    
    //constructor with message
    public DuplicateISBNException(String message) {
        super(message);
    }
    
    //get method
    public String getMessage() {
    	return super.getMessage();
    }    
    
}
