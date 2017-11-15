package Programa;

public class QueueImpl<T> implements Queue<T> {

    private int num = 0;
    private T[] vector;
    private int max ;

    public int getMax() {
        return max;
    }

    public QueueImpl(int n) {
        max = n;
        //vector= new T[n];
        vector = (T[]) new Object[n];
    }

    public void push(T t) {
        if(num != max)
            vector[num]=t;
        num++;
    }


    public T pop() {
        num--;
        return vector[num];
    }


    public int size() {
        return num;
    }

}
