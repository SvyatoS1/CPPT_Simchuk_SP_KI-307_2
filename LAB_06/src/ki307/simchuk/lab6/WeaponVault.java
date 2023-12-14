/**
 * Package for lab6
 */
package ki307.simchuk.lab6;

import java.util.ArrayList;
import java.util.List;

public class WeaponVault<T extends Comparable<T>> {
    private List<T> items = new ArrayList<>();

    public void store(T item) {
        items.add(item);
    }

    public T retrieveMax() {
        if (!items.isEmpty()) {
            T maxItem = items.get(0);
            for (T item : items) {
                if (item.compareTo(maxItem) > 0) {
                    maxItem = item;
                }
            }
            return maxItem;
        }
        return null;
    }

    public T retrieveMin() {
        if (!items.isEmpty()) {
            T minItem = items.get(0);
            for (T item : items) {
                if (item.compareTo(minItem) < 0) {
                    minItem = item;
                }
            }
            return minItem;
        }
        return null;
    }

    public List<T> getItems() {
        return items;
    }

    public int getItemCount() {
        return items.size();
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println("Item: " + item);
        }
    }
    
    public int calculateSumOfOddPositions() {
        int sum = 0;
        for (int i = 0; i < items.size(); i += 2) {
            T item = items.get(i);
            if (item instanceof Integer) {
                sum += (Integer) item;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        WeaponVault<Integer> integerVault = new WeaponVault<>();
        integerVault.store(5);
        integerVault.store(4);
        integerVault.store(7);
        integerVault.store(8);

        System.out.println("All Items in Integer Vault:");
        integerVault.displayItems();

        System.out.println("Max Item: " + integerVault.retrieveMax());
        System.out.println("Min Item: " + integerVault.retrieveMin());

        int sumOfOddPositions = integerVault.calculateSumOfOddPositions();
        System.out.println("Sum of Items on Odd Positions: " + sumOfOddPositions);
        
        WeaponVault<String> stringVault = new WeaponVault<>();
        stringVault.store("Sword");
        stringVault.store("Axe");
        stringVault.store("Bow");

        System.out.println("All Items in String Vault:");
        stringVault.displayItems();

        System.out.println("Max Item: " + stringVault.retrieveMax());
        System.out.println("Min Item: " + stringVault.retrieveMin());
    }
}
