import java.util.Random;

public class PasswordGenerator{
    // Строка содержащая возможные символы
    static final String chars = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiop[]asdfghjkl;'zxcvbnm,./\\1234567890-=!@#$%^&*)_+";
    public static String generate(int passwordLen){ //Метод отвечающий за генерацию пароля
        String output = "";
        Random rnd = new Random();
        int j;
        for (int i = 0; i < passwordLen; i++){
            j = rnd.nextInt(chars.length()-1);
            output+= chars.substring(j,j+1);
        }
        return output;
    }
}
