package business.model.topic;

public interface TopicCommand {
    public Topic execute(String question, String answer);
}
