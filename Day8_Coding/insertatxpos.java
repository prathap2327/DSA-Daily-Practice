package Day8_Coding;

public class insertatxpos {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int x = 10;
        int pos = 2;
        insertAtPosition(arr, x, pos);
    }

    public static void insertAtPosition(int[] arr, int x, int pos) {
        if (pos < 0 || pos > arr.length) {
            System.out.println("Invalid position");
            return;
        }
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        System.out.print("Array after insertion: ");
        for (int num : newArr) {
            System.out.print(num + " ");
        }
    }
}
