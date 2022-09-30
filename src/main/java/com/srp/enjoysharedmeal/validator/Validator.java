package com.srp.enjoysharedmeal.validator;

public interface Validator {

    abstract <T> void nullCheck(T entity);

    default void stringCheck(String str)
    {
        if(str == null)
            throw new RuntimeException("String is null");

        if(str.length() == 0 )
            throw new RuntimeException("String is empty");

    }
}
