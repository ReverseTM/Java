package org.example;

public abstract class AssociativeContainer<tkey, tvalue> {
    public abstract AssociativeContainer<tkey, tvalue> insert(tkey key, tvalue value);

    public abstract AssociativeContainer<tkey, tvalue> remove(tkey key);

    public abstract tvalue find(tkey key);
}
