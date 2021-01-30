package serialization;

import java.io.Serializable;

public class Dog implements Serializable {

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    String caste;
}
