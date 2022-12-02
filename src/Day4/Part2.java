package Day4;

public class Part2 {
	public static void main(String[] args) {
		
		int counter = 0;
		for (int i = 387638; i <= 919123; i++) {
			String password = String.valueOf(i);
			boolean ok1 = true;
			boolean ok2 = false;
			int[] arr = new int[10];
			for (int j = 0; j < password.length() - 1; j++) {
				if (password.charAt(j) > password.charAt(j + 1)) {
					ok1 = false;
				}
				if (password.charAt(j) == password.charAt(j + 1)) {
					ok2 = true;
					int value = Integer.parseInt(String.valueOf(password.charAt(j)));
					arr[value] += 1; 
				}
			}
			
			boolean ok3 = false;
			for (int k = 0; k < arr.length; k++) {
				int am = 0;
				if(arr[k] == 1) {
					am++;
				}
				if (am == 1) {
					ok3 = true;
				}
			}
			
			if (ok1 && ok2 && ok3 ) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}
