import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day15Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day15/Test1a.txt").getPath());
    final Day15 day15 = new Day15(fileReader);

    Assertions.assertThat(day15.maximumScore()).isEqualTo(62842880);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day15/input.txt").getPath());
    final Day15 day15 = new Day15(fileReader);

    Assertions.assertThat(day15.maximumScore()).isEqualTo(18965440);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day15/Test1a.txt").getPath());
    final Day15 day15 = new Day15(fileReader);

    Assertions.assertThat(day15.maximumScore(500)).isEqualTo(57600000);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day15/input.txt").getPath());
    final Day15 day15 = new Day15(fileReader);

    Assertions.assertThat(day15.maximumScore(500)).isEqualTo(15862900);
  }

}