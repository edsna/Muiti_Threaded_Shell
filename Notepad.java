import java.io.IOException;

public class Notepad extends Thread implements Runnable{
  /*
      Command:
      edit
      Action:
      The notepad editor shows up on the screen.

      Use the java Runtime class to execute the notepad.exe. With this approch
      you do not need notepad.h, notepad.c, and notepad.exe.
      This approach is easier than one I posted last week. You do not
      need the java native interface (JNI) or Microsoft visual C++.
  */
  public Notepad(){
    f();
  }

  private void f() {
  	Runtime rs = Runtime.getRuntime();

    try {
      rs.exec("notepad");
    }
    catch (IOException e) {
      System.out.println(e);
    }
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
