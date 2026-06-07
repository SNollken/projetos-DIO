package gftstart7.collectionsjavaapi.collections.map;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(Long id, Produto produto) {
        estoqueProdutosMap.put(id, produto);
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto p : estoqueProdutosMap.values()){
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()){
        for(Produto p : estoqueProdutosMap.values()){
            if(p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
                maiorPreco = p.getPreco();
            }

        }
    }
    return produtoMaisCaro;
    }
}

 public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(1L, new Produto("Produto A", 10, 5));
        estoque.adicionarProduto(2L, new Produto("Produto B", 5, 10));
        estoque.adicionarProduto(3L, new Produto("Produto C", 2, 15));

        System.out.println("Produtos no estoque:");
        estoque.exibirProdutos();

        System.out.println("\nValor total do estoque: R$ " + estoque.calcularValorTotalEstoque());

        System.out.println("\nProduto mais caro: " + estoque.obterProdutoMaisCaro());
    }