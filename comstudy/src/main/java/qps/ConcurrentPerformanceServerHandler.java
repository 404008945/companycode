package qps;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
@ChannelHandler.Sharable
public class ConcurrentPerformanceServerHandler extends ChannelInboundHandlerAdapter {

   static  AtomicInteger counter = new AtomicInteger(0);
    static ExecutorService executorService = Executors.newFixedThreadPool(10,new ThreadFactory() {
        AtomicInteger n = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            return new WorkThread(r, n);
        }
    });
    static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(System.currentTimeMillis());

        scheduledExecutorService.scheduleAtFixedRate(() ->{//qps的意思是每秒多少个个请求
            int qps = counter.getAndSet(0);
     //       System.out.println(Thread.currentThread());
            System.out.println("The Server QPS is : " + qps);
        },0, 1000, TimeUnit.MILLISECONDS);
    }

    int count=0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
   //     ((ByteBuf)msg).release();
     //   System.out.println(Thread.currentThread());
      //  ctx.executor().execute(()-> System.out.println("executor:"+Thread.currentThread()));
     //   System.out.println(ctx.executor());
        counter.incrementAndGet();
            Random random = new Random();
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        ctx.fireChannelRead(msg);
    }

    static class WorkThread extends Thread {
        private Runnable target;   //线程执行目标
        private AtomicInteger counter;


        public WorkThread(Runnable target, AtomicInteger counter) {
            this.target = target;
            this.counter = counter;
            this.setName("work线程:"+counter);
        }

        public WorkThread(Runnable target, AtomicInteger counter,String name) {
            this.target = target;
            this.counter = counter;
            this.setName(name+":"+counter);
        }
        @Override
        public void run() {
            try {
                target.run();
            } finally {
                int c = counter.getAndDecrement();
                System.out.println("terminate no " + c + " Threads");
            }
        }
    }

    }
