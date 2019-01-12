package BackEnd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amdemassh
 */
public class Database {

    public static Connection Connect() {
        String url = "jdbc:postgresql://localhost:5432/erpmarin_db";
        String usuario = "erpmarin_user";
        String senha = "1234";

        String driverName = "org.postgresql.Driver";

        Connection conn = null;
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public boolean cadastraConta(Conta x) {
        String stm = "INSERT INTO financeiro_controle (titular,num_ficha,dataIN,dataOUT,num_suite,diaria,"
                + "quiosque,frigobar,total,cartao,dinheiro,adiantamento,tipocartao) VALUES (?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?)";
        PreparedStatement pst;
        String dataTemp[] = x.getDataIn().split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        Date date = Date.valueOf(dataTemp2);

        String dataTemp3[] = x.getDataOut().split("/");
        String dataTemp4 = dataTemp3[2] + "-" + dataTemp3[1] + "-" + dataTemp3[0];

        Date date1 = Date.valueOf(dataTemp4);

        Connection conn = Database.Connect();

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, x.getTitular());
            pst.setInt(2, x.getNumFicha());
            pst.setDate(3, date);
            pst.setDate(4, date1);
            pst.setInt(5, x.getNumsuite());
            pst.setDouble(6, x.getDiaria());
            pst.setDouble(7, x.getQuiosque());
            pst.setDouble(8, x.getFrigobar());
            pst.setDouble(9, x.getTotal());
            pst.setDouble(10, x.getCartao());
            pst.setDouble(11, x.getDinheiro());
            pst.setDouble(12, x.getAdiantamento());
            pst.setInt(13, x.getTipoCartao());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ResultSet relatorioFinanceiro(String dataIn, String dataOut) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        String dataTemp[] = dataIn.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        String dataTemp1[] = dataOut.split("/");
        String dataTemp3 = dataTemp1[2] + "-" + dataTemp1[1] + "-" + dataTemp1[0];

        Date date = Date.valueOf(dataTemp2);
        Date date1 = Date.valueOf(dataTemp3);

        stm = "select sum(diaria) as \"diaria\",sum(quiosque) as \"quiosque\",sum(frigobar) as \"frigobar\", "
                + "sum(total) as \"total\" "
                + "from financeiro_controle where datain >= '" + dataTemp2 + "' and dataout <= '" + dataTemp3 + "'";

        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema ao consultar "
                    + "banco de dados, verifique!");
        }

        return rs;
    }

    public ResultSet buscaTodosProdutos() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from produto";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;

    }

    public boolean inserirProduto(String nome, float preco) {
        PreparedStatement pst;
        String stm = "INSERT INTO produto (nome,preco) values(?, ?)";

        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setString(1, nome);
            pst.setFloat(2, preco);
            pst.execute();
            conn.close();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte" + e);
            System.out.println("e" + e);
        }
        return false;
    }

    public ResultSet buscaProdutoRelatorio(String dataInicio, String dataFinal, String codigo) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;
        String dataTemp[] = dataInicio.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        String dataTemp1[] = dataFinal.split("/");
        String dataTemp3 = dataTemp1[2] + "-" + dataTemp1[1] + "-" + dataTemp1[0];

        Date date = Date.valueOf(dataTemp2);
        Date date1 = Date.valueOf(dataTemp3);

        stm = "select   t.id_produto,t.nome,sum(t.quantidade) as qtd, sum(t.valor_total) as valor "
                + "from lancamento t where t.id_produto=" + codigo + " and (data_venda::date >= '" + dataTemp2 + "' AND data_venda::date <='" + dataTemp3 + "') "
                + "group by t.id_produto,t.nome;";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;

    }

    public ResultSet buscaRelatorio(String dataInicio, String dataFinal) throws ParseException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;
        String dataTemp[] = dataInicio.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        String dataTemp1[] = dataFinal.split("/");
        String dataTemp3 = dataTemp1[2] + "-" + dataTemp1[1] + "-" + dataTemp1[0];

        Date date = Date.valueOf(dataTemp2);
        Date date1 = Date.valueOf(dataTemp3);
        
        stm = "select a.id_produto,sum(a.quantidade) as qtd,sum(a.valor_total) as total,a.nome FROM lancamento a \n"
                + "WHERE data_venda BETWEEN '" + dataTemp2 + "' AND '" + dataTemp3 + "' group by a.id_produto,a.nome order by qtd desc";
        System.out.println(stm);
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaRelatorioInterno(String dataInicio, String dataFinal) throws ParseException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;
        String dataTemp[] = dataInicio.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        String dataTemp1[] = dataFinal.split("/");
        String dataTemp3 = dataTemp1[2] + "-" + dataTemp1[1] + "-" + dataTemp1[0];

        Date date = Date.valueOf(dataTemp2);
        Date date1 = Date.valueOf(dataTemp3);

        stm = "select a.id_produto,sum(a.quantidade) as qtd,sum(a.valor_total) as total,a.nome FROM lancamentointerno a \n"
                + "WHERE data_venda BETWEEN '" + dataTemp2 + " 00:00' AND '" + dataTemp3 + " 23:59' group by a.id_produto, a.nome order by qtd desc";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaProduto(String codigo) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from produto where id = ? order by nome";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setInt(1, Integer.valueOf(codigo));
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;

    }

    public boolean insereComanda(int codigo, int quantidade, float valor_total, String nome, String data) throws ParseException {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        Date date = Date.valueOf(dataTemp2);
        String stm = "INSERT INTO lancamento (id_produto, quantidade, valor_total, nome, data_venda) values(?, ?, ?, ?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setInt(1, codigo);
            pst.setInt(2, quantidade);
            pst.setFloat(3, valor_total);
            pst.setString(4, nome);
            pst.setDate(5, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public boolean insereAgenda(String nome, String telFixo, String telMovel) {
        PreparedStatement pst;
        String stm = "INSERT INTO agenda (nome, telefone_fixo,telefone_movel ) values(?, ?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setString(1, nome);
            pst.setString(2, telFixo);
            pst.setString(3, telMovel);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public boolean insereFaturamentoEntrada(String valor, String data) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];
        Date date = Date.valueOf(dataTemp2);

        String stm = "INSERT INTO faturamento_entrada (valor, data) values(?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setFloat(1, (float) Double.parseDouble(valor));
            pst.setDate(2, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public boolean insereFaturamentoSaida(String valor, String data) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];
        Date date = Date.valueOf(dataTemp2);

        String stm = "INSERT INTO faturamento_saida (valor, data) values(?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setFloat(1, (float) Double.parseDouble(valor));
            pst.setDate(2, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public ArrayList buscaFaturamentoTotal(String dataIn, String dataOut) throws SQLException {
        PreparedStatement pst;
        ResultSet rs = null;
        String stm = null;
        ArrayList<String> retorno = new ArrayList<String>();

        String dataTemp[] = dataIn.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        String dataTemp1[] = dataOut.split("/");
        String dataTemp3 = dataTemp1[2] + "-" + dataTemp1[1] + "-" + dataTemp1[0];

        Date date = Date.valueOf(dataTemp2);
        Date date1 = Date.valueOf(dataTemp3);

        //usar no banco date e date1
        stm = "select sum(t.valor) as valor from faturamento_saida t where (data BETWEEN '" + date + "' AND '" + date1 + "')";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }

        while (rs.next()) {
            retorno.add(rs.getString("valor"));
        }

        stm = "select sum(t.valor) as valor from faturamento_entrada t where (data BETWEEN '" + date + "' AND '" + date1 + "')";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }

        while (rs.next()) {
            retorno.add(rs.getString("valor"));
        }

        return retorno;

    }

    public ResultSet buscaFaturamentoEntrada() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from faturamento_entrada order by data";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaFaturamentoSaida() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from faturamento_saida order by data";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public boolean cadastraFuncionario(Funcionario x) {
        String stm = "INSERT INTO FUNCIONARIO (nome,tel1,cargo,salario,extra,valorFolga,data_admissao) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst;

        String dataTemp3[] = x.getDataEntrada().split("/");
        String dataTemp4 = dataTemp3[2] + "-" + dataTemp3[1] + "-" + dataTemp3[0];

        Date date1 = Date.valueOf(dataTemp4);

        Connection conn = Database.Connect();

        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, x.getNome());
            pst.setString(2, x.getTelefone1());
            pst.setString(3, x.getCargo());
            pst.setDouble(4, x.getSalario());
            pst.setDouble(5, x.getExtra());
            pst.setDouble(6, x.getValorFolga());
            pst.setDate(7, date1);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ResultSet buscaFuncionario(String text) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "SELECT * from funcionario where id = ? order by nome";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setInt(1, Integer.valueOf(text));
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaFuncionarioNome(String text) {
        String stm = "select id,nome from funcionario where nome ilike '%" + text + "%'";
        PreparedStatement pst;
        ResultSet rs = null;

        Connection conn = Database.Connect();

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico e mostre a mensagem a seguir. " + ex);
        }
        return rs;
    }

    public ArrayList<Fornecedor> buscaTodosFornecedores(String nome) {
        ArrayList<Fornecedor> saida = new ArrayList<>();
        String stm = "select * from fornecedor where nome ilike  '%" + nome + "%'";
        PreparedStatement pst;
        ResultSet rs = null;
        System.out.println(stm);
        Connection conn = Database.Connect();

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();

            while (rs.next()) {
                saida.add(new Fornecedor(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico e mostre a mensagem a seguir. " + ex);
        }

        return saida;
    }

    public int buscaFornecedor(String text) throws SQLException {
        String stm = "select id from fornecedor where nome ilike '%" + text + "%'";
        PreparedStatement pst;
        ResultSet rs = null;
        int id = 0;
        Connection conn = Database.Connect();

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico e mostre a mensagem a seguir. " + ex);
        }
        while (rs.next()) {
            id = rs.getInt("id");

        }
        return id;
    }

    public boolean insereCompra(String nome, String quantidade, String id) {
        String stm = "INSERT INTO pedido (id_fornecedor, descricao, concluido, quantidade) VALUES (?,?,?,?)";
        PreparedStatement pst;

        Connection conn = Connect();
        try {
            pst = conn.prepareStatement(stm);
            pst.setInt(1, Integer.parseInt(id));
            pst.setString(2, nome);
            pst.setBoolean(3, false);
            pst.setInt(4, Integer.parseInt(quantidade));
            pst.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico e mostre a mensagem a seguir. " + ex);
        }
        return false;
    }

    public ResultSet buscaPedidos(String text) {
        String stm = "select a.id,id_fornecedor,descricao,concluido,quantidade,b.nome "
                + "from pedido a left join fornecedor b on a.id_fornecedor = b.id where nome "
                + "ilike '" + text + "' and a.concluido = false order by a.descricao";

        PreparedStatement pst;
        ResultSet rs = null;
        Connection conn = Database.Connect();

        try {
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, contate o suporte técnico e mostre a mensagem a seguir. " + ex);
        }

        return rs;

    }

    public boolean atualizaPedidos(String id) throws SQLException {

        String stm = "UPDATE pedido SET concluido = true where id_fornecedor = " + id + "";
        PreparedStatement pst;
        Connection conn = Database.Connect();
        boolean retorno = false;

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            retorno = true;
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public boolean insereComandaInterna(int codigo, int quantidade, float valor_total, String nome, String data) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        Date date = Date.valueOf(dataTemp2);
        String stm = "INSERT INTO lancamentoInterno (id_produto, quantidade, valor_total, nome, data_venda) values(?, ?, ?, ?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setInt(1, codigo);
            pst.setInt(2, quantidade);
            pst.setFloat(3, valor_total);
            pst.setString(4, nome);
            pst.setDate(5, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public ResultSet buscaProdutoRelatorioInterno(String dataInicio, String dataFinal, String codigo) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;
        String dataTemp[] = dataInicio.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        String dataTemp1[] = dataFinal.split("/");
        String dataTemp3 = dataTemp1[2] + "-" + dataTemp1[1] + "-" + dataTemp1[0];

        Date date = Date.valueOf(dataTemp2);
        Date date1 = Date.valueOf(dataTemp3);

        stm = "select   t.id_produto,t.nome,sum(t.quantidade) as qtd, sum(t.valor_total) as valor "
                + "from lancamentointerno t where t.id_produto=" + codigo + " and (data_venda::date >= '" + dataTemp2 + "' AND data_venda::date <='" + dataTemp3 + "') "
                + "group by t.id_produto,t.nome;";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;

    }

    public boolean insereManutencao(String data, String descricao) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        Date date = Date.valueOf(dataTemp2);
        String stm = "INSERT INTO manutencao (descricao, data, concluido) values(?, ?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setString(1, descricao);
            pst.setDate(2, date);
            pst.setBoolean(3, false);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public boolean inserePorcao(String camarao, String lula, String isca, String bolinho, String casquinha, String data) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        Date date = Date.valueOf(dataTemp2);
        String stm = "INSERT INTO porcao (camarao,lula,isca,bolinho,casquinha,data) values(?,?,?,?,?,?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setInt(1, Integer.parseInt(camarao));
            pst.setInt(2, Integer.parseInt(lula));
            pst.setInt(3, Integer.parseInt(isca));
            pst.setInt(4, Integer.parseInt(bolinho));
            pst.setInt(5, Integer.parseInt(casquinha));
            pst.setDate(6, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public ResultSet buscaManutenções() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select * from manutencao where concluido = false order by descricao";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public boolean marcaManutencaoFeito(String id) {
        String stm = "UPDATE manutencao SET concluido = true where id = " + id + "";
        PreparedStatement pst;
        Connection conn = Database.Connect();
        boolean retorno = false;

        try {
            pst = conn.prepareStatement(stm);
            pst.execute();
            retorno = true;
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public ResultSet buscaManutençõesFeitas() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select * from manutencao where concluido = true order by descricao";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaFichas() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select * from financeiro_controle order by titular";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaFichaHospede(String id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select * from financeiro_controle where id = " + id + "";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public boolean insereCardBooking(String titular, String id, String numCard, String validade, String cod) {
        String stm = "INSERT INTO bookingcard (titular, codreserva, numcard, validade, codseg) VALUES (?,?,?,?,?)";
        PreparedStatement pst;

        Connection conn = Connect();
        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, titular);
            pst.setString(2, id);
            pst.setString(3, numCard);
            pst.setString(4, validade);
            pst.setString(5, cod);
            pst.execute();
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean salvaFolga(String cod, String nome, String data) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        Date date = Date.valueOf(dataTemp2);
        String stm = "INSERT INTO folga_funcionario (id_funcionario, data) values(?, ?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setInt(1, Integer.parseInt(cod));
            pst.setDate(2, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;

    }

    public ResultSet buscaFolgas(String in, String out) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select a.id,a.nome,b.data from funcionario a inner join folga_funcionario b on (a.id = b.id_funcionario) and b.data between '" + in + "' and '" + out + "' order by a.nome,b.data";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public boolean cadastraExtra(String nome, String valor, String data, String cargo, String obs) {
        PreparedStatement pst;
        String dataTemp[] = data.split("/");
        String dataTemp2 = dataTemp[2] + "-" + dataTemp[1] + "-" + dataTemp[0];

        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");
        Date date = Date.valueOf(dataTemp2);
        String stm = "INSERT INTO extra (nome,cargo,obs,valor,data) values(?,?,?,?,?)";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            pst.setString(1, nome);
            pst.setString(2, cargo);
            pst.setString(3, obs);
            pst.setDouble(4, Double.parseDouble(valor));
            pst.setDate(5, date);
            pst.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return false;
    }

    public boolean cadastraAgenda(String nome, String fixo, String celular, String obs) {
        String stm = "INSERT INTO agenda (nome, fixo, celular, obs) VALUES (?,?,?,?)";
        PreparedStatement pst;

        Connection conn = Connect();
        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1, nome);
            pst.setString(2, fixo);
            pst.setString(3, celular);
            pst.setString(4, obs);
            pst.execute();
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public ResultSet buscaAgenda() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select * from agenda order by nome";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }

    public ResultSet buscaContatoAgenda(String a) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        String stm = null;

        stm = "select * from agenda where id = " + a + "";
        try {
            Connection conn = Database.Connect();
            pst = conn.prepareStatement(stm);
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao conectar ao banco, contate o suporte");
        }
        return rs;
    }
}
