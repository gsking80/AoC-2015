import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day06 {

  final boolean[][] lights = new boolean[1000][1000];
  final int[][] lightsPlus = new int[1000][1000];

  public Day06(FileReader fileReader) {
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while(true) {
        final String lineJustFetched = buf.readLine();
        if(null == lineJustFetched) {
          break;
        } else {
          final String[] instructions = lineJustFetched.split(" ");
          int x1,y1,x2,y2;
          switch(instructions[0]){
            case "turn":
                switch (instructions[1]){
                  case "on":
                    turnOn(calcPoint(instructions[2]),calcPoint(instructions[4]));
                    break;
                  case "off":
                    turnOff(calcPoint(instructions[2]),calcPoint(instructions[4]));
                    break;
                }
              break;
            case "toggle":
              toggle(calcPoint(instructions[1]),calcPoint(instructions[3]));
              break;
          }
        }
      }

    } catch (IOException ioe) {

    }

  }



  private void turnOn(final Point cornerA, final Point cornerB){
    for(int x = cornerA.x; x <= cornerB.x; x++) {
      for(int y = cornerA.y; y <= cornerB.y; y++) {
        lights[x][y] = true;
        lightsPlus[x][y] += 1;
      }
    }
  }

  private void turnOff(final Point cornerA, final Point cornerB){
    for(int x = cornerA.x; x <= cornerB.x; x++) {
      for(int y = cornerA.y; y <= cornerB.y; y++) {
        lights[x][y] = false;
        if (lightsPlus[x][y] > 0){
          lightsPlus[x][y] -= 1;
        }
      }
    }
  }

  private void toggle(final Point cornerA, final Point cornerB){
    for(int x = cornerA.x; x <= cornerB.x; x++) {
      for(int y = cornerA.y; y <= cornerB.y; y++) {
        lights[x][y] ^= true;
        lightsPlus[x][y] += 2;
      }
    }
  }

  private Point calcPoint(final String pointString) {
    final String[] coords = pointString.split(",");
    return new Point(Integer.valueOf(coords[0]),Integer.valueOf(coords[1]));
  }

  public int totalLit() {
    int lit = 0;
    for(int x = 0; x < 1000; x++){
      for (int y = 0; y < 1000; y++) {
        if (lights[x][y]){
          lit++;
        }
      }
    }
    return lit;
  }

  public int totalBrightness() {
    int brightness = 0;
    for(int x = 0; x < 1000; x++){
      for (int y = 0; y < 1000; y++) {
          brightness+= lightsPlus[x][y];
      }
    }
    return brightness;
  }
}
