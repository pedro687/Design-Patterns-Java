package Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

public class StaticRegistry {
    public static void main(String[] args) {
        DocumentRegistry registry = DocumentRegistry.getInstance();
        Document pdfRestrict = registry.getDocument("PDF RESTRITO");
        System.out.println(pdfRestrict);
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

final class DocumentRegistry {
    private static final DocumentRegistry INSTANCE = new DocumentRegistry();
    private static final Map<String, Document> REGISTRY = new HashMap<>();

    static {
        Document d1 = new Document("d1.pdf", "awds/d1.pdf", "PRIVATE");
        REGISTRY.put("PDF RESTRITO", d1);

        Document d2 = new Document("d2.pdf", "awds/d2.pdf", "PUBLIC");
        REGISTRY.put("PDF PUBLICO", d2);

        Document d3 = new Document("d3.doc", "awds/d3.doc", "PRIVATE");
        REGISTRY.put("DOC PRIVADO", d3);

        Document d4 = new Document("d4.doc", "awds/d4.doc", "PUBLIC");
        REGISTRY.put("DOC PUBLIC", d4);
    }

    public static DocumentRegistry getInstance() {
        return INSTANCE;
    }

    public Document getDocument(String key) {
        try {
            return REGISTRY.get(key).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}