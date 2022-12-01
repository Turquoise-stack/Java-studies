public class Main {
    public static void main(String[] args) {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setArticle("Mori 1");
        caretaker.addMemento(originator.save());
        printState(originator);

        originator.setArticle("Mori 2");
        caretaker.addMemento(originator.save());
        printState(originator);

        originator.restore(caretaker.undo());
        printState(originator);

        originator.restore(caretaker.redo());
        printState(originator);
    }

    public static void printState(Originator o){
        System.out.println("Current state: " + o.getArticle());
    }
}
