import javax.swing.*;
import java.awt.event.ActionEvent;

class TelaConsultaCarga extends TelaCadastroVeiculo {

    private JFrame parent;
    private JLabel lblTara;
    private JTextField txtTara;
    private JLabel lblCargaMax;
    private JTextField txtCargaMax;

    private JButton btnConsultar;
    private JButton btnExcluir;

    public TelaConsultaCarga(JFrame parent) {
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
        lblTara = new JLabel("Tara: ");
        lblCargaMax = new JLabel("Carga Máx.: ");
        txtTara = new JTextField(15);
        txtCargaMax = new JTextField(15);
        btnConsultar = new JButton("Consultar");
        btnExcluir = new JButton("Excluir");
        btnSair.addActionListener(this::closeOperation);
        btnConsultar.addActionListener(this::consultarCarga);
        btnExcluir.addActionListener(this::excluirCarga);
        disableFields();
    }

    private void excluirCarga(ActionEvent actionEvent) {
        String placa = txtInfoPlaca.getText().trim();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Carga carga = BDVeiculos.buscaCargaPorId(placa);
        if (carga == null) {
            JOptionPane.showMessageDialog(null, "Veículo de carga não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        BDVeiculos.removeCarg(carga);
        JOptionPane.showMessageDialog(null, "Veículo de carga removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        closeOperation(null);
    }

    private void consultarCarga(ActionEvent actionEvent) {
        String placa = txtInfoPlaca.getText().trim();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Carga carga = BDVeiculos.buscaCargaPorId(placa);
        if (carga == null) {
            JOptionPane.showMessageDialog(null, "Veículo de carga não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        txtPlaca.setText(carga.getPlaca());
        txtMarca.setText(carga.getMarca());
        txtModelo.setText(carga.getModelo());
        txtCor.setText(carga.getCor());
        txtQtdRodas.setText(carga.getQtdRodas() + "");
        txtVelocMax.setText(carga.getVelocMax() + "");
        txtQtdPistoes.setText(carga.getMotor().getQtdPist() + "");
        txtPotencia.setText(carga.getMotor().getPotencia() + "");
        txtTara.setText(carga.getTara() + "");
        txtCargaMax.setText(carga.getCargaMax() + "");
    }

    @Override
    protected void disableFields() {
        txtTara.setEditable(false);
        txtCargaMax.setEditable(false);
        super.disableFields();
    }

    @Override
    protected GroupLayout.ParallelGroup addLabelGrupoParaleloHorizontal() {
        return super.addLabelGrupoParaleloHorizontal().addComponent(lblTara).addComponent(lblCargaMax);
    }

    @Override
    protected GroupLayout.ParallelGroup addFieldGrupoParaleloHorizontal() {
        return super.addFieldGrupoParaleloHorizontal().addComponent(txtTara).addComponent(txtCargaMax);
    }

    @Override
    protected GroupLayout.SequentialGroup addGrupoSequencialVertical() {
        return super.addGrupoSequencialVertical().addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTara)
                .addComponent(txtTara))
                .addGroup(grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCargaMax)
                        .addComponent(txtCargaMax));
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
