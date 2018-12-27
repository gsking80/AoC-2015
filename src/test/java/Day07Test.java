import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day07Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/Test1a.txt").getPath());
    final Day07 day07 = new Day07(fileReader);
    final Map<String, Integer> wires = day07.getWires();

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(wires.get("d")).isEqualTo(72);
    softly.assertThat(wires.get("e")).isEqualTo(507);
    softly.assertThat(wires.get("f")).isEqualTo(492);
    softly.assertThat(wires.get("g")).isEqualTo(114);
    softly.assertThat(wires.get("h")).isEqualTo(65412);
    softly.assertThat(wires.get("i")).isEqualTo(65079);
    softly.assertThat(wires.get("x")).isEqualTo(123);
    softly.assertThat(wires.get("y")).isEqualTo(456);
    softly.assertThat(wires.size()).isEqualTo(8);
    softly.assertAll();
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/input.txt").getPath());
    final Day07 day07 = new Day07(fileReader);
    final Map<String, Integer> wires = day07.getWires();

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(wires.get("a")).isEqualTo(72);
    softly.assertAll();
  }

}