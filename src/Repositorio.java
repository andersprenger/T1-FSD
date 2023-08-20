import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Repositorio {
    private List<RegistroDoTempo> registros;
    private FonteDados fonteDados;                  // objeto genérico que uso do padrão Strategy pra extrair os dados seja qual for a fonte
    
    public Repositorio(FonteDados fonteDados){
        this.fonteDados = fonteDados;
        registros = new LinkedList<>();
    }

    public void carregaDados(){
        registros = fonteDados.carregarDados();
    }
}
