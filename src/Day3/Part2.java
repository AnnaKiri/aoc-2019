package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Part2 {
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
		
		Set<String> hashSet = new HashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		for (int i = 0; i < map.size(); i++) {
			String[] coord = map.get(i).split(",");
			int x = 0;
			int y = 0;
			int steps = 0;
			
			for (int j = 0; j < coord.length; j++) {
				char direction = coord[j].charAt(0);
				int value = Integer.parseInt(coord[j].substring(1, coord[j].length()));

				switch (direction) {
				case 'R':
					for (int k = 0; k < value; k++) {
						x++;
						
						String coord1 = Integer.toString(x) + "," + Integer.toString(y);
						if (i == 0) {
							hashSet.add(coord1);
						} else {
							steps++;
							if (hashSet.contains(coord1)) {
								treeSet.add(steps + findStepsSum(map.get(0), coord1));					
							}
						}	
					}
					break;
					
				case 'L':
					for (int k = 0; k < value; k++) {
						x--;
						
						String coord1 = Integer.toString(x) + "," + Integer.toString(y);
						if (i == 0) {
							hashSet.add(coord1);
						} else {
							steps++;
							if (hashSet.contains(coord1)) {
								treeSet.add(steps + findStepsSum(map.get(0), coord1));	
							}
						}	
					}
					break;
					
				case 'U':
					for (int k = 0; k < value; k++) {
						y++;
						
						String coord1 = Integer.toString(x) + "," + Integer.toString(y);
						if (i == 0) {
							hashSet.add(coord1);
						} else {
							steps++;
							if (hashSet.contains(coord1)) {
								treeSet.add(steps + findStepsSum(map.get(0), coord1));	
							}
						}	
					}
					break;
					
				case 'D':
					for (int k = 0; k < value; k++) {
						y--;
						
						String coord1 = Integer.toString(x) + "," + Integer.toString(y);
						if (i == 0) {
							hashSet.add(coord1);
						} else {
							steps++;
							if (hashSet.contains(coord1)) {
								treeSet.add(steps + findStepsSum(map.get(0), coord1));	
							}
						}	
					}
					break;
	
				default:
					System.out.println("Error1!");
					break;
				}
			}
		}
		
		return treeSet.first();
	}
	
	public static int findStepsSum(String coord, String coord1) {
		
		String[] oneWireCoord = coord.split(",");
		int x = 0;
		int y = 0;
		int steps = 0;
		for (int l = 0; l < oneWireCoord.length; l++) {
			char direction = oneWireCoord[l].charAt(0);
			int value = Integer.parseInt(oneWireCoord[l].substring(1, oneWireCoord[l].length()));
			switch (direction) {
			case 'R':
				for (int r = 0; r < value; r++) {
					x++;
					steps++;
					String coord2 = Integer.toString(x) + "," + Integer.toString(y);
					if (coord2.equals(coord1)) {
						return steps;
					}
				}
				break;
				
			case 'L':
				for (int r = 0; r < value; r++) {
					x--;
					steps++;
					String coord2 = Integer.toString(x) + "," + Integer.toString(y);
					if (coord2.equals(coord1)) {
						return steps;
					}
				}
				break;
				
			case 'U':
				for (int r = 0; r < value; r++) {
					y++;
					steps++;
					String coord2 = Integer.toString(x) + "," + Integer.toString(y);
					if (coord2.equals(coord1)) {
						return steps;
					}
				}
				break;
				
			case 'D':
				for (int r = 0; r < value; r++) {
					y--;
					steps++;
					String coord2 = Integer.toString(x) + "," + Integer.toString(y);
					if (coord2.equals(coord1)) {
						return steps;
					}
				}
				break;

			default:
				System.out.println("Error1!");
				break;
			}
		}
		
		return -1;
		
	}
	
}
