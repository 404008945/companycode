package qps;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.IOException;

public class ConcurrentClient2 {
    static final EventExecutorGroup executor = new DefaultEventExecutorGroup(100);
    public static void main(String[] args) throws InterruptedException, IOException {


    NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try{
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(nioEventLoopGroup).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8))
                                .addLast(new StringEncoder(CharsetUtil.UTF_8)).addLast(executor,new ConcurrentPerformanceClientHandler());
                    }
                });
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();

        while (true){

        }
    }finally{
        nioEventLoopGroup.shutdownGracefully().sync();
    }
}
}
