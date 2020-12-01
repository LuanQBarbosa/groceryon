package business.model.topic;

class TopicMemento {
    private final String topicQuestion;
    private final String topicAnswer;

    TopicMemento(String topicQuestion, String topicAnswer) {
        this.topicQuestion = topicQuestion;
        this.topicAnswer = topicAnswer;
    }

    String getTopicQuestion() {
        return topicQuestion;
    }

    String getTopicAnswer() {
        return topicAnswer;
    }
}
