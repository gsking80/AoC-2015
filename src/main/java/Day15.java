import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day15 {

  final List<Ingredient> ingredients = new ArrayList<>();

  Day15(final FileReader fileReader) {
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // do a thing
          final String[] bits = line.split(": capacity |, durability |, flavor |, texture |, calories ");
          final Ingredient ingredient = new Ingredient(bits[0],Integer.valueOf(bits[1]),Integer.valueOf(bits[2]),Integer.valueOf(bits[3]),Integer.valueOf(bits[4]),Integer.valueOf(bits[5]));
          ingredients.add(ingredient);
        }
      }
    } catch (IOException ioe) {

    }
  }

  public int maximumScore() {
    return maximumScore(0);
  }

  public int maximumScore(final int calories) {
    final int[] ingredientAmounts = new int[ingredients.size()];
    return maximizeScore(ingredientAmounts, 0, 0, calories);
  }

  private int maximizeScore(final int[] amounts, final int position, final int maxSoFar, final int calories) {

      if (position < amounts.length) {
        int bestScore = maxSoFar;
        for (int i = 0; i <= 100; i++) {
          amounts[position] = i;
          bestScore = maximizeScore(amounts,position + 1, bestScore, calories);
        }
        return bestScore;
      } else {
        int teaspoons = 0;
        for (int i = 0; i < amounts.length; i++) {
          teaspoons += amounts[i];
        }
        if ((teaspoons != 100) || (calories != 0 && getCalories(amounts) != calories)) {
          return maxSoFar;
        } else {
          final int newScore = getScore(amounts);
          return maxSoFar > newScore ? maxSoFar : newScore;
        }
      }
  }

  public int getScore(final int[] amounts) {
    int capacity = 0;
    int durability = 0;
    int flavor = 0;
    int texture = 0;
    for(int i = 0; i < amounts.length; i++) {
      capacity += ingredients.get(i).capacityScore(amounts[i]);
      durability += ingredients.get(i).durabilityScore(amounts[i]);
      flavor += ingredients.get(i).flavorScore(amounts[i]);
      texture += ingredients.get(i).textureScore(amounts[i]);
    }

    return (capacity < 0 ? 0 : capacity) * (durability < 0 ? 0 : durability) * (flavor < 0 ? 0 : flavor) * (texture < 0 ? 0 : texture);
  }

  public int getCalories(final int[] amounts) {
    int calories = 0;
    for(int i = 0; i< amounts.length; i++) {
      calories += ingredients.get(i).caloriesScore(amounts[i]);
    }
    return calories;
  }

  class Ingredient {

    private String name;
    private int capacity;
    private int durability;
    private int flavor;
    private int texture;
    private int calories;

    public Ingredient(final String name, final int capacity, final int durability, final int flavor,
        final int texture, final int calories) {
      this.name = name;
      this.capacity = capacity;
      this.durability = durability;
      this.flavor = flavor;
      this.texture = texture;
      this.calories = calories;
    }

    public int capacityScore(final int amount) {
      return amount*capacity;
    }

    public int durabilityScore(final int amount) {
      return amount*durability;
    }

    public int flavorScore(final int amount) {
      return amount*flavor;
    }

    public int textureScore(final int amount) {
      return amount*texture;
    }

    public int caloriesScore(final int amount) {
      return amount*calories;
    }

  }

}
