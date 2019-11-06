package java_core_1.homework.dynamic_array;


/**
 * Parameterizable class like ArrayList, allows you to store an array of elements of any type.
 * Supports adding an element to the end of an array.
 * Retrieving an item by index
 * Deleting an arbitrary element by index
 *
 * @param <T>
 */
public class DynamicArray<T> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public DynamicArray() {
    }

    public DynamicArray(int size) {
        this();
        this.resize(size);
    }

    /**
     * Adds a new item to the list. When the size of the internal
     * and there is its increase twice.
     *
     * @param item
     */
    public void add(T item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;

    }

    /**
     * Returns a list item by index.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Deletes a list item by index. All items to the right of the deleted item
     * move one step to the left. If, after deleting an item, the quantity
     * elements became in CUT_RATE times less than the size of the internal array,
     * then the internal array is reduced by half, to save space
     * places.
     *
     * @param index
     */
    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);

    }

    /**
     * Returns the number of items in the list
     *
     * @return
     */
    public int size() {
        return pointer;
    }

    /**
     * A helper method for scaling.
     *
     * @param newLength
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public String toString() {
        int size = size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(array[i]).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
