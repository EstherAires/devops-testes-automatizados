package com.example.helloselenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class AppTest {
    @Test
    public void navegacaoVerificacaoDeTitulo() {
        // Define o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://Users//esthe//Desktop//selenium//chrome-driver//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Navega para o Google
        driver.get("https://www.google.com");
        
        // Obtém o título da página
        String title = driver.getTitle();
        
        // Verifica se o título é "Google"
        Assert.assertEquals("Google", title);
        
        // Fecha o navegador
        driver.quit();
    }

    @Test
    public void localizandoElementosEInteragindo() {
        System.setProperty("webdriver.chrome.driver", "C://Users//esthe//Desktop//selenium//chrome-driver//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            // Aceita cookies se aparecer (dependendo da sua região)
            try {
                WebElement aceitar = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Aceitar tudo' or text()='Accept all']")));
                aceitar.click();
            } catch (Exception e) {
                // Ignora se não aparecer
            }

            // Localiza o campo de busca e envia o termo
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            // Aguarda o botão "Pesquisar Google" estar clicável
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchButton = wait.until(ExpectedConditions
                    .elementToBeClickable(By.name("btnK")));

            searchButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha o navegador
            driver.quit();
        }
    }




}
