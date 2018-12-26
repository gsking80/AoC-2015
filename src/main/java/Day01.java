public class Day01 {
  static int floorReacher(final String instructions) {
    int currentFloor = 0;
    for (Character direction: instructions.toCharArray()) {
      switch (direction){
        case '(':
          currentFloor ++;
          break;
        case ')':
          currentFloor --;
          break;
      }
    }
    return currentFloor;
  }

  static int floorReacher(final String instructions, final int targetFloor) {
    int currentFloor = 0;
    for (int i = 0; i < instructions.length(); i++) {
      switch (instructions.charAt(i)){
        case '(':
          currentFloor ++;
          break;
        case ')':
          currentFloor --;
          break;
      }
      if (currentFloor == targetFloor) {
        return i+1;
      }
    }
    throw new RuntimeException("Couldn't find the floor");
  }
}
