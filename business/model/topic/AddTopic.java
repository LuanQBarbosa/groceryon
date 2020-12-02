package business.model.topic;

import business.control.TopicController;

public class AddTopic implements TopicCommand {
    private TopicController topicController;

    public AddTopic(TopicController topicController) {
        this.topicController = topicController;
    }

    public Topic execute(String question, String answer) {
        return topicController.addTopic(question, answer);
    }
}
