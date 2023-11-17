package king.greg.aoc2015;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day11Test {

  @Test
  public void test1a() {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day11.validate("hijklmn")).isFalse();
    softly.assertThat(Day11.validate("abbceffg")).isFalse();
    softly.assertThat(Day11.validate("abbcegjk")).isFalse();
    softly.assertThat(Day11.validate("abcdffaa")).isTrue();
    softly.assertThat(Day11.validate("ghjaabcc")).isTrue();
    softly.assertAll();
  }

  @Test
  public void test1b() {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day11.increment("aaaaaaaa")).isEqualTo("aaaaaaab");
    softly.assertThat(Day11.increment("aaaaaaaz")).isEqualTo("aaaaaaba");
    softly.assertThat(Day11.increment("yzzzzzzz")).isEqualTo("zaaaaaaa");
    softly.assertAll();
  }

  @Test
  public void test1c() {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day11.nextPassword("abcdefgh")).isEqualTo("abcdffaa");
    softly.assertThat(Day11.nextPassword("ghijklmn")).isEqualTo("ghjaabcc");
    softly.assertAll();
  }

  @Test
  public void testSolution1() {
    Assertions.assertThat(Day11.nextPassword("hxbxwxba")).isEqualTo("hxbxxyzz");
  }

  @Test
  public void testSolution2() {
    Assertions.assertThat(Day11.nextPassword("hxbxxyzz")).isEqualTo("hxcaabcc");
  }

}