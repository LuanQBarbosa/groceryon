package business.model.topic;

import business.control.TopicController;

public class UpdateTopic implements TopicCommand {
    private TopicController topicController;
    private String topicQuestion;

    public UpdateTopic(TopicController topicController) {
        this.topicController = topicController;
        topicQuestion = null;
    }

    public void setTopicQuestion(String question) {
        this.topicQuestion = question;
    }

    public Topic execute(String question, String answer) {
        return this.topicController.updateTopic(topicQuestion, question, answer);
    }
}
