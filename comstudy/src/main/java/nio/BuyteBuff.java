package nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class BuyteBuff {

    public static void main(String[] args) throws InterruptedException {
        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.heapBuffer(10);
        ByteBuf buffer5 = PooledByteBufAllocator.DEFAULT.heapBuffer(10);
        buffer.writeBytes("hello".getBytes());//缓冲区只能读取字节，将String转换成字
        buffer5.writeBytes("hello".getBytes());//缓冲区只能读取字节，将String转换成字
        ByteBuf allByteBuf = Unpooled.wrappedBuffer(buffer, buffer5);
        ByteBuf b = buffer.duplicate();
        //2.写入数据

        Executors.newFixedThreadPool(1).execute(()->{
            ByteBuf buffer1= buffer;
        });
        Executors.newFixedThreadPool(1).execute(()->{
            ByteBuf buffer1= buffer;
            buffer1.release();
        });
        sleep(3000);
        ByteBuf buffer2= ByteBufAllocator.DEFAULT.heapBuffer(100);


    }
}
