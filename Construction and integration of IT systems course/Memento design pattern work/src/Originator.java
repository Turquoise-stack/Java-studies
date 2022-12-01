public class Originator {
    private String article;

    public Originator(){}

    public void setArticle(String article){
        this.article = article;
    }

    public String getArticle(){
        return this.article;
    }

    public Memento save(){
        return new Memento(article);
    }

    public void restore(Memento x){
        this.article = x.getState();
    }

}

