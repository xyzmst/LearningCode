package com.example.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class BIOTest {

    private static String path = "./io/text.txt";
    private static String new_path = "./io/new_text.txt";

    public static void main(String[] args) {
//        String content = readFile(path);
//        System.out.println(content);
//        writeFile(new_path, content);
        copyFileTo(path, new_path);
    }

    private static void copyFileTo(String path, String new_path) {
        try (InputStream inputStream = new FileInputStream(path);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             OutputStream outputStream = new FileOutputStream(new_path);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            byte[] bytes = new byte[1024];
            int read;
            while ((read = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String path, String content) {
        try (OutputStream outputStream = new FileOutputStream(path);
             Writer writer = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) {
            bufferedWriter.write(content);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(path);
             Reader reader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
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
