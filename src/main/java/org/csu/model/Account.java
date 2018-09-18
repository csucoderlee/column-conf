package org.csu.model;

import java.io.Serializable;

/**
 * Created by csucoderlee on 2018/9/18
 */
public class Account implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
