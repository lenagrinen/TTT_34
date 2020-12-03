package core;

public class TDG {
	
	static int count = 2_000_000;
	
	static void getMoves(int length, String result) {
		for (int i = 0; i < count; i++) { 
			int s = randomNumber(length);
			if (isDistinct(s)) {
				if (TicTacToe.api(String.valueOf(s), false).contains(result))
				System.out.println(s + "," + result); else continue;
							   } 
			else continue;
										}
													};
  
public static int randomNumber(int length) {
	int size = 0;
	if (length == 5) {size = 10000;}
	else if (length == 6) {size = 100000;}
	else if (length == 7) {size = 1000000;}
	else if (length == 8) {size = 10000000;}
	else if (length == 9) {size = 100000000;};
	return (int) (size +  Math.round(Math.random() * size));

}

public static boolean isDistinct(int number) {
	if (String.valueOf(number).matches("^.*(.).*\\1.*$") || String.valueOf(number).contains("0")) {return false;} else {return true;}
}

	public static void main(String[] args) {
		
//		getMoves(9, "Draw");
//		getMoves(5, "X won");
		getMoves(7, "O won");
		
//		System.out.println(TicTacToe.api("159287364", false));  // Draw
//		System.out.println(TicTacToe.api("14352", false));  	// X won
//		System.out.println(TicTacToe.api("415263", false));  	// O won
	}
}
