
import java.util.*;
import java.io.*;

public class Naloga2 {

	public static void main(String[] args) {
		try {
			Scanner vh = new Scanner(new FileReader(new File("Kratice.txt")));
			
			String oci,lasje,obraz,lepota,kratica;
			
			String kljuc = "GACCATACCAGTAAGCGAATATGGTCCGTAAGTTATCATTGTTGGTGTGACAGCCAGGTAGAGATCACTGCCGATTATATTTGGAAGTTTCCCATGCTACTCCATCGACTTTTCCACTGAGTCCCTCACCTATGGGCAGAAAACGCCCCTATTAACCTTGTTCGCCCAGCCTCGCGTCGCGGAATGCCGGAGAACCGAAGCTCTAGGAACGATCGACCCCGGTATTCCTATTTGTCACTGTACAGTACACGGTGAGCGGC";
			boolean konec = false;
			int x = 0;
			
			while(vh.hasNext() && !konec) {
				x = 0;
				kratica = obreziK(vh.nextLine());
				oci = obrezi(vh.nextLine());
				lasje = obrezi(vh.nextLine());
				obraz = obrezi(vh.nextLine());
				lepota = obrezi(vh.nextLine());
				vh.nextLine();
				
				
				for(int i = 0; i < kljuc.length()-49; i++) {				
					if(kljuc.substring(i,i+50).equals(oci)) {
						x++;
					}
					if(kljuc.substring(i,i+50).equals(lasje)) {
						x++;
					}
					if(kljuc.substring(i,i+50).equals(lepota)) {
						x++;
					}
					if(kljuc.substring(i,i+50).equals(obraz)) {
						x++;
					}
					
					
				}
				if(x >= 4) {
						konec = true;
						System.out.println("Kratica ki jo iscemo: "+kratica);
					}
				
				
				
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String obrezi(String niz) {
		String rez = "";
		for(int i = 0; i < niz.length()-1; i++) {
			if(niz.charAt(i) == '=') {
				rez =  niz.substring(i+2);
				break;
			}
		}
		return rez;
	}
	
	public static String obreziK(String niz) {
		String rez = "";
		for(int i = 0; i < niz.length()-1; i++) {
			if(niz.charAt(i) == ' ') {
				rez =  niz.substring(i+1);
				break;
			}
		}
		return rez;
	}

	
}
