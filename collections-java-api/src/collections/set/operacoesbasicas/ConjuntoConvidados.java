package collections.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {

            System.out.println(convidadoSet);
        
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("Número de convidados: " + conjuntoConvidados.contarConvidados());

        conjuntoConvidados.adicionarConvidado("Convidado 1", 101);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 102);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 103);

        System.out.println("Número de convidados: " + conjuntoConvidados.contarConvidados());
        System.out.println("Lista de convidados:");
        conjuntoConvidados.exibirConvidados();

        conjuntoConvidados.removerConvidadoPorCodigoConvite(102);
        System.out.println("Número de convidados após remoção: " + conjuntoConvidados.contarConvidados());
        System.out.println("Lista de convidados após remoção:");
        conjuntoConvidados.exibirConvidados();
    }
}
