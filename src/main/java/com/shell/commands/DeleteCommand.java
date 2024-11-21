import java.io.*;

public class Delete implements Runnable{
  /* Command::
     delet name           where name must be the name of a file and its paths.
     Action:
     delets name
     Errors:
     The user enters:
     1. delet                The user did not type the file name.
     2. delet name           The file name does not exist in the path.
     3. delete name          But the file is a directory.
     When there is an error println a message and return (not exit).
*/

  String a;
  
  public Delete(String name){
    this.a = name;
  }

  private void f(String name) {
  	if (name == null || name.equals("")) {
  		System.out.println("ERROR: file name is missing");
  		return;
  	}
  	File f = new File(name);
  	if (!f.exists()) {
  		System.out.println("ERROR: file does not exist");
  		return;
  	}
  	if (f.isDirectory()) {
  		System.out.println("ERROR: file is a directory");
  		return;
  	}
  	if (!f.delete()) {
  		System.out.println("ERROR: file couldn't be deleted");
  	}
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
