package business.model.topic;

import business.control.TopicController;

public class SearchTopic implements TopicCommand {
    private TopicController topicController;

    public SearchTopic(TopicController topicController) {
        this.topicController = topicController;
    }

    public Topic execute(String question, String answer) {
        return topicController.searchTopic(question, answer);
    }
}
