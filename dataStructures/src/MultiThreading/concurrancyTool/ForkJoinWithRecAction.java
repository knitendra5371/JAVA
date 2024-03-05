package MultiThreading.concurrancyTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

class SquareOfNumbers extends RecursiveAction{
    List<Integer> list;
    public SquareOfNumbers(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected void compute() {
        if(list.size()>3){
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int cnt=0;
            for (int i = 0; i < list.size(); i++) {
                if(cnt < list.size()/2){
                    list1.add(list.get(i));
                }else{
                    list2.add(list.get(i));
                }
                cnt++;
            }
            SquareOfNumbers task1 = new SquareOfNumbers(list1);
            SquareOfNumbers task2 = new SquareOfNumbers(list2);
            invokeAll(task1,task2);
        }else{
            list.stream().map(ele -> ele*ele).forEach(System.out::println);
        }
    }
}


public class ForkJoinWithRecAction {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 2, 4, 6, 5, 8, 7, 9, 10);
        SquareOfNumbers task = new SquareOfNumbers(integers);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(task);


    }
}
