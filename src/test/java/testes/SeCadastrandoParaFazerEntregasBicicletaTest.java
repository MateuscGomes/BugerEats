package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PageHome;
import suporte.Web;

public class SeCadastrandoParaFazerEntregasBicicletaTest {


    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();

    }
    @Test
    public void SeCadastrandoParaFazerEntregasBicicletaComDadosValidos(){
        String textoDaConfirmacaoDeCadastro= new PageHome(navegador)
                .clicarCadastreSeParaFazerEntregas()
                .digitarNome("Mateus Carneiro Gomes")
                .digitarCpf()
                .digitarEmail()
                .digitarNumeroWhatsapp("85999889988")
                .digitarCepEConfirmar("60851120")
                .digitarNumeroDaResidencia("145")
                .selecionarMetodoDeEntregaBicicleta()
                .inserirFotoDaCnh()
                .confirmandoCadastro()
                .screenshot("SeCadastrandoParaFazerEntregasBicicletaComDadosValidos")
                .capturarTextoDaConfirmacaoDoCadastro();
        Assert.assertEquals("Aí Sim...", textoDaConfirmacaoDeCadastro);

    }
    @Test
    public void SeCadastrandoParaFazerEntregasBicicletaComDadosInvalidos(){
        new PageHome(navegador)
                .clicarCadastreSeParaFazerEntregas()
                .digitarNome("Mateus")
                .digitarCpf()
                .digitarEmail()
                .digitarNumeroWhatsapp("85999889988")
                .digitarCepEConfirmar("60851120")
                .digitarNumeroDaResidencia("145")
                .inserirFotoDaCnh()
                .confirmandoCadastro()
                .screenshot("SeCadastrandoParaFazerEntregasBicicletaComDadosInvalidos")
                .clicarVoltarParaHome();
        Assert.assertEquals("Buger Eats", navegador.getTitle());
    }

    @After
    public void tearDonw(){
        navegador.quit();
    }

}
