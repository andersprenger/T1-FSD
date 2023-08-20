public class App {
    public static void main(String[] args) {
        FonteDados fonte = new FonteDadosArquivo("poa_temps.txt");                  // usuário passa o nome do arquivo a ser consultado
        Repositorio repositorio = new Repositorio(fonte);
        repositorio.carregaDados();
        /*System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        consultas.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);*/
    }
}
