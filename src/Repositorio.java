import java.util.LinkedList;
import java.util.List;

public class Repositorio implements IRepositorio {
    private List<RegistroDoTempo> registros;
    private IFonteDados fonteDados;                  // objeto genérico que uso do padrão Strategy pra extrair os dados seja qual for a fonte
    
    public Repositorio(IFonteDados fonteDados){
        this.fonteDados = fonteDados;
        registros = new LinkedList<>();
    }

    public void carregaDados(){
        registros = fonteDados.carregarDados();
    }

    public List<RegistroDoTempo> getRegistros(){
        return registros;
    }
}
