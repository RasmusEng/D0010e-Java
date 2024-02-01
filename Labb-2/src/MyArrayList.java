import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
@SuppressWarnings("serial")

public class MyArrayList<E> implements Serializable, Cloneable, Iterable<E>,
        Collection<E>, List<E>, RandomAccess {
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        MyArrayList<String> strlist = new MyArrayList<String>(10);
// testa metoder härifrån
    }
    // ---------------------------------------------------------------
    private int size;
    private int added;
    private E[] array = (E[]) new Object[size];

    public MyArrayList(int initialCapacity) {
        size = initialCapacity;
        ensureCapacity(size);
        //array = (E[]) new Object[size];

    }
    public MyArrayList() {
        size = 10;
        //array = (E[]) new Object[size];
    }
    // -- 1 --
    @Override
    public int size() {
        return added;
    }
    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }
    @Override
    public void clear() {
        for(int i = 0; i < array.length; i++ ){
            array[i] = null;
        }
        added = 0;
        size = 0;
    }
    // -- 2 --
    public void ensureCapacity(int minCapacity) {
       // if (minCapacity > size()) array = Arrays.copyOf(array, minCapacity);
        if (minCapacity > size())
        {
            size = minCapacity;
            E[] newArray = (E[]) new Object[size];
            for(int i = 0; i < added; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }

    }
    public void trimToSize() {
        // if(added >= size()) array = Arrays.copyOf(array, size() + 1);
        if(size != array.length)
        {
            E[] newArray = (E[]) new Object[added];
            for(int i = 0; i < added; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    // -- 3 --
    @Override
    public void add(int index, E element) {
        ensureCapacity(added++);
        for(int i = index+1; i < array.length; i++){
            array[i] = array[i-1];
        }
        array[index] = element;
    }
    @Override
    public boolean add(E e) {
        ensureCapacity(added + 1);
        array[added++] = e;
        return false;
    }
    // -- 4 --
    @Override
    public E get(int index) {
        return array[index];
    }
    @Override
    public E set(int index, E element) {
        trimToSize();
        return array[index] = element;
    }
    // -- 5 --
    @Override
    public E remove(int index) {
        E[] newArray = (E[]) new Object[added--];
        E oldVal = array[index];
        array[index] = null;
        for(int i = 0; i < size(); i++){
            if(i != index){
                newArray[i] = array[i];
            }
        }
        array = newArray;
        return oldVal;
    }
    protected void removeRange(int fromIndex, int toIndex) {
        if(toIndex <= array.length){
            for(int i = fromIndex; i < toIndex; i++){
                added--;
                array[i] = null;
            }
            E[] newArray = (E[]) new Object[added];
            int count = 0; // Håller reda på vilket index den ska lägga in i den nya arrayen
            for(int i = 0; i < toIndex; i++){
                if (array[i] != null){
                    newArray[count] = array[i];
                    count++;
                }
            }
            array = newArray;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
    // -- 6 --
    @Override
    public int indexOf(Object o) {
        for(int i = array.length; i >= 0; i--){
            if(o == array[i]) {
                return i;
            }
        }
        return -1; // Om det inte finns
    }
    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < array.length; i++){
            if(o == array[i]){
                remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < array.length; i++){
            if(o == array[i]){
                return true;
            }
        }
        return false;
    }
    // -- 7 --
    @Override
    public Object clone() {
        MyArrayList<E> clone = new MyArrayList<E>(array.length);
        for(int i = 0; i < size; i++){
            clone.add(array[i]);
        }
        return clone; // En shallow kopia, alltså samma längd
    }
    @Override
    public Object[] toArray() {
        E[] newArray = (E[]) new Object[size];
        for(int i = 0; i < array.length; i++){
             newArray[i] = array[i];
        }
        return newArray; /* bara med för att Eclipse inte ska klaga */
    }
    // --- Rör ej nedanstående kod -----------------------------------
    public MyArrayList(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }
    private class InternalIterator implements Iterator {
        int current = 0;
        @Override
        public boolean hasNext() {
            return current < size();
        }
        @Override
        public Object next() {
            return get(current++);
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new InternalIterator();
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void forEach(Consumer<? super E> action) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
}
