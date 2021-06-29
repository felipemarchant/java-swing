import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class Carga extends Veiculo implements  Calc {

    private int tara;
    private int cargaMax;

    public Carga(String placa, String marca, String modelo, float velocMax, int qtdRodas, String cor, int tara, int cargaMax) {
        super(placa, marca, modelo, velocMax, qtdRodas, cor);
        this.tara = tara;
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    protected float calcVel(float velocMax) {
        return velocMax * 100000;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "\nTARA: " + tara;
        str += "\nCARGA MÁXIMA: " + cargaMax;
        str += "\nCALC: " + calcular();
        return str;
    }

    @Override
    public float calcular() {
        Class<? extends Veiculo> clazz = this.getClass();
        Method[] methods = clazz.getMethods();
        int total = 0;
        for (Method method : methods) total += calculaTamanhoCalc(method);
        return total;
    }

    protected float calculaTamanhoCalc(Method method) {
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if ((returnType.equals(int.class) || returnType.equals(float.class)) && name.startsWith("get")) {
            try {
                if (returnType.equals(int.class)) {
                    return ((Integer) method.invoke(this, null)).floatValue();
                }
                return (Float) method.invoke(this, null);
            } catch (IllegalAccessException | InvocationTargetException ignored) {

            }
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "Carga";
    }
}
