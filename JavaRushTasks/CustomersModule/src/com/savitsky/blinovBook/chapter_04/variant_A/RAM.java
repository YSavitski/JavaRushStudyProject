package com.savitsky.blinovBook.chapter_04.variant_A;

/**
 * Created by esavitski on 17.04.2017.
 */
public class RAM {
    private int storage_size;

    public RAM(int storage_size) {
        this.storage_size = storage_size;
    }

    public int getStorage_size() {
        return storage_size;
    }

    /*@Override
    public int hashCode() {
        return (3 * storage_size);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        RAM ram = (RAM) obj;
        if(this.storage_size != ram.storage_size)
            return false;

        return true;
    }*/

    @Override
    public String toString() {
        return "RAM{" +
                "storage_size=" + storage_size +
                '}';
    }
}
