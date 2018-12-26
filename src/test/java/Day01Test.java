import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day01Test {

  @Test
  public void test1a(){
    Assertions.assertThat(Day01.floorReacher("(())")).isEqualTo(0);
  }

  @Test
  public void Solution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day01/input.txt").getPath());
    String input ="";
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

        input = buf.readLine();

    } catch (IOException ioe) {
      Assertions.fail("Shouldnagothere");
    }
    Assertions.assertThat(Day01.floorReacher(input)).isEqualTo(280);
  }

  @Test
  public void Solution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day01/input.txt").getPath());
    String input ="";
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      input = buf.readLine();

    } catch (IOException ioe) {
      Assertions.fail("Shouldnagothere");
    }
    Assertions.assertThat(Day01.floorReacher(input, -1)).isEqualTo(280);
  }

}