package netty;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
@ChannelHandler.Sharable
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

            public static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


            @Override
            protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                Channel channel = ctx.channel();
                group.forEach(ch ->{
            if(channel != ch){
                ctx.writeAndFlush(channel.remoteAddress()+": "+ msg+"\n");//通过channel，发送消息会走
            }else{
                ChannelFuture future =  ctx.write("自己： "+msg+"\n");
                future.addListener((o)-> System.out.println("发送成功"));
                System.out.println("开始flush");
                ctx.flush();
            }
        });
                channel.disconnect();

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        group.writeAndFlush("服务器： "+channel.remoteAddress()+"加入");//广播
        group.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        group.writeAndFlush("服务器 ： "+channel.remoteAddress() + "离开");

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" 上线");
        ctx.executor().schedule(()-> System.out.println("hello0"),100, TimeUnit.MILLISECONDS);
        ctx.executor().schedule(()-> {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },10, TimeUnit.MILLISECONDS);
        ctx.channel().eventLoop().schedule(()-> System.out.println("hello2"),100, TimeUnit.MILLISECONDS);
        ctx.channel().eventLoop().schedule(()-> {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },10, TimeUnit.MILLISECONDS);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" 下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }









}