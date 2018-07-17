package org.demenkov.apacheintegration.controller;

import org.demenkov.apacheintegration.dao.entity.ReportEntity;
import org.demenkov.apacheintegration.service.ReportEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestResultController {

    @Autowired
    private ReportEntityService reportEntityService;

    @RequestMapping("/")
    @ResponseBody
    public List<ReportEntity> findAll() {
        return reportEntityService.findAll();
    }

    @RequestMapping("/filter")
    @ResponseBody
    public List<ReportEntity> findBySuccess(@RequestParam(value = "success") String success) {
        List<ReportEntity> filteredResults = reportEntityService.findBySuccess(success);
        return filteredResults;
    }


    @GetMapping("/page")
    public ModelAndView getAllWithPage() {
        List<ReportEntity> result = findAll();
        ModelAndView model = new ModelAndView();
        model.addObject("result", result);
        model.setViewName("index");
        return model;
    }
}
