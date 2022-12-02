package Day4;

public class Part1 {
	public static void main(String[] args) {
		
		int counter = 0;
		for (int i = 387638; i <= 919123; i++) {
			String password = String.valueOf(i);
			boolean ok1 = true;
			boolean ok2 = false;
			for (int j = 0; j < password.length() - 1; j++) {
				if (password.charAt(j) > password.charAt(j + 1)) {
					ok1 = false;
				}
				if (password.charAt(j) == password.charAt(j + 1)) {
					ok2 = true;
				}
			}
			
			if (ok1 && ok2 ) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}
