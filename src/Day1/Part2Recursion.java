package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2Recursion {
	public static void main(String[] args) {
		String path = ".\\src\\Day1\\data.txt";
		File file = new File(path);
		List<Integer> modules = new ArrayList<>();
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextInt()) {
				modules.add(scan.nextInt());
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		int result = 0;
		for (int i = 0; i < modules.size(); i++) {
			int module = modules.get(i);

			result += findFuel(module);
		}

		System.out.println(result);

	}

	private static int findFuel(int mass) {
		int fuel = (int) Math.floor(mass / 3) - 2;

		if (fuel <=0)
			return 0;

		return fuel + findFuel(fuel);
	}
}