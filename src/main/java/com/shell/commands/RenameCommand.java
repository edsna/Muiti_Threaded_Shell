import java.io.*;

public class Rename implements Runnable{
  /* Command:
             rename nameA nameB
             Action:
             Renames the file nameA to the file nameB.
             Use your classes Copy and Delete for this.
             Errors:
             The user enters:
             1. rename              The names nameA and nameB are missing.
             When there is an error println a message and return (not exit).
    */
String a;

  public Rename(String params) {
    this.a = params;
  }

  private void f(String params) {
  	if (params == null || params.equals("")) {
  		System.out.println("ERROR: file names are missing");
  		return;
  	}
  	String[] prms = params.split(" ");
  	if (prms.length < 2) {
  		System.out.println("ERROR: second file name is missing");
  		return;
  	}
  	File f0 = new File(prms[0]);
  	File f1 = new File(prms[1]);
  	try {
			f0.renameTo(f1);
		} catch (Exception e) {
			System.out.println("ERROR: couldn't rename file");
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
