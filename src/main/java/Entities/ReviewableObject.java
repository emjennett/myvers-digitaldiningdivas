package Entities;

import java.io.Serializable;

public abstract class ReviewableObject implements Serializable {

    private String name;

    public String getName(){
        return this.name;
    }
}
