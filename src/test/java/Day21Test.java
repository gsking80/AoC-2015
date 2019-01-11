import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day21Test {

  @Test
  public void test1a() {
    Assertions.assertThat(Day21.beatBoss(8,5,5,12,7,2)).isTrue();
  }

  @Test
  public void testSolution1() {
    final Day21 day21 = new Day21();
    Assertions.assertThat(day21.minCostToBeatBoss(100, 8, 2)).isEqualTo(91);
  }

  @Test
  public void test2a() {
    Assertions.assertThat(Day21.beatBoss(100,3,6,100,8,2)).isFalse();
  }

  @Test
  public void testSolution2() {
    final Day21 day21 = new Day21();
    Assertions.assertThat(day21.maxCostToLoseBoss(100, 8, 2)).isEqualTo(158);
  }



}