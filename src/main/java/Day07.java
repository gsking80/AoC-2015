import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day07 {

  final Map<String, Integer> wires;
  final Map<String, String> wirePlans;


  public Day07(final FileReader fileReader) {
    wires = new HashMap<>();
    wirePlans = new HashMap<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while (true) {
        final String lineJustFetched = buf.readLine();
        if (null == lineJustFetched) {
          break;
        } else {
          final String[] instructions = lineJustFetched.split(" -> ");
          wirePlans.put(instructions[1], instructions[0]);
        }
      }

    } catch (IOException ioe) {

    }
  }

  private void copy(final String left, final String right){
    wires.put(right, value(left));
  }

  private void and(final String leftA, final String leftB, final String right){
    wires.put(right, value(leftA) & value(leftB));
  }

  private void or(final String leftA, final String leftB, final String right){
    wires.put(right, value(leftA) | value(leftB));
  }

  private void lshift(final String leftA, final String leftB, final String right){
    wires.put(right, value(leftA) << value(leftB));
  }

  private void rshift(final String leftA, final String leftB, final String right){
    wires.put(right, value(leftA) >> value(leftB));
  }

  private void not(final String left, final String right){
    wires.put(right, value(left) ^ 65535);
  }

  public int value(final String test) {
    if (test.matches("\\d+")) {
      return Integer.valueOf(test);
    } else if (null != wires.get(test)) {
      return wires.get(test);
    } else {
      final String[] instructions = wirePlans.get(test).split(" ");

      if (instructions.length == 1) {
        copy(instructions[0],test);
      } else if (instructions[1].equals("AND")) {
        and(instructions[0],instructions[2], test);
      }  else if (instructions[1].equals("OR")) {
        or(instructions[0],instructions[2], test);
      }else if (instructions[1].equals("LSHIFT")) {
        lshift(instructions[0],instructions[2], test);
      } else if (instructions[1].equals("RSHIFT")) {
        rshift(instructions[0],instructions[2], test);
      } else if (instructions[0].equals("NOT")) {
        not(instructions[1], test);
      } else {
        throw new RuntimeException("unknown command! -- " + instructions);
      }
      return wires.get(test);
    }
  }

  public Map<String, Integer> getWires() {
    return wires;
  }
}
