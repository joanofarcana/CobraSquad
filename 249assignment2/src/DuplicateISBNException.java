public class DuplicateISBNException extends Exception{
    
    private String message;
    
    //default constructor
    public DuplicateISBNException()
    {        
        super("Duplicated ISBN number1111");
    }
    
    //constructor with message
    public DuplicateISBNException(String message)
    {
        super(message);
    }
    
    //get method
    public String getMessage()
    {
	return super.getMessage();
    }    
    
}
