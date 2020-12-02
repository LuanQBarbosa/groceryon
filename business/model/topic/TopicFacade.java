package business.model.topic;

import business.control.TopicController;

public class TopicFacade {
    private TopicController topicController;

    public TopicFacade(TopicController topicController) {
        this.topicController = new TopicController();
    }

    public Topic addTopic(String question, String answer) {
        return new AddTopic(topicController).execute(question, answer);
    }

    public Topic updateTopic(String oldQuestion, String newQuestion, String newAnswer) {
        UpdateTopic updTop = new UpdateTopic(topicController);
        updTop.setTopicQuestion(oldQuestion);
        return updTop.execute(oldQuestion, newAnswer);
    }

    public Topic searchTopic(String question, String answer) {
        return new SearchTopic(topicController).execute(question, answer);
    }
}
