package padroesCriacao.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class conexaoBancoTest {

    @Test
    public void deveRetornarCaminhoPPPoE(){
        conexaoPPPoE.getInstance().setCaminho("Caminho 01");
        assertEquals("Caminho 01",conexaoPPPoE.getInstance().getCaminho());
    }

    @Test
    public void deveRetornarUsuarioPPPoE(){
        conexaoPPPoE.getInstance().setUsuario("Usuario 01");
        assertEquals("Usuario 01",conexaoPPPoE.getInstance().getUsuario());
    }

    @Test
    public void deveRetornarSenhaPPPoE(){
        conexaoPPPoE.getInstance().setSenha("Senha 01");
        assertEquals("Senha 01",conexaoPPPoE.getInstance().getSenha());
    }

    @Test
    public void deveRetornarConexao(){
        conexaoPPPoE.getInstance().getConexao();
    }

    @Test
    public void deveRetornarFechamentoConexao(){
        conexaoPPPoE.getInstance().fechaConexao();
    }

}