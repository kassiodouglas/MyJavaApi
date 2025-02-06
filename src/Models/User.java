package Models;

public class User {
    private String id;
    private String name;
    private String document;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                '}';
    }

    public User(String id, String name, String document) {
        this.id = id;
        this.name = name;
        this.document = document;
    }

    public static void populate(){
        User[] users = {
                new User("id0001", "Kassio Douglas", "00055588896"),
                new User("id0002", "Ana Jack", "14578965235"),
                new User("id0003", "Matheus Souza", "00011122233")
        };
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
