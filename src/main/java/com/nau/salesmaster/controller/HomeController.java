package com.nau.salesmaster.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import com.nau.salesmaster.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    int countThreAD = 0;

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String firstJsp(Locale local, Model model, HttpServletRequest request) {
        String threadName = Thread.currentThread().getName();
        countThreAD++;
        logger.info(countThreAD + "*** !!THREAD = " + threadName);
        for (int i = 0; i < 10; i++) {
            logger.info("loop #" + i + "  *** thread = " + threadName);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        model.addAttribute("firstJspValue", "Hello from first jsp!");


        return "first";

    }

    @RequestMapping(value = "/first/{var}", method = RequestMethod.GET)
    public String firstJspTemplate(@RequestBody String body, Locale local, Model model, @PathVariable String var, HttpServletRequest request) {
        logger.info("THREAD = " + Thread.currentThread().getName());

        model.addAttribute("firstJspValue", "VAR = " + body);


        return "first";

    }


    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public String secondJspGet(Model model,
                               @RequestParam(value = "text", required = false) String text) {


        model.addAttribute("firstJspValue", "GET  -  params: " + (text == null ? "Haven`t params!" : text));


        return "first";
    }

    @RequestMapping(value = "/second", method = RequestMethod.POST)
    public String secondJspPost(Model model,
                                @RequestParam(value = "text", required = false) String text,
                                @RequestBody String body) {


        model.addAttribute("firstJspValue", "POST  -  params: " + (body == null ? "Haven`t body!" : body));


        return "first";
    }

    @RequestMapping(value = "/12", method = RequestMethod.GET)
    public String newJspGet(Model model) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        try {
            factory = Persistence.createEntityManagerFactory("perUnit");
            manager = factory.createEntityManager();

            Query query = manager.createQuery("SELECT prod FROM Product as prod");
            List list = (List) query.getResultList();

            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                Product blogPost = (Product) iterator.next();
                System.out.println(blogPost.getId() + " - " + blogPost.getName());
            }



        } finally {
            if (manager != null) manager.close();
            if (factory != null) factory.close();
        }


        return "first";
    }

}
