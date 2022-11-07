package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		String[] temp = scan.nextLine().split(",");
		scan.close();	
		
		List<Integer> inputData = new ArrayList<>();
		
		for (int i = 0; i < temp.length; i++) {
			inputData.add(Integer.parseInt(temp[i]));
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				List<Integer> temp2 = new ArrayList<>(inputData);
				temp2.set(1, i);
				temp2.set(2, j);
				if (programAlarm(temp2) == 19690720) {
					System.out.println(100 * i + j);
					return;
				}
			}
		}
	}
	
	public static int programAlarm(List<Integer> inputData) {
		
		int pointer = 0;
		while (true) {
			switch (inputData.get(pointer)) {
			case 1:
				inputData.set(inputData.get(pointer + 3), inputData.get(inputData.get(pointer + 1)) + inputData.get(inputData.get(pointer + 2)));
//				int addressOperand1 = inputData.get(pointer + 1);
//				int addressOperand2 = inputData.get(pointer + 2);
//				int operand1 = inputData.get(addressOperand1);
//				int operand2 = inputData.get(addressOperand2);
//				int result = operand1 + operand2;
//				int pos = inputData.get(pointer + 3);
//				inputData.set(pos, result);			то же самое что и выше
				pointer += 4;
				break;
				
			case 2:
				inputData.set(inputData.get(pointer + 3), inputData.get(inputData.get(pointer + 1)) * inputData.get(inputData.get(pointer + 2)));
				pointer += 4;
				break;
				
			case 99:
				return  inputData.get(0);	

			default:
				System.out.println("Unknown opcode!");
				return -1;
			}
		}		
	}
}
