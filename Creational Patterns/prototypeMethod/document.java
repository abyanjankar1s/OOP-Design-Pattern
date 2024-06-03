import java.util.ArrayList;
import java.util.List;

interface DocumentPrototype {
    DocumentPrototype cloneDocument(); 
    void display(); 
}

class Document implements DocumentPrototype {
    private String content;
    private List<String> images;
    private String formatting;
    private List<String> annotations;

    public Document (
        String content,
        List<String> images,
        String formatting,
        List<String> annotations
    ) {
        this.content = content;
        this.images = new ArrayList<>(images);
        this.formatting = formatting; 
        this.annotations = new ArrayList<>(annotations); 
    }
    @Override
    public DocumentPrototype cloneDocument(){
        return new Document (
            this.content,
            this.images,
            this.formatting,
            this.annotations
        );
    }
    @Override
    public void display(){
        System.out.println("Content: " + content);
        System.out.println("Images: " + images);
        System.out.println("Formatting: " + formatting);
        System.out.println("Annotations: " + annotations);
    }
    public void addImage(String image){
        images.add(image);
    } 
    public void addAnnotation(String annotation){
        annotations.add(annotation); 
    }
}

class Client {
    public static void main(String[] args) {
        List<String> images = new ArrayList<>();
        images.add("Image1.png");
        List<String> annotations = new ArrayList<>();
        annotations.add("Annotations1")

        Document originalDoc = new Document("This is Prototype Pattern.", images, "Bold", annotations); 

        DocumentPrototype copiedDoc = (Document) originalDoc.cloneDocument();

        originalDoc.addImage("Image2.png");
        originalDoc.addAnnotation("Annotation22");

        System.out.println("Original Document: ");
        originalDoc.display();
        System.out.println("\nCopied Document: ");
        copiedDoc.display();
    }
}

