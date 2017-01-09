package demo.controller;

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

    @RequestMapping(value = "/create", method = RequestMethod.POST )
    @ResponseBody
    public boolean createQA(@RequestBody QuestionAnswer qa){
        //questionAnswerRepository.insert(qa);
        questionAnswerRepository.save(qa);
        return true;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST )
    @ResponseBody
    public boolean updateQA(@RequestBody QuestionAnswer qa){
        //questionAnswerRepository.insert(qa);
        questionAnswerRepository.save(qa);
        return true;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST )
    @ResponseBody
    //public void deleteQA(@RequestBody ModelMap qa){
    public boolean deleteQA(@RequestBody QuestionAnswer qa){
        System.out.println(qa.getId());
        questionAnswerRepository.delete(qa.getId());
        return true;
    }

    @RequestMapping(value = "/find/{search}", method = RequestMethod.GET )
    @ResponseBody
    public QuestionAnswer findQA(@PathVariable String search){

        return questionAnswerRepository.findByType("type6");
    }
}
