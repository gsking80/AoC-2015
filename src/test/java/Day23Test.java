import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day23Test {

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day23/input.txt").getPath());
    final Day23 day23 = new Day23(fileReader);
    Assertions.assertThat(day23.runProgram()).containsEntry("b",170L);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day23/input.txt").getPath());
    final Day23 day23 = new Day23(fileReader);
    day23.setRegister("a", 1L);
    Assertions.assertThat(day23.runProgram()).containsEntry("b",247L);
  }

}