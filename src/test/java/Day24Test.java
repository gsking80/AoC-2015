import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day24Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day24/test1a.txt").getPath());
    final Day24 day24 = new Day24(fileReader);
    Assertions.assertThat(day24.smallestQE(3)).isEqualTo(99);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day24/input.txt").getPath());
    final Day24 day24 = new Day24(fileReader);
    Assertions.assertThat(day24.smallestQE(3)).isEqualTo(11846773891L);  // 67601337186L is too high...
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day24/test1a.txt").getPath());
    final Day24 day24 = new Day24(fileReader);
    Assertions.assertThat(day24.smallestQE(4)).isEqualTo(44);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day24/input.txt").getPath());
    final Day24 day24 = new Day24(fileReader);
    Assertions.assertThat(day24.smallestQE(4)).isEqualTo(80393059L);
  }

}