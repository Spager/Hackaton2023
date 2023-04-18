import java.util.*;
import java.io.*;

public class Naloga5 {
	public static char[][][] POLJE = new char[26][26][26];
	
	public static int X = 6; 
	public static int Y = 6; 
	public static int Z = 22;
	
	public static String Beseda = "";
	
	public static int SMER = 3;
	//	1 : x+		 2 : y+		 3 : z+
	// -1 : x-		-2 : y-		-3 : z-
	
	public static char ZNAK;
	
	public static void main(String[] args) {
		
		init();
		//draw();

		boolean konec = false;
		
		
		
		while(!konec){
			ZNAK = POLJE[Z][Y][X];
			//System.out.println("ZNAK = "+ZNAK+"  SMER = "+SMER);
			if(ZNAK == '*') {
				konec = true;
				break;
			}else if(Character.isLetter(ZNAK) && ZNAK != 'v') {
				Beseda += ZNAK+"";
				premik();
				
			}else if(ZNAK == '>' || ZNAK == '<' || ZNAK == '^' || ZNAK == 'v') {
				zavij();
				
			}else 
				premik();
			
			
			
		}
		System.out.println(Beseda);
		
	}
	
	public static void zavij() {
		//XXXXXXXXXXXXXXXXXXXXXXX
		if(ZNAK == '>' && SMER == 1 || ZNAK == '<' && SMER == -1) {
			Z--;
			SMER = -3;
		}else if(ZNAK == '<' && SMER == 1 || ZNAK == '>' && SMER == -1) {
			Z++;
			SMER = 3;
		}else if(ZNAK == '^' && SMER == 1 || ZNAK == '^' && SMER == -1) {
			Y--;
			SMER = -2;
		}else if(ZNAK == 'v' && SMER == 1 || ZNAK == 'v' && SMER == -1) {
			Y++;
			SMER = 2;
		}//YYYYYYYYYYYYYYYYYYYYYYYY
		else if(ZNAK == '^' && SMER == 2 || ZNAK == 'v' && SMER == -2) {
			Z++;
			SMER = 3;
		}else if(ZNAK == 'v' && SMER == 2 || ZNAK == '^' && SMER == -2) {
			Z--;
			SMER = -3;
		}else if(ZNAK == '>' && SMER == 2 || ZNAK == '>' && SMER == -2) {
			X++;
			SMER = 1;
		}else if(ZNAK == '<' && SMER == 2 || ZNAK == '<' && SMER == -2) {
			X--;
			SMER = -1;
		}//ZZZZZZZZZZZZZZZZZZZZZZ
		else if(ZNAK == '^' && SMER == 3 || ZNAK == '^' && SMER == -3) {
			Y--;
			SMER = -2;
		}else if(ZNAK == 'v' && SMER == 3 || ZNAK == 'v' && SMER == -3) {
			Y++;
			SMER = 2;
		}else if(ZNAK == '>' && SMER == 3 || ZNAK == '>' && SMER == -3) {
			X++;
			SMER = 1;
		}else if(ZNAK == '<' && SMER == 3 || ZNAK == '<' && SMER == -3) {
			X--;
			SMER = -1;
		}
	}
	
	public static void premik() {
		if(SMER == 3) {
			Z++;
		}else if(SMER == -3) {
			Z--;
		}else if(SMER == 2) {
			Y++;
		}else if(SMER == -2) {
			Y--;
		}else if(SMER == -1) {
			X--;
		}else
			X++;
	}
	
	
	public static void init() {
		try {
			Scanner vh = new Scanner(new FileReader(new File("PotSocutja.txt")));
			int z = 0, y=0;
			String niz;
			
			while(vh.hasNext()) {
				niz = vh.nextLine();
		        for (int x = 0; x < niz.length(); x++) 
		            POLJE[z][y][x] = niz.charAt(x);
		        y++;
		        if(y > 25) {
		        	y = 0;
		        	z += 1;	
		        }
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void draw() {
		for (char[][] array2D: POLJE) {
            for (char[] array1D: array2D) {
                for(char item: array1D) {
                    System.out.print(item);
                }
                System.out.println();
            }
            System.out.println();
        }
	}
	
}