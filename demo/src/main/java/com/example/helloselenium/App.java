
package com.example.helloselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\esthe\\Desktop\\selenium");

        // Instancia o Navegador
        WebDriver chrome = new ChromeDriver();

        try {
            // Abre o navegador
            chrome.get("https://www.bing.com/?cc=br");

            // Digita "Hello World"
            WebElement campoBusca = chrome.findElement(By.name("q"));
            campoBusca.sendKeys("Hello World");
            campoBusca.submit();

            // Aguarda 10 segundos
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
            
        } finally {
            // Fecha o navegador
            chrome.quit();
        }
    }
}
