package Imp_Programs.histogramProblems;

import java.util.Arrays;
import java.util.Stack;

public class HistogramAreaEx2 {
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3, 4, 2}; // output=> Max Area = 8
        int[] next = nextSmallerElement(arr);
        int[] prev = prevSmallerElement(arr);
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(prev));

        int maxArea = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int len = arr[i];
            if (next[i] == -1) next[i] = n;
//            if(prev[i]==-1) prev[i]=0;
            int width = (next[i] - prev[i]) - 1;
            int tempArea = len * width;
            if (maxArea < tempArea) {
                maxArea = tempArea;
            }
        }
        System.out.println("MaxArea => " + maxArea);
    }

    private static int[] prevSmallerElement(int[] arr) {
        int len = arr.length;
        int[] prev = new int[len];
        Arrays.fill(prev, -1);

        if (len <= 1) return prev;

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < len; i++) {
            if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                prev[i] = st.peek();
            } else {
                while (!st.isEmpty()) {
                    if (arr[i] > arr[st.peek()]) {
                        prev[i] = st.peek();
                        break;
                    }
                    st.pop();
                }
            }
            st.push(i);
        }

        return prev;
    }

    private static int[] nextSmallerElement(int[] arr) {
        int len = arr.length;
        int[] next = new int[len];
        Arrays.fill(next, -1);

        if (len <= 1) return next;

        Stack<Integer> st = new Stack<>();
        st.push(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                next[i] = st.peek();
            } else {
                while (!st.isEmpty()) {
                    if (arr[i] > arr[st.peek()]) {
                        next[i] = st.peek();
                        break;
                    }
                    st.pop();
                }
            }
            st.push(i);
        }
        return next;
    }
}
