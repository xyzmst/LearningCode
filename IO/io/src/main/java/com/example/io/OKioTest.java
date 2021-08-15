package com.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class OKioTest {
    private static String path = "./io/text.txt";
    private static String new_path = "./io/new_text.txt";

    public static void main(String[] args) {
//        String content = readFile(path);
//        writeFile(new_path, content);
        copyFileTo(path, new_path);
    }

    private static void copyFileTo(String path, String new_path) {
        try (BufferedSource source = Okio.buffer(Okio.source(new File(path)));
             BufferedSink sink = Okio.buffer(Okio.sink(new File(new_path)));) {

            Buffer buffer = new Buffer();
            long read;
            while ((read = source.read(buffer, 1024)) != -1) {
                sink.write(buffer, read);
            }
            sink.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String path, String content) {
        try (BufferedSink sink = Okio.buffer(Okio.sink(new File(path)));) {
            sink.writeUtf8(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedSource source = Okio.buffer(Okio.source(new File(path)))) {
            String line;
            while ((line = source.readUtf8Line()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return builder.toString();
        }
    }


}
