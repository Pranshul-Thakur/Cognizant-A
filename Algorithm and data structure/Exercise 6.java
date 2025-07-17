import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author;
    }
}

public class LibraryManager {

    // Linear search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary search by title (array must be sorted by title)
    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Algorithms", "CLRS"),
            new Book(2, "Data Structures", "Narasimha"),
            new Book(3, "Java Programming", "Herbert"),
            new Book(4, "Operating Systems", "Galvin")
        };

        // Sort the books array by title for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("Linear Search for 'Java Programming':");
        Book result1 = linearSearch(books, "Java Programming");
        System.out.println(result1 != null ? result1 : "Not Found");

        System.out.println("\nBinary Search for 'Algorithms':");
        Book result2 = binarySearch(books, "Algorithms");
        System.out.println(result2 != null ? result2 : "Not Found");
    }
}

/*
Step 1: Search Algorithms
- Linear Search: Checks each element one by one. Works on unsorted data. Time: O(n)
- Binary Search: Divides the sorted array and searches. Requires sorted data. Time: O(log n)

Step 4: Time Complexity
Linear Search:  O(n)
Binary Search:  O(log n)

When to Use:
- Use Linear Search for small or unsorted data.
- Use Binary Search for large and sorted data.

Conclusion:
Binary search is much faster for large, sorted datasets. But if data isn't sorted, linear search is simpler.
*/