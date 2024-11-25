package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BaseClass {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    By user = By.xpath("//input[@name='username']");
    By pass = By.xpath("//input[@name='password']");

    public void logIn(String usuario,String contra) {
        agregarTexto(esperaExplicita(user,10), usuario);
        agregarTexto(esperaExplicita(pass,10), contra);

        esperaExplicita(By.xpath("//button[@type = 'submit']"),10).click();
    }

}
