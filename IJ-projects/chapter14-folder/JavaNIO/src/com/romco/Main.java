package com.romco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();
            
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
    
                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();
    
                            buffer.put(currentTime.getBytes());
                            buffer.flip();
    
                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
    
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            
            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
    
                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("reader thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            
            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binChannel = binFile.getChannel()) {
//
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            long pos1 = outputBytes.length;
//            buffer.putInt(245);
//            long pos2 = pos1 + Integer.BYTES;
//            buffer.putInt(-98765);
//            long pos3 = pos2 + Integer.BYTES;
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            long pos4 = pos3 + outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();
//
////            byte[] outputBytes = "Hello World!".getBytes();
////            byte[] outputBytes2 = "Nice to meet you".getBytes();
////            buffer
////                    .put(outputBytes)
////                    .putInt(245)
////                    .putInt(-98765)
////                    .put(outputBytes2)
////                    .putInt(1000)
////                    .flip();
//
//            binChannel.write(buffer);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(pos4);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int3: " + readBuffer.getInt());
//            readBuffer.flip();
//
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer = ByteBuffer.wrap(outputBytes2);
//            channel.position(pos3);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            readBuffer.get(inputString2);
//            System.out.println("string2: " + new String(inputString2));
//            readBuffer.flip();
//
//            readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(pos2);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int2: " + readBuffer.getInt());
//            readBuffer.flip();
//
//            readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(pos1);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1: " + readBuffer.getInt());
//            readBuffer.flip();
//
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer = ByteBuffer.wrap(outputBytes);
//            channel.position(0);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            readBuffer.get(inputString);
//            System.out.println("string1: " + new String(inputString));
//
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
//            FileChannel copyChannel = copyFile.getChannel();
//            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
//            System.out.println("num transferred: " + numTransferred);
//
//            channel.close();
//            ra.close();
//            copyChannel.close();
////            byte[] inputString = new byte[outputBytes.length];
////            readBuffer.get(inputString);
////            System.out.println("string1: " + new String(inputString));
////            System.out.println("int1: " + readBuffer.getInt());
////            System.out.println("int2: " + readBuffer.getInt());
////            byte[] inputString2 = new byte[outputBytes2.length];
////            readBuffer.get(inputString2);
////            System.out.println("string2: " + new String(inputString2));
////            System.out.println("int3: " + readBuffer.getInt());
//
////            // if you wrap an array, it is used to back the buffer
////            // if you allocate, a new array is created to back the buffer
//////            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
////            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
////            buffer.put(outputBytes);
////            buffer.flip();
////
////            int numBytes = binChannel.write(buffer);
////            System.out.println("numBytes written was: " + numBytes);
////
////            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//////            IntBuffer intBuffer1 = IntBuffer.allocate(Integer.BYTES);
////            intBuffer.putInt(245);
////            intBuffer.flip();
////            numBytes = binChannel.write(intBuffer);
////            System.out.println("numBytes written was: " + numBytes);
////
////            intBuffer.flip();
////            intBuffer.putInt(-98765);
////            intBuffer.flip();
////            numBytes = binChannel.write(intBuffer);
////            System.out.println("numBytes written was: " + numBytes);
////
//////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//////            byte[] b = new byte[outputBytes.length];
//////            ra.read(b);
//////            System.out.println(new String(b));
//////
//////            long int1 = ra.readInt();
//////            long int2 = ra.readInt();
//////            System.out.println("int1: " + int1);
//////            System.out.println("int2: " + int2);
////
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            FileChannel channel = ra.getChannel();
////            buffer.flip();
////            long numBytesRead = channel.read(buffer);
////            if (buffer.hasArray()) {
////                System.out.println("bytes in file: " + new String(buffer.array()));
////            }
////
////            // absolute read
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            System.out.println(intBuffer.getInt(0));
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            // see how absolute read doesn't change the cursor:
////            System.out.println(intBuffer.getInt(0));
////            System.out.println(intBuffer.getInt(0));
////            System.out.println(intBuffer.getInt());
//
//            // relative read:
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////            channel.close();
////            ra.close();
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
    }
}
