package Day8_Coding;

public class Searchelement {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int x = 3;
        int index = searchElement(arr, x);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static int searchElement(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // Return the index of the element
            }
        }
        return -1; // Return -1 if the element is not found
    }
}
