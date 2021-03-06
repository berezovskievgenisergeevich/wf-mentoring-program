package com.epam.test.serializbl;

import java.io.*;
import java.util.Base64;

public class Serializer {
    /**
     * Method that serializes the data in a file.
     *
     * @param o the object to be serialized.
     * @param f the file where the serialization will occur.
     * @return nothing.
     */
    public static void dump(Object o, File f) {
        dump(o, f, false);
    }

    /**
     * Method that serializes the data in a file with append writting mode or not.
     *
     * @param o      the object to be serialized.
     * @param f      the file where the serialization will occur.
     * @param append sets the writting mode in the file to the append mode or not.
     */
    public static void dump(Object o, File f, boolean append) {

        if (o != null && f != null) {

            try {

//				File where the data will be serialized.
                FileOutputStream fos = new FileOutputStream(f, append);

//				Object responsible for writing the data in the file.
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.flush();

//				Writting the data.
                oos.writeObject(o);

                oos.close();

                fos.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * Method that serializes and stores an object in memory.
     * Then returns a string representing the serialized object.
     *
     * @param o the object to be serialized.
     * @return a string representing the serialized object.
     */

    public static String dumps(Object o) {

        String s = "";

        try {

//			Serializing.

//			Reference to a byte sequence in the memory.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

//			Reference to the serializer.
            ObjectOutputStream oos = new ObjectOutputStream(baos);

//                      Serializing the object.
            oos.writeObject(o);

//                      Closing the serializer.
            oos.close();

//                      Converting a byte array to a string.
            s =  new String (Base64.getEncoder().encode(baos.toByteArray()));
          //  s = new String(Base64.encodeBase64(baos.toByteArray()));

//                      Closing the byte array.
            baos.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return s;
    }

    /**
     * Method that deserialize a object.
     *
     * @param f file where the object is serialized.
     * @return the deserialized object.
     */
    public static Object load(File f) {

        Object o = null;

        if (f != null) {

            try {

//                              Creating an input stream of data from a file.
                FileInputStream fis = new FileInputStream(f);

//				Creating an object that read data from a file.
                ObjectInputStream ois = new ObjectInputStream(fis);

//                              Reading the data.
                o = ois.readObject();

//                              Closing the reader.
                ois.close();

//                              Closing the input stream.
                fis.close();

            } catch (IOException e) {

                e.printStackTrace();

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
        }

        return o;
    }


    /**
     * Method that deserializes a object from a string.
     *
     * @param s string that represents the serialized object.
     * @return the deserialized object.
     */
    public static Object loads(String s) {

        Object o = null;

        ByteArrayInputStream bais;

        try {

//                      Creating a input stream of data that comes from an array of bytes.
            Base64.Decoder decoder = Base64.getDecoder();
            bais = new ByteArrayInputStream(decoder.decode(s.getBytes()));
            // bais = new ByteArrayInputStream( Base64.decodeBase64(s.getBytes() ) );

//                      Creating reader object.
            ObjectInputStream ois = new ObjectInputStream(bais);

//                      Reading the data.
            o = ois.readObject();

//                      Closing the reader.
            ois.close();

//                      Closing the byte array.
            bais.close();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return o;
    }
}
