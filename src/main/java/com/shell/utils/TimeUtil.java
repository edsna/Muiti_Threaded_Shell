import java.util.Date;
/* Command:
           time
           Action:
           the current time is displayed.
  */

public class MyTime implements Runnable{
  public MyTime(){

  }

  private void f(){
  	long millis = System.currentTimeMillis();  
		Date date = new Date(millis);
		String[] arr = date.toString().split(" ");
		String time = arr[3] + " " + arr[4];
		System.out.println(time);
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
