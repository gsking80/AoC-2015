import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day08Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day08/Test1a.txt").getPath());
    final Day08 day08 = new Day08(fileReader);

    Assertions.assertThat(day08.getDifference()).isEqualTo(12);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day08/input.txt").getPath());
    final Day08 day08 = new Day08(fileReader);

    Assertions.assertThat(day08.getDifference()).isEqualTo(1350);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day08/Test1a.txt").getPath());
    final Day08 day08 = new Day08(fileReader);

    Assertions.assertThat(day08.getEncodedDifference()).isEqualTo(19);
  }


  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day08/input.txt").getPath());
    final Day08 day08 = new Day08(fileReader);

    Assertions.assertThat(day08.getEncodedDifference()).isEqualTo(2085);
  }

}