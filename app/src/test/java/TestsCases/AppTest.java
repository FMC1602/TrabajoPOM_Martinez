package TestsCases;

import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LogInPage;
import Utils.DataDriven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

class AppTest {
    protected WebDriver driver;
    private LogInPage logIn;
    private HomePage homePage;
    private EmployeePage employeePage;


    private static String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";
    private ArrayList<String> data;



    @Test
    public void TC001_LogIn() {
        data = DataDriven.getTestData("TC001_LogIn");
        logIn.logIn(data.get(1), data.get(2));
    }

    @Test
    public void Test002_lateralSearchBar() {
        data = DataDriven.getTestData("TC001_LogIn");
        data = DataDriven.getTestData("Test002_lateralSearchBar");
        logIn.logIn(data.get(1), data.get(2));
        homePage.searchBar_Time(data.get(3));
    }

    @Test
    public void Test003_addUser() {
        data = DataDriven.getTestData("TC001_LogIn");
        data = DataDriven.getTestData("Test003_addUser");
        logIn.logIn(data.get(1), data.get(2));
        homePage.searchBar_PIM(data.get(3));
        employeePage.buttonAdd();
        employeePage.agregarDatos();
    }

    @Test
    public void Test004_removeUser() {
        data = DataDriven.getTestData("TC001_LogIn");
        data = DataDriven.getTestData("Test004_removeUser");
        logIn.logIn(data.get(1), data.get(2));
        homePage.searchBar_PIM(data.get(3));
        employeePage.buscarPerfil();
        employeePage.eliminarPerfil();
    }

    @Test
    public void Test005_logOut() {
        data = DataDriven.getTestData("TC001_LogIn");
        logIn.logIn(data.get(1), data.get(2));
        homePage.botonLogOut();
    }

    @BeforeEach
    public void preCondiciones() {
        data = new ArrayList<String>();
        logIn = new LogInPage(driver);
        logIn.conexionDriver(browser, rutaDriver,property);
        logIn.maximize();
        logIn.cargarPagina("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        homePage = new HomePage(logIn.getDriver());
        employeePage = new EmployeePage(logIn.getDriver());
    }
}
