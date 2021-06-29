import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TelaCadastroPasseio extends TelaCadastroVeiculo {

    private JFrame parent;
    private JLabel lblQtdePassageiros;
    private JTextField txtQtdePassageiros;

    public TelaCadastroPasseio(JFrame parent) {
        super("Cadastro de Passeio");
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
        btnSair.addActionListener(this::closeOperation);
        btnCadastrar.addActionListener(this::salvarPasseio);
        btnLimpar.addActionListener(this::limparCampos);
        btnNovo.addActionListener(this::novaTela);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
                dispose();
            }
        });
    }

    private void novaTela(ActionEvent actionEvent) {
        setVisible(false);
        new TelaCadastroPasseio(parent);
        dispose();
    }

    protected void limparCampos(ActionEvent actionEvent) {
        super.limparCampos(actionEvent);
        txtQtdePassageiros.setText("");
    }

    private void salvarPasseio(ActionEvent actionEvent) {
        Passeio passeio = validoPasseio();
        if (passeio != null) {
            BDVeiculos.salvaPas(passeio);
            JOptionPane.showMessageDialog(null, "Cadastro de veículo de passeio com sucesso!");
        }
    }

    private Passeio validoPasseio() {
        String placa = txtPlaca.getText().trim();
        if (placa.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            if (BDVeiculos.buscaPasseioPorId(placa) != null) {
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

        int qtdePassageiros;
        try {
            qtdePassageiros = Integer.parseInt(txtQtdePassageiros.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Qtd.Passageiros corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Passeio passeio = new Passeio(placa, marca, modelo, velocMax, qtdRodas, cor, qtdePassageiros);
        passeio.setMotor(qtdPistoes, potencia);

        return passeio;
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
}
