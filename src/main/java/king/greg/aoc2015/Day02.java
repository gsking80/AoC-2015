package king.greg.aoc2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day02 {

  List<int[]> dimensionsList;

  Day02(final FileReader fileReader){
    dimensionsList = new ArrayList<int[]>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while(true) {
        final String lineJustFetched = buf.readLine();
        if(null == lineJustFetched) {
          break;
        } else {
          final String dimensions[] = lineJustFetched.split("x");
          dimensionsList.add(new int[]{Integer.valueOf(dimensions[0]),Integer.valueOf(dimensions[1]),Integer.valueOf(dimensions[2])});
        }
      }

    } catch (IOException ioe) {

    }
  }

  public int paperNeeded(){
    int totalSize = 0;
    for (int[] dimensions: dimensionsList) {
      totalSize += paperNeeded(dimensions[0],dimensions[1],dimensions[2]);
    }
    return totalSize;
  }

  public int ribbonNeeded(){
    int totalSize = 0;
    for (int[] dimensions: dimensionsList) {
      totalSize += ribbonNeeded(dimensions[0],dimensions[1],dimensions[2]);
    }
    return totalSize;
  }

  static int paperNeeded(final int length, final int width, final int height) {
    final int sideA = length * width;
    final int sideB = length * height;
    final int sideC = width * height;
    final int smallestSide = Math.min(Math.min(sideA,sideB),sideC);

    return 2*sideA + 2* sideB + 2* sideC + smallestSide;
  }

  static int ribbonNeeded(final int length, final int width, final int height) {
    final int bow = length * width * height;
    final int largestDimension = Math.max(Math.max(length,width),height);
    final int smallestPerimeter = 2*length + 2*width + 2*height - 2*largestDimension;

    return bow + smallestPerimeter;
  }

}
