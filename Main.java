import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> nums_to_sort = new LinkedList<>();
        for(int i = -100; i <= 10; ++i) {
            nums_to_sort.add(i);
        }

        // Set an adjustment if there's a negative
        int min_num = Collections.min(nums_to_sort);
        int array_length = nums_to_sort.size();

        for(int num : nums_to_sort)
        {
            SortingThread sort_thread = new SortingThread(num, min_num, array_length);
            Thread thread = new Thread(sort_thread);
            thread.start();

        }
    }



    static class SortingThread implements Runnable {

        int num;
        int min_num;
        int array_length;


        SortingThread(int num, int min_num, int array_length) {
            this.num = num;
            this.min_num = min_num;
            this.array_length = array_length;
        }


        @Override
         public void run() {

            try
            {
                Thread.sleep((long) (this.num - min_num) * array_length);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

            System.out.println(this.num);

        }
    }

}
