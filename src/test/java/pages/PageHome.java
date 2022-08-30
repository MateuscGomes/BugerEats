package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHome extends PageBase{

    public PageHome(WebDriver navegador) {
        super(navegador);
    }
    // Clicando no botão Cadastra-se para fazer entregas e ser direcionado para a página de cadastro.
    public PageCadastroDoCliente clicarCadastreSeParaFazerEntregas(){
        navegador.findElement(By.xpath("//strong[text()='Cadastre-se para fazer entregas']")).click();


        return new PageCadastroDoCliente(navegador);
    }
}
