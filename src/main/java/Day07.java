import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day07 {

  final Map<String, Integer> wires;


  public Day07(final FileReader fileReader) {
    wires = new HashMap<String, Integer>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while (true) {
        final String lineJustFetched = buf.readLine();
        if (null == lineJustFetched) {
          break;
        } else {
          final String[] instructions = lineJustFetched.split(" ");
          if (instructions[1].equals("->")) {
            copy(instructions[0],instructions[2]);
          } else if (instructions[1].equals("AND")) {
            and(instructions[0],instructions[2], instructions[4]);
          }  else if (instructions[1].equals("OR")) {
            or(instructions[0],instructions[2], instructions[4]);
          }else if (instructions[1].equals("LSHIFT")) {
            lshift(instructions[0],instructions[2], instructions[4]);
          } else if (instructions[1].equals("RSHIFT")) {
            rshift(instructions[0],instructions[2], instructions[4]);
          } else if (instructions[0].equals("NOT")) {
            not(instructions[1],instructions[3]);
          } else {
            throw new RuntimeException("unknown command! -- " + lineJustFetched);
          }
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

  private int value(final String test) {
    if (test.matches("\\d+")) {
      return Integer.valueOf(test);
    } else if (null != wires.get(test)) {
      return wires.get(test);
    }
    return 0;
  }

  public Map<String, Integer> getWires() {
    return wires;
  }
}
