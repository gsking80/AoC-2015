import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day09Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day09/Test1a.txt").getPath());
    final Day09 day09 = new Day09(fileReader);

    Assertions.assertThat(day09.getShortestDistance()).isEqualTo(605);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day09/input.txt").getPath());
    final Day09 day09 = new Day09(fileReader);

    Assertions.assertThat(day09.getShortestDistance()).isEqualTo(141);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day09/Test1a.txt").getPath());
    final Day09 day09 = new Day09(fileReader);

    Assertions.assertThat(day09.getLongestDistance()).isEqualTo(982);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day09/input.txt").getPath());
    final Day09 day09 = new Day09(fileReader);

    Assertions.assertThat(day09.getLongestDistance()).isEqualTo(736);
  }

}