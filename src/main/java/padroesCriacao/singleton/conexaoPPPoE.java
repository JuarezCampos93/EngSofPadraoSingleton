package padroesCriacao.singleton;
import javax.swing.*;
import java.sql.*;
public class conexaoPPPoE {

    private String driver = "org.gjt.mm.mysql.Driver";
    private String caminho = null;
    private String usuario = null;
    private String senha = null;
    private Connection conexao = null;

    private conexaoPPPoE(){}

    private static conexaoPPPoE instance = new conexaoPPPoE();

    public static synchronized  conexaoPPPoE getInstance() {
        return instance;
    }

    public String getCaminho() {
        return caminho;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public Connection getConexao() {
        try {
            if (this.conexao == null) {
                Class.forName(driver);
                this.conexao = DriverManager.getConnection(this.caminho, this.usuario, this.senha);
            } else if (this.conexao.isClosed()) {
                this.conexao = null;
                return getConexao();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro não há vinculo PPPoE criado");
        } catch (SQLException e) {
            System.out.println("Erro não há vinculo PPPoE criado");
        }
        return this.conexao;
    }

    public void fechaConexao(){
        if (this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException e) {
               System.out.println("Conexao Feita e encerrada");
            }
        }
    }
}