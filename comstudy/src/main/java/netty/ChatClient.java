package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(nioEventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
//                        .addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()))
                                    .addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder(CharsetUtil.UTF_8))
                                    .addLast(new StringEncoder(CharsetUtil.UTF_8))
                                    .addLast(new ChatClientInbondHandler())
                                    .addLast(new SimpleChannelInboundHandler<String>() {

                                        @Override
                                        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                            System.out.println(msg);

                                        }
                                    });
                        }
                    });
            ChannelFuture future = bootstrap.connect("localhost", 8888).sync();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Channel channel = future.channel();
            while(true){
                channel.writeAndFlush(br.readLine()+"\n");//直接通过channel进行发送
            }

        }finally{
            nioEventLoopGroup.shutdownGracefully().sync();
        }
    }

}