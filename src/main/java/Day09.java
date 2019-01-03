import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day09 {

  Map<String, Map<String,Integer>> distances;
  Travel travel;

  public Day09(final FileReader fileReader) {
    distances = new HashMap<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      final Set<String> cities = new HashSet<>();
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          final String[] lineBits = line.split(" to | = ");
          Map<String,Integer> cityA = distances.get(lineBits[0]);
          Map<String,Integer> cityB = distances.get(lineBits[1]);
          if (null == cityA){
            cityA = new HashMap<>();
            distances.put(lineBits[0],cityA);
          }
          if (null == cityB){
            cityB = new HashMap<>();
            distances.put(lineBits[1],cityB);
          }
          cityA.put(lineBits[1],Integer.valueOf(lineBits[2]));
          cityB.put(lineBits[0],Integer.valueOf(lineBits[2]));
          cities.add(lineBits[0]);
          cities.add(lineBits[1]);
        }
      }
      System.out.println(distances);
      travel = new Travel(cities);
    } catch (IOException ioe) {

    }
  }

  public int getShortestDistance() {
    double temperature = 1000000000000L;
    double coolingRate = .999;
    int numberOfIterations = 10000000;
    int bestDistance = travel.getDistance();
    Travel bestSolution = travel;
    Travel currentSolution = bestSolution;
    for (int i = 0; i < numberOfIterations; i++) {
      if (temperature > 0.1){
        currentSolution.swapCities();
        int currentDistance = currentSolution.getDistance();
        if (currentDistance < bestDistance) {
          bestDistance = currentDistance;
        } else if (Math.exp((bestDistance - currentDistance) / temperature) < Math.random()) {
          currentSolution.revertSwap();
        }
        temperature *= coolingRate;
      } else {
        continue;
      }
      if (i % 100 == 0) {
//        System.out.println("Iteration #" + i);
      }
    }
    return bestDistance;
  }

  public int getLongestDistance() {
    double temperature = 1000000000000L;
    double coolingRate = .999;
    int numberOfIterations = 10000000;
    int bestDistance = travel.getDistance();
    Travel bestSolution = travel;
    Travel currentSolution = bestSolution;
    for (int i = 0; i < numberOfIterations; i++) {
      if (temperature > 0.1){
        currentSolution.swapCities();
        int currentDistance = currentSolution.getLongestDistance();
        if (currentDistance > bestDistance) {
          bestDistance = currentDistance;
        } else if (Math.exp((currentDistance - bestDistance) / temperature) < Math.random()) {
          currentSolution.revertSwap();
        }
        temperature *= coolingRate;
      } else {
        continue;
      }
      if (i % 100 == 0) {
//        System.out.println("Iteration #" + i);
      }
    }
    return bestDistance;
  }

  public class Travel {
    private List<String> travel;
    private List<String> previousTravel;

    public Travel(final Set<String> cities) {
      travel = new ArrayList<>(cities);
      Collections.shuffle(travel);
      System.out.println(cities + " -- " + travel);
    }

    public void swapCities() {
      int a = generateRandomIndex();
      int b = generateRandomIndex();
      previousTravel = travel;
      String x = travel.get(a);
      String y = travel.get(b);
      travel.set(a,y);
      travel.set(b,x);
    }

    public void revertSwap() {
      travel = previousTravel;
    }

    public int getDistance() {
      int distance = 0;
      int longestLeg = 0;
      String starting = travel.get(0);
      String destination;
      for (int index = 1; index < travel.size(); index++){
        destination = travel.get(index);
//        System.out.println(starting + " -- " + destination);
        int leg = distances.get(starting).get(destination);
        distance += leg;
        if (leg > longestLeg) {
          longestLeg = leg;
        }
        starting = destination;
      }
      int leg = distances.get(starting).get(travel.get(0));

      if (leg < longestLeg) {
        distance += leg;
        distance -= longestLeg;
      }
      return distance;
    }

    public int getLongestDistance() {
      int distance = 0;
      int shortestLeg = Integer.MAX_VALUE;
      String starting = travel.get(0);
      String destination;
      for (int index = 1; index < travel.size(); index++){
        destination = travel.get(index);
//        System.out.println(starting + " -- " + destination);
        int leg = distances.get(starting).get(destination);
        distance += leg;
        if (leg < shortestLeg) {
          shortestLeg = leg;
        }
        starting = destination;
      }
      int leg = distances.get(starting).get(travel.get(0));

      if (leg > shortestLeg) {
        distance += leg;
        distance -= shortestLeg;
      }
      return distance;
    }

    private int generateRandomIndex() {
      return (int) (Math.random() * travel.size());
    }
  }

}
