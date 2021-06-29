import javax.swing.*;
import java.awt.event.ActionEvent;

class TelaCadastroCarga extends TelaCadastroVeiculo {

    private JFrame parent;
    private JLabel lblTara;
    private JTextField txtTara;
    private JLabel lblCargaMax;
    private JTextField txtCargaMax;

    public TelaCadastroCarga(JFrame parent) {
        super("Cadastro de Carga");
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
        btnSair.addActionListener(this::closeOperation);
        btnCadastrar.addActionListener(this::salvarCarga);
        btnLimpar.addActionListener(this::limparCampos);
        btnNovo.addActionListener(this::novaTela);
    }

    protected void limparCampos(ActionEvent actionEvent) {
        super.limparCampos(actionEvent);
        txtTara.setText("");
        txtCargaMax.setText("");
    }

    private void novaTela(ActionEvent actionEvent) {
        setVisible(false);
        new TelaCadastroCarga(parent);
        dispose();
    }

    private void salvarCarga(ActionEvent actionEvent) {
        Carga carga = validoCarga();
        if (carga != null) {
            BDVeiculos.salvaCarg(carga);
            JOptionPane.showMessageDialog(null, "Cadastro de veículo de carga com sucesso!");
        }
    }

    private Carga validoCarga() {
        String placa = txtPlaca.getText().trim();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            if (BDVeiculos.buscaCargaPorId(placa) != null) {
                JOptionPane.showMessageDialog(null, "Já existe veículo de passeio com essa placa", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        String marca = txtMarca.getText().trim();
        if (marca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Marca corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String modelo = txtModelo.getText().trim();
        if (modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Modelo corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String cor = txtCor.getText().trim();
        if (cor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Cor corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int qtdRodas;
        try {
            qtdRodas = Integer.parseInt(txtQtdRodas.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Qtd.Rodas corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        float velocMax;
        try {
            velocMax = Float.parseFloat(txtVelocMax.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Velocidade Máx. corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int qtdPistoes;
        try {
            qtdPistoes = Integer.parseInt(txtQtdPistoes.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Qtd.Pistões corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int potencia;
        try {
            potencia = Integer.parseInt(txtPotencia.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Potência corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int tara;
        try {
            tara = Integer.parseInt(txtTara.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Tara corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int cargaMax;
        try {
            cargaMax = Integer.parseInt(txtCargaMax.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Carga Máx. corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Carga carga = new Carga(placa, marca, modelo, velocMax, qtdRodas, cor, tara, cargaMax);
        carga.setMotor(qtdPistoes, potencia);

        return carga;
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
}
