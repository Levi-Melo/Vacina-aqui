package client.atend;
import services.AttendantsService;

import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Rosicléia Frasson
 */
public class Queue extends JFrame {
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;

    String [] colunas = {"id", "nome", "cpf", "age", "state","city", "priority"};


    public Queue() {
        super ("Contatos");
    }

    public void criaJanela(Object[][] fila){

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(fila, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException, IOException {
        Queue lc = new Queue();
        AttendantsService att = new AttendantsService();
        Object [][] fila = att.consultQueue();
        lc.criaJanela(fila);
    }
}