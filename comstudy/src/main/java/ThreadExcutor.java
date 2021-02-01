
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadExcutor{

    //创建
    private volatile boolean RUNNING = true;

    //所有任务都放队列中，让工作线程来消费
    private static BlockingQueue<Runnable> queue = null;//任务放到队列中

    private final HashSet<Worker> workers = new HashSet<Worker>();//work集合

    private final List<Thread> threadList = new ArrayList<Thread>();

    //工作线程数
    int poolSize = 0;
    //核心线程数（创建了多少个工作线程）
    int coreSize = 0;

    boolean shutdown = false;

    public ThreadExcutor(int poolSize){//线程池队列大小
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>(poolSize);
    }

    public void exec(Runnable runnable) {
        if (runnable == null) throw new NullPointerException();
        if(coreSize < poolSize){//有容量的时候，直接新建线程操作
            addThread(runnable);
        }else{
            //System.out.println("offer" +  runnable.toString() + "   " + queue.size());
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Runnable runnable){
        coreSize ++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        try {
            t.start();//开启线程
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void shutdown() {
        RUNNING = false;
        if(!workers.isEmpty()){
            for (Worker worker : workers){
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }
    //这里留个位置放内部类Worker
    /**
     * 工作线程
     */
    class  Worker implements Runnable{

        public Worker(Runnable runnable){
            queue.offer(runnable);
        }


        public void run() {
            while (true && RUNNING){//线程不关闭，因此做到了线程的复用
                if(shutdown == true){
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }

        public void interruptIfIdle() {
            for (Thread thread :threadList) {
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }
    }
}

