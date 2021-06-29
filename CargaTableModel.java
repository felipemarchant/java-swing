import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class CargaTableModel extends AbstractTableModel {
    private List<Carga> dados = new ArrayList<>();
    private String[] colunas = { "Placa","Marca","Modelo", "Cor", "Qtd.Rodas", "VelocMax", "Qtd.Pist", "Potênc", "Tara", "Carga Máx" };

    public CargaTableModel(List<Carga> dados) {
        this.dados = dados;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch(coluna){
            case 0:
                return dados.get(linha).getPlaca();
            case 1:
                return dados.get(linha).getMarca();
            case 2:
                return dados.get(linha).getModelo();
            case 3:
                return dados.get(linha).getCor();
            case 4:
                return dados.get(linha).getQtdRodas();
            case 5:
                return dados.get(linha).getVelocMax();
            case 6:
                return dados.get(linha).getMotor() != null ? dados.get(linha).getMotor().getQtdPist() : "";
            case 7:
                return dados.get(linha).getMotor() != null ? dados.get(linha).getMotor().getPotencia() : "";
            case 8:
                return dados.get(linha).getTara();
            case 9:
                return dados.get(linha).getCargaMax();
        }

        return null;

    }
}
