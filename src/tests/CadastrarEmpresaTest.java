package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastrarEmpresaTest {

	WebDriver driver;

	@Dado("^Acessar a pagina cadastro de empresas$")
	public void acessar_a_pagina_cadastro_de_empresas() {

		// definindo o local onde esta o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// Abrindo o google chrome
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// Acessando a pagina de cadastro de funcionario
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio06");

	}

	@Dado("^informar nome fantasia \"([^\"]*)\"$")
	public void informar_nome_fantasia(String nomefantasia) {

		driver.findElement(By.xpath("//*[@id=\"NomeFantasia\"]")).sendKeys(nomefantasia);

	}

	@Dado("^informar a razao sicial \"([^\"]*)\"$")
	public void informar_a_razao_sicial(String Rsocial) {

		driver.findElement(By.xpath("//*[@id=\"RazaoSocial\"]")).sendKeys(Rsocial);

	}

	@Dado("^selecionar a categoria \"([^\"]*)\"$")
	public void selecionar_a_categoria(String categoria) {

		new Select(driver.findElement(By.xpath("//*[@id=\"Categoria\"]"))).selectByVisibleText(categoria);

	}

	@Dado("^informar o CNPJ \"([^\"]*)\"$")
	public void informar_o_CNPJ(String CNPJ) {

		driver.findElement(By.xpath("//*[@id=\"Cnpj\"]")).sendKeys(CNPJ);

	}

	@Dado("^informar a descricao da empresa \"([^\"]*)\"$")
	public void informar_a_descricao_da_empresa(String descricao) {

		driver.findElement(By.xpath("//*[@id=\"Descricao\"]")).sendKeys(descricao);

	}

	@Quando("^Realizar cadastro de empresa$")
	public void realizar_cadastro_de_empresa() {

		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Entao("^o sistema exibe a mensagem \"([^\"]*)\"$")
	public void o_sistema_exibe_a_mensagem(String resultado) {

		// ler a mensagem exibida na tela do sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando a mensagem obitida com o resultado esperado na feature
		assertEquals(mensagem, resultado);

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\cucumber\\Cadastro de Empresa " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

	@Entao("^o sistema exibe a mensagem campo obrigatorio$")
	public void o_sistema_exibe_a_mensagem_campo_obrigatorio() {

		// ler a mensagem de erro exibida em cada campo
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[1]/div/span")).getText();
		String erroCNPJ = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div/span")).getText();
		String erroRazãoSocial = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[2]/div/span"))
				.getText();
		String erroCategoria = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[2]/div/span"))
				.getText();
		String erroDescrição = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div/div/span")).getText();

		// comparar o conteudo de cada mensagem
		assertEquals(erroNome, "Campo obrigatório");
		assertEquals(erroCNPJ, "Campo obrigatório");
		assertEquals(erroRazãoSocial, "Campo obrigatório");
		assertEquals(erroCategoria, "Campo obrigatório");
		assertEquals(erroDescrição, "Campo obrigatório");

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\cucumber\\Validacao Cadastro de Empresa " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();
	}

}
