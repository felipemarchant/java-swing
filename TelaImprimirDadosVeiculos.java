import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class TelaImprimirDadosVeiculos extends JFrame{
    private JFrame parent;
    private JLabel lblOuput = new JLabel("Show time");
    private List<?> lista;

    public TelaImprimirDadosVeiculos(JFrame parent, List<?> lista) {
        this.parent = parent;
        this.lista = lista;
        configTela();
        setVisible(true);
    }

    private void configTela() {
        Dimension dimensoes = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(640, 480);
        setLocation((int) ((dimensoes.getWidth() - getWidth()) / 2), (int) ((dimensoes.getHeight() - getHeight()) / 2));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        lblOuput.setPreferredSize(new Dimension(640, 480));
        lblOuput.setBackground(Color.RED);
        JPanel pnlPanel = new JPanel();
        pnlPanel.setLayout(new BoxLayout(pnlPanel, BoxLayout.PAGE_AXIS));

        for (Object o : lista) pnlPanel.add(new JLabel("<html>" + o.toString().replaceAll("\n", "<br/>") + "<hr/></html>"));

        pnlPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JScrollPane scrScroll = new JScrollPane(pnlPanel);
        scrScroll.setPreferredSize(getPreferredSize());
        add(scrScroll);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                parent.setVisible(true);
                dispose();
            }
        });
    }
}
