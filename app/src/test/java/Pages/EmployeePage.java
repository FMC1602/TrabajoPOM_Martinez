package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BaseClass {

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    public void buttonAdd() {
        click(esperaExplicita(By.xpath("//Button[text()[contains(., 'Add')]]"),10));
    }

    public void agregarDatos() {
        agregarTexto(esperaExplicita(By.xpath("//input[@placeholder='First Name']"),10),"Juan");
        agregarTexto(esperaExplicita(By.xpath("//input[@placeholder='Middle Name']"),10),"Prueba");
        agregarTexto(esperaExplicita(By.xpath("//input[@placeholder='Last Name']"),10),"Prueba");

        agregarTexto(esperaExplicita(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//child::input[@class='oxd-input oxd-input--active']"),10),"000001");
        click(esperaExplicita(By.xpath("//Button[text()[contains(., ' Save ')]]"),10));
    }

    public void buscarPerfil() {
        agregarTexto(esperaExplicita(By.xpath("//input[@placeholder='Type for hints...']"),10), "Juan Prueba Prueba");
        click(esperaExplicita(By.xpath("//Button[text()[contains(., ' Search ')]]"),10));
    }

    public void eliminarPerfil() {
        click(esperaExplicita(By.xpath("//div[@class='oxd-table-cell-actions']//child::button[@class='oxd-icon-button" +
                " oxd-table-cell-action-space']"),10));
    }
}
