import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day12Test {

  @Test
  public void test1a() {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day12.sumNumbers("[1,2,3]")).isEqualTo(6);
    softly.assertThat(Day12.sumNumbers("{\"a\":2,\"b\":4}")).isEqualTo(6);
    softly.assertThat(Day12.sumNumbers("[[[3]]]")).isEqualTo(3);
    softly.assertThat(Day12.sumNumbers("{\"a\":{\"b\":4},\"c\":-1}")).isEqualTo(3);
    softly.assertThat(Day12.sumNumbers("{\"a\":[-1,1]}")).isEqualTo(0);
    softly.assertThat(Day12.sumNumbers("[-1,{\"a\":1}]")).isEqualTo(0);
    softly.assertThat(Day12.sumNumbers("[]")).isEqualTo(0);
    softly.assertThat(Day12.sumNumbers("{}")).isEqualTo(0);
    softly.assertAll();
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day12/input.txt").getPath());
    String input ="";
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      input = buf.readLine();

    } catch (IOException ioe) {
      Assertions.fail("Shouldnagothere");
    }
    Assertions.assertThat(Day12.sumNumbers(input)).isEqualTo(111754);
  }

  @Test
  public void test2a() {
    final Day12 day12 = new Day12();
    Assertions.assertThat(day12.sumNonRedNumbers("[1,2,3]")).isEqualTo(6);
  }

  @Test
  public void test2b() {
    final Day12 day12 = new Day12();
    Assertions.assertThat(day12.sumNonRedNumbers("[1,{\"c\":\"red\",\"b\":2},3]")).isEqualTo(4);
  }

  @Test
  public void test2c() {
    final Day12 day12 = new Day12();
    Assertions.assertThat(day12.sumNonRedNumbers("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}")).isEqualTo(0);
  }

  @Test
  public void test2d() {
    final Day12 day12 = new Day12();
    Assertions.assertThat(day12.sumNonRedNumbers("[1,\"red\",5]")).isEqualTo(6);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day12/input.txt").getPath());
    String input ="";
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      input = buf.readLine();

    } catch (IOException ioe) {
      Assertions.fail("Shouldnagothere");
    }
    final Day12 day12 = new Day12();
    Assertions.assertThat(day12.sumNonRedNumbers(input)).isEqualTo(65402);
  }

}