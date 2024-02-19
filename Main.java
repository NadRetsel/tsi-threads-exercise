import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums_to_sort = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};

        // Set an adjustment if there's a negative
        int min_num = Math.min(0, Arrays.stream(nums_to_sort).min().getAsInt()) * -1;

        for(int num : nums_to_sort)
        {
            SortingThread sort_thread = new SortingThread(num, min_num);
            Thread thread = new Thread(sort_thread);
            thread.start();

        }
    }



    static class SortingThread implements Runnable {

        int num;
        int min_num;


        SortingThread(int num, int min_num) {
            this.num = num;
            this.min_num = min_num;
        }


        @Override
         public void run() {

            try
            {
                Thread.sleep((this.num + min_num) * 100L);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

            System.out.println(this.num);

        }
    }

}
