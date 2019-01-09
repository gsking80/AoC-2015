import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day19 {

  final List<String> expansions;

  public Day19(final FileReader fileReader) {
    expansions = new ArrayList<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          expansions.add(line);
        }
      }
    } catch (IOException ioe) {

    }
  }

  public int expand(final String molecule){
    final Set<String> molecules = new HashSet<>();
    molecules.add(molecule);
    return expansions(molecules).size();
  }

  private Set<String> expansions(final Set<String> baseMolecules){
    final Set<String> newMolecules = new HashSet<>();
    for(final String molecule: baseMolecules) {
      for (final String expansion : expansions) {
        final String[] split = expansion.split(" => ");
        int index = 0;
        while (true) {
          index = molecule.indexOf(split[0], index);
          if (index == -1) {
            break;
          }
          final StringBuilder builder = new StringBuilder();
          if (index > 0) {
            builder.append(molecule.substring(0, index));
          }
          builder.append(split[1]);
          if (index + split[0].length() < molecule.length()) {
            builder.append(molecule.substring(index + split[0].length()));
          }
          newMolecules.add(builder.toString());
          index++;
        }
      }
    }
    return newMolecules;
  }

  public int fabricate(final String molecule) {
    int steps = 0;
    final Set<String> possibilities = new HashSet<>();
    possibilities.add(molecule);
    while(!possibilities.contains("e")){
      Set<String> candidates = new HashSet<>();
      for(final String possibility: possibilities){
        for(final String expansion: expansions) {
          final String[] split = expansion.split(" => ");
          if (possibility.contains(split[1])) {
            final int index = possibility.lastIndexOf(split[1]);
            final StringBuilder builder = new StringBuilder();
            if (index > 0) {
              builder.append(possibility.substring(0, index));
            }
            builder.append(split[0]);
            if (index + split[1].length() < possibility.length()) {
              builder.append(possibility.substring(index + split[1].length()));
            }
            candidates.add(builder.toString());
          }
        }
      }
      Set<String> next = new HashSet<>();
      candidates.stream().filter(p -> !possibilities.contains(p)).filter(p -> p.length() == 1 || !p.contains("e")).sorted((a,b) -> a.length() - b.length()).limit(5).forEach(s -> next.add(s));
      if (next.isEmpty()) {
        return -1;
      }
      possibilities.clear();
      possibilities.addAll(next);
      steps++;
      System.out.println("------ After Step " + steps + " -------");
      System.out.println(possibilities);
    }
    return steps;
  }

}
