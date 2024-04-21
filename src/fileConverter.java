import com.aspose.words.*;

public class fileConverter{
    public static void convert(String input, String output, String format) throws Exception {
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        Shape shape = builder.insertImage(input);
        int fileFormat = switch (format.toUpperCase()) {
            case "BMP" -> SaveFormat.BMP;
            case "DOT" -> SaveFormat.DOT;
            case "DOC" -> SaveFormat.DOC;
            case "DOCX" -> SaveFormat.DOCX;
            case "GIF" -> SaveFormat.GIF;
            case "PNG" -> SaveFormat.PNG;
            case "JPEG" -> SaveFormat.JPEG;
            case "PDF" -> SaveFormat.PDF;
            default -> 102;
        };
        shape.getShapeRenderer().save(output, new ImageSaveOptions(fileFormat));
    }
}