import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class fileConverter{

    private final static String[] supportedFormats = {"JPG", "JPEG", "PNG", "BMP", "WBMP","GIF"};

    public static void convert(String inputImagePath, String outputImagePath, String formatName) throws IOException {
        if (!formatCheck(formatName)) throw new IOException();
        FileInputStream inputStream = new FileInputStream(inputImagePath);
        FileOutputStream outputStream = new FileOutputStream(outputImagePath+"."+formatName);
        BufferedImage inputImage = ImageIO.read(inputStream);
        ImageIO.write(inputImage, formatName, outputStream);
        outputStream.close();
        inputStream.close();
    }
    public static String massConvert(String inputDir, String outputDir, String formatName){
        if (!formatCheck(formatName)) return "Ошибка неверный формат";
        File dir = new File(inputDir);
        int sucRate = 0;
        int errRate = 0;
        for ( File file : dir.listFiles() ){
            if ( file.isFile() ) {
                FileTools managedFile = new FileTools(file);
                try {
                    if (formatCheck(managedFile.getFormat())){
                        fileConverter.convert(file.getAbsolutePath(), outputDir + "\\" + managedFile.getNameWithoutFormat(), formatName);
                        sucRate += 1;
                    }
                    else throw new IOException();
                } catch (IOException ex) {
                    errRate += 1;
                }
            }
        }
        return "Удачно конвертированно: "+sucRate+" Возникла ошибка: "+ errRate;
    }
    private static boolean formatCheck(String formatName){
        return Arrays.asList(supportedFormats).contains(formatName.toUpperCase());
    }
}
