import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

class TelaImprimirVeiculo extends JFrame {

    private JFrame parent;
    protected final Container ctnPane = getContentPane();
    protected GroupLayout grpLayout;
    protected GroupLayout.ParallelGroup seqGroupHor;
    protected GroupLayout.SequentialGroup seqGroupVer;

    protected JTable tabela = new JTable();
    protected JButton btnImprirmir = new JButton("Imprirmir todos");
    protected JButton btnExcluir = new JButton("Excluir todos");
    protected JButton btnSair = new JButton("Sair");

    protected Class<? extends Veiculo> clazz;

    public TelaImprimirVeiculo(Class<? extends Veiculo> clazz, JFrame parent) {
        super("Imprimir / Excluir todos");
        this.parent = parent;
        this.clazz = clazz;
        configTela();
        setVisible(true);
    }

    private void configTela() {
        Dimension dimensoes = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1024, 480);
        setLocation((int) ((dimensoes.getWidth() - getWidth()) / 2), (int) ((dimensoes.getHeight() - getHeight()) / 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        grpLayout = new GroupLayout(ctnPane);
        grpLayout.setAutoCreateGaps(true);
        grpLayout.setAutoCreateContainerGaps(true);

        tabela.setModel(setModel());
        JScrollPane scrPane = new JScrollPane(tabela);
        scrPane.setPreferredSize(new Dimension(1024, 480));
        seqGroupHor = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrPane)
                .addGroup(grpLayout.createSequentialGroup().addComponent(btnImprirmir).addComponent(btnExcluir).addComponent(btnSair));
        seqGroupVer = grpLayout.createSequentialGroup()
                .addComponent(scrPane)
                .addGroup(grpLayout.createParallelGroup()
                        .addComponent(btnImprirmir)
                        .addComponent(btnExcluir)
                        .addComponent(btnSair));
        grpLayout.setHorizontalGroup(seqGroupHor);
        grpLayout.setVerticalGroup(seqGroupVer);
        ctnPane.setLayout(grpLayout);
        setLocationRelativeTo(null);
        btnSair.addActionListener(this::closeOperation);
        btnImprirmir.addActionListener(this::imprimirTodos);
        btnExcluir.addActionListener(this::removeTodos);
        pack();
    }

    private void imprimirTodos(ActionEvent actionEvent) {
        List<?> lista = clazz.equals(Passeio.class) ? BDVeiculos.todosPas() : BDVeiculos.todosCarg();
        new TelaImprimirDadosVeiculos(this, lista);
        setVisible(false);
    }

    private AbstractTableModel setModel() {
        return clazz.equals(Passeio.class) ? new PasseioTableModel(BDVeiculos.todosPas()) : new CargaTableModel(BDVeiculos.todosCarg());
    }

    private void removeTodos(ActionEvent actionEvent) {
        if (clazz.equals(Passeio.class)) {
            BDVeiculos.removeTodosPas();
            tabela.setModel(setModel());
            return;
        }
        BDVeiculos.removeTodosCarg();
        tabela.setModel(setModel());
    }

    private void closeOperation(ActionEvent actionEvent) {
        setVisible(false);
        parent.setVisible(true);
        dispose();
    }
}
