package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) {
selecaoCandidatos();
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }
            else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }


        } while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " tentativa)");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MAXIMO DE 3 TENTATIVAS REALIZADA");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }
    static void imprimirSelecionados(){
        String [] canditatos = {"FELIPE", "MARCOS", "JULIA", "ANA", "JOAO", "MARIO", "MARIA", "GUSTAVO", "PAULO", "MARCELA"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int indice = 0; indice < canditatos.length; indice++){
            System.out.println("O candidato de numero " + (indice+1) + " é o " + canditatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each");

        for(String candidato : canditatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }
    static void selecaoCandidatos(){
        String[] canditatos = {"FELIPE", "MARCOS", "JULIA", "ANA", "JOAO", "MARIO", "MARIA", "GUSTAVO", "PAULO", "MARCELA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;
        while(candidatosSelecionados < 5 && candidatoAtual < canditatos.length){
            String candidato = canditatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        if (salarioPretendido < salarioBase){
            System.out.println("Ligar para o candidato");
        } else if(salarioBase==salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardar o resultado dos outros candidatos");
        }

    }

}
