public class App {
    public static void main(String[] args) {
        IFonteDados fonte = new FonteDadosArquivo("poa_temps.txt"); // usuário passa o nome do arquivo a ser consultado
        IRepositorio repositorio = new Repositorio(fonte); // repository com strategy
        repositorio.carregaDados();

        Consultas consulta = new Consultas(repositorio.getRegistros());                         // passa os registros extraídos do arquivo (através da classe FonteDados) deixado no objeto repositorio
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consulta.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        consulta.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);
    }
}
