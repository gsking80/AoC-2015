import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day17 {
  final List<Integer> containers;

  public Day17(final FileReader fileReader){
    containers = new ArrayList<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          containers.add(Integer.valueOf(line));
        }
      }
    } catch (IOException ioe) {

    }
  }

  public int storageOptions(final int liters) {
    int totalOptions = 0;
    for (long i = 0; i < Math.pow(2, containers.size()); i++){
      int storage = 0;
      for (int j = 0; j < containers.size(); j++) {
        long test = (long) Math.pow(2, j);
        if ((i & test) == test) {
          storage += containers.get(j);
        }
      }
      if (storage == liters) {
        totalOptions++;
      }
    }
    return totalOptions;
  }

  public int storageOptionsMin(final int liters) {
    int totalOptions = 0;
    int minContainers = Integer.MAX_VALUE;
    for (long i = 0; i < Math.pow(2, containers.size()); i++){
      int storage = 0;
      int containersUsed = 0;
      for (int j = 0; j < containers.size(); j++) {
        long test = (long) Math.pow(2, j);
        if ((i & test) == test) {
          storage += containers.get(j);
          containersUsed++;
        }
      }
      if (storage == liters) {
        if (containersUsed < minContainers) {
          minContainers = containersUsed;
          totalOptions = 1;
        } else if (containersUsed == minContainers) {
          totalOptions++;
        }
      }
    }
    return totalOptions;
  }

}
