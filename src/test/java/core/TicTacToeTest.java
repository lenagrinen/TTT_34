package core;

import java.io.*;
import java.util.*;
import org.testng.annotations.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TicTacToeTest {
	
	// String csvFile = "./tictactoe_10.csv";        // mvn site -Dtestcases="./primes_10.csv"
	String csvFile = System.getProperty("testcases"); 
	// String csvFile = "./qa_01.csv";
	
	@DataProvider(name = "Tic Tac Toe")
	public Iterator<String[]> data() throws IOException {
		String cvsLine = "";
		String[] a = null;
		ArrayList<String[]> al = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((cvsLine = br.readLine()) != null) {a = cvsLine.split(",");al.add(a);}
		br.close();
		return al.iterator();
	}

	@Test(timeOut = 1000, dataProvider = "Tic Tac Toe")
	public void test(String a, String b) {
		assertThat(TicTacToe.api(a, false), containsString(b));
	}
	
	@Test(enabled = false)
	public void win_X_01() {
		assertThat(TicTacToe.api("14253", false), containsString("X's won!"));
	}
	@Test(enabled = false)
	public void win_O_01() {
		assertThat(TicTacToe.api("415263", false), containsString("O's won!"));
	}
	@Test(enabled = false)
	public void draw_01() {
		assertThat(TicTacToe.api("153286479", false), containsString("Draw!"));
	}
	@Test(enabled = false)
	public void uncompleted_01() {
		assertThat(TicTacToe.api("12345", false), containsString("Game is not completed"));
	}
	@Test(enabled = false)
	public void error_handling_01() {
		assertThat(TicTacToe.api("1234", false), containsString("Should be at least 5 turns"));
	}
	@Test(enabled = false)
	public void error_handling_02() {
		assertThat(TicTacToe.api("1234567899", false), containsString("Should be the most 9 turns"));
	}
	@Test(enabled = false)
	public void error_handling_03() {
		assertThat(TicTacToe.api("112345", false), containsString("All turns must be unique"));
	}
	@Test(enabled = false)
	public void error_handling_04() {
		assertThat(TicTacToe.api("a12345", false), containsString("All turns must be a digit 1-9"));
	}
}
