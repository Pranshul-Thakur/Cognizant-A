import java.util.*;
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName + " | $" + totalPrice;
    }
}

public class OrderSorter {

    // Step 3: Bubble Sort Implementation
    // Bubble Sort compares adjacent elements and swaps if needed
    // Time Complexity: O(n^2), inefficient for large data
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Step 3: Quick Sort Implementation
    // Quick Sort uses divide-and-conquer and picks a pivot
    // It partitions the array and recursively sorts the partitions
    // Time Complexity: Average O(n log n), Worst O(n^2), faster than bubble sort generally
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 500.50),
            new Order(2, "Bob", 250.00),
            new Order(3, "Charlie", 700.75),
            new Order(4, "Diana", 300.25)
        };

        System.out.println("Sorted by Bubble Sort:");
        bubbleSort(orders);
        displayOrders(orders);
        orders = new Order[]{
            new Order(1, "Alice", 500.50),
            new Order(2, "Bob", 250.00),
            new Order(3, "Charlie", 700.75),
            new Order(4, "Diana", 300.25)
        };

        System.out.println("\nSorted by Quick Sort:");
        quickSort(orders, 0, orders.length - 1);
        displayOrders(orders);
    }
}

/*
Explanation of Sorting Algorithms:

1. Bubble Sort:
   - Repeatedly swaps adjacent elements if they are in wrong order.
   - Simple but inefficient (O(n²)) for large data.
   - Stable sort (preserves relative order).

2. Quick Sort:
   - Uses pivot to partition array and recursively sort subarrays.
   - Average time complexity: O(n log n), worst: O(n²).
   - Faster and preferred in most real-world use cases.

Conclusion:
Quick Sort is better than Bubble Sort for sorting large customer orders
as it's significantly faster and more scalable.
*/
