public class Naloga4 {
	
	public static int[] X,Y,C,Z,B;
	public static void main(String[] args) {
		X = new int[280];
		tabelaX();
		
		Y = new int[280];
		tabelaY();

		Z = new int[280];
		tabelaZ();

	
		B = new int[280];
		C = new int[280];
		sifra();
		tabelaCinB();
		
		System.out.println("Začetna Matrika:");
		narisi();
		System.out.println();
		System.out.println("(De)sifrirana Matrika: kao");
		output();
		


	}
	
	

	
	public static void tabelaX(){
		X[0] = 1;
		X[1] = 1;
		X[2] = 0;
		for(int i = 3; i < 280; i++) {
			X[i] = XOR(X[i-2],X[i-3]);
		}
	}
	
	public static void tabelaY(){
		Y[0] = 1;
		Y[1] = 0;
		Y[2] = 0;
		for(int i = 3; i < 280; i++) {
			Y[i] = XOR(Y[i-1],Y[i-3]);
		}
	}
	
	public static void tabelaZ(){
		for(int i = 0; i < 280; i++) {
			Z[i] = XOR(X[i],Y[i]);
		}
	}

	public static void output() {
		int j = 1;
		for(int i = 0; i < 280; i++) {
			if(i == j*40) {
				j++;
				System.out.println();
				
			}if(B[i] == 1)
				System.out.print("#");
			else
				System.out.print(" ");
			
		}
		System.out.println();
	}
	
	public static void tabelaCinB(){
		for(int i = 0; i < 8;i++) {
			B[i] = 1;
		}
		B[8] = 0;
		B[9] = 0;
		for(int i = 10; i < 280; i++) {
			B[i] = XOR(C[i],Z[i]);
		}
		
	}
	
	
	public static void test(int[] tab) {
		for(int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]+", ");
		}
		System.out.println();
	}
	
	
	public static void sifra() {
		String key =  "1010100110010010100101010100010100011010000101000001101101010111001011011000001001110100110110101101010000101010110110100101001001100101101101001110100111010011011010110110011010101100110110010100101110101010111001011010101011010101101010111001101010001010101010110101011010101101";
		for(int i = 0; i < key.length(); i++) {
			if(key.charAt(i) == '1')
				C[i] = 1;
			else
				C[i] = 0;
		}
	}
		
	public static int XOR(int a, int b) {
		if(a == b)
			return 0;
		else
			return 1;
	}
	
	public static void narisi() {
		String niz = "1010100110010010100101010100010100011010000101000001101101010111001011011000001001110100110110101101010000101010110110100101001001100101101101001110100111010011011010110110011010101100110110010100101110101010111001011010101011010101101010111001101010001010101010110101011010101101";
		int j = 1;
		for(int i = 0; i < niz.length(); i++) {
			if(i == (280/7)*j) {
				System.out.println();
				j++;
			}if(niz.charAt(i) == '1')
				System.out.print("#");
			else
				System.out.print(" ");
			
		}
		System.out.println();
	}
}
