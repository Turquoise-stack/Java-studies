import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Caretaker {

    private ArrayList<Memento> history;

    private int currentState = -1;

    public Caretaker(){
        this.history = new ArrayList<>();
    }

    public void addMemento(Memento x){
        this.history.add(x);
        currentState = this.history.size() - 1;
    }

    public Memento getMemento(int index){
        return history.get(index);
    }

    public Memento undo(){
        System.out.println("One article has been undone!");

        if (currentState <= 0){
            currentState = 0;
            return getMemento(0);
        }

        currentState--;
        return getMemento(currentState);
    }

    public Memento redo(){
        System.out.println("One article has been redone!");

        if(currentState >= history.size() -1){
            currentState = history.size() -1;
            return getMemento(currentState);
        }

        currentState++;
        return getMemento(currentState);
    }
}
