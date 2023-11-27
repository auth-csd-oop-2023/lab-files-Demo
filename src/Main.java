import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String outFile = "files/outfile.txt";

        // create and write
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outFile))) {
            buffer.write("test");
            buffer.newLine();
            buffer.write("test2");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // open and append
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outFile, true))) {
            buffer.write("test3");
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        //open for read
        try (BufferedReader buffer = new BufferedReader(new FileReader(outFile))) {
            String line = buffer.readLine();
            System.out.println(line.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//       // read all lines
        try (BufferedReader buffer = new BufferedReader(new FileReader(outFile))) {
            String line = buffer.readLine();
            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//      //split lines
        try (BufferedReader buffer = new BufferedReader(new FileReader(outFile))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] split = line.split("2");
                for (String s : split) {
                    System.out.println(s);
                }
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        // read characters
        try (BufferedReader buffer = new BufferedReader(new FileReader(outFile))) {
            int c = buffer.read();
            while (c != -1) {
                char ch = (char) c;
                System.out.println(c);
                c = buffer.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//       // write binary
        List<String> list = Arrays.asList("george", "maria");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/binary.dat"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

//       //load binary
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("files/binary.dat"))) {
            List<String> list2;
            list2 = (List<String>) oos.readObject();
            list2.add("nick");
            System.out.println(list2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
