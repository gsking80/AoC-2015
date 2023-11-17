package king.greg.aoc2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Day24 {

  final List<Integer> packageWeights;
  int smallestGrouping;

  Day24(final FileReader fileReader) {
    packageWeights = new ArrayList<>();
    smallestGrouping = Integer.MAX_VALUE;
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          packageWeights.add(Integer.valueOf(line));
        }
      }
    } catch (IOException ioe) {

    }
  }

  public long smallestQE(final int groups) {
    final int totalWeight = packageWeights.stream().mapToInt(Integer::intValue).sum();
    final int targetWeight = totalWeight / groups;
    System.out.println("Total Weight: " + totalWeight);
    System.out.println("Target Weight: " + targetWeight);
    Collections.sort(packageWeights, Comparator.comparingInt(Integer::intValue).reversed());
    System.out.println(packageWeights);
    final List<List<Integer>> potentialGroups = groupPackages(new ArrayList<>(), new Vector<>(), 0, targetWeight);
    System.out.println(potentialGroups);
    return potentialGroups.stream().mapToLong(p -> p.stream().mapToLong(Integer::longValue).reduce(1, Math::multiplyExact)).min().orElse(-1);
  }

  private List<List<Integer>> groupPackages(List<List<Integer>> groups, Vector<Integer> current, final int currentPackage, final int targetWeight) {
    current.add(packageWeights.get(currentPackage));
    if (current.stream().mapToInt(Integer::intValue).sum() > targetWeight) {

    } else if (current.size() > smallestGrouping) {

    } else if (current.stream().mapToInt(Integer::intValue).sum() == targetWeight) {
      if (current.size() < smallestGrouping) {
        groups.clear();
        smallestGrouping = current.size();
      }
      final List<Integer> currentCopy = new ArrayList<>();
      currentCopy.addAll(current);
      groups.add(currentCopy);
    } else if (currentPackage + 1 < packageWeights.size()) {
      groups = groupPackages(groups, current, currentPackage + 1, targetWeight);
    }
    current.remove(packageWeights.get(currentPackage));
    if (currentPackage + 1 < packageWeights.size()) {
      groups = groupPackages(groups, current, currentPackage + 1, targetWeight);
    }
    return groups;
  }
}
