import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * DataAnalyzer class provides various data manipulation and analysis methods.
 */
public class DataAnalyzer {
    // Reverse list
    public static int[] reverseList(int[] numbers) {
        int[] tempList = new int[numbers.length];
        int index = numbers.length - 1;
        int i = 0;
        while (index >= 0) {
            tempList[i] = numbers[index];
            i++;
            index--;
        }
        return tempList;
    }

    // Binary Search
    public static int searchList(int target, int[] numbers) {
        int minIndex = 0;
        int maxIndex = numbers.length - 1;
        while (minIndex <= maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            if (target == numbers[middleIndex]) {
                return middleIndex;
            } else if (target > numbers[middleIndex]) {
                minIndex = middleIndex + 1;
            } else {
                maxIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int searchList(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int getMax(int[] numbers) {
        int maxNum = numbers[0];
        for (int num : numbers) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    public static int getMin(int[] numbers) {
        int minNum = numbers[0];
        for (int num : numbers) {
            if (num < minNum) {
                minNum = num;
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(searchList(arr, 5));

        int[] newArr = reverseList(arr);
        for (int num : newArr) {
            System.out.print(num + " ");
        }
        System.out.println("");

        int[] fileArr = new int[100];
        try {
            File f = new File("numbers.txt");
            Scanner scan = new Scanner(f);
            for (int i = 0; i < 100; i++) {
                fileArr[i] = scan.nextInt();
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("File not found.");
        }

        // Linear search
        System.out.println(searchList(fileArr, 81));

        // Binary search
        System.out.println(searchList(81, fileArr));

        // Reverse list
        int[] reverseArr = reverseList(fileArr);
        for (int num : reverseArr) {
            System.out.print(num + " ");
        }

        System.out.println("");

        // User entity example
        BusinessApp.run();
    }
}

/**
 * Represents a User entity with personal details and data analysis methods.
 */
class User {
    private String name;
    private int age;
    private String email;
    private int[] transactions; // Stores user data such as purchase transactions

    /**
     * Default constructor initializes default values.
     */
    public User() {
        name = "Unknown";
        age = 0;
        email = "Unknown";
        transactions = new int[0];
    }

    /**
     * Parameterized constructor to initialize user details.
     * @param name User's name
     * @param age User's age
     * @param email User's email
     * @param transactions Array of transactions representing user activity
     */
    public User(String name, int age, String email, int[] transactions) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.transactions = transactions;
    }

    /**
     * Gets the user's name.
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * @param name Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's age.
     * @return age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the user's age.
     * @param age Age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the user's email.
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     * @param email Email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the transaction history.
     * @return Array of transactions
     */
    public int[] getTransactions() {
        return transactions;
    }

    /**
     * Sets the transaction history.
     * @param transactions Array of transactions to set
     */
    public void setTransactions(int[] transactions) {
        this.transactions = transactions;
    }

    /**
     * Finds the highest transaction amount.
     * @return Maximum transaction value
     */
    public int getMaxTransaction() {
        if (transactions.length == 0) return 0;
        int max = transactions[0];
        for (int num : transactions) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Finds the lowest transaction amount.
     * @return Minimum transaction value
     */
    public int getMinTransaction() {
        if (transactions.length == 0) return 0;
        int min = transactions[0];
        for (int num : transactions) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Returns a summary of user information.
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return "User: " + name + "\nAge: " + age + "\nEmail: " + email +
               "\nMax Transaction: " + getMaxTransaction() +
               "\nMin Transaction: " + getMinTransaction();
    }
}

/**
 * Business class to demonstrate entity storage and analysis.
 */
class BusinessApp {
    public static void run() {
        System.out.println("\n----- Running BusinessApp -----\n");

        // Example user data
        int[] transactions = {120, 450, 230, 780, 560, 90};

        // Creating a User object using a parameterized constructor
        User user1 = new User("Robert Sullivan", 17, "rob@example.com", transactions);

        // Displaying user details
        System.out.println(user1);

        // Updating user information
        user1.setEmail("new_email@example.com");
        System.out.println("\nUpdated User Email: " + user1.getEmail());

        // Finding and displaying transaction statistics
        System.out.println("Highest Transaction: " + user1.getMaxTransaction());
        System.out.println("Lowest Transaction: " + user1.getMinTransaction());

        System.out.println("\n----- BusinessApp Execution Completed -----");
    }
}
