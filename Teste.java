import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Teste extends JFrame {

	public Teste() {
		super("Gestão de Veículos");
		configTela();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Teste();
	}

	private JLabel configLblPasseio()
	{
		JLabel lblLabel = new JLabel("PASSEIO");
		lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/passeio-icone.png")));
		lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaVeiculo(Teste.this, Passeio.class);
				setVisible(false);
			}
		});
		return lblLabel;
	}

	private JLabel configLblCarga()
	{
		JLabel lblLabel = new JLabel("CARGA");
		lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/carga-icone.png")));
		lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaVeiculo(Teste.this, Carga.class);
				setVisible(false);
			}
		});
		return lblLabel;
	}

	private JLabel configLblInfo()
	{
		JLabel lblLabel = new JLabel("SOBRE");
		lblLabel.setIcon(new ImageIcon(getClass().getResource("/resources/info-icone.png")));
		lblLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Desenvolvido por Felipe Marchant F. Soares\n<felipemarchant.dev@gmail.com>");
			}
		});
		return lblLabel;
	}

	private void configTela()
	{
		Dimension dimensoes = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(240, 120);
		setLocation((int) ((dimensoes.getWidth() - getWidth()) / 2), (int) ((dimensoes.getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel pnlPanel = new JPanel();
		pnlPanel.setLayout(new GridLayout(3,1));
		pnlPanel.add(configLblPasseio());
		pnlPanel.add(configLblCarga());
//		pnlPanel.add(configLblInfo());
		setLayout(new FlowLayout());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(
						null,
						"Desenvolvido por Felipe Marchant F. Soares\n<felipemarchant.dev@gmail.com>",
						"Info", JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("/resources/info-icone.png"))
				);
				dispose();
			}
		});
		add(pnlPanel);
	}
}
