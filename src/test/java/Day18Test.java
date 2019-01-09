import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day18Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day18/Test1a.txt").getPath());
    final Day18 day18 = new Day18(fileReader);

    Assertions.assertThat(day18.lightsOn(4)).isEqualTo(4);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day18/input.txt").getPath());
    final Day18 day18 = new Day18(fileReader);

    Assertions.assertThat(day18.lightsOn(100)).isEqualTo(768);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day18/Test1a.txt").getPath());
    final Day18 day18 = new Day18(fileReader, true);

    Assertions.assertThat(day18.lightsOn(5)).isEqualTo(17);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day18/input.txt").getPath());
    final Day18 day18 = new Day18(fileReader, true);

    Assertions.assertThat(day18.lightsOn(100)).isEqualTo(781);
  }

}