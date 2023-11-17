package king.greg.aoc2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day23 {

  final List<String> program;
  Map<String, Long> registers;

  Day23(final FileReader fileReader) {
    program = new ArrayList<>();
    registers = new HashMap<>();
    registers.put("a",0L);
    registers.put("b",0L);
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          program.add(line);
        }
      }
    } catch (IOException ioe) {

    }
  }

  public Map<String,Long> runProgram(){
    int instruction = 0;
    while (instruction >= 0 && instruction < program.size()){
      instruction = runLine(instruction);
    }
    return registers;
  }

  private int runLine(final int instruction) {
    int nextInstruction = instruction;
    final String[] line = program.get(instruction).split(", | ");
    switch(line[0]) {
      case "hlf":
        registers.put(line[1], registers.get(line[1]) / 2 );
        nextInstruction ++;
        break;
      case "tpl":
        registers.put(line[1], registers.get(line[1]) * 3 );
        nextInstruction ++;
        break;
      case "inc":
        registers.put(line[1], registers.get(line[1]) + 1 );
        nextInstruction ++;
        break;
      case "jmp":
        nextInstruction += Integer.valueOf(line[1]);
        break;
      case "jie":
        if (registers.get(line[1]) % 2 == 0) {
          nextInstruction += Integer.valueOf(line[2]);
        } else {
          nextInstruction++;
        }
        break;
      case "jio":
        if (registers.get(line[1]) == 1) {
          nextInstruction += Integer.valueOf(line[2]);
        } else {
          nextInstruction++;
        }
        break;
    }

    return nextInstruction;
  }

  public void setRegister(final String register, final long value){
    registers.put(register, value);
  }

}
