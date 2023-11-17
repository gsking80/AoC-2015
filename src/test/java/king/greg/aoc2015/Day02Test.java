package king.greg.aoc2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day02Test {

  @Test
  public void test1a() {
    Assertions.assertThat(Day02.paperNeeded(2,3,4)).isEqualTo(58);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day02/input.txt").getPath());
    final Day02 day02 = new Day02(fileReader);
    Assertions.assertThat(day02.paperNeeded()).isEqualTo(1586300);
  }

  @Test
  public void test2a() {
    Assertions.assertThat(Day02.ribbonNeeded(2,3,4)).isEqualTo(34);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day02/input.txt").getPath());
    final Day02 day02 = new Day02(fileReader);
    Assertions.assertThat(day02.ribbonNeeded()).isEqualTo(3737498);
  }

}