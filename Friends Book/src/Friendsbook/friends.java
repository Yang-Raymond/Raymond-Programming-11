package Friendsbook;

public class friends {
    public String name;
    public String properties;

    friends(String name, String properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getproperties (){return properties;}
    public String getname(){return name;}
    public String toString(){return name;}
}
