package collections.set.ordenacao;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos(){
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(int cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.adicionarProduto(1, "Produto 5", 3500.00, 10);
        cadastroProdutos.adicionarProduto(2, "Produto 0", 1500.00, 20);
        cadastroProdutos.adicionarProduto(3, "Produto 7", 2000.00, 15);

        System.out.println(cadastroProdutos.produtoSet);
        
        System.out.println("Produtos por nome:");
        for (Produto p : cadastroProdutos.exibirProdutosPorNome()) {
            System.out.println(p);
        }

        System.out.println("\nProdutos por preço:");
        for (Produto p : cadastroProdutos.exibirProdutosPorPreco()) {
            System.out.println(p);
        }
    }

}


