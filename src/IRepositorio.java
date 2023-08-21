public interface IRepositorio {
    void carregaDados();
    List<RegistroDoTempo> getRegistros();

    String getNomeArquivo();
    void setNomeArquivo(String nomeArquivo);
}
