
package gftstart7.collectionsjavaapi;

import gftstart7.collectionsjavaapi.collections.map.AgendaContatos;

public class App {
    public static void main(String[] args) throws Exception {
        AgendaContatos agendaContatos = new AgendaContatos();

            agendaContatos.adicionarContato("Maria", 123456789);
            agendaContatos.adicionarContato("João", 987654321);
            agendaContatos.adicionarContato("Ana", 555555555);
    
            System.out.println("Contatos na agenda:");
            agendaContatos.exibirContatos();
    
            System.out.println("\nPesquisando número de João:");
            Integer numeroJoao = agendaContatos.pesquisarPorNome("João");
            if (numeroJoao != null) {
                System.out.println("Número de João: " + numeroJoao);
            } else {
                System.out.println("João não encontrado na agenda.");
            }
    
            System.out.println("\nRemovendo contato de Ana...");
            agendaContatos.removerContato("Ana");
    
            System.out.println("\nContatos na agenda após remoção:");
            agendaContatos.exibirContatos();
    }
}
