import java.awt.Point;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Day03 {

  Map<Point, Integer> houses;

  Day03(final String input){
    this(input,false);
  }

  Day03(final String input, final boolean useRoboSanta) {
    houses = new HashMap<>();
    final Point santa = new Point(0,0);
    final Point roboSanta = new Point(0,0);
    int x = 0;
    int y = 0;
    houses.put(new Point(santa), 1);
    for(int i = 0; i < input.length(); i++){
      if (useRoboSanta && (i % 2 == 1)) {
        moveSanta(roboSanta, input.charAt(i));
      } else {
        moveSanta(santa, input.charAt(i));
      }
    }
  }

  private void moveSanta(final Point santa, final Character direction) {
    switch (direction){
      case '^':
        santa.y++;
        break;
      case 'v':
        santa.y--;
        break;
      case '>':
        santa.x++;
        break;
      case '<':
        santa.x--;
    }
    final Point house = new Point(santa);
    if (null == houses.get(house)){
      houses.put(house,1);
    } else {
      houses.put(house,houses.get(house)+1);
    }
  }

  public int totalHouses() {
    return houses.size();
  }

}
