public class No implements INo {
    private Object conteudo;
    private No prox;

    public No(Object conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
    }

    public Object getConteudo() {
        return conteudo;
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}


