import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TelaVeiculo extends JFrame {

    private JFrame parent;
    private Class<? extends Veiculo> veiculo;

    public TelaVeiculo(JFrame parent, Class<? extends Veiculo> veiculo) {
        super("Veículos de " +  getTitulo(veiculo));
        this.parent = parent;
        this.veiculo = veiculo;
        configTela();
        setVisible(true);
    }

    private static String getTitulo(Class<? extends Veiculo> veiculo) {
        if (veiculo.equals(Passeio.class)) {
            return "Passeio";
        }
        return "Carga";
    }

    private JLabel configLblCadastro()
    {
        JLabel lblLabel = new JLabel("Cadastrar");
        lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/veiculo-cadastro-icone.png")));
        lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                if (veiculo.equals(Passeio.class))
                     new TelaCadastroPasseio(TelaVeiculo.this);
                else new TelaCadastroCarga(TelaVeiculo.this);
            }
        });
        return lblLabel;
    }

    private JLabel configLblConsultarOuExcluirPelaPlaca()
    {
        JLabel lblLabel = new JLabel("Consultar / Excluir pela Placa");
        lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/veiculo-consulta-icone.png")));
        lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                if (veiculo.equals(Passeio.class))
                     new TelaConsultaPasseio(TelaVeiculo.this);
                else new TelaConsultaCarga(TelaVeiculo.this);

            }
        });
        return lblLabel;
    }

    private JLabel configLblImprimirOuExcluirTodos()
    {
        JLabel lblLabel = new JLabel("Imprimir / Excluir todos");
        lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/veiculo-imprimir-icone.png")));
        lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new TelaImprimirVeiculo(veiculo,TelaVeiculo.this);
            }
        });
        return lblLabel;
    }

    private JLabel configLblSair()
    {
        JLabel lblLabel = new JLabel("Sair");
        lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/saida-icone.png")));
        lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                parent.setVisible(true);
                dispose();
            }
        });
        return lblLabel;
    }

    private void configTela() {
        Dimension dimensoes = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(300, 180);
        setLocation((int) ((dimensoes.getWidth() - getWidth()) / 2), (int) ((dimensoes.getHeight() - getHeight()) / 2));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JPanel pnlPanel = new JPanel();
        pnlPanel.setLayout(new GridLayout(4,1));
        pnlPanel.add(configLblCadastro());
        pnlPanel.add(configLblConsultarOuExcluirPelaPlaca());
        pnlPanel.add(configLblImprimirOuExcluirTodos());
        pnlPanel.add(configLblSair());
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
                dispose();
            }
        });
        add(pnlPanel);
    }
}
