package IOStream;
import java.nio.ByteBuffer;

/*
https://www.cnblogs.com/greyzeng/p/14874725.html
https://blog.csdn.net/u013938578/article/details/128659257

ByteBuffer是一个抽象类，它的两种具体实现是HeapByteBuffer和DirectByteBuffer。

HeapByteBuffer是在Java堆内存中分配的，它的底层实现是一个字节数组，因此它的读写操作是基于字节数组的。
由于HeapByteBuffer使用了Java虚拟机的内存管理机制，所以在进行内存分配和回收时可能会产生一些额外的开
销和延迟。但是由于HeapByteBuffer的实现相对简单，所以它通常比DirectByteBuffer更适合处理小量的数据。

DirectByteBuffer则是在操作系统的本地内存中分配的，它的底层实现是一个指向操作系统本地内存的指针，因此
它的读写操作是直接基于本地内存的。由于DirectByteBuffer避免了Java虚拟机的内存管理机制，所以在进行读
写操作时通常比HeapByteBuffer更快速和高效。但是由于DirectByteBuffer需要调用Java的本地方法来进行
内存分配和回收，因此在进行大量分配和回收操作时可能会产生一些额外的开销和延迟。

总之，HeapByteBuffer和DirectByteBuffer都有各自的优缺点，
具体使用哪种类型的ByteBuffer取决于应用程序的需求和实际情况。
 */

public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("mark: " + buffer);

        buffer.put("123".getBytes());

        System.out.println("-------------put:123......");
        System.out.println("mark: " + buffer);

        buffer.flip();

        System.out.println("-------------flip......");
        System.out.println("mark: " + buffer);

        buffer.get();

        System.out.println("-------------get......");
        System.out.println("mark: " + buffer);

        buffer.compact();

        System.out.println("-------------compact......");
        System.out.println("mark: " + buffer);

        buffer.clear();

        System.out.println("-------------clear......");
        System.out.println("mark: " + buffer);
    }
}
