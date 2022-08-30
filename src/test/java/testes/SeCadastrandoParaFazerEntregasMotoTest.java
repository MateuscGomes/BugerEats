package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PageHome;
import suporte.Web;

public class SeCadastrandoParaFazerEntregasMotoTest {


    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();

    }

    @Test
    public void SeCadastrandoParaFazerEntregasMotoComDadosValidos(){
        String textoDaConfirmacaoDoCadastro =  new PageHome(navegador)
                .clicarCadastreSeParaFazerEntregas()
                .digitarNome("Mateus Carneiro Gomes")
                .digitarCpf()
                .digitarEmail()
                .digitarNumeroWhatsapp("85988998899")
                .digitarCepEConfirmar("60851120")
                .digitarNumeroDaResidencia("544")
                .selecionarMetodoDeEntregaMoto()
                .inserirFotoDaCnh()
                .confirmandoCadastro()
                .screenshot("SeCadastrandoParaFazerEntregasMotoComDadosValidos")
                .capturarTextoDaConfirmacaoDoCadastro();
        Assert.assertEquals("Aí Sim...", textoDaConfirmacaoDoCadastro);

    }

    @Test
    public void SeCadastrandoParafazerEntregasMotoComDadosInvalidos(){
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
                .screenshot("SeCadastrandoParafazerEntregasMotoComDadosInvalidos")
                .clicarVoltarParaHome();
        Assert.assertEquals("Buger Eats", navegador.getTitle());

    }

    @After
    public void tearDonw(){
        navegador.quit();
    }

}
