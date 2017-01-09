package demo;


import demo.entry.QuestionAnswer;
import demo.repository.QuestionAnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataManagerApplicationTests {

	@Autowired
	private QuestionAnswerRepository questionAnswerRepository;


	@Test
	public void repositoryTest() {

		questionAnswerRepository.deleteAll();

		for(Integer i = 1; i<=100;i++){
			QuestionAnswer tempItem = new QuestionAnswer();
			tempItem.setAnswer("ansddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddwer"+i);
			tempItem.setScore(i);
			tempItem.setSource("source"+i);
			tempItem.setSubject("subdddddddddddddddddddddddddddddddddddddddddddddject"+i);
			tempItem.setTime("time"+System.currentTimeMillis());
			tempItem.setType("type"+i);
			tempItem.setUrl("url"+i);
			questionAnswerRepository.save(tempItem);

		}

//		Assert.assertEquals(10, questionAnswerRepository.findAll().size());
//		// 删除一个User，再验证User总数
//		QuestionAnswer qa = questionAnswerRepository.findByType("type"+1);
//		questionAnswerRepository.delete(qa);
//		Assert.assertEquals(9, questionAnswerRepository.findAll().size());
//		// 删除一个User，再验证User总数
//		qa = questionAnswerRepository.findBySubject("subject"+2);
//		questionAnswerRepository.delete(qa);
//		Assert.assertEquals(8, questionAnswerRepository.findAll().size());
	}

}
