import java.util.*;

public class PilhaDinamica implements IEstruturaDinamica {
    private No primeiroElemento;

    public PilhaDinamica(String conteudo) {
        primeiroElemento = new No(conteudo);
    }

    public No getPrimeiroElemento() {
        return this.primeiroElemento;
    }

    @Override
    public void inserirElemento(Object conteudo) {
        No novoNo = new No(conteudo);

        if (primeiroElemento == null) {
            primeiroElemento = novoNo;
        } else {
            No atual = primeiroElemento;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novoNo);
        }
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (elementos instanceof List<?>) {
            for (Object e : (List<?>) elementos) {
                inserirElemento(e);
            }
        }
    }

    @Override
    public boolean removerElemento(Object elemento) {
        if (primeiroElemento == null) return false;

        if (primeiroElemento.getConteudo().equals(elemento)) {
            primeiroElemento = primeiroElemento.getProx();
            return true;
        }

        No anterior = primeiroElemento;
        No atual = primeiroElemento.getProx();

        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                anterior.setProx(atual.getProx());
                return true;
            }
            anterior = atual;
            atual = atual.getProx();
        }

        return false;
    }

    @Override
    public void removerSequencia(Object elementos) {
        if (elementos instanceof List<?>) {
            for (Object e : (List<?>) elementos) {
                removerElemento(e);
            }
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        while (removerElemento(elemento)) {}
    }

    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        return primeiroElemento == null;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        No atual = primeiroElemento;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) return true;
            atual = atual.getProx();
        }
        return false;
    }

    @Override
    public void ordenarCrescente() {
        List<Object> lista = toList();
        lista.sort(null);
        reconstruir(lista);
    }

    @Override
    public void ordenarDecrescente() {
        List<Object> lista = toList();
        lista.sort(Collections.reverseOrder());
        reconstruir(lista);
    }

    private List<Object> toList() {
        List<Object> lista = new ArrayList<>();
        No atual = primeiroElemento;
        while (atual != null) {
            lista.add(atual.getConteudo());
            atual = atual.getProx();
        }
        return lista;
    }

    private void reconstruir(List<Object> lista) {
        limpar();
        for (Object item : lista) {
            inserirElemento(item);
        }
    }

    @Override
    public int quantidadeElementos() {
        int cont = 0;
        No atual = primeiroElemento;
        while (atual != null) {
            cont++;
            atual = atual.getProx();
        }
        return cont;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        No atual = primeiroElemento;
        while (atual != null) {
            if (atual.getConteudo().equals(elementoAntigo)) {
                atual.setConteudo(elementoNovo);
                return;
            }
            atual = atual.getProx();
        }
    }

    @Override
    public void limpar() {
        primeiroElemento = null;
    }

    @Override
    public void exibir() {
        No atual = primeiroElemento;
        System.out.println("Pilha (base → topo):");
        while (atual != null) {
            System.out.println(atual.getConteudo());
            atual = atual.getProx();
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        return primeiroElemento;
    }

    @Override
    public No obterUltimoElemento() {
        No atual = primeiroElemento;
        if (atual == null)
            return null;

        while (atual.getProx() != null) {
            atual = atual.getProx();
        }
        return atual;
    }

    @Override
    public String toString() {
        return "PilhaDinamica{" +
                "primeiroElemento=" + primeiroElemento +
                '}';
    }
}


