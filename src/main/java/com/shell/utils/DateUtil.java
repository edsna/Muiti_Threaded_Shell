import java.util.Date;

public class MyDate implements Runnable{
	/* Command:
           date
           Action:
           the current date is displayed.
	 */

	public MyDate(){
	
	}

	private void f(){
		long millis = System.currentTimeMillis();  
		Date date = new Date(millis);  
		System.out.println(date);  
	}

	 /*
   * Implements run() Method
   * Anything inside the run method is what is going to run when we start the thread
  */
  public void run(){
    try{
      f();
    }catch(Exception e){
      System.out.println("Exception " + e + " caught!");
    }
  }
}
