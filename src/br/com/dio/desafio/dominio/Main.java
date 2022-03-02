package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static Integer lerOpcao() {
		Integer opcao = null;
		do {
			try {
				opcao = Integer.parseInt(sc.nextLine());
			} catch (Exception exc) {
				System.out.println("Opção inválida!!!");
			}
		} while (opcao == null);
		return opcao;
	}

	public static void main(String[] args) {
		ArrayList<Dev> devs = new ArrayList<Dev>();
		int opcao;
		
		Curso curso1 = new Curso();
		curso1.setTitulo("curso Introdução ao Git e ao GitHub");
		curso1.setDescricao("descrição curso Git e GitHub");
		curso1.setCargaHoraria(4);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("curso IDEs");
		curso2.setDescricao("descrição curso IDEs ");
		curso2.setCargaHoraria(2);
		
		Curso curso3 = new Curso();
		curso3.setTitulo("curso java");
		curso3.setDescricao("descrição curso java");
		curso3.setCargaHoraria(9);
		
		Curso curso4 = new Curso();
		curso4.setTitulo("curso JavaScript");
		curso4.setDescricao("descrição curso JavaScript");
		curso4.setCargaHoraria(5);
		
		Curso curso5 = new Curso();
		curso5.setTitulo("curso HTML e CSS");
		curso5.setDescricao("descrição curso HTML e CSS");
		curso5.setCargaHoraria(10);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Mentoria Git e GitHub");
		mentoria.setDescricao("Descrição Mentoria Git e GitHub");
		mentoria.setData(LocalDate.now());
		
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp FullStack Developer");
		bootcamp.setDescricao("Descrição Bootcamp FullStack Developer ");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(curso3);
		bootcamp.getConteudos().add(curso4);
		bootcamp.getConteudos().add(curso5);
		bootcamp.getConteudos().add(mentoria);
		
		System.out.println("---------------------------------Inscrição para o Bootcamp---------------------------------");
		do {
			System.out.println("\nO que deseja fazer?\n");
			System.out.printf("1-Inscrever-se\n2-Ver cursos inscritos\n3-Concluir um curso\n4-Ver cursos concluídos\n5-Ver XP\n6-Fechar\n");
			opcao = lerOpcao();
			switch (opcao) {
			case 1:
				Dev dev = new Dev();
				System.out.println("Informe o seu nome:");
				dev.setNome(sc.nextLine());
				dev.inscreverBootcamp(bootcamp);
				devs.add(dev);
				System.out.println("Inscrição realizada!\n");
				break;
			case 2:
				System.out.println("Informe o seu nome:");
				String nomeDev = (sc.nextLine());
				for(Dev d: devs) {
					if(d.getNome().equals(nomeDev)) {
						System.out.println("Cursos inscritos:");
						for(Conteudo c: d.getConteudosInscritos()) {
							System.out.println(c);
						}
					}
				}
				
				break;
			case 3:
				System.out.println("Informe o seu nome:");
				nomeDev = (sc.nextLine());
				for(Dev d: devs) {
					if(d.getNome().equals(nomeDev)) {
						d.progredir();
						System.out.println("\nCurso concluído!!!\n");
						System.out.println("Ainda restam " + d.getConteudosInscritos().size() + " cursos a serem concluídos");
					}
				}
				
				break;
			case 4:
				System.out.println("Informe o seu nome:");
				nomeDev = (sc.nextLine());
				for(Dev d: devs) {
					if(d.getNome().equals(nomeDev)) {
						System.out.println("Cursos concluídos:");
						for(Conteudo c: d.getConteudosConcluidos()) {
							System.out.println(c);
						}
					}
				}
				
				break;
			case 5:
				System.out.println("Informe o seu nome:");
				nomeDev = (sc.nextLine());
				for(Dev d: devs) {
					if(d.getNome().equals(nomeDev)) {
						System.out.println("XP:" + d.calcularTotalXp());
					}
				}
				
				break;
			case 6:
				break;
			default:
				System.out.printf("Opção inválida!!!\n\n");
				break;
			}
		} while (opcao != 6);

		sc.close();
		
		
	}

}
