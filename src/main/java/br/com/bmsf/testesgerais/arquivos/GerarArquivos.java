package br.com.bmsf.testesgerais.arquivos;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class GerarArquivos {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String UNKNOWN_CHARACTER = ".";
	
	private GerarArquivos() {
		
	}
	
	public static InputStream texto() {
		try(ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\breno\\temp\\teste2.TMP"); 
			
//			"SEGUROS".chars().forEach(ch ->{				
//				try {
//					fileOut.write((int)ch);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
			
			
//			fileOut.write("SEGUROS".getBytes());
			
//			fileOut.write(convertFileToHex(Paths.get("C:\\Users\\breno\\temp\\teste.TMP")).getBytes());
			
//			StringBuilder sb = new StringBuilder();
//			for(char ch:"SEGUROS".toCharArray()) {
//				sb.append((int)ch);
//			}		
			
//			fileOut.write(sb.toString().getBytes(StandardCharsets.US_ASCII));
			
			writeFile("C:\\Users\\breno\\temp\\teste2.TMP");	
		
//			Writer w = new BufferedWriter(new OutputStreamWriter(fileOut));
//		    w.write("SEGUROS");
			
			System.out.println("Arquivo gerado com sucesso!!!");
		 return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String convertToBinary(String input, String encoding) throws UnsupportedEncodingException {
		    byte[] encoded_input = Charset.forName(encoding)
		      .encode(input)
		      .array();  
		    return IntStream.range(0, encoded_input.length)
		        .map(i -> encoded_input[i])
		        .mapToObj(e -> Integer.toBinaryString(e ^ 255))
		        .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
		        .collect(Collectors.joining(" "));
	}
	
    public static String convertFileToHex(Path path) throws IOException {

        if (Files.notExists(path)) {
            throw new IllegalArgumentException("File not found! " + path);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder hex = new StringBuilder();
        StringBuilder input = new StringBuilder();

        int count = 0;
        int value;

        // path to inputstream....
        try (InputStream inputStream = Files.newInputStream(path)) {

            while ((value = inputStream.read()) != -1) {

                hex.append(String.format("%02X ", value));

                //If the character is unable to convert, just prints a dot "."
                if (!Character.isISOControl(value)) {
                    input.append((char) value);
                } else {
                    input.append(UNKNOWN_CHARACTER);
                }

                // After 15 bytes, reset everything for formatting purpose
                if (count == 14) {
                    result.append(String.format("%-60s | %s%n", hex, input));
                    hex.setLength(0);
                    input.setLength(0);
                    count = 0;
                } else {
                    count++;
                }

            }

            // if the count>0, meaning there is remaining content
            if (count > 0) {
                result.append(String.format("%-60s | %s%n", hex, input));
            }

        }

        return result.toString();
    }
    
	public static boolean writeFile(String path){
		try{
			PrintWriter fo = new PrintWriter(new FileOutputStream(new File(path)),true);
			fo.print((char) 147); //WRITES "?" TO FILE (ASCII 63, NOT 147)
			fo.close();
		}catch(Exception e){
			return true;
		}
		return false;
	}
}
