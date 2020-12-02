package business.control;

import business.model.topic.Topic;

import java.util.TreeMap;

public class TopicController {
    private final TreeMap<String, Topic> topics;

    public TopicController() {
        topics = new TreeMap<>();
    }

    public Topic getTopic(String question) {
        return topics.get(question);
    }

    public Topic addTopic(String question, String answer) {
        Topic topic = new Topic(question, answer);
        topics.put(question, topic);
        return topic;
    }

    public Topic updateTopic(String oldQuestion, String question, String answer) {
        Topic topic = topics.get(oldQuestion);
        topic.update(question, answer);
        topics.remove(oldQuestion);
        topics.put(question, topic);
        return topic;
    }

    public Topic searchTopic(String question, String answer) {
        return topics.get(question);
    }
}
