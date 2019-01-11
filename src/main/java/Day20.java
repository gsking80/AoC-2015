public class Day20 {

  public static int firstHouseWithAtLeast(final int presents) {

    int MAX_HOUSES = 1000000;
    final int[] houses = new int[MAX_HOUSES];
    for (int elf = 1; elf < MAX_HOUSES; elf++) {
      for (int house = elf; house < MAX_HOUSES; house += elf) {
        houses[house] += elf * 10;
      }
    }

    for (int house = 1; house < MAX_HOUSES; house++) {
      if (houses[house] >= presents) {
        return house;
      }
    }

    return -1;
  }

  public static int firstHouseWithAtLeastPart2(final int presents) {

    int MAX_HOUSES = 1000000;
    final int[] houses = new int[MAX_HOUSES];
    for (int elf = 1; elf < MAX_HOUSES; elf++) {
      int houseCount = 0;
      for (int house = 0; house < MAX_HOUSES; house += elf) {
        houses[house] += elf * 11;
        houseCount++;
        if (houseCount >= 50) {
          break;
        }
      }
    }

    for (int house = 1; house < MAX_HOUSES; house++) {
      if (houses[house] >= presents) {
        return house;
      }
    }

    return -1;
  }

}
