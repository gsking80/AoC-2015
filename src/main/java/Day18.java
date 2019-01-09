import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day18 {

  final Map<Point,Light> lights;
  int maxY;
  int maxX;

  public Day18(final FileReader fileReader) {
    this(fileReader, false);
  }

  public Day18(final FileReader fileReader, final boolean broken) {
    lights = new HashMap<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      int y = 0;
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          for (int x = 0; x < line.length(); x++){
            switch(line.charAt(x)){
              case '#':
                lights.put(new Point(x,y), new Light(true));
                break;
              case '.':
                lights.put(new Point(x,y), new Light(false));
                break;
            }
          }
          maxX = line.length();
          y++;
        }
      }
      maxY = y;
      if (broken) {
        lights.put(new Point(maxX-1, 0), new BrokenLight(true));
        lights.put(new Point(maxX-1, maxY-1), new BrokenLight(true));
        lights.put(new Point(0, 0), new BrokenLight(true));
        lights.put(new Point(0, maxY-1), new BrokenLight(true));
      }
    } catch (IOException ioe) {

    }
  }

  public int lightsOn(final int steps) {
    for (int i = 0; i < steps; i++) {
      advanceLights();
    }
    return lightsOn();
  }

  public int lightsOn(){
    int lightsOn = 0;
    for (final Light light: lights.values()) {
      if (light.isOn()) {
        lightsOn++;
      }
    }
    return lightsOn;
  }

  public void advanceLights(){
    for (int x = 0; x < maxX; x++) {
      for (int y = 0; y < maxY; y++){
        int litNeighbors = 0;
        for (int xx = x-1; xx < x+2; xx++) {
          for (int yy = y-1; yy < y+2; yy++) {
            final Light neighbor = lights.get(new Point(xx,yy));
            if ((xx != x || yy != y) && null != neighbor && neighbor.isOn()) {
              litNeighbors++;
            }
          }
        }
        final Light light = lights.get(new Point(x,y));
        if (light.isOn() && (litNeighbors == 2 || litNeighbors == 3)) {
          light.turnOn();
        } else if (!light.isOn() && (litNeighbors == 3)) {
          light.turnOn();
        } else {
          light.turnOff();
        }
      }
    }

    for (final Light light: lights.values()){
      light.nextState();
    }
  }

  class Light{
    private boolean on;
    private boolean nextOn;

    public Light(final boolean on) {
      this.on = on;
    }

    public void turnOn(){
      nextOn = true;
    }

    public void turnOff(){
      nextOn = false;
    }

    public void nextState() {
      on = nextOn;
    }

    public boolean isOn(){
      return on;
    }
  }

  class BrokenLight extends Light{
    public BrokenLight(final boolean on) {
      super(on);
    }

    @Override
    public boolean isOn() {
      return true;
    }
  }

}
