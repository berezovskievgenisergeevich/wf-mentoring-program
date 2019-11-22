package com.epam.introdactionToJVM.homework.task1;

import javassist.CannotCompileException;
import javassist.ClassPool;
import sun.misc.Unsafe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;


/**
 * Design and implement code that will introduce:
 * <p>
 * 1. java.lang.OutOfMemoryError: Java heap space. You can use different data structures. Do not tune heap size.
 * <p>
 * 2. java.lang.OutOfMemoryError: Java heap space. Create big objects continuously and make them stay in memory. Do not use arrays or collections.
 * <p>
 * 3. java.lang.OutOfMemoryError: Metaspace. Load classes continuously and make them stay in memory.
 * <p>
 * 4. java.lang.StackOverflowError. Use recursive methods. Don’t tune stack size.
 * <p>
 * 5. java.lang.StackOverflowError. Do not use recursive methods. Don’t tune stack size.
 */
public class Runner {

    static ClassPool classPool = ClassPool.getDefault();


    public static void main(String[] args) throws Exception {

        // generateJavaHeapSpaceError();
        // generateJavaHeapSpaceErrorDoNotUseArray();
        //  generateJavaHeapSpaceMetaspace();
        //   recursivePrint(1);

        Stackoverflow.generateStackOverflow();

    }

    /**
     * java.lang.OutOfMemoryError: Java heap space. You can use different data structures. Do not tune heap size.
     */
    private static void generateJavaHeapSpaceError() {
        System.out.println("java.lang.OutOfMemoryError: Java heap space.");
        var strings = new String[Integer.MAX_VALUE - 2];
    }

    /**
     * java.lang.OutOfMemoryError: Java heap space. Create big objects continuously and make them stay in memory. Do not use arrays or collections.
     */
    private static void generateJavaHeapSpaceErrorDoNotUseArray() throws CannotCompileException {
        for (int i = 0; i < 100_000_000; i++) {
            System.out.println(i);
            String result = i + "We are generate Java Heap Space Error Do Not yse array".repeat(100);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(result);
            stringBuffer.toString().intern();
            InputStream is = new ByteArrayInputStream(Charset.forName("UTF-16").encode(result).array());
            for (int j = 0; j < 1000000000; j++) {
                Class c = classPool.makeClass("com.epam.introdactionToJVM.homework.task1.Runner" + j).toClass();
                System.out.println(c.getName());
            }
        }
    }

    /**
     * java.lang.OutOfMemoryError: Metaspace. Load classes continuously and make them stay in memory.
     *
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void generateJavaHeapSpaceMetaspace() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class unsafeClass = Class.forName("sun.misc.Unsafe");
        Field f = unsafeClass.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        try {
            for (; ; )
                unsafe.allocateMemory(1024 * 1024);
        } catch (Error e) {

            e.printStackTrace();
        }
    }

    /**
     * java.lang.StackOverflowError. Use recursive methods. Don’t tune stack size.
     *
     * @param num
     */
    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);

        if (num == 0)
            return;
        else
            recursivePrint(++num);
    }

}
