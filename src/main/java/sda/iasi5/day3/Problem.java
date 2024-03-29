package sda.iasi5.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
      Item currentItem = iterator.next();
      if (backpack.add(currentItem)) {
        availableItems.remove(currentItem);
      }
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

  public void showItemsCount() {
    Map<String, Integer> itemsByCount = new HashMap<>();
    for (int index = 0; index < availableItems.size(); index++) {
      Item currentItem = availableItems.get(index);
      String currentItemName = currentItem.getName();
      Integer beforeItemCount = itemsByCount.get(currentItemName);
      if (beforeItemCount == null) {
        beforeItemCount = 0;
      }
      itemsByCount.put(currentItemName, beforeItemCount + 1);
    }
  }

  public void showTotalValueForEachItem() {
    Map<String, Integer> itemsByCount = new HashMap<>();
    Map<String, Double> itemsByValue = new HashMap<>();
    for (int index = 0; index < availableItems.size(); index++) {
      Item currentItem = availableItems.get(index);
      String currentItemName = currentItem.getName();
      Double currentItemValue = currentItem.getValue();
      Double beforeItemValue = itemsByValue.get(currentItemName);
      Integer beforeItemCount = itemsByCount.get(currentItemName);
      if (beforeItemValue == null) {
        beforeItemValue = 0.0;
        beforeItemCount = 0;
      }
      itemsByValue.put(currentItemName, beforeItemValue + currentItemValue);
      itemsByCount.put(currentItemName, beforeItemCount + 1);
    }

    for (Entry<String, Double> entry : itemsByValue.entrySet()) {
      Integer countForEach = itemsByCount.get(entry.getKey());
      System.out.println(
          "key: " + entry.getKey() + " value: " + entry.getValue() + " in total: " + countForEach
              + " average: " + (entry.getValue() / countForEach));


    }
    ;


  }
}
