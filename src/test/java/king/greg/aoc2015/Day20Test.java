package king.greg.aoc2015;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day20Test {

  @Test
  public void test1a() {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day20.firstHouseWithAtLeast(10)).isEqualTo(1);
    softly.assertThat(Day20.firstHouseWithAtLeast(30)).isEqualTo(2);
    softly.assertThat(Day20.firstHouseWithAtLeast(40)).isEqualTo(3);
    softly.assertThat(Day20.firstHouseWithAtLeast(70)).isEqualTo(4);
    softly.assertThat(Day20.firstHouseWithAtLeast(120)).isEqualTo(6);
    softly.assertThat(Day20.firstHouseWithAtLeast(80)).isEqualTo(6);
    softly.assertThat(Day20.firstHouseWithAtLeast(150)).isEqualTo(8);
    softly.assertAll();
  }

  @Test
  public void testSolution1() {
    Assertions.assertThat(Day20.firstHouseWithAtLeast(33100000)).isEqualTo(776160);
  }

  @Test
  public void testSolution2() {
    Assertions.assertThat(Day20.firstHouseWithAtLeastPart2(33100000)).isEqualTo(786240);
  }

}