import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class Passeio extends Veiculo implements Calc {

    private int qtdePassageiros;

    public Passeio(String placa, String marca, String modelo, float velocMax, int qtdRodas, String cor, int qtdePassageiros) {
        super(placa, marca, modelo, velocMax, qtdRodas, cor);
        this.qtdePassageiros = qtdePassageiros;
    }

    public int getQtdePassageiros() {
        return qtdePassageiros;
    }

    public void setQtdePassageiros(int qtdePassageiros) {
        this.qtdePassageiros = qtdePassageiros;
    }

    @Override
    protected float calcVel(float velocMax) {
        return velocMax * 1000;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "\nQUANTIDADE DE PASSAGEIROS: " + qtdePassageiros;
        str += "\nCALC: " + calcular();
        return str;
    }

    @Override
    public float calcular() {
        Class<? extends Veiculo> clazz = this.getClass();
        Method[] methods = clazz.getMethods();
        float total = 0;
        for (Method method : methods) total += calculaTamanhoCalc(method);
        return total;
    }

    protected float calculaTamanhoCalc(Method method) {
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (returnType.equals(String.class) && name.startsWith("get")) {
            try {
                String returnValue = (String) method.invoke(this, null);
                return returnValue.length();
            } catch (IllegalAccessException | InvocationTargetException ignored) {

            }
        }
        return 0;
    }

    @Override
    public String getTitle() {
        return "Passeio";
    }
}
