package wordocc;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

//Author Name: Mehrdad Ghazi
//Date: 7/10/2022
//Test Program Name: Ghazi_NullValueTest
//Purpose: Testing values that aren't in the word occurrences list, expected to receive null values

class Ghazi_NullValueTest {

	@Test
	void test() {
		
		Map<String, Integer> test = Ghazi_TextAnalyzer.buildWordMap("src/macbeth.txt");
		
		//testing values that are not in the map to make sure they return null
		assertEquals(null, test.get("seminole"));
		
	}

}
