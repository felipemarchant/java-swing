import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

abstract class TelaCadastroVeiculo extends JFrame {

    protected final Container ctnPane = getContentPane();
    protected GroupLayout grpLayout;
    protected GroupLayout.ParallelGroup seqGroupHor;
    protected GroupLayout.SequentialGroup seqGroupVer;

    protected final JLabel lblPlaca = new JLabel("Placa: ");
    protected final JLabel lblMarca = new JLabel("Marca: ");
    protected final JLabel lblModelo = new JLabel("Modelo: ");
    protected final JLabel lblCor = new JLabel("Cor: ");
    protected final JLabel lblQtdRodas = new JLabel("Qtd. Rodas: ");
    protected final JLabel lblVelocMax = new JLabel("Velocidade Máx: ");
    protected final JLabel lblQtdPistoes = new JLabel("Qtd Pistões: ");
    protected final JLabel lblPotencia = new JLabel("Potência: ");
    protected final JLabel lblInfoPlaca = new JLabel("Informe a Placa: ");

    protected final JTextField txtPlaca = new JTextField(15);
    protected final JTextField txtMarca = new JTextField(15);
    protected final JTextField txtModelo = new JTextField(15);
    protected final JTextField txtCor = new JTextField(15);
    protected final JTextField txtQtdRodas = new JTextField(15);
    protected final JTextField txtVelocMax = new JTextField(15);
    protected final JTextField txtQtdPistoes = new JTextField(15);
    protected final JTextField txtPotencia = new JTextField(15);
    protected final JTextField txtInfoPlaca = new JTextField(15);

    protected final JButton btnCadastrar = new JButton("Cadastrar");
    protected final JButton btnLimpar = new JButton("Limpar");
    protected final JButton btnNovo = new JButton("Novo");
    protected final JButton btnSair = new JButton("Sair");

    public TelaCadastroVeiculo(String title) {
        super(title);
        configTela();
    }

    private void configTela() {
        initConfigTela();
        Dimension dimensoes = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(640, 480);
        setLocation((int) ((dimensoes.getWidth() - getWidth()) / 2), (int) ((dimensoes.getHeight() - getHeight()) / 2));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        lblInfoPlaca.setForeground(Color.red);
        grpLayout = new GroupLayout(ctnPane);
        grpLayout.setAutoCreateGaps(true);
        grpLayout.setAutoCreateContainerGaps(true);
        seqGroupHor = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(grpLayout.createSequentialGroup()
                        .addGroup(addLabelGrupoParaleloHorizontal())
                        .addGroup(addFieldGrupoParaleloHorizontal()))
                .addGroup(addButtonHorizontal(grpLayout.createSequentialGroup()));
        seqGroupVer = grpLayout.createSequentialGroup()
                .addGroup(addGrupoSequencialVertical())
                .addGroup(addButtonVertical(grpLayout.createParallelGroup()));
        grpLayout.setHorizontalGroup(seqGroupHor);
        grpLayout.setVerticalGroup(seqGroupVer);
        ctnPane.setLayout(grpLayout);
        pack();
        setLocationRelativeTo(null);
    }

    protected abstract void initConfigTela();

    protected GroupLayout.Group addButtonVertical(GroupLayout.ParallelGroup buttons) {
        return buttons.addComponent(btnCadastrar)
                .addComponent(btnLimpar)
                .addComponent(btnNovo)
                .addComponent(btnSair);
    }

    protected GroupLayout.Group addButtonHorizontal(GroupLayout.SequentialGroup buttons) {
        return buttons.addComponent(btnCadastrar)
                .addComponent(btnLimpar)
                .addComponent(btnNovo)
                .addComponent(btnSair);
    }

    protected GroupLayout.ParallelGroup initCreateLblParallelGroup(GroupLayout.ParallelGroup group) {
        return group;
    }

    protected GroupLayout.ParallelGroup initCreateTxtParallelGroup(GroupLayout.ParallelGroup group) {
        return group;
    }

    protected GroupLayout.SequentialGroup initCreateSequentialGroup(GroupLayout.SequentialGroup group) {
        return group;
    }

    protected GroupLayout.ParallelGroup addLabelGrupoParaleloHorizontal() {
        return initCreateLblParallelGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
                .addComponent(lblPlaca)
                .addComponent(lblMarca)
                .addComponent(lblModelo)
                .addComponent(lblCor)
                .addComponent(lblQtdRodas)
                .addComponent(lblVelocMax)
                .addComponent(lblQtdPistoes)
                .addComponent(lblPotencia);
    }

    protected GroupLayout.ParallelGroup addFieldGrupoParaleloHorizontal() {
        return initCreateTxtParallelGroup(grpLayout.createParallelGroup())
                .addComponent(txtPlaca)
                .addComponent(txtMarca)
                .addComponent(txtModelo)
                .addComponent(txtCor)
                .addComponent(txtQtdRodas)
                .addComponent(txtVelocMax)
                .addComponent(txtQtdPistoes)
                .addComponent(txtPotencia);
    }

    protected GroupLayout.SequentialGroup addGrupoSequencialVertical() {
        return initCreateSequentialGroup(grpLayout.createSequentialGroup())
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPlaca)
                        .addComponent(txtPlaca))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMarca)
                        .addComponent(txtMarca))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblModelo)
                        .addComponent(txtModelo))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCor)
                        .addComponent(txtCor))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQtdRodas)
                        .addComponent(txtQtdRodas))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVelocMax)
                        .addComponent(txtVelocMax))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQtdPistoes)
                        .addComponent(txtQtdPistoes))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPotencia)
                        .addComponent(txtPotencia));
    }

    protected void disableFields() {
        txtPlaca.setEditable(false);
        txtMarca.setEditable(false);
        txtModelo.setEditable(false);
        txtCor.setEditable(false);
        txtQtdPistoes.setEditable(false);
        txtQtdRodas.setEditable(false);
        txtVelocMax.setEditable(false);
        txtPotencia.setEditable(false);
    }

    protected void limparCampos(ActionEvent actionEvent) {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtQtdRodas.setText("");
        txtVelocMax.setText("");
        txtQtdPistoes.setText("");
        txtPotencia.setText("");
    }
}
