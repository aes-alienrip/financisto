package ru.orangesoftware.financisto.utils;

/**
 * Created by IntelliJ IDEA.
 * User: solomonk
 * Date: 5/2/12
 * Time: 11:14 PM
 */
public interface ExecutableEntityEnum<V> extends EntityEnum {
    
    public void execute(V value);
    
}
