package java_core_1.homework.dynamic_array;

public class Run {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();


        for (int i = 0; i < 100; i++) {
            dynamicArray.add("№" + i);
        }
        System.out.println("size: " + dynamicArray.size());
        System.out.println(dynamicArray);

        System.out.println("dynamicArray.get(5): " + dynamicArray.get(5));
        dynamicArray.remove(1);

        System.out.println("size: " + dynamicArray.size());
        System.out.println(dynamicArray);
    }
}
