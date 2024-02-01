import com.sun.corba.se.impl.protocol.giopmsgheaders.TargetAddress;

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
    private E[] array;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        array = (E[]) new Object[initialCapacity];
    }
    public MyArrayList() {
        array = (E[]) new Object[10];
    }
    // -- 1 --
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }
    @Override
    public void clear() {
        size = 0; // Sätter size till 0, vilket gör att resterade element kommer skrivas över när vi lägger till nya
    }
    // -- 2 --
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length)
        {
            E[] newArray = (E[]) new Object[minCapacity];
            for(int i = 0; i < size; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }

    }
    public void trimToSize() {
        // if(added >= size()) array = Arrays.copyOf(array, size() + 1);
        if(size != array.length)
        {
            E[] newArray = (E[]) new Object[size];
            for(int i = 0; i < size; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    // -- 3 --
    @Override
    public void add(int index, E element) {
        ensureCapacity(size+ 1); // Kolla om index stämmer
        if(index > size || index <0){
            throw new IndexOutOfBoundsException();
        }
        for(int i = index+1; i < array.length; i++){
            array[i] = array[i-1];
        }
        array[index] = element;
    }
    @Override
    public boolean add(E e) {
        add(size++, e);
        return false;
    }
    // -- 4 --
    @Override
    public E get(int index) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    @Override
    public E set(int index, E element) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return array[index] = element;
    }
    // -- 5 --
    @Override
    public E remove(int index) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        E[] newArray = (E[]) new Object[size--];
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
        if(fromIndex < 0 || fromIndex >= size|| toIndex > size || toIndex < fromIndex){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex == toIndex){
            return;
        }
        for(int i = fromIndex; i < toIndex; i++){
            size--;
            array[i] = null;
        }
        E[] newArray = (E[]) new Object[size];
        int count = 0; // Håller reda på vilket index den ska lägga in i den nya arrayen
        for(int i = 0; i < toIndex; i++){
            if (array[i] != null){
                newArray[count] = array[i];
                count++;
            }
        }
        array = newArray;
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
        if(indexOf(o) != -1){
            remove(indexOf(o));
            return true;
        }
        return false;
    }
    @Override
    public boolean contains(Object o) {
        if (indexOf(o) != -1){
            return true;
        }
        return false;
    }
    // -- 7 --
    @Override
    public Object clone() {
        MyArrayList<E> clone = new MyArrayList<E>(array.length);
        clone.array = array;
        return clone; // En shallow kopia, alltså samma längd
    }
    @Override
    public Object[] toArray() {
        E[] newArray = (E[]) new Object[size];
        for(int i = 0; i < size; i++){
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
