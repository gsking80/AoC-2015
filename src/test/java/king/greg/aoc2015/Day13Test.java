package king.greg.aoc2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day13Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day13/Test1a.txt").getPath());
    final Day13 day13 = new Day13(fileReader);

    Assertions.assertThat(day13.getMaximumHappiness()).isEqualTo(330);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day13/input.txt").getPath());
    final Day13 day13 = new Day13(fileReader);

    Assertions.assertThat(day13.getMaximumHappiness()).isEqualTo(618);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day13/input.txt").getPath());
    final Day13 day13 = new Day13(fileReader, true);

    Assertions.assertThat(day13.getMaximumHappiness()).isEqualTo(601);
  }
}