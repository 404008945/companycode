package nio;

import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String[] args) {
        //1.创建缓冲区指定容量
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //2.写入数据
        buffer.put("hello".getBytes());//缓冲区只能读取字节，将String转换成字节
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //3.把写入模式换成读取模式
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        buffer.clear();
       /* //单个读取
        byte b=buffer.get();
        System.out.println((char)b);*/
        //读取

        buffer.get();
        buffer.rewind();//重新进入写模式，舍弃已经读取的数据

        buffer.duplicate();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        buffer.clear();//清空缓冲区

    }
}
