import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day16 {

  final Set<Sue> sues;

  public Day16(final FileReader fileReader){
    sues = new HashSet<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          final String[] bits = line.split("Sue |: |, ");
          final Sue sue = new Sue(Integer.valueOf(bits[1]));
          for(int i = 2; i < bits.length; i += 2) {
            sue.addAttribute(bits[i], Integer.valueOf(bits[i+1]));
          }
          sues.add(sue);
        }
      }
    } catch (IOException ioe) {

    }
  }

  public int findSue() {
    return (int)sues.stream()
        .filter(sue -> sue.attributeTest("children", 3))
        .filter(sue -> sue.attributeTest("cats", 7))
        .filter(sue -> sue.attributeTest("samoyeds", 2))
        .filter(sue -> sue.attributeTest("pomeranians", 3))
        .filter(sue -> sue.attributeTest("akitas", 0))
        .filter(sue -> sue.attributeTest("vizslas", 0))
        .filter(sue -> sue.attributeTest("goldfish", 5))
        .filter(sue -> sue.attributeTest("trees", 3))
        .filter(sue -> sue.attributeTest("cars", 2))
        .filter(sue -> sue.attributeTest("perfumes", 1))
        .findFirst().orElseThrow(RuntimeException::new)
        .getNumber();
  }

  public int findSue2() {
    return (int)sues.stream()
        .filter(sue -> sue.attributeTest("children", 3))
        .filter(sue -> sue.attributeTestGreater("cats", 7))
        .filter(sue -> sue.attributeTest("samoyeds", 2))
        .filter(sue -> sue.attributeTestFewer("pomeranians", 3))
        .filter(sue -> sue.attributeTest("akitas", 0))
        .filter(sue -> sue.attributeTest("vizslas", 0))
        .filter(sue -> sue.attributeTestFewer("goldfish", 5))
        .filter(sue -> sue.attributeTestGreater("trees", 3))
        .filter(sue -> sue.attributeTest("cars", 2))
        .filter(sue -> sue.attributeTest("perfumes", 1))
        .findFirst().orElseThrow(RuntimeException::new)
        .getNumber();
  }

  class Sue {
    private final int number;
    private Map<String,Integer> attributes;

    public Sue(final int number){
      this.number = number;
      attributes = new HashMap<>();
    }

    public void addAttribute(final String attribute, final Integer value){
      attributes.put(attribute,value);
    }

    public boolean attributeTest(final String attribute, final Integer test) {
      final Integer value = attributes.get(attribute);
      return (null == value || value.equals(test));
    }

    public boolean attributeTestGreater(final String attribute, final Integer test) {
      final Integer value = attributes.get(attribute);
      return (null == value || value > test);
    }

    public boolean attributeTestFewer(final String attribute, final Integer test) {
      final Integer value = attributes.get(attribute);
      return (null == value || value < test);
    }

    public int getNumber() {
      return number;
    }
  }

}
