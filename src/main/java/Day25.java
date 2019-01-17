public class Day25 {

  private static final long SEED = 20151125L;
  private static final long MULTIPLICAND = 252533;
  private static final long DIVISOR = 33554393;

  public static long getCode(final int row, final int column){
    int number = 0;
    for (int i = 1; i <= column; i++) {
      number += i;
    }
    for (int i = 1; i < row; i++) {
      number += column + i - 1;
    }
    return getCode(number);
  }

  private static long getCode(final int number){
    long code = SEED;
    for (int i = 1; i < number; i++) {
      code = (code * MULTIPLICAND) % DIVISOR;
    }
    return code;
  }

}
