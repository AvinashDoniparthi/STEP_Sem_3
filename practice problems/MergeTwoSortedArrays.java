public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int first = 0;
        int second = 0;
        int output = 0;

        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) {
                merged[output++] = arr1[first++];
            } else {
                merged[output++] = arr2[second++];
            }
        }
        while (first < arr1.length) {
            merged[output++] = arr1[first++];
        }
        while (second < arr2.length) {
            merged[output++] = arr2[second++];
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] result = mergeSortedArrays(new int[] {1, 3, 5}, new int[] {2, 4, 6});
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}