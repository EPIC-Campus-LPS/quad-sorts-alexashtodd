public class QuadSorts {

    public static int[] bubbleSort(int[] arr) {
        int[] Lsorted;
        Lsorted = new int[arr.length];
        Lsorted = arr;
        int[] temp;
        temp = new int[3];

        for(int x = 0; x < Lsorted.length; x++){
            for (int i = 0; i < (Lsorted.length); i++) {
                if((i+1 > Lsorted.length)){
                    return(Lsorted);
                }
                temp[0] = Lsorted[i];
                temp[1] = Lsorted[i + 1];

                if (temp[0] > temp[1]) {
                    temp[2] = temp[0]; //puts first into tmepary solt [2]
                    temp[0] = temp[1]; //puts 2nd value into 1st val
                    temp[1] = temp[2]; // tempary solt replaces solt [1]
                    temp[2] = 0; // resest and updating sorted list
                    Lsorted[i] =  temp[0];
                    Lsorted[i + 1] = temp[1];
                }
            }
        }
        return (Lsorted);
    }

    public static void main(String[] args) {
        // 1. Create an unsorted integer array
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Unsorted array: " + unsortedArray);

        // 2. Call the bubbleSort method and store the returned (sorted) array
        int[] sortedArray = bubbleSort(unsortedArray);

        // 3. Print the sorted array
        System.out.println("Sorted array: " + sortedArray);
    }



}
