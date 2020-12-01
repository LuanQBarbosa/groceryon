package business.model.topic;

public class Topic {

    public Topic() {
        careTaker = new TopicCareTaker();
    }

    public Topic(String question, String answer) {
        this.question = question;
        this.answer = answer;

        careTaker = new TopicCareTaker();
    }

    private String question;
    private String answer;

    private final TopicCareTaker careTaker;

    private void saveMemento() {
        careTaker.addState(new TopicMemento(this.question, this.answer));
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        saveMemento();
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        saveMemento();
        this.answer = answer;
    }

    public void update(String question, String answer) {
        saveMemento();
        this.question = question;
        this.answer = answer;
    }

    public boolean undo() { // retorna se houve algo que foi desfeito
        TopicMemento state = careTaker.getLastState();
        if(state == null)
            return false;

        this.question = state.getTopicQuestion();
        this.answer = state.getTopicAnswer();
        return true;
    }
}
