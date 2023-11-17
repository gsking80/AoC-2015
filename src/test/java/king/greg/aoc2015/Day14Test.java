package king.greg.aoc2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day14Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day14/Test1a.txt").getPath());
    final Day14 day14 = new Day14(fileReader);

    Assertions.assertThat(day14.getFastestAfter(1000)).isEqualTo(1120);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day14/input.txt").getPath());
    final Day14 day14 = new Day14(fileReader);

    Assertions.assertThat(day14.getFastestAfter(2503)).isEqualTo(2655);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day14/Test1a.txt").getPath());
    final Day14 day14 = new Day14(fileReader);

    Assertions.assertThat(day14.getWinnerAfter(1000)).isEqualTo(689);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day14/input.txt").getPath());
    final Day14 day14 = new Day14(fileReader);

    Assertions.assertThat(day14.getWinnerAfter(2503)).isEqualTo(1059);
  }

}