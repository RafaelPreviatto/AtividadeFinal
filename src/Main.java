import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro elemento da pilha: ");
        String primeiro = scanner.nextLine();
        PilhaDinamica pilha = new PilhaDinamica(primeiro);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU PILHA DINÂMICA ===");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Inserir sequência de elementos");
            System.out.println("3 - Remover elemento");
            System.out.println("4 - Remover sequência de elementos");
            System.out.println("5 - Remover todas as ocorrências de um elemento");
            System.out.println("6 - Buscar elemento");
            System.out.println("7 - Editar elemento");
            System.out.println("8 - Ordenar crescente");
            System.out.println("9 - Ordenar decrescente");
            System.out.println("10 - Verificar se está cheia");
            System.out.println("11 - Verificar se está vazia");
            System.out.println("12 - Quantidade de elementos");
            System.out.println("13 - Limpar pilha");
            System.out.println("14 - Exibir pilha");
            System.out.println("15 - Obter primeiro elemento");
            System.out.println("16 - Obter último elemento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a inserir: ");
                    String elemento = scanner.nextLine();
                    pilha.inserirElemento(elemento);
                    break;
                case 2:
                    System.out.print("Digite os elementos separados por vírgula: ");
                    String linha = scanner.nextLine();
                    List<String> elementos = Arrays.asList(linha.split(","));
                    pilha.inserirSequencia(elementos);
                    break;
                case 3:
                    System.out.print("Elemento a remover: ");
                    String remov = scanner.nextLine();
                    System.out.println(pilha.removerElemento(remov) ? "Removido!" : "Não encontrado.");
                    break;
                case 4:
                    System.out.print("Digite os elementos a remover separados por vírgula: ");
                    String remLinha = scanner.nextLine();
                    List<String> remSeq = Arrays.asList(remLinha.split(","));
                    pilha.removerSequencia(remSeq);
                    break;
                case 5:
                    System.out.print("Elemento para remover todas as ocorrências: ");
                    String alvo = scanner.nextLine();
                    pilha.removerTodasOcorrencias(alvo);
                    break;
                case 6:
                    System.out.print("Elemento a buscar: ");
                    String busca = scanner.nextLine();
                    System.out.println(pilha.buscarElemento(busca) ? "Encontrado!" : "Não encontrado.");
                    break;
                case 7:
                    System.out.print("Elemento antigo: ");
                    String antigo = scanner.nextLine();
                    System.out.print("Novo elemento: ");
                    String novo = scanner.nextLine();
                    pilha.editarElemento(antigo, novo);
                    break;
                case 8:
                    pilha.ordenarCrescente();
                    System.out.println("Ordenado em ordem crescente.");
                    break;
                case 9:
                    pilha.ordenarDecrescente();
                    System.out.println("Ordenado em ordem decrescente.");
                    break;
                case 10:
                    System.out.println(pilha.estaCheia() ? "Pilha está cheia." : "Pilha nunca está cheia.");
                    break;
                case 11:
                    System.out.println(pilha.estaVazia() ? "Pilha está vazia." : "Pilha contém elementos.");
                    break;
                case 12:
                    System.out.println("Quantidade de elementos: " + pilha.quantidadeElementos());
                    break;
                case 13:
                    pilha.limpar();
                    System.out.println("Pilha limpa.");
                    break;
                case 14:
                    pilha.exibir();
                    break;
                case 15:
                    No primeiroElemento = pilha.obterPrimeiroElemento();
                    System.out.println(primeiroElemento != null ? "Primeiro elemento: " + primeiroElemento.getConteudo() : "Pilha vazia.");
                    break;
                case 16:
                    No ultimo = pilha.obterUltimoElemento();
                    System.out.println(ultimo != null ? "Último elemento (topo): " + ultimo.getConteudo() : "Pilha vazia.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
