package com.javarush.task.task23.task2312;

import java.util.Objects;

public class SnakeSection {
    private int x;
    private int y;


    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31 * result + y;
        return result;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true; // если ссылки равны
        if (!(o instanceof SnakeSection)) return false;  // если не равны типы
        SnakeSection that = (SnakeSection) o;
        if (x != that.x) return false;
        if (y != that.y) return false;
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
