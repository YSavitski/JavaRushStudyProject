package com.savitsky.blinovBook.chapter_04.variant_A;

/**
 * Created by esavitski on 17.04.2017.
 */
public class Processor {
    private String name;

    public Processor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*@Override
    public int hashCode() {
        return (31 + ((name != null) ? name.hashCode() : 0));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Processor processor = (Processor) obj;
        if(!this.name.equals(processor.name))
            return false;

        return true;
    }*/

    @Override
    public String toString() {
        return "Processor{" +
                "name='" + name + '\'' +
                '}';
    }
}
