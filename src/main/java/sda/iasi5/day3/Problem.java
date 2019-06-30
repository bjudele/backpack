package sda.iasi5.day3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem {

  private List<Item> availableItems;
  private Backpack backpack;

  public Problem() {
    availableItems = new ArrayList<>();
  }

  public List<Item> getAvailableItems() {
    return availableItems;
  }

  public void setAvailableItems(List<Item> availableItems) {
    this.availableItems = availableItems;
  }

  public Backpack getBackpack() {
    return backpack;
  }

  public void setBackpack(Backpack backpack) {
    this.backpack = backpack;
  }

  public void addAvailableItem(Item item) {
    this.availableItems.add(item);
  }

  public double getTotalWeightOfItemsInBackpack() {
    return backpack.getTotalWeightOfItems();
  }

  public double getBackpackCapacity() {
    return backpack.getCapacity();
  }

  public double getBackpackValue() {
    return backpack.getTotalValueOfItems();
  }

  public int getNumberOfItemsInBackpack() {
    return backpack.getNumberOfItems();
  }

  public void moveItemsToBackpack() {
    for (int index = 0; index < availableItems.size(); index++) {
      Item currentItem = availableItems.get(index);
      backpack.add(currentItem);
    }

  }

  public void moveProfitableItemsToBackpack() {
    Set<Item> itemSet = new TreeSet<>(availableItems);
    Iterator<Item> iterator = itemSet.iterator();
    while (iterator.hasNext()) {
      backpack.add(iterator.next());
    }
  }

  public void moveLightItemsToBackpack() {
    ItemComparatorByWeight comparator = new ItemComparatorByWeight();
    Set<Item> itemSet = new TreeSet<>(comparator);
    itemSet.addAll(availableItems);
    Iterator<Item> iterator = itemSet.iterator();
    while (iterator.hasNext()) {
      backpack.add(iterator.next());
    }
  }

  public void moveFractionItemsToBackpack() {
    Set<Item> itemSet = new TreeSet<>(availableItems);
    Iterator<Item> iterator = itemSet.iterator();
    while (iterator.hasNext()) {
      backpack.addFraction(iterator.next());
    }

  }
}
