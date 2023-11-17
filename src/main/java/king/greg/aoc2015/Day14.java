package king.greg.aoc2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day14 {
  final List<Reindeer> reindeer = new ArrayList<>();

  Day14(final FileReader fileReader) {
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          final String[] lineBits = line.split(" ");
          final Reindeer thisReindeer = new Reindeer(lineBits[0], Integer.valueOf(lineBits[3]), Integer.valueOf(lineBits[6]), Integer.valueOf(lineBits[13]));
          reindeer.add(thisReindeer);
        }
      }
    } catch (IOException ioe) {

    }
  }

  public int getFastestAfter(final int seconds){
    fly(seconds);
    System.out.println(reindeer);
    return reindeer.stream().mapToInt(Reindeer::getDistanceTraveled).max().orElseThrow(RuntimeException::new);
  }

  public int getWinnerAfter(final int seconds){
    fly(seconds);
    System.out.println(reindeer);
    return reindeer.stream().mapToInt(Reindeer::getScore).max().orElseThrow(RuntimeException::new);
  }

  public void fly(final int seconds){
    for (int i = 0; i < seconds; i++) {
      for (final Reindeer currentReindeer : reindeer) {
        currentReindeer.fly(1);
      }
      awardPoints();
    }
  }

  public void awardPoints(){
    final int farthestDistance = reindeer.stream().mapToInt(Reindeer::getDistanceTraveled).max().orElseThrow(RuntimeException::new);
    reindeer.stream().filter(reindeer -> reindeer.getDistanceTraveled() == farthestDistance).forEach(Reindeer::awardPoint);
  }

  class Reindeer {
    final String name;
    final int speed;
    final int flyTime;
    final int restTime;

    int remainingFlyTime;
    int remainingRestTime;
    int distanceTraveled;
    int score;

    @Override
    public String toString() {
      return "Reindeer{" +
          "name='" + name + '\'' +
          ", distanceTraveled=" + distanceTraveled +
          ", score=" + score +
          '}';
    }

    Reindeer(final String name, final int speed, final int flyTime, final int restTime){
      this.name = name;
      this.speed = speed;
      this.flyTime = flyTime;
      this.restTime = restTime;

      this.remainingFlyTime = flyTime;
      this.remainingRestTime = 0;
      this.distanceTraveled = 0;
      this.score = 0;
    }

    public int getDistanceTraveled() {
      return distanceTraveled;
    }

    public int getScore() {
      return score;
    }

    public void fly(int seconds) {
      while(seconds > 0) {
        seconds--;
        if(remainingFlyTime > 0){
          remainingFlyTime--;
          distanceTraveled += speed;
          if (remainingFlyTime == 0) {
            remainingRestTime = restTime;
          }
        } else if(remainingRestTime > 0) {
          remainingRestTime --;
          if (remainingRestTime == 0) {
            remainingFlyTime = flyTime;
          }
        }
      }
    }

    public void awardPoint() {
      score++;
    }

  }


}
