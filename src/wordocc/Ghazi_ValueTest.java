package wordocc;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

//Author Name: Mehrdad Ghazi
//Date: 7/10/2022
//Test Program Name: Ghazi_ValueTest
//Purpose: Testing values that are in the test list to figure out if this is outputting the correct value

class Ghazi_ValueTest {

	@Test
	void test() {
		
		Map<String, Integer> test = Ghazi_TextAnalyzer.buildWordMap("src/test.txt");
		
		/*testing values that are in the map to make sure they return the correct key. The test.txt contains
		the word test five times. Therefore, the value associated with that word should be 5. */
		assertEquals(5, test.get("test"));
		
	}

}
