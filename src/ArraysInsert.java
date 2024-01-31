public class ArraysInsert {
    public static void main(String[] args) {
        System.out.println("hello arrays");
         System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,0,0,0,1,1,1}));
         System.out.println(sortedSquares(new int[]{-4,-1,0,3,10}));
        System.out.println("array with dulplicate zeros");
        int[] duplicates = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(duplicates);
        java.util.Arrays.stream(duplicates).forEach(System.out::println);

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        // Hint: Initialise and declare a variable here to
        // keep track of how many 1's you've seen in a row.
        int maxOneCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                count++;
                if(count > maxOneCount){
                    maxOneCount =count;
                }
            } else {
                count = 0;
            }

        }
        return maxOneCount;
    }

    static public int findEvenNumbersOfDigits(int[] nums) {

        int count = 0; // Counter for numbers with even number of digits

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                // Increment count if the number of digits is even
                count++;
                Math.log10(num);
            }
        }
        return count;

        /* Efficient solution
        int evens = 0;
        for (int num : nums) {
            int digits = (int) Math.floor(Math.log10(num)) + 1;
            if (digits % 2 == 0)
                evens++;
        }
        return evens;*/
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left =0;
        int right = n-1;
        int index = n-1;
        int[] sortedSquares = new int[nums.length];

        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                sortedSquares[index] = nums[left]*nums[left];
                left++;
            }else {
                sortedSquares[index] = nums[right]*nums[right];
                right--;
            }
            index--;
        }
        return sortedSquares;
    }

    public static void duplicateZeros(int[] arr) {

        for(int i =0; i< arr.length; i++){
            if(i == arr.length-1){
                return;
            }
            if(arr[i]==0){
                int length = arr.length-1;
                while(length > i){
                    arr[length] =arr[length-1];
                    length--;
                }
                arr[++i]=0;
            }
        }
    }

    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }

            while(j>=0){
                nums1[k--] = nums2[j--];
            }
        }
    }

}
