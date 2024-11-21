import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Copy implements Runnable {
  /* Command::
   copy nameA nameB      where nameA and nameB must be the name of a files and their paths.
   Action:
   Copies file nameA to file nameB.
   Errors:
   The user enters:
   1. copy               Does not type the file names.
   2. copy name          Did not type a second file name.
   3. copy nameA nameB   but the file nameA does not exist.
   4. copy nameA nameB   but the file nameB already exists.
   5. copy nameA nameB   but nameA is a directory.
   6. copy nameA nameB   but the file is a directory.
   When there is an error println a message and return (not exit).
*/
  String a;
  
  public Copy(String params) {
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
  	if (!f0.exists()) {
  		System.out.println("ERROR: file nameA does not exist");
  		return;
  	}
  	if (f1.exists()) {
  		System.out.println("ERROR: file nameB already exists");
  		return;
  	}
  	if (f0.isDirectory()) {
  		System.out.println("ERROR: file nameA is a directory");
  		return;
  	}
  	if (f1.isDirectory()) {
  		System.out.println("ERROR: file nameB is a directory");
  		return;
  	}
  	try {
			Files.copy(f0.toPath(), f1.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("ERROR: couldn't copy file");
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
