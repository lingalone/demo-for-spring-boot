package demo;

import demo.entry.QuestionAnswer;
import demo.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lingalone on 2017/1/6.
 */

@Controller
@RequestMapping("/qa")
public class QAController
{

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    @RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<QuestionAnswer> getList() {
        return questionAnswerRepository.findAll();
    }

    @RequestMapping(value = "/update")
    public void updateQA(@ModelAttribute QuestionAnswer qa){
        questionAnswerRepository.insert(qa);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST )
    @ResponseBody
    //public void deleteQA(@RequestBody ModelMap qa){
    public void deleteQA(@RequestBody QuestionAnswer qa){
        System.out.println(qa.getId());
        questionAnswerRepository.delete(qa.getId());
    }
}
