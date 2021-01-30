package serialization;

import java.io.Serializable;

public class Cat implements Serializable {

    private String name ="cat";
    String race;

    public String getName() {
        return name;
    }
}
