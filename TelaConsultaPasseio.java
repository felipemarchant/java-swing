import javax.swing.*;
import java.awt.event.ActionEvent;

class TelaConsultaPasseio extends TelaCadastroVeiculo {

    private JFrame parent;
    private JLabel lblQtdePassageiros;
    private JTextField txtQtdePassageiros;

    private JButton btnConsultar;
    private JButton btnExcluir;

    public TelaConsultaPasseio(JFrame parent) {
        super("Consultar / Excluir pela Placa");
        this.parent = parent;
        setVisible(true);
    }

    private void closeOperation(ActionEvent e) {
        setVisible(false);
        parent.setVisible(true);
        dispose();
    }

    @Override
    protected void initConfigTela() {
        lblQtdePassageiros = new JLabel("Qtd. Passageiros: ");
        txtQtdePassageiros = new JTextField(15);
        btnConsultar = new JButton("Consultar");
        btnExcluir = new JButton("Excluir");
        btnSair.addActionListener(this::closeOperation);
        btnConsultar.addActionListener(this::consultarPasseio);
        btnExcluir.addActionListener(this::excluirPasseio);
        disableFields();
    }

    private void excluirPasseio(ActionEvent actionEvent) {
        String placa = txtInfoPlaca.getText().trim();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Passeio passeio = BDVeiculos.buscaPasseioPorId(placa);
        if (passeio == null) {
            JOptionPane.showMessageDialog(null, "Veículo de passeio não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        BDVeiculos.removePas(passeio);
        JOptionPane.showMessageDialog(null, "Veículo de passeio removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        closeOperation(null);
    }

    private void consultarPasseio(ActionEvent actionEvent) {
        String placa = txtInfoPlaca.getText().trim();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Passeio passeio = BDVeiculos.buscaPasseioPorId(placa);
        if (passeio == null) {
            JOptionPane.showMessageDialog(null, "Veículo de passeio não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        txtPlaca.setText(passeio.getPlaca());
        txtMarca.setText(passeio.getMarca());
        txtModelo.setText(passeio.getModelo());
        txtCor.setText(passeio.getCor());
        txtQtdRodas.setText(passeio.getQtdRodas() + "");
        txtVelocMax.setText(passeio.getVelocMax() + "");
        txtQtdPistoes.setText(passeio.getMotor().getQtdPist() + "");
        txtPotencia.setText(passeio.getMotor().getPotencia() + "");
        txtQtdePassageiros.setText(passeio.getQtdePassageiros() + "");
    }

    @Override
    protected void disableFields() {
        txtQtdePassageiros.setEditable(false);
        super.disableFields();
    }

    @Override
    protected GroupLayout.ParallelGroup addLabelGrupoParaleloHorizontal() {
        return super.addLabelGrupoParaleloHorizontal().addComponent(lblQtdePassageiros);
    }

    @Override
    protected GroupLayout.ParallelGroup addFieldGrupoParaleloHorizontal() {
        return super.addFieldGrupoParaleloHorizontal().addComponent(txtQtdePassageiros);
    }

    @Override
    protected GroupLayout.SequentialGroup addGrupoSequencialVertical() {
        return super.addGrupoSequencialVertical().addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblQtdePassageiros)
                .addComponent(txtQtdePassageiros));
    }

    @Override
    protected GroupLayout.ParallelGroup initCreateLblParallelGroup(GroupLayout.ParallelGroup group) {
        return super.initCreateLblParallelGroup(group).addComponent(lblInfoPlaca);
    }

    @Override
    protected GroupLayout.ParallelGroup initCreateTxtParallelGroup(GroupLayout.ParallelGroup group) {
        return super.initCreateTxtParallelGroup(group).addComponent(txtInfoPlaca);
    }

    @Override
    protected GroupLayout.SequentialGroup initCreateSequentialGroup(GroupLayout.SequentialGroup group) {
        return super.initCreateSequentialGroup(group).addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblInfoPlaca)
                .addComponent(txtInfoPlaca));
    }

    @Override
    protected GroupLayout.Group addButtonHorizontal(GroupLayout.SequentialGroup buttons) {
        return buttons
                .addComponent(btnConsultar)
                .addComponent(btnExcluir)
                .addComponent(btnSair);
    }

    @Override
    protected GroupLayout.Group addButtonVertical(GroupLayout.ParallelGroup buttons) {
        return buttons
                .addComponent(btnConsultar)
                .addComponent(btnExcluir)
                .addComponent(btnSair);
    }
}
