import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day19Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day19/Test1a.txt").getPath());
    final Day19 day19 = new Day19(fileReader);

    Assertions.assertThat(day19.expand("HOH")).isEqualTo(4);
  }

  @Test
  public void test1b() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day19/Test1a.txt").getPath());
    final Day19 day19 = new Day19(fileReader);

    Assertions.assertThat(day19.expand("HOHOHO")).isEqualTo(7);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day19/input.txt").getPath());
    final Day19 day19 = new Day19(fileReader);

    Assertions.assertThat(day19.expand("CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr")).isEqualTo(509);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day19/Test2a.txt").getPath());
    final Day19 day19 = new Day19(fileReader);

    Assertions.assertThat(day19.fabricate("HOH")).isEqualTo(3);
  }

  @Test
  public void test2b() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day19/Test2a.txt").getPath());
    final Day19 day19 = new Day19(fileReader);

    Assertions.assertThat(day19.fabricate("HOHOHO")).isEqualTo(6);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(
        getClass().getClassLoader().getResource("Day19/input.txt").getPath());
    final Day19 day19 = new Day19(fileReader);

    Assertions.assertThat(day19.fabricate("CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr")).isEqualTo(195);
  }

}