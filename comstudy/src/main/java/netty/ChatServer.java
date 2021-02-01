package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
@ChannelHandler.Sharable
public class ChatServer {
   static final   EventExecutorGroup group = new DefaultEventExecutorGroup(16);
    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1, new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("Boss线程 "+count.getAndAdd(1));
                return t;
            }
        });
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8, new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("Work线程 "+count.getAndAdd(1));
                return t;
            }
        });
        try{

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            ChatServerHandler chatServerHandler =    new ChatServerHandler();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline()
//                        .addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()))
                                    .addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder(CharsetUtil.UTF_8))
                                    .addLast("e2",new StringEncoder(CharsetUtil.UTF_8))
                                    .addLast("e1",new ChatOutHandler())
                                    .addLast(chatServerHandler);
                        }

                    });
            ChannelFuture future = serverBootstrap.bind(8888).sync();
            future.channel().closeFuture().sync();
        }finally{
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
        }

    }



}