
public class SequentialSearch {

	public SequentialSearch (Book[] b, int start, int end, int isbn) 
{   
    int iterations = 0;
    boolean wrongIndex = false;
    boolean notFound = true;
    
    if (end>b.length)
    {
        System.out.println("The end index is too big!");
        wrongIndex = true;
    }
        else 
        {   
            while(notFound)
            for (int i=start ; i<end; i++) 
            {   
                iterations++;
                System.out.println(iterations+" iteration(s). ISBN: " + b[i].getISBN());
                if (b[i].getISBN() == isbn)
                {
                    notFound = false;
                }
            }
        }
    
    if (notFound == false && wrongIndex == false)
    {
        System.out.println("It took " + iterations + " iteration(s) to find the book with ISBN #"+isbn);

    }
        else if(notFound == true && wrongIndex == false)
        {
            System.out.println("ISBN #" + isbn + " not found in " + iterations + " iterations.");
        }
}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book();
		book1.setISBN(222222222);
		Book book2 = new Book();
		book2.setISBN(100000000);
		Book book3 = new Book();
		book3.setISBN(333333333);
		Book[] array = {book1, book2, book3};
		new SequentialSearch(array, 0, 3, 100000000);
	}

}
