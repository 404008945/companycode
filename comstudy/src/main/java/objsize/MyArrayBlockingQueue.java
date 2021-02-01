package objsize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ducx
 * @Date 2020/7/14 15:24
 * @Description 用condition实现的阻塞队列
 **/
public class MyArrayBlockingQueue<T> {
    private int MAX_LENGTH;
    private Queue<T> queue = null;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyArrayBlockingQueue(int MAX_LENGTH){
        this.MAX_LENGTH = MAX_LENGTH;
        this.queue = new LinkedList<T>();
    }

    public void put(T obj) throws InterruptedException {
        lock.lock();
        while(queue.size() >= MAX_LENGTH){ //满了就阻塞
            notFull.await(); //这里设置不满条件为等待，线程在这里阻塞
        }
        queue.add(obj);
        notEmpty.signalAll(); //这里设置非空条件的信号，唤醒在notEmpty出阻塞的线程
        lock.unlock();
    }

    public T take() throws InterruptedException {
        lock.lock();
        try{
            while(queue.isEmpty()){ //队列为空
                notEmpty.await(); //这里设置非空条件为等待，线程在这里阻塞
            }
            notFull.signalAll(); //这里设置不满条件的信号，唤醒在notFull条件处阻塞的线程
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        return queue.size();
    }

}

