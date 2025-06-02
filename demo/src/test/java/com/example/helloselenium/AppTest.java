package com.example.helloselenium;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

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

    @Test
    public void verificarPresencaDoLinkSeleniumComFindElements() {
        System.setProperty("webdriver.chrome.driver", "C://Users//esthe//Desktop//selenium//chrome-driver//chromedriver-win64//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            // Aceita cookies, se necessário
            try {
                WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement aceitar = shortWait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//div[text()='Aceitar tudo' or text()='Accept all']")));
                aceitar.click();
            } catch (Exception ignored) {}

            // Digita no campo de busca
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            // Aguarda o botão de busca e clica
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
            searchButton.click();

            // Aguarda os resultados aparecerem
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

            // Usa findElements para procurar o link do site oficial do Selenium
            List<WebElement> resultados = driver.findElements(By.partialLinkText("SeleniumHQ"));

            // Verifica se o link está presente
            Assert.assertFalse("O link para o site oficial do Selenium não foi encontrado.", resultados.isEmpty());

        } finally {
            driver.quit();
        }
    }

        @Test
         public void testaNavegacao() {
            System.setProperty("webdriver.chrome.driver", "C://Users//esthe//Desktop//selenium//chrome-driver//chromedriver-win64//chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            try {
                // Acessa o Google
                driver.get("https://www.google.com");
                String tituloGoogle = driver.getTitle();
                Assert.assertTrue("Título não contém 'Google'", tituloGoogle.contains("Google"));

                // Navega para a página 'Sobre o Google'
                driver.navigate().to("https://about.google/");
                String tituloAbout = driver.getTitle();
                Assert.assertTrue("Título da página 'Sobre' não contém 'Google'", tituloAbout.contains("Google"));

                // Volta para a página do Google
                driver.navigate().back();
                String tituloVolta = driver.getTitle();
                Assert.assertEquals("Google", tituloVolta);

                // Avança novamente para a página 'Sobre'
                driver.navigate().forward();
                String tituloAvanco = driver.getTitle();
                Assert.assertTrue("Título após avançar não contém 'Google'", tituloAvanco.contains("Google"));

                // Recarrega a página atual
                driver.navigate().refresh();

            } finally {
                driver.quit();
            }
    }

        @Test
        public void tirarPrintEmCasoDeFalha() {
            System.setProperty("webdriver.chrome.driver", "C://Users//esthe//Desktop//selenium//chrome-driver//chromedriver-win64//chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            
            try {
                driver.get("https://www.google.com");
                // Grave um screenshot caso falhe
                Assert.assertTrue("Verificando elemento inexistente", driver.findElement(By.id("inexistente")).isDisplayed());
            } catch (NoSuchElementException e) {
                // Captura a screenshot em caso de falha
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File("C://Users//esthe//Documents//helloword-selenium//demo//src//test//java//com//example//FailedTestScreenshots//screenshot"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } finally {
                driver.quit();
            }
         }



}
