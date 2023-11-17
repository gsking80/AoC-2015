package king.greg.aoc2015;

public class Day21 {

  final Item[] weapons = new Item[]{
      new Item(8, 4, 0),
      new Item(10, 5, 0),
      new Item(25, 6, 0),
      new Item(40, 7, 0),
      new Item(74, 8, 0)
  };

  final Item[] armors = new Item[]{
      new Item(0,0,0), // armor optional
      new Item(13,0,1),
      new Item(31, 0,2),
      new Item(53, 0, 3),
      new Item(75,0,4),
      new Item(102, 0, 5)
  };

  final Item[] rings = new Item[]{
      new Item(0,0,0),
      new Item(0,0,0),
      new Item(25, 1, 0),
      new Item(50,2,0),
      new Item(100, 3, 0),
      new Item(20, 0, 1),
      new Item(40, 0, 2),
      new Item(80, 0, 3)
  };

  class Item {

    public int getCost() {
      return cost;
    }

    public int getDamage() {
      return damage;
    }

    public int getArmor() {
      return armor;
    }

    private int cost;
    private int damage;
    private int armor;

    public Item(final int cost, final int damage, final int armor) {
      this.cost = cost;
      this.damage = damage;
      this.armor = armor;
    }

  }

  public int minCostToBeatBoss(final int bossHp, final int bossDamage, final int bossArmor) {
    int bestCost = Integer.MAX_VALUE;
    for (int weaponId = 0; weaponId < weapons.length; weaponId++) {
      final Item weapon = weapons[weaponId];
      for (int armorId = 0; armorId < armors.length; armorId++) {
        final Item armor = armors[armorId];
        for (int ring1Id = 1; ring1Id < rings.length; ring1Id++) {
          final Item ring1 = rings[ring1Id];
          for (int ring2Id = 0; ring2Id < ring1Id; ring2Id++) {
            final Item ring2 = rings[ring2Id];
            final int currentCost = weapon.getCost() + armor.getCost() + ring1.getCost() + ring2.getCost();
            if (currentCost < bestCost){
              final int myDamage = weapon.getDamage() + armor.getDamage() + ring1.getDamage() + ring2.getDamage();
              final int myArmor = weapon.getArmor() + armor.getArmor() + ring1.getArmor() + ring2.getArmor();
              if (beatBoss(100,myDamage,myArmor,bossHp,bossDamage,bossArmor)) {
                bestCost = currentCost;
              }
            }
          }
        }
      }
    }
    return bestCost;
  }

  public int maxCostToLoseBoss(final int bossHp, final int bossDamage, final int bossArmor) {
    int bestCost = 0;
    for (int weaponId = 0; weaponId < weapons.length; weaponId++) {
      final Item weapon = weapons[weaponId];
      for (int armorId = 0; armorId < armors.length; armorId++) {
        final Item armor = armors[armorId];
        for (int ring1Id = 1; ring1Id < rings.length; ring1Id++) {
          final Item ring1 = rings[ring1Id];
          for (int ring2Id = 0; ring2Id < ring1Id; ring2Id++) {
            final Item ring2 = rings[ring2Id];
            final int currentCost = weapon.getCost() + armor.getCost() + ring1.getCost() + ring2.getCost();
            if (currentCost > bestCost){
              final int myDamage = weapon.getDamage() + armor.getDamage() + ring1.getDamage() + ring2.getDamage();
              final int myArmor = weapon.getArmor() + armor.getArmor() + ring1.getArmor() + ring2.getArmor();
              if (beatBoss(100, myDamage, myArmor, bossHp, bossDamage, bossArmor)) {
                continue;
              }
              bestCost = currentCost;
            }
          }
        }
      }
    }
    return bestCost;
  }

  public static boolean beatBoss(final int myHp, final int myDamage, final int myArmor, final int bossHp, final int bossDamage, final int bossArmor){
    int myCurrentHp = myHp;
    int bossCurrentHp = bossHp;
    while (true) {
        bossCurrentHp -= (myDamage > bossArmor) ? (myDamage - bossArmor) : 1;
        if (bossCurrentHp <= 0) {
          return true;
        }
        myCurrentHp -= (bossDamage > myArmor) ? (bossDamage - myArmor) : 1;
        if (myCurrentHp <= 0) {
          return false;
        }
    }
  }
}
