package Creational.Prototype;

public class JeitoCorretoSemCloneable {
    public static void main(String[] args) {
        Document document = new Document();
        document.setName("Archive.pdf");
        document.setPath("asdwas.pdf");
        document.setVisibility("PRIVATE");

        System.out.println("ORIGINAL: " + document.toString());

        System.out.println("--------------------------------");

        Document documentClone = new Document(document);

        System.out.println("CLONE 1: " + documentClone.toString());

        System.out.println("-----------------------");
        documentClone.setName("NameEdited.pdf");
        System.out.println("CLONE 1 EDITADO: " + documentClone.toString());

    }
}


class Document {
    private String name;
    private String path;
    private String visibility;

    //Implementação de clone usando Controller
    public Document(Document document) {
        name = document.getName();
        path = document.getPath();
        visibility = document.getVisibility();
    }

    public Document() {
    }

    //Implementação de clone usando factory method
    public static Document clone(Document document) {
        Document documentClone = new Document();
        documentClone.setName(document.getName());
        documentClone.setPath(document.getPath());
        documentClone.setVisibility(document.getVisibility());
        return documentClone;
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