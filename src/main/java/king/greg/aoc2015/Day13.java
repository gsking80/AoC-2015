package king.greg.aoc2015;

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

public class Day13 {

  Map<String, Map<String,Integer>> happiness;
  Seating seating;

  public Day13(final FileReader fileReader) {
    this(fileReader, false);
  }

  public Day13(final FileReader fileReader, final boolean addHost) {
    happiness = new HashMap<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      final Set<String> guests = new HashSet<>();
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          final String[] lineBits = line.split(" ");
          Map<String, Integer> guestA = happiness.computeIfAbsent(lineBits[0],
              k -> new HashMap<>());
          guestA.put(lineBits[10].substring(0,lineBits[10].length() - 1), lineBits[2].equals("gain") ? Integer.parseInt(lineBits[3]) : Integer.parseInt(lineBits[3]) * -1 );
          guests.add(lineBits[0]);
        }
      }
      if (addHost) {
        final Map<String,Integer> host = new HashMap<>();
        for(final String guest: happiness.keySet()){
          host.put(guest, 0);
          happiness.get(guest).put("host",0);
        }
        happiness.put("host", host);
        guests.add("host");
      }
      System.out.println(happiness);
      seating = new Seating(guests);
    } catch (IOException ioe) {

    }
  }

  public int getMaximumHappiness() {
    double temperature = 1000000000000L;
    double coolingRate = .999;
    int numberOfIterations = 10000000;
    int bestHappiness = seating.getHappiness();
    Seating bestSolution = seating;
    Seating currentSolution = bestSolution;
    for (int i = 0; i < numberOfIterations; i++) {
      if (temperature > 0.1){
        currentSolution.swapGuests();
        int currentHappiness = currentSolution.getHappiness();
        if (currentHappiness > bestHappiness) {
          bestHappiness = currentHappiness;
        } else if (Math.exp((currentHappiness - bestHappiness) / temperature) < Math.random()) {
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
    return bestHappiness;
  }

  public class Seating {
    private List<String> seating;
    private List<String> previousSeating;

    public Seating(final Set<String> guests) {
      seating = new ArrayList<>(guests);
      Collections.shuffle(seating);
      System.out.println(guests + " -- " + seating);
    }

    public void swapGuests() {
      int a = generateRandomIndex();
      int b = generateRandomIndex();
      previousSeating = seating;
      String x = seating.get(a);
      String y = seating.get(b);
      seating.set(a,y);
      seating.set(b,x);
    }

    public void revertSwap() {
      seating = previousSeating;
    }

    public int getHappiness() {
      int totalHappiness = 0;
      String guest = seating.get(0);
      String neighbor;
      for (int index = 1; index < seating.size(); index++){
        neighbor = seating.get(index);
//        System.out.println(starting + " -- " + destination);
        int localHappiness = happiness.get(guest).get(neighbor) + happiness.get(neighbor).get(guest);
        totalHappiness += localHappiness;
        guest = neighbor;
      }
      int localHappiness = happiness.get(guest).get(seating.get(0)) + happiness.get(seating.get(0)).get(guest);
      totalHappiness += localHappiness;

      return totalHappiness;
    }


    private int generateRandomIndex() {
      return (int) (Math.random() * seating.size());
    }
  }

}
