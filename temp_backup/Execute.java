import java.io.*;
import java.util.StringTokenizer;
import java.lang.reflect.*;
import java.net.URLClassLoader;

public class Execute implements Runnable{
	/* Command::
         exec name word1 word2, ....   where name must the name of a java class and its paths
                                       and wordis are the arguments.
         Action:
         Executes the "main" of the name.class. Therefore this file must be the main file.
         Errors:
         The user enters:
         1. exec                 The class name is missing.
         2. exec name            But name.class does not exist.
         3. There are exceptions that you need to find them.
         When there is an error println a message and return (not exit).
	 */
   String a;

	public Execute(String params) {
      this.a = params;
	}

	private void f(String params) {
		if (params == null || params.equals("")) {
         System.out.println("ERROR: file name is missing!");
         return;
      }
      //split iput into 3 parts with space
      String[] prms = params.split(" ");
      if (prms.length < 3) {
         System.out.println("ERROR: argument 2 is missing!");
         return;
      }
      if (prms.length < 2) {
         System.out.println("ERROR: argument 1 is missing!");
         return;
      }
      File name = new File(prms[0]);
      File arg1 = new File(prms[1]);
      File arg2 = new File(prms[2]);
       //Check existence of file name/class
      if (!name.exists()) {
         System.out.println("ERROR: class does not exist!");
         return;
      }

      //try to run the class
      /*
         Test myclass = new Test();
         args[0] = name;
         args[1] = arg1;
         args[2] = arg2;
         myclass.f(5);
      */

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
