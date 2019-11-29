package com.epam.workingWithFiles.lectures.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;

public class SerializDemo {
    private static String filePath = "src\\com\\epam\\workingWithFiles\\lectures\\test_file.txt";
    private static String serPathOut = "src\\com\\epam\\workingWithFiles\\lectures\\test_file1.txt";
    public static void main(String[] args) {
        BigDecimal total = BigDecimal.ZERO;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(filePath));
            while (true){
                BigDecimal price = (BigDecimal) in.readObject();
                int unit = in.readInt();
                String description = in.readUTF();
                total = total.add(price.multiply(new BigDecimal(unit)));
                in.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(total);
    }
}
