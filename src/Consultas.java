import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Consultas {
    private final IRepositorio repositorio;
    private Predicate<RegistroDoTempo> consulta;

    public Consultas(IRepositorio repositorio) {
        this.repositorio = repositorio;
        this.consulta = registro -> registro.getTempMaxima() > 30;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros) {
        return repositorio.getRegistros()
                .stream()
                .filter(r -> r.getPrecipitacao() > milimetros)
                .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
                .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = repositorio.getRegistros()
                .stream()
                .filter(reg -> reg.getAno() == ano)
                .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
                .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", " + registro.getPrecipitacao();
        return resp;
    }

    void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        this.consulta = consulta;
    }

    List<Data> diasEmQue() {
        List<RegistroDoTempo> registros = repositorio.getRegistros();
        List<Data> datas = new LinkedList<>();

        for (RegistroDoTempo r : registros) {
            if (consulta.test(r)) {
                datas.add(new Data(r.getDia(), r.getMes(), r.getAno()));
            }
        }

        return datas;
    }
}
