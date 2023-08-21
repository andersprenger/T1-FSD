import java.util.List;

public interface IRepositorio {
    void carregaDados();
    List<RegistroDoTempo> getRegistros();
}
