package gftstart7.desafioiphone.desafio;

public class Main {
    public static void main(String[] args) {
        IPhone iphone = new IPhone();

        System.out.println("=== Reprodutor Musical ===");
        iphone.selecionarMusica("Bohemian Rhapsody - Queen");
        iphone.tocar();
        iphone.pausar();

        System.out.println("\n=== Aparelho Telefônico ===");
        iphone.ligar("(11) 99999-1234");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        System.out.println("\n=== Navegador Internet ===");
        iphone.exibirPagina("https://www.google.com");
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();
    }
}
