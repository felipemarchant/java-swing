import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class BDVeiculos {
    private static final List<Carga> BDCarg = new ArrayList<>();
    private static final List<Passeio> BDPas = new ArrayList<>();

    public static final List<Passeio> todosPas()
    {
        return BDPas;
    }

    public static final void salvaPas(Passeio passeio)
    {
        BDPas.add(passeio);
    }

    public static final List<Carga> todosCarg()
    {
        return BDCarg;
    }

    public static final void salvaCarg(Carga carga)
    {
        BDCarg.add(carga);
    }

    public static void removePas(Passeio passeio) {
        BDPas.remove(passeio);
    }

    public static void removeCarg(Carga carga) {
        BDCarg.remove(carga);
    }

    public static void removeTodosPas() {
        BDPas.clear();
    }

    public static void removeTodosCarg() {
        BDCarg.clear();
    }

    public static Passeio buscaPasseioPorId(String placa) {
        String finalPlaca = placa.toUpperCase();
        Predicate<Passeio> filter = p -> p.getPlaca().toUpperCase().equals(finalPlaca);
        return BDVeiculos.todosPas().stream().filter(filter).findAny().orElse(null);
    }

    public static Carga buscaCargaPorId(String placa) {
        String finalPlaca = placa.toUpperCase();
        Predicate<Carga> filter = p -> p.getPlaca().toUpperCase().equals(finalPlaca);
        return BDVeiculos.todosCarg().stream().filter(filter).findAny().orElse(null);
    }
}
