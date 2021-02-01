package bytebuff;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        String s = "hello world";
        byteBuffer.put(s.getBytes());
        byteBuffer.flip();
        byteBuffer.get();
    }
}
