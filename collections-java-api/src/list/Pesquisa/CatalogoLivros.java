package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;


    public CatalogoLivros(){
        this.livroList = new ArrayList<>();
    }

    public void adiconarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor){

        List<Livro> livrosPorAutor = new ArrayList<>();

        if(!livroList.isEmpty()){
            for (Livro l : livroList) {
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

        if(!livroList.isEmpty()){
            for (Livro l : livroList) {
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal)
                {
                    livrosPorIntervaloAnos.add(l);
                }
            }
        }
        return livrosPorIntervaloAnos; 
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;

        if(!livroList.isEmpty()){
            for (Livro l : livroList) {
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();
        catalogo.adiconarLivro("Livro 1", "Autor 1", 2020);
        catalogo.adiconarLivro("Livro 1", "Autor 2", 2021);
        catalogo.adiconarLivro("Livro 3", "Autor 1", 2022);
        catalogo.adiconarLivro("Livro 4", "Autor 3", 2023);

        System.out.println(catalogo.pesquisarPorAutor("Autor 1"));

        System.out.println(catalogo.pesquisarPorIntervaloAnos(2020, 2021));

        System.out.println(catalogo.pesquisarPorTitulo("Livro 1"));

    }

}

