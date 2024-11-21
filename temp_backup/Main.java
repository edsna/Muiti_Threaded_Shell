import java.io.*;
import java.util.StringTokenizer;
/*
  As we are going through the semester I will add more names to Token.java.
  The errors that I mentioned in any class are the ones that I could think of
  while I was writing the class. There may be more erros that I could not think
  of. Please inform me if there are more errors so that I inform other students.
 */
class Main {
	public static void main(String[] args) {
		while(true){
			System.out.print("PROMPT\\>");
			String command = "";
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			try {
				command = stdin.readLine();
			}
			catch (Exception e) {
				System.out.println(e);
				return;
			}
			StringTokenizer tok = new StringTokenizer(command);
			if (tok.hasMoreTokens()) {
				Token token = new Token(tok.nextToken());
				String s = "";
				while (tok.hasMoreTokens())
					s = s + " " + tok.nextToken();
				if (!s.equals(""))
					s = s.substring(1);
				switch (token.kind) {
					case Token.ATTRIB:
						Thread atr = new Thread(new Attrib(s));	//Create thread
						atr.start();	//Start thread
						try{
					        atr.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.COPY:
						Thread cp = new Thread(new Copy(s));	//Create thread
						cp.start();	//Start thread
						try{
					        cp.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.DATE:
						Thread dt = new Thread(new MyDate());	//Create thread
						dt.start();	//Start thread
						try{
					        dt.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.DELETE:
						Thread dl = new Thread(new Delete(s));	//Create thread
						dl.start();	//Start thread
						try{
					        dl.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.DIR:
						Thread dr = new Thread(new Dir(s));	//Create thread
						dr.start();	//Start thread
						try{
					        dr.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.EDIT:
						Thread edt = new Thread(new Notepad());	//Create thread
						edt.start();	//Start thread
						try{
					        edt.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.EXEC:
						Thread ex = new Thread(new Execute(s));	//Create thread
						ex.start();	//Start thread
						try{
					        ex.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.EXIT:
						System.exit(1);
					case Token.MKDIR:
						Thread mk = new Thread(new Mkdir(s));	//Create thread
						mk.start();	//Start thread
						try{
					        mk.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.RENAME:
						Thread rn = new Thread(new Rename(s));	//Create thread
						rn.start();	//Start thread
						try{
					        rn.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.RMDIR:
						Thread rmd = new Thread(new Rmdir(s));	//Create thread
						rmd.start();	//Start thread
						try{
					        rmd.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
					case Token.TIME:
						Thread mt = new Thread(new MyTime());	//Create thread
						mt.start();	//Start thread
						try{
					        mt.join();
					    }catch(Exception e){
					        System.out.printf("Exception %s caught", e);
					    }
						break;
				default:
					System.out.println("Wrong command.");
				}
			}
		}
	}
}
