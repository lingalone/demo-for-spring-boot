package demo.repository;


import demo.entry.QuestionAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lingalone on 2017/1/5.
 */

public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswer, String> {

    public QuestionAnswer findBySubject(String subject);
    public QuestionAnswer findByType(String type);



}
