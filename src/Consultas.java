import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Consultas {
    private List<RegistroDoTempo> registros;

    public Consultas(List<RegistroDoTempo> registros){
        this.registros = registros;
        
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return registros
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }

    void alteraConsultaPadrao(Predicate consulta){

    }

    /*Tarefa 3
    Acrescente um método na classe "Consulta" com a seguinte assinatura: "List diasEmQue()". Este método deve retornar a lista de datas em que uma determinada condição se aplica. Esta condição deve ser implementada usando o padrão "strategy". Uma condição padrão deve ser definida no construtor da classe "Consulta", mas deve poder ser alterada por um método com a seguinte assinatura:

    "void alteraConsultaPadrao(Predicate consulta)"

    Crie também a classe "Data", um "DTO" simples que armazena dia, mes e ano. */

    public List diasEmQue() {
        return 
    }
}
