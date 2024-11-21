import java.io.*;

public class Dir implements Runnable{
	/* Command::
       dir name           where name must be null or the name of a directory and its paths.
       Action:
       List the file and directory names in this directory.
       Note that if the user enters "dir" it is OK and it means the current
       directory. In this case as you know a period (e,g .) means the current
       directory
       Errors:
       The user enters:
       1. dir name             The directory name does not exist.
       2. dir name             But the name does is not a directory name.
       When there is an error println a message and return (not exit).
	 */
String a;

	public Dir(String name){
    this.a = name;
	}

	private void f(String name){
		if (name == null || name.equals("")) {
  		System.out.println("ERROR: dir name is missing");
  		return;
  	}
		File dir = new File(name);
		if (!dir.exists()) {
  		System.out.println("ERROR: dir does not exist");
  		return;
  	}
  	if (!dir.isDirectory()) {
  		System.out.println("ERROR: file is not a directory");
  		return;
  	}
		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isFile()) {
				System.out.println("File " + f.getName());
			} else if (f.isDirectory()) {
				System.out.println("Directory " + f.getName());
			}
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
