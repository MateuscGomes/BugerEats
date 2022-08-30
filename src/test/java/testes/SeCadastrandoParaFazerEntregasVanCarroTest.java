package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PageHome;
import suporte.Web;

public class SeCadastrandoParaFazerEntregasVanCarroTest {


    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();

    }
    @Test
    public void SeCadastrandoParaFazerEntregasVanCarroComDadosValidos(){
        String textoDeConfirmacaoDeCadastro = new PageHome(navegador)
                .clicarCadastreSeParaFazerEntregas()
                .digitarNome("Mateus Carneiro Gomes")
                .digitarCpf()
                .digitarEmail()
                .digitarNumeroWhatsapp("85999889988")
                .digitarCepEConfirmar("60851120")
                .digitarNumeroDaResidencia("145")
                .selecionarMetodoDeEntregaVanCarro()
                .inserirFotoDaCnh()
                .confirmandoCadastro()
                .screenshot("SeCadastrandoParaFazerEntregasVanCarroComDadosValidos")
                .capturarTextoDaConfirmacaoDoCadastro();
        Assert.assertEquals("Aí Sim...",textoDeConfirmacaoDeCadastro);
    }

    @Test
    public void SeCadastrandoParaFazerEntregasVanCarroComDadosInvalidos(){
        new PageHome(navegador)
                .clicarCadastreSeParaFazerEntregas()
                .digitarNome("Mateus")
                .digitarCpf()
                .digitarEmail()
                .digitarNumeroWhatsapp("85999889988")
                .digitarCepEConfirmar("60851120")
                .digitarNumeroDaResidencia("100")
                .inserirFotoDaCnh()
                .confirmandoCadastro()
                .screenshot("SeCadastrandoParaFazerEntregasVanCarroComDadosInvalidos")
                .clicarVoltarParaHome();


        Assert.assertEquals("Buger Eats", navegador.getTitle() );


    }

    @After
    public void tearDonw(){
        navegador.quit();
    }

}
