package com.sudoku.Prototype;

public class SudokuCloneable<T> implements Cloneable {
    @Override
    @SuppressWarnings("unchecked")
    public T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}
