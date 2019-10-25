package com.janis.bgg.utils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class JpaPredicateList {

    private List<Predicate> list;

    /**
     * Creates an empty predicate list
     */
    public JpaPredicateList() {
        list = new ArrayList<>();
    }

    /**
     * Adds the specified predicate to the list if the specified condition is met and if the predicate is not null
     *
     * @param condition condition
     * @param predicate predicate
     * @return this
     */
    public JpaPredicateList addConditionally(boolean condition, Predicate predicate) {
        if (condition) {
            add(predicate);
        }

        return this;
    }

    /**
     * Adds each of the specified predicates to the list as long as the predicate is not null
     *
     * @param predicates predicates
     * @return this
     */
    public JpaPredicateList add(Predicate... predicates) {
        if (null != predicates) {
            for (Predicate predicate : predicates) {
                if (null != predicate) {
                    list.add(predicate);
                }
            }
        }

        return this;
    }

    /**
     * @return the list of predicates as an array
     */
    public Predicate[] asArray() {
        Predicate[] array;
        array = new Predicate[list.size()];

        list.toArray(array);

        return array;
    }

    /**
     * @return copy of the list of predicates
     */
    public List asList() {
        return new ArrayList<>(list);
    }
}
