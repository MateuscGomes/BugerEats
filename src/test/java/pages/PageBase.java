package pages;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PageBase {

    protected WebDriver navegador;

    public PageBase(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String capturarTextoDaConfirmacaoDoCadastro() {
        return navegador.findElement(By.id("swal2-title")).getText();
    }

    public class RandomEmailGenerator {
        public static String randomEmail(){
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            Random rnd = new Random();
            String emailRandom;
            int i = 0;
            StringBuilder sb = new StringBuilder();

            while (sb.length() < 5){
                int index = (int) (rnd.nextFloat() * chars.length());
                sb.append(chars.charAt(index));
            }
            emailRandom = sb.toString().toLowerCase();
            return emailRandom;

        }
    }
    public class RandomCPFGenerator {
        public static String randomCPF(){
            String chars = "1234567890";
            Random rnd = new Random();
            String cpfRandom;
            int i = 0;
            StringBuilder sb = new StringBuilder();

            while (sb.length() < 11){
                int index = (int) (rnd.nextFloat() * chars.length());
                sb.append(chars.charAt(index));
            }
            cpfRandom = sb.toString().toLowerCase();
            return cpfRandom;

        }
    }
    public class DataGenerator{
        public static String dataHoraParaArquivo(){
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
        }
    }
    public class Screenshot{
        public static void tirar(WebDriver navegador, String arquivo){
            File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshot, new File(arquivo));
            } catch (Exception e){
                System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());
            }

        }
    }

}
