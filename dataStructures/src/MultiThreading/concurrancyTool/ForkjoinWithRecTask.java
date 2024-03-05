package MultiThreading.concurrancyTool;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SearchTask extends RecursiveTask<Integer> {

    int[] arr;
    int start,end,searchElement;

    public SearchTask(int[] arr, int start, int end, int searchElement) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.searchElement = searchElement;
    }

    @Override
    protected Integer compute() {
        int size = end-start+1;
        if(size>3){
            int mid = (end+start)>>1;
            SearchTask task1= new SearchTask(arr,start,mid,searchElement);
            SearchTask task2 = new SearchTask(arr,mid+1,end,searchElement);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }else{
            return processSearch();
        }

    }

    private Integer processSearch(){
        int count=0;
        for (int i = start; i <=end ; i++) {
            if(arr[i]==searchElement){
                count++;
            }
        }
        return count;
    }
}


public class ForkjoinWithRecTask {
    public static void main(String[] args) {
        int[] iarr = new int[]{6,2,4,3,7,1,8,6,9,10,12,45,6,6,32,8,6,45,6,87};
        ForkJoinPool pool = ForkJoinPool.commonPool();
        SearchTask task= new SearchTask(iarr,0,iarr.length-1,6);
        int result= pool.invoke(task);
        System.out.println(result);
    }
}
