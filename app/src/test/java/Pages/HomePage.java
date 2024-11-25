package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By searchBar = By.xpath("//input[@placeholder='Search']");

    public void searchBar_Time(String texto) {
        agregarTexto(esperaExplicita(searchBar, 10), texto);
        click(esperaExplicita(By.xpath("//span[text()[contains(.,'Time')]]"),10));
    }

    public void searchBar_PIM(String texto) {
        agregarTexto(esperaExplicita(searchBar, 10), texto);
        click(esperaExplicita(By.xpath("//span[text()[contains(.,'PIM')]]"),10));
    }

    public void botonLogOut() {
        click(esperaExplicita(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]"),10));

        click(esperarElementoClickeable(By.xpath("//a[text()[contains(.,'Logout')]]")));
    }
}
