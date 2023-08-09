package com.antifrida.utils;

import java.io.*;

import com.antifrida.utils.Utils;

import static com.antifrida.utils.TransformUtils.reverseBytes;

public class Reader {

    private volatile InputStream in;
    private byte[] buffer = new byte[8];
    private static boolean showLog = true;
    private boolean isLittleEndian = true;

    public Reader(InputStream in) throws FileNotFoundException {
        this(in, true);
    }

    public Reader(InputStream in, boolean isLittleEndian) throws FileNotFoundException {
        this.in = in;
        this.isLittleEndian = isLittleEndian;

        // redirect log to file
        PrintStream out = new PrintStream("/root/IdeaProjects/parseMobileFile/src/main/java/com/antifrida/dex/parse.log");
        System.setOut(out);
    }

    /**
     * @param count 字节数
     * @return 返回 little endian 字节数组
     * @throws IOException
     */
    public byte[] read(int count) throws IOException {
        byte[] b = new byte[count];
        int read = in.read(b);
        if (read == -1) throw new EOFException();
        if (isLittleEndian) return b;
        else {
            return reverseBytes(b);
        }
    }

    public byte[] readBig(int count) throws IOException {
        byte[] b = new byte[count];
        int read = in.read(b);
        if (read == -1) throw new EOFException();
        if (!isLittleEndian) return b;
        else {
            return reverseBytes(b);
        }
    }


    public byte[] read(byte[] buffer) throws IOException {
        int read = in.read(buffer);
        if (read == -1) throw new EOFException();
        if (isLittleEndian) return buffer;
        else {
            buffer = reverseBytes(buffer);
            return buffer;
        }
    }

    public byte[] readOrigin(int count) throws IOException {
        /*
        这里读取的单位是字节
         */
        byte[] b = new byte[count];
        int read = in.read(b);
        if (read == -1) throw new EOFException();
        else return b;
    }

    public byte readByte() throws IOException {
        int b = in.read();
        if (-1 == b) throw new EOFException();
        return (byte) b;
    }

    public int readUnsignedByte() throws IOException {
        int b = in.read();
        if (-1 == b) throw new EOFException();
        return (byte) b;
    }

    public short readShort() throws IOException {
        return TransformUtils.bytes2Short(read(2));
    }

    public int readUnsignedShort() throws IOException {
        return TransformUtils.bytes2UnsignedShort(read(2));
    }

    public int readInt() throws IOException {
        byte[] ints = read(4);
        return TransformUtils.bytes2Int(ints);
    }

    public long readUnsignedInt() throws IOException {
        byte[] ints = read(4);
        return TransformUtils.bytes2UnsignedInt(ints);
    }

    public long readLong() throws IOException {
        return TransformUtils.bytes2Long(read(8));
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public String readHexString(int count) throws IOException {
        return TransformUtils.byte2HexStr(readBig(count));
    }

    public int avaliable() throws IOException {
        return in.available();
    }

    public void skip(long count) throws IOException {
        if (count > 0)
            in.skip(count);
    }

    public void reset() throws IOException {
        in.reset();
    }

    public static void log(String format, Object... params) {
        if (showLog)
            System.out.printf(format, params);
        System.out.println();
    }

}
