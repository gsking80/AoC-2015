package king.greg.aoc2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day07Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/Test1a.txt").getPath());
    final Day07 day07 = new Day07(fileReader);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(day07.value("d")).isEqualTo(72);
    softly.assertThat(day07.value("e")).isEqualTo(507);
    softly.assertThat(day07.value("f")).isEqualTo(492);
    softly.assertThat(day07.value("g")).isEqualTo(114);
    softly.assertThat(day07.value("h")).isEqualTo(65412);
    softly.assertThat(day07.value("i")).isEqualTo(65079);
    softly.assertThat(day07.value("x")).isEqualTo(123);
    softly.assertThat(day07.value("y")).isEqualTo(456);
    softly.assertAll();
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/input.txt").getPath());
    final Day07 day07 = new Day07(fileReader);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(day07.value("a")).isEqualTo(3176);
    softly.assertAll();
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/input2.txt").getPath());
    final Day07 day07 = new Day07(fileReader);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(day07.value("a")).isEqualTo(14710);
    softly.assertAll();
  }

}