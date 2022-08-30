package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCadastroDoCliente extends PageBase{



    public PageCadastroDoCliente(WebDriver navegador) {
        super(navegador);
    }
    // Digitar o nome completo no campo nome na página de cadastro do cliente.
    public PageCadastroDoCliente digitarNome(String nome){
        navegador.findElement(By.xpath("//input[@placeholder='Nome completo']")).sendKeys(nome);

        return this;
    }
    // Digitar o CPF no campo CPFna página de cadastro do cliente.
    public PageCadastroDoCliente digitarCpf(){
        navegador.findElement(By.xpath("//input[@placeholder='CPF somente números']")).sendKeys(RandomCPFGenerator.randomCPF());

        return this;
    }
    // Digitar o E-Mail no campo E-Mail na página de cadastro do cliente.
    public PageCadastroDoCliente digitarEmail(){
        navegador.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys(RandomEmailGenerator.randomEmail() + "@email.com");

        return this;
    }
    // Digitar o número do Whatsapp no campo Whatsapp na página de cadastro do cliente.
    public PageCadastroDoCliente digitarNumeroWhatsapp(String numeroWhatsapp){
        navegador.findElement(By.xpath("//input[@placeholder='Whatsapp']")).sendKeys(numeroWhatsapp);

        return this;
    }
    // Digitar o numero do CEP e apertar o botão Buscar CEP na página de cadastro do cliente.
    public PageCadastroDoCliente digitarCepEConfirmar(String cep){
        navegador.findElement(By.xpath("//input[@placeholder='CEP']")).sendKeys(cep);
        navegador.findElement(By.xpath("//input[@value='Buscar CEP']")).click();

        return this;
    }
    // Digitar o número da residência no campo Número na página de cadastro do cliente.
    public PageCadastroDoCliente digitarNumeroDaResidencia(String numeroDaResidencia){
        navegador.findElement(By.xpath("//input[@placeholder='Número']")).sendKeys(numeroDaResidencia);

        return this;
    }
    // Selecionar o método de entrega moto na página de cadastro do cliente.
    public PageCadastroDoCliente selecionarMetodoDeEntregaMoto(){
        navegador.findElement(By.xpath("//span[text()='Moto']")).click();

        return this;
    }
    //Selecionar o método de entrega bicicleta na página de cadastro do cliente.
    public PageCadastroDoCliente selecionarMetodoDeEntregaBicicleta(){
        navegador.findElement(By.xpath("//span[text()='Bicicleta']")).click();

        return this;
    }
    //Selecionar o método de entrega bicicleta na página de cadastro do cliente.
    public PageCadastroDoCliente selecionarMetodoDeEntregaVanCarro(){
        navegador.findElement(By.xpath("//span[text()='Van/Carro']"));

        return this;
    }
    // Selecionar o campo Imagem e adicionar foto da CNH.
    public PageCadastroDoCliente inserirFotoDaCnh(){
        String foto = "C:/Users/mateu/ImagemCnh.jpg"; // Na sua máquina utilizar uma imagem e mencionar o próprio caminho do local do arquivo.
        navegador.findElement(By.xpath("//input[@accept='image/*']")).sendKeys(foto);

        return this;
    }
    // Clicar no botão para para confirmar o cadastro.
    public PageCadastroDoCliente confirmandoCadastro(){
        navegador.findElement(By.className("button-success")).click();

        return this;
    }
    public PageCadastroDoCliente screenshot(String metodoDeEntrega){
        String arquivo = "C:/Users/mateu/Screenshot/BugerEats/" + DataGenerator.dataHoraParaArquivo() + metodoDeEntrega + ".png";
        Screenshot.tirar(navegador, arquivo );

        return this;
    }
    public PageHome fecharEVoltarParaPageHome(){
        navegador.findElement(By.xpath("//button[text()='Fechar']")).click();

        return new PageHome(navegador);
    }
    public PageHome clicarVoltarParaHome(){
        navegador.findElement(By.linkText("Voltar para home"));

        return new PageHome(navegador);
    }

}
