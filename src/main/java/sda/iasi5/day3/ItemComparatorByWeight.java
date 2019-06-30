package sda.iasi5.day3;

import java.util.Comparator;

public class ItemComparatorByWeight implements Comparator<Item> {

  @Override
  public int compare(Item firstItem, Item secondItem) {
    double firstItemWright = firstItem.getWeight();
    double secondItemWeight = secondItem.getWeight();
    return Double.compare(firstItemWright, secondItemWeight);
  }

}
