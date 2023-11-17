package king.greg.aoc2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day17Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day17/Test1a.txt").getPath());
    final Day17 day17 = new Day17(fileReader);

    Assertions.assertThat(day17.storageOptions(25)).isEqualTo(4);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day17/input.txt").getPath());
    final Day17 day17 = new Day17(fileReader);

    Assertions.assertThat(day17.storageOptions(150)).isEqualTo(1304);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day17/Test1a.txt").getPath());
    final Day17 day17 = new Day17(fileReader);

    Assertions.assertThat(day17.storageOptionsMin(25)).isEqualTo(3);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day17/input.txt").getPath());
    final Day17 day17 = new Day17(fileReader);

    Assertions.assertThat(day17.storageOptionsMin(150)).isEqualTo(18);
  }

}