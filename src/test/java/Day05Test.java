import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day05Test {

  @Test
  public void test1a() {
    Assertions.assertThat(Day05.nice("ugknbfddgicrmopn")).isTrue();
  }

  @Test
  public void test1b() {
    Assertions.assertThat(Day05.nice("aaa")).isTrue();
  }

  @Test
  public void test1c() {
    Assertions.assertThat(Day05.nice("jchzalrnumimnmhp")).isFalse();
  }

  @Test
  public void test1d() {
    Assertions.assertThat(Day05.nice("haegwjzuvuyypxyu")).isFalse();
  }

  @Test
  public void test1e() {
    Assertions.assertThat(Day05.nice("dvszwmarrgswjxmb")).isFalse();
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day05/input.txt").getPath());
    final Day05 day05 = new Day05(fileReader);
    Assertions.assertThat(day05.getNiceStrings()).isEqualTo(238);
  }

  @Test
  public void test2a() {
    Assertions.assertThat(Day05.newNice("qjhvhtzxzqqjkmpb")).isTrue();
  }

  @Test
  public void test2b() {
    Assertions.assertThat(Day05.newNice("xxyxx")).isTrue();
  }

  @Test
  public void test2c() {
    Assertions.assertThat(Day05.newNice("uurcxstgmygtbstg")).isFalse();
  }

  @Test
  public void test2d() {
    Assertions.assertThat(Day05.newNice("ieodomkazucvgmuy")).isFalse();
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day05/input.txt").getPath());
    final Day05 day05 = new Day05(fileReader, true);
    Assertions.assertThat(day05.getNiceStrings()).isEqualTo(69);
  }

}