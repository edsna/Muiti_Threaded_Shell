import java.io.*;

public class Attrib implements Runnable{

  String a;

  public Attrib(String name){
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
  	f.setReadOnly();
  	if (f.canWrite()) {
  		System.out.println("ERROR: file couldn't be set read only");
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
