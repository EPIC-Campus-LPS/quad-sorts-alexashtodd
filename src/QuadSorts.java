import java.util.Arrays;

public class QuadSorts {

    public static int[] bubbleSort(int[] arr) {
        int[] Lsorted;
        Lsorted = new int[arr.length];
        Lsorted = Arrays.copyOf(arr, arr.length); //todo: need to make this not alter unsortedArray // done
        int[] temp;
        temp = new int[3];

        for(int x = 0; x < (Lsorted.length -1); x++){
            for (int i = 0; i < (Lsorted.length -1 ); i++) {
//                if((i == Lsorted.length - 1)){
//                    return(Lsorted);
//                }
                temp[0] = Lsorted[i];
                temp[1] = Lsorted[i + 1];

                if (temp[0] > temp[1]) {
                    temp[2] = temp[0]; //puts first into tmepary solt [2]
                    temp[0] = temp[1]; //puts 2nd value into 1st val
                    temp[1] = temp[2]; // temupdatingpary solt replaces solt [1]
                    temp[2] = 0; // resest and  sorted list
                    Lsorted[i] =  temp[0];
                    Lsorted[i + 1] = temp[1];
                }
            }
        }
        return (Lsorted);
    }//good

    public static int[] selectionSort(int[] arr){
        int[] Lsorted = Arrays.copyOf(arr, arr.length);
        int n = Lsorted.length; //todo: need to make this not alter unsortedArray // done

        for (int i = 0; i < n - 1; i++) {
            // 1. Find the index of the minimum element in the remaining unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // 2. Swap the found minimum element with the first element of the unsorted part
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr){
        int[] Lsorted = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < Lsorted.length; i++) {
            int key = Lsorted[i];
            int j = i - 1;

            while (j >= 0 && Lsorted[j] > key) {
                Lsorted[j + 1] = Lsorted[j];
                j--;
            }

            Lsorted[j + 1] = key;
        }

        return Lsorted;
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return(arr);
        } else {
            int mid = arr.length / 2;

            // This creates a NEW array of size 'mid' and copies the data
            int[] splitA = Arrays.copyOfRange(arr, 0, mid);

            // This creates a NEW array for the remaining elements
            int[] splitB = Arrays.copyOfRange(arr, mid, arr.length);

            int[] la = mergeSort(splitA);
            int[] lb = mergeSort(splitB);

            // merge together la and lb
                //int[] mab = new int[la.length + lb.length];
                //System.arraycopy(la, 0, mab, 0, la.length);
                //System.arraycopy(lb, 0, mab, la.length, lb.length);
            // // cal size of resulting array - size of la and lb
                int size = la.length + lb.length;
            // // for loop over the resulting array size
            // //  // pick the smallest value from the start of la or lb and put into the index of the resulting array
                for (int i = 0; i < size; i++){
                    // Use the index for the combine array to index into la and lb, but perform index safety checks

                    // Four cases to check for: null/null, a/null, b/null, a/b
                    if ((i >= la.length) && (i >= lb.length)) {
                        // The la and lb arrays ore now processed - break
                        break;
                    }
                    else if ((i < la.length) && (i >= lb.length)) {
                        arr[i] = la[i];
                    }
                    else if ((i >= la.length) && (i < lb.length)) {
                        arr[i] = lb[i];
                    }
                    else { // both input arrays have something to process
//                        int[] ReturnArr;
//                        ReturnArr = new int[size];
//                        int lai = 0;
//                        int lbi = 0;
//                        for(int x = 0; x < size; x++ ) {
//                            if (la[lai] < lb[lbi]){
//                                ReturnArr[x] = la[lai];
//                                lai = lai+1;
//                            }else{
//                                ReturnArr[x] = lb[lbi];
//                                lbi = lbi+1;
//                            }
//                        }
                        int leftPtr = 0;
                        int rightPtr = 0;
                        int k = 0; // index for the main arr

                        while (leftPtr < la.length && rightPtr < lb.length) {
                            if (la[leftPtr] <= lb[rightPtr]) {
                                arr[k] = la[leftPtr];
                                leftPtr++;
                            } else {
                                arr[k] = lb[rightPtr];
                                rightPtr++;
                            }
                            k++;
                        }

                        // If la has leftover elements (lb is empty)
                        while (leftPtr < la.length) {
                            arr[k] = la[leftPtr];
                            leftPtr++;
                            k++;
                        }

                        // If lb has leftover elements (la is empty)
                        while (rightPtr < lb.length) {
                            arr[k] = lb[rightPtr];
                            rightPtr++;
                            k++;
                        }


                        // We used two array values - increment the overall index
                        i++;
                    }
                }
        }
        return arr;
    }
    public static void main(String[] args) {
        // 1. Create an unsorted integer array.
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        // 2. Call the bubbleSort method and store the returned (sorted) array
        int[] sortedArray = bubbleSort(unsortedArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        sortedArray = selectionSort(unsortedArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        mergeSort(unsortedArray);


        // 3. Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
