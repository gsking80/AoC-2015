package king.greg.aoc2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day16Test {

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day16/input.txt").getPath());
    final Day16 day16 = new Day16(fileReader);

    Assertions.assertThat(day16.findSue()).isEqualTo(373);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day16/input.txt").getPath());
    final Day16 day16 = new Day16(fileReader);

    Assertions.assertThat(day16.findSue2()).isEqualTo(260);
  }

}