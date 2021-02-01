package qps;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentPerformanceServer {

    static final EventExecutorGroup executor = new DefaultEventExecutorGroup(4,new ThreadFactory() {
        AtomicInteger n = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            n.incrementAndGet();
            return new ConcurrentPerformanceServerHandler.WorkThread(r, n,"业务线程");
        }
    });

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1,new ThreadFactory() {
            AtomicInteger n = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                n.incrementAndGet();
                return new ConcurrentPerformanceServerHandler.WorkThread(r, n,"BOSS");
            }
        });
        EventLoopGroup workerGroup = new NioEventLoopGroup(4,new ThreadFactory() {
            AtomicInteger n = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                n.incrementAndGet();
                return new ConcurrentPerformanceServerHandler.WorkThread(r, n);
            }
        });

        System.out.println(executor);
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(new StringDecoder()).addLast(new StringEncoder(CharsetUtil.UTF_8)).addLast(executor,"r1",new ConcurrentPerformanceServerHandler()).addLast("r2",new ConcurrentPerformanceServerHandler1());
                        }
                    });
            ChannelFuture f = b.bind(8888).sync();
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

}
