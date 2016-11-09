package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{


    /**
     * Constructs a FileWriter object given a file name.
     *
     * @param fileName String The system-dependent filename.
     * @throws IOException if the named file exists but is a directory rather
     *                     than a regular file, does not exist but cannot be
     *                     created, or cannot be opened for any other reason
     */
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    /**
     * Constructs a FileWriter object given a file name with a boolean
     * indicating whether or not to append the data written.
     *
     * @param fileName String The system-dependent filename.
     * @param append   boolean if <code>true</code>, then data will be written
     *                 to the end of the file rather than the beginning.
     * @throws IOException if the named file exists but is a directory rather
     *                     than a regular file, does not exist but cannot be
     *                     created, or cannot be opened for any other reason
     */
    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    /**
     * Constructs a FileWriter object given a File object.
     *
     * @param file a File object to write to.
     * @throws IOException if the file exists but is a directory rather than
     *                     a regular file, does not exist but cannot be created,
     *                     or cannot be opened for any other reason
     */
    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    /**
     * Constructs a FileWriter object given a File object. If the second
     * argument is <code>true</code>, then bytes will be written to the end
     * of the file rather than the beginning.
     *
     * @param file   a File object to write to
     * @param append if <code>true</code>, then bytes will be written
     *               to the end of the file rather than the beginning
     * @throws IOException if the file exists but is a directory rather than
     *                     a regular file, does not exist but cannot be created,
     *                     or cannot be opened for any other reason
     * @since 1.4
     */
    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    /**
     * Constructs a FileWriter object associated with a file descriptor.
     *
     * @param fd FileDescriptor object to write to.
     */
    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("/home/lion/java/test/test1.txt");
        fileConsoleWriter.write("123456789".toCharArray(), 2, 5);
        fileConsoleWriter.write("123456789");
        fileConsoleWriter.write(9999);
        fileConsoleWriter.write("qwertyu", 2, 5);
        fileConsoleWriter.write("dfghj".toCharArray());

        fileConsoleWriter.flush();
        fileConsoleWriter.close();
    }

    /**
     * Writes an array of characters.
     *
     * @param cbuf Array of characters to be written
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void write(char[] cbuf) throws IOException
    {
        super.write(cbuf);
    }

    /**
     * Writes a single character.
     *
     * @param c
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
    }

    /**
     * Writes a portion of an array of characters.
     *
     * @param cbuf Buffer of characters
     * @param off  Offset from which to start writing characters
     * @param len  Number of characters to write
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
    }

    /**
     * Writes a portion of a string.
     *
     * @param str A String
     * @param off Offset from which to start writing characters
     * @param len Number of characters to write
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
    }

    /**
     * Flushes the stream.
     *
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void flush() throws IOException
    {
        super.flush();
    }

    @Override
    public void close() throws IOException
    {
        super.close();
    }

    /**
     * Writes a string.
     *
     * @param str String to be written
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void write(String str) throws IOException
    {
        super.write(str);
    }
}