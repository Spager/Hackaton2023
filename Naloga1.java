
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Naloga1 {
    public static void main(String[] args) {
        String fileName = "VpisnaSt.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        	int i = 1;
        	while(reader.ready()) {
	            String hexString = reader.readLine(); 
	            long decimalValue = Long.parseLong(hexString, 16);
	            if(decimalValue == 35210087) {
	            	System.out.println(i);
	            	System.out.println("Hex string: " + hexString);
	            	System.out.println("Decimal value: " + decimalValue);
	            }
	            i++;
        	}
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid hex string: " + e.getMessage());
        }
    }
}