import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day10Test {

  @Test
  public void test1a() {
    final SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day10.lookAndSay("1")).isEqualTo("11");
    softly.assertThat(Day10.lookAndSay("11")).isEqualTo("21");
    softly.assertThat(Day10.lookAndSay("21")).isEqualTo("1211");
    softly.assertThat(Day10.lookAndSay("1211")).isEqualTo("111221");
    softly.assertThat(Day10.lookAndSay("111221")).isEqualTo("312211");
    softly.assertThat(Day10.lookAndSay("1", 5)).isEqualTo("312211");
    softly.assertAll();
  }

  @Test
  public void testSolution1() {
    Assertions.assertThat(Day10.lookAndSay("1113122113", 40).length()).isEqualTo(360154);
  }

  @Test
  public void testSolution2() {
    Assertions.assertThat(Day10.lookAndSay("1113122113", 50).length()).isEqualTo(5103798);
  }

}