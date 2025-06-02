package com.example.helloselenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
