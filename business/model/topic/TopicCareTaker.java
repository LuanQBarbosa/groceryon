package business.model.topic;

import java.util.Stack;

class TopicCareTaker {
    private Stack<TopicMemento> states;

    TopicCareTaker() {
        states = new Stack<>();
    }

    void addState(TopicMemento memento) {
        states.push(memento);
    }

    TopicMemento getLastState() {
        if(states.isEmpty())
            return null; // indica que não há o que desfazer
        else
            return states.pop();

    }

}
