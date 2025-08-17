package desafio.dominio;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("curso java");
		curso1.setDescricao("descricao curso java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("curso js");
		curso2.setDescricao("descricao curso js");
		curso2.setCargaHoraria(2);
		
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria java");
		mentoria.setDescricao("descricao mentoria java");
		mentoria.setData(LocalDate.now());
		
		
		
		/*System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(mentoria);*/
		
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java");
		bootcamp.setDescricao("Descricao Bootcamp Java");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devSofia = new Dev();
		devSofia.setNome("Sofia");
		devSofia.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Sofia: " + devSofia.getConteudosInscritos());
		System.out.println("-");
		devSofia.progredir();
		devSofia.progredir();
		System.out.println("Conteudos Inscritos Sofia: " + devSofia.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Sofia: " + devSofia.getConteudosInscritos());
		System.out.println("XP: " + devSofia.calcularXp());

		System.out.println("-------------------");
		
		Dev devJoao = new Dev();
		devJoao.setNome("Joao");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Joao: " + devJoao.getConteudosInscritos());
		System.out.println("-");
		devJoao.progredir();
		System.out.println("Conteudos Inscritos Joao: " + devJoao.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Joao: " + devJoao.getConteudosInscritos());
		System.out.println("XP: " + devJoao.calcularXp());
		
		
		
	}

}
