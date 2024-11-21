import java.io.*;

public class Mkdir implements Runnable {
  /* Command:
           mkdir name
           Action:
           make a directory in the path of the name.
           Errors:
           The user enters:
           1. dir                 The name is missing.
           2. dir name            But name is already exist.

           When there is an error println a message and return (not exit).
  */
String a;

  public Mkdir(String name){
    this.a = name;
  }

  private void f(String name){
  	if (name == null || name.equals("")) {
  		System.out.println("ERROR: dir name is missing");
  		return;
  	}
  	File f = new File(name);
  	if (f.exists()) {
  		System.out.println("ERROR: dir already exists");
  		return;
  	}
  	f.mkdir();
  }

   /*
   * Implements run() Method
   * Anything inside the run method is what is going to run when we start the thread
  */
  public void run(){
    try{
      f(a);
    }catch(Exception e){
      System.out.println("Exception " + e + " caught!");
    }
  }
}
