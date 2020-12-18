package com.lesan.application.json;

import java.util.List;

/**
 *
 * @param <T>
 */
public class Resultlnfo<T> {
    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
