package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Part1 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day3\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		List<String> map = new ArrayList<>();
		while (scan.hasNextLine()) {
			map.add(scan.nextLine());
		}
				
		scan.close();	
		
		System.out.println(intersectionSearch(map));

	}
	
	public static int intersectionSearch(List<String> map) {
		int min = Integer.MAX_VALUE;
		int distance = 0;
		
		Set<String> hashSet = new HashSet<>();
		
		for (int i = 0; i < map.size(); i++) {
			String[] coord = map.get(i).split(",");
			int x = 0;
			int y = 0;
			
			for (int j = 0; j < coord.length; j++) {
				char direction = coord[j].charAt(0);
				int value = Integer.parseInt(coord[j].substring(1, coord[j].length()));
			
				switch (direction) {
				case 'R':
					for (int k = 0; k < value; k++) {
						x ++;
						if (i == 0) {
							hashSet.add(Integer.toString(x) + "," + Integer.toString(y));
						} else {
							distance = x + y;
							if (hashSet.contains(Integer.toString(x) + "," + Integer.toString(y)) && distance < min) {
								min = distance;
							}
						}	
					}
					break;
					
				case 'L':
					for (int k = 0; k < value; k++) {
						x --;
						if (i == 0) {
							hashSet.add(Integer.toString(x) + "," + Integer.toString(y));
						} else {
							distance = x + y;
							if (hashSet.contains(Integer.toString(x) + "," + Integer.toString(y)) && distance < min) {
								min = distance;
							}
						}	
					}
					break;
					
				case 'U':
					for (int k = 0; k < value; k++) {
						y ++;
						if (i == 0) {
							hashSet.add(Integer.toString(x) + "," + Integer.toString(y));
						} else {
							distance = x + y;
							if (hashSet.contains(Integer.toString(x) + "," + Integer.toString(y)) && distance < min) {
								min = distance;
							}
						}	
					}
					break;
					
				case 'D':
					for (int k = 0; k < value; k++) {
						y --;
						if (i == 0) {
							hashSet.add(Integer.toString(x) + "," + Integer.toString(y));
						} else {
							distance = x + y;
							if (hashSet.contains(Integer.toString(x) + "," + Integer.toString(y)) && distance < min) {
								min = distance;
							}
						}	
					}
					break;
	
				default:
					System.out.println("Error1!");
				}
			}
		}
		return min;
	}
	
}
