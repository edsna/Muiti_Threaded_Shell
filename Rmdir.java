import java.io.*;

public class Rmdir implements Runnable {
  /* Command:
               rmdir name
               Action:
               Removes the directory name.
               Errors:
               The user enters:
               1. rmdir              The name is missing.
               2. rmdir name         But the name does not exist.
               3. rmdir name         But name is not a directory.
               4. rmdir name         But the directory name is not empty.
               When there is an error println a message and return (not exit).
  */
String a;

  public Rmdir(String name){
    this.a = name;
  }

  private void f(String name){
  	if (name == null || name.equals("")) {
  		System.out.println("ERROR: dir name is missing");
  		return;
  	}
  	File f = new File(name);
  	if (!f.exists()) {
  		System.out.println("ERROR: dir does not exist");
  		return;
  	}
  	if (!f.isDirectory()) {
  		System.out.println("ERROR: file is not a directory");
  		return;
  	}
  	try {
  		f.delete();
		} catch (Exception e) {
			System.out.println("ERROR: dir is not empty");
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
