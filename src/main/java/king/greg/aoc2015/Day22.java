package king.greg.aoc2015;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Day22 {

  boolean hardmode;

  Boss initialBoss;
  Wizard initialWizard;

  public void defineBoss(final int hitPoints, final int damage) {
    initialBoss = new Boss(hitPoints,damage);
  }

  public void defineWizard(final int hitPoints, final int mana) {
    initialWizard = new Wizard(hitPoints, mana);
  }

  public int minimumManaToWin() {
    return aStar();
  }

  private PriorityQueue<FightState> initQueue() {
    return new PriorityQueue<>(10, new Comparator<FightState>() {

      @Override
      public int compare(FightState arg0, FightState arg1) {
        return Comparator.comparing(FightState::getEstimatedTotalMana).compare(arg0, arg1);
      }

    });
  }

  public int aStar() {
    // Setup for A*
    Set<FightState> visited = new HashSet<FightState>();

    Queue<FightState> priorityQueue = initQueue();

    final FightState initialState = new FightState(initialWizard,initialBoss);
    priorityQueue.add(initialState);
    FightState current = null;

    while (!priorityQueue.isEmpty()) {
      current = priorityQueue.remove();

      if(!visited.contains(current)) {
        visited.add(current);
        System.out.println(current.isPlayerTurn()? "-- Player turn --" : "-- Boss turn --");
        System.out.println("- Player has " + current.getWizard().getHitPoints() + " hit points, " + (current.getShieldTurns() > 0 ? 7 : 0) + " armor, " + current.getWizard().getMana() + " mana");
        System.out.println("- Boss has " + current.getBoss().getHitPoints() + " hit points");

        // Execute start of turn effects
        final FightState currentTurn = new FightState(current);
        currentTurn.startTurn();
        if(currentTurn.getWizard().getHitPoints() <= 0) {
          continue;
        }
        if(currentTurn.getBoss().getHitPoints() <= 0) {
          return currentTurn.getManaSpent();
        }
        // Take and queue actions
        if (currentTurn.isPlayerTurn()) {
          for (final String spell : currentTurn.getWizard().spells()) {
            FightState nextState = new FightState(currentTurn);
            switch (spell) {
              case "Magic Missile":
                if (nextState.getWizard().spendMana(53)) {
                  System.out.println("Player casts Magic Missile, dealing 4 damage.");
                  nextState.increaseManaSpent(53);
                  nextState.getBoss().takeDamage(4);
                } else {
                  continue;
                }
                break;
              case "Drain":
                if (nextState.getWizard().spendMana(73)) {
                  System.out.println("Player casts Drain, dealing 2 damage, and healing 2 hit points.");
                  nextState.increaseManaSpent(73);
                  nextState.getBoss().takeDamage(2);
                  nextState.getWizard().heal(2);
                } else {
                  continue;
                }
                break;
              case "Shield":
                if (nextState.getWizard().spendMana(113) && nextState.activateShield()) {
                  System.out.println("Player casts Shield, increasing armor by 7.");
                  nextState.increaseManaSpent(113);
                } else {
                  continue;
                }
                break;
              case "Poison":
                if (nextState.getWizard().spendMana(173) && nextState.activatePoison()) {
                  System.out.println("Player casts Poison.");
                  nextState.increaseManaSpent(173);
                } else {
                  continue;
                }
                break;
              case "Recharge":
                if (nextState.getWizard().spendMana(229) && nextState.activateRecharge()) {
                  System.out.println("Player casts Recharge.");
                  nextState.increaseManaSpent(229);
                } else {
                  continue;
                }
                break;
            }
            if (nextState.getBoss().getHitPoints() <= 0) {
              return nextState.getManaSpent();
            } else {
              nextState.setPlayerTurn(false);
              if (!visited.contains(nextState)) {
                priorityQueue.add(nextState);
              }
            }
          }
        } else {
          FightState nextState = new FightState(currentTurn);
          nextState.getWizard().takeDamage(nextState.getBoss().getDamage(), nextState.getShieldTurns() > 0);
          if (nextState.getWizard().getHitPoints() > 0) {
            nextState.setPlayerTurn(true);
            if (!visited.contains(nextState)) {
              priorityQueue.add(nextState);
            }
          }
        }
        System.out.println(" ");
      }
    }
    //Unwinnable
    return -1;
  }

  class FightState{
    private Wizard wizard;
    private Boss boss;
    private int manaSpent;
    private int shieldTurns;
    private int poisonTurns;
    private int rechargeTurns;
    private boolean playerTurn;

    public FightState(final FightState previous) {
      wizard = new Wizard(previous.getWizard().getHitPoints(), previous.getWizard().getMana());
      boss = new Boss(previous.getBoss().getHitPoints(), previous.getBoss().getDamage());
      manaSpent = previous.getManaSpent();
      shieldTurns = previous.getShieldTurns();
      poisonTurns = previous.getPoisonTurns();
      rechargeTurns = previous.getRechargeTurns();
      playerTurn = previous.isPlayerTurn();
    }

    public FightState(Wizard wizard, Boss boss) {
      this.wizard = wizard;
      this.boss = boss;
      manaSpent = 0;
      shieldTurns = 0;
      poisonTurns = 0;
      rechargeTurns = 0;
      playerTurn = true;
    }

    public int getManaSpent() {
      return manaSpent;
    }

    public void increaseManaSpent(final int mana) {
      manaSpent += mana;
    }

    public int getEstimatedTotalMana() {
      return manaSpent + boss.getHitPoints() + (playerTurn ? 53 : 0);
    }

    public void startTurn() {
      if (playerTurn && hardmode) {
        getWizard().takeDamage(1, false);
      }
      if (shieldTurns > 0) {
        shieldTurns--;
      }
      if (poisonTurns > 0) {
        boss.takeDamage(3);
        poisonTurns--;
      }
      if (rechargeTurns > 0) {
        wizard.gainMana(101);
        rechargeTurns--;
      }

    }

    public Wizard getWizard() {
      return wizard;
    }

    public void setWizard(Wizard wizard) {
      this.wizard = wizard;
    }

    public Boss getBoss() {
      return boss;
    }

    public void setBoss(Boss boss) {
      this.boss = boss;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      final FightState that = (FightState) o;
      return shieldTurns == that.shieldTurns &&
          poisonTurns == that.poisonTurns &&
          rechargeTurns == that.rechargeTurns &&
          wizard.equals(that.wizard) &&
          boss.equals(that.boss) &&
          playerTurn == that.playerTurn;
    }

    @Override
    public int hashCode() {
      return Objects.hash(wizard, boss, shieldTurns, poisonTurns, rechargeTurns, playerTurn);
    }

    public int getShieldTurns() {
      return shieldTurns;
    }

    public boolean activateShield() {
      if (shieldTurns == 0) {
        shieldTurns = 6;
        return true;
      }
      return false;
    }

    public int getPoisonTurns() {
      return poisonTurns;
    }

    public boolean activatePoison() {
      if (poisonTurns == 0) {
        poisonTurns = 6;
        return true;
      }
      return false;
    }

    public int getRechargeTurns() {
      return rechargeTurns;
    }

    public boolean activateRecharge() {
      if (rechargeTurns == 0) {
        rechargeTurns = 5;
        return true;
      }
      return false;
    }

    public boolean isPlayerTurn() {
      return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
      this.playerTurn = playerTurn;
    }
  }

  class Wizard{
    private int hitPoints;
    private int mana;

    public String[] spells() {return new String[]{"Magic Missile", "Drain", "Shield", "Poison", "Recharge"};}

    public Wizard(int hitPoints, int mana) {
      this.hitPoints = hitPoints;
      this.mana = mana;
    }

    public int getHitPoints() {
      return hitPoints;
    }

    public void takeDamage(final int damage, final boolean shielded) {
      System.out.println("Boss attacks for " + (shielded ? damage - 7 : damage) + " damage!");
      hitPoints -= shielded ? damage - 7 : damage;
    }

    public void heal(final int hitPoints) {
      this.hitPoints += hitPoints;
    }

    public void setHitPoints(int hitPoints) {
      this.hitPoints = hitPoints;
    }

    public int getMana() {
      return mana;
    }

    public void setMana(int mana) {
      this.mana = mana;
    }

    public void gainMana(int mana) {
      this.mana += mana;
    }

    public boolean spendMana(int mana) {
      if (this.mana >= mana) {
        this.mana -= mana;
        return true;
      }
      return false;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      final Wizard wizard = (Wizard) o;
      return hitPoints == wizard.hitPoints &&
          mana == wizard.mana;
    }

    @Override
    public int hashCode() {
      return Objects.hash(hitPoints, mana);
    }
  }

  class Boss{
    private int hitPoints;
    private int damage;

    public Boss(int hitPoints, int damage) {
      this.hitPoints = hitPoints;
      this.damage = damage;
    }

    public int getHitPoints() {
      return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
      this.hitPoints = hitPoints;
    }

    public int getDamage() {
      return damage;
    }

    public void setDamage(int damage) {
      this.damage = damage;
    }

    public void takeDamage(int damage) {
      hitPoints -= damage;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      final Boss boss = (Boss) o;
      return hitPoints == boss.hitPoints &&
          damage == boss.damage;
    }

    @Override
    public int hashCode() {
      return Objects.hash(hitPoints, damage);
    }
  }

  public Day22() {
    this(false);
  }

  public Day22(final boolean hardmode){
    this.hardmode = hardmode;
  }

}
