package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		String path = ".\\src\\Day1\\data.txt";
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			List<Integer> modules = new ArrayList<>();
			
			while (scan.hasNextInt()) {
				modules.add(scan.nextInt());
			}
			
			scan.close();
			
			int result = 0;
			for (int i = 0; i < modules.size(); i++) {
				int module = modules.get(i);
				int fuel = (int) Math.floor(module / 3) - 2;
				int sumFuel = 0;
				int fuelForFuel = fuel;
				while (true) {
					
					fuelForFuel = (int) Math.floor(fuelForFuel / 3) - 2;
					if (fuelForFuel <= 0) {
						break;
					}
					
					sumFuel += fuelForFuel;
				}
				
				result += fuel; 
				result += sumFuel;
			}
			
			System.out.println(result);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
