public class App {
    public static void main(String[] args) {
        IRepositorio repositorio = new Repositorio("poa_temps.txt"); // repository
        repositorio.carregaDados();

        // passa os registros extraídos do arquivo (através da classe FonteDados) deixado no objeto repositorio
        Consultas consulta = new Consultas(repositorio.getRegistros());

        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consulta.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        consulta.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);
    }
}