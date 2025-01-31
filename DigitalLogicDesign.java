import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DigitalLogicDesign {
    public static void main(String[] args) throws IOException {
            File file = new File("input.txt");
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

            Scanner scanner;
			try {
				scanner = new Scanner(file);
				while(scanner.hasNextLine()) {
		                String operation = scanner.next();
		                String syntax = scanner.next();
		                String[] myArray = syntax.split(",");
		                switch (operation) {
		                case "ADD":
		                	convert("00000",new int[]{4, 4, 4},"000",myArray,new int[]{1, 1, 1},writer);
		                    break;
		                case "ADDI":
		                	convert("00001",new int[]{4, 4, 7},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "SUB":
		                	convert("00010",new int[]{4, 4, 4},"000",myArray,new int[]{1, 1, 1},writer);
		                    break;
		                case "SUBI":
		                	convert("00011",new int[]{4, 4, 7},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "OR":
		                	convert("00100",new int[]{4, 4, 4},"000",myArray,new int[]{1, 1, 1},writer);
		                    break;
		                case "ORI":
		                	convert("00101",new int[]{4, 4, 7},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "NAND":
		                	convert("00110",new int[]{4, 4, 4},"000",myArray,new int[]{1, 1, 1},writer);
		                    break;
		                case "NANDI":
		                	convert("00111",new int[]{4, 4, 7},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "SLL":
		                	convert("010",new int[]{4, 4, 4},"00000",myArray,new int[]{1, 1, 1},writer);
		                    break;
		                case "SLLI":
		                	convert("011",new int[]{4, 4, 9},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "BEQ":
		                	convert("1010",new int[]{4, 4, 8},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "BLT":
		                	convert("1100",new int[]{4, 4, 8},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "BGT":
		                	convert("1001",new int[]{4, 4, 8},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "BLE":
		                	convert("1110",new int[]{4, 4, 8},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "BGE":
		                	convert("1011",new int[]{4, 4, 8},"",myArray,new int[]{1, 1, 0},writer);
		                    break;
		                case "JUMP":
		                	convert("1000",new int[]{13},"000",myArray,new int[]{0},writer);
		                    break;
		                case "LD":
		                	convert("1101",new int[]{4, 12},"",myArray,new int[]{1, 0},writer);
		                    break;
		                case "ST":
		                	convert("1111",new int[]{4, 12},"",myArray,new int[]{1, 0},writer);
		                    break;
		                default:
		                    System.out.println("Operation isn't valid!");
		                    writer.write("Operation isn't valid!");
		                    break;
		            }
				}
            scanner.close();
            writer.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found.");
		}
    }
    
    public static void convert(String str,int[] array,String str5,String[] myArray,int[] substringMyArray, PrintWriter writer) throws IOException {
    for(int i=0;i<array.length;i++)
                str+=String.format("%0"+array[i]+"d",Integer.parseInt(Integer.toBinaryString(Integer.parseInt(myArray[i].substring(substringMyArray[i])))));
    str+=str5;
                			
    for(int i=0;i<5;i++) {
    	System.out.print(Integer.toHexString(Integer.parseInt(str.substring(4*i, 4*(i+1)),2)).toUpperCase());
    	writer.print((Integer.toHexString(Integer.parseInt(str.substring(4*i, 4*(i+1)),2)).toUpperCase()));
    }
    writer.println();
    System.out.println();
    }
    
}
