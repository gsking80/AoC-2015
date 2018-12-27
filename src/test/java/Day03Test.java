import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day03Test {

  @Test
  public void test1a() {
    final Day03 day03 = new Day03(">");
    Assertions.assertThat(day03.totalHouses()).isEqualTo(2);
  }

  @Test
  public void test1b() {
    final Day03 day03 = new Day03("^>v<");
    Assertions.assertThat(day03.totalHouses()).isEqualTo(4);
  }

  @Test
  public void test1c() {
    final Day03 day03 = new Day03("^v^v^v^v^v");
    Assertions.assertThat(day03.totalHouses()).isEqualTo(2);
  }


  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day03/input.txt").getPath());
    String input ="";
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      input = buf.readLine();

    } catch (IOException ioe) {
      Assertions.fail("Shouldnagothere");
    }
    final Day03 day03 = new Day03(input);
    Assertions.assertThat(day03.totalHouses()).isEqualTo(2081);
  }

  @Test
  public void test2a() {
    final Day03 day03 = new Day03("^v", true);
    Assertions.assertThat(day03.totalHouses()).isEqualTo(3);
  }

  @Test
  public void test2b() {
    final Day03 day03 = new Day03("^>v<", true);
    Assertions.assertThat(day03.totalHouses()).isEqualTo(3);
  }

  @Test
  public void test2c() {
    final Day03 day03 = new Day03("^v^v^v^v^v", true);
    Assertions.assertThat(day03.totalHouses()).isEqualTo(11);
  }


  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day03/input.txt").getPath());
    String input ="";
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      input = buf.readLine();

    } catch (IOException ioe) {
      Assertions.fail("Shouldnagothere");
    }
    final Day03 day03 = new Day03(input, true);
    Assertions.assertThat(day03.totalHouses()).isEqualTo(2341);
  }
}