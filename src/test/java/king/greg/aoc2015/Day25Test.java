package king.greg.aoc2015;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day25Test {

  @Test
  public void test1a() {
    Assertions.assertThat(Day25.getCode(1,1)).isEqualTo(20151125);
  }

  @Test
  public void test2a() {
    Assertions.assertThat(Day25.getCode(6,6)).isEqualTo(27995004);
  }

  @Test
  public void solution1() {
    Assertions.assertThat(Day25.getCode(3010, 3019)).isEqualTo(8997277);
  }

}