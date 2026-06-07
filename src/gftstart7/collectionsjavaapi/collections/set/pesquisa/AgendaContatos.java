package gftstart7.collectionsjavaapi.collections.set.pesquisa;
import java.util.Set;
import java.util.HashSet;

public class AgendaContatos {

    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumerContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet){
            if (c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {

        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Camila", 123456789);
        agenda.adicionarContato("Camila", 0);
        agenda.adicionarContato("Camila Calvagante", 1111);
        agenda.adicionarContato("Maria", 1111);
        agenda.adicionarContato("Sofia", 1234);

        System.out.println("Contatos na agenda:");
        agenda.exibirContatos();

        System.out.println("\nPesquisando por nome 'Ca':");
        Set<Contato> contatosEncontrados = agenda.pesquisarPorNome("Ca");
        System.out.println(contatosEncontrados);

        System.out.println("\nAtualizando número de contato para 'Sofia':");
        Contato contatoAtualizado = agenda.atualizarNumerContato("Sofia", 111111111);
        if (contatoAtualizado != null) {
            System.out.println("Contato atualizado: " + contatoAtualizado);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
