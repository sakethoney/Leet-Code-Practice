public class ArraysDeletion {
    public static void main(String[] args) {

        int[] duplicates = new int[]{1,0,2,3,0,4,5,0};
       // java.util.Arrays.stream(duplicates).forEach(System.out::println);
        int[]  inputArr = new int[]{0,1,2,2,3,0,4,2};
        int numOfElements = removeElement(inputArr, 2);
        System.out.println("Number of elements in array:"+numOfElements);
        java.util.Arrays.stream(inputArr).forEach(System.out::print);


    }

    public static void deleteFromStart(int nums[]){
        int length = nums.length;
        for(int i=1; i<length; i++){
            nums[i-1] = nums[i];
        }
        length--;
    }

    public static void deleteFromAnyIndex(int nums[], int index){
        int length = nums.length;
        for(int i=index; i<length; i++){
            nums[i-1] = nums[i];
        }
        length--;
    }

    public static int removeElement(int[] nums, int val) {
     int k =0;
     int length = nums.length;
     for(int i =1; i <= length; i++){
         if(i == length && nums[i]==val){
             length--;
         }
         if(i < length-2 && nums[i-1] == val && nums[i] == val) {
             nums[i - 1] = nums[i+1];
             nums[i]= nums[i+2];
             nums[i+1] = '_';
             nums[i+2] ='-';
             length--;
             length--;
         }else if(nums[i-1] == val){
             nums[i - 1] = nums[i];
             length--;
         }
         i++;
     }
     return length;
    }

    //nums{1,1,2};
    //nums{1,2,2};
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
           // 1 != 1;
           // 2 != 1;
            //nums[1] = nums[2];
           // k = 2;
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
