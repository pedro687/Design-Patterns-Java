package Creational.Prototype;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Document d1 = new Document("document1.pdf", "arquivos/adwasd2.pdf", "PRIVATE");
        Document d2 = d1.clone();

        System.out.println(d1.toString());
        System.out.println("-------");

        System.out.println(d2.toString());

        System.out.println("--------------");
        d2.setName("documento2.word");

        System.out.println("EDITED: " + d2.toString());
        System.out.println("Original: " + d1.toString());
    }
}

class Document implements Cloneable {
    private String name;
    private String path;
    private String visibility;

    public Document(String name, String path, String visibility) {
        this.name = name;
        this.path = path;
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    @Override
    protected Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "{ name = " + name + " Path: " + path + " visibility: " + visibility + "}";
    }

}