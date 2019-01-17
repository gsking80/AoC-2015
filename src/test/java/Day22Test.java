import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day22Test {

  @Test
  public void testSolution1(){
    final Day22 day22 = new Day22();
    day22.defineBoss(51, 9);
    day22.defineWizard(50, 500);
    Assertions.assertThat(day22.minimumManaToWin()).isEqualTo(900);
  }

  @Test
  public void testSolution2(){
    final Day22 day22 = new Day22(true);
    day22.defineBoss(51, 9);
    day22.defineWizard(50, 500);
    Assertions.assertThat(day22.minimumManaToWin()).isEqualTo(1216); //1242 too high
  }

}