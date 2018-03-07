package com.kodilla.sudoku.Prototype;

public class SudokuCloneable<T> implements Cloneable {
    public T clone() throws CloneNotSupportedException {
        return (T) super.clone();
    }
}
