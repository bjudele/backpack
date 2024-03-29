package sda.iasi5.day3;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

  private double capacity;
  private List<Item> itemList;

  public Backpack(double capacity) {
    itemList = new ArrayList<>();
    this.capacity = capacity;
  }

  public double getCapacity() {
    return capacity;
  }

  public void setCapacity(double capacity) {
    this.capacity = capacity;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  public double getTotalWeightOfItems() {
    double sumOfWeights = 0;
    for (int index = 0; index < itemList.size(); index++) {
      Item currentItem = itemList.get(index);
      sumOfWeights = sumOfWeights + currentItem.getWeight();
    }
    return sumOfWeights;
  }

  public boolean add(Item item) {
    if (getAvailableCapacity() >= item.getWeight()) {
      itemList.add(item);
      return true;
    }
    return false;
  }

  public double getAvailableCapacity() {
    return capacity - getTotalWeightOfItems();
  }

  public double getTotalValueOfItems() {
    double sumOfValue = 0;
    for (int index = 0; index < itemList.size(); index++) {
      Item currentItem = itemList.get(index);
      sumOfValue = sumOfValue + currentItem.getValue();
    }
    return sumOfValue;
  }

  public int getNumberOfItems() {
    return itemList.size();
  }

  public void addFraction(Item item) {
    double availableCapacity = getAvailableCapacity();
    if (availableCapacity == 0) {
      return;
    }
    if (availableCapacity >= item.getWeight()) {
      itemList.add(item);
    } else {
      Item fractionItem = new Item(item.getName(), availableCapacity,
          availableCapacity * item.getValue() / item.getWeight());
      itemList.add(fractionItem);
    }
  }
}
