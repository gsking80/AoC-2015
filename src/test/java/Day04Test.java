import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day04Test {

  @Test
  public void test1a() {
    Assertions.assertThat(Day04.leadingZeros("abcdef", 5)).isEqualTo(609043);
  }

  @Test
  public void test1b() {
    Assertions.assertThat(Day04.leadingZeros("pqrstuv", 5)).isEqualTo(1048970);
  }

  @Test
  public void testSolution1() {
    Assertions.assertThat(Day04.leadingZeros("yzbqklnj", 5)).isEqualTo(282749);
  }


  @Test
  public void testSolution2() {
    Assertions.assertThat(Day04.leadingZeros("yzbqklnj", 6)).isEqualTo(9962624);
  }
}