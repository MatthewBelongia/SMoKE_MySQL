package io.matthewbelongia.controllers;

import io.matthewbelongia.models.Tab;
import io.matthewbelongia.models.TabDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * Created by matthewb on 6/15/16.
 */
@CrossOrigin
@RestController
public class TabController {



    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /newtab --> create a new tab and save it in database
     *
     * @param empid Employee's Id who opened tab
     * @param name Employess's name who opened tab
     * @param location tab's location
     * @param card tab's card
     * @param total tab's total
     * @param date timestamp of tab opening
     */
    @RequestMapping(value = "/newtab", method = RequestMethod.GET)
    @ResponseBody
    public Tab newTab(String empid, String name,String location,String card, Double total, Timestamp date){
        Tab tab = null;
        try{
            tab = new Tab(empid,name,location,card,total,date);
            tabDao.save(tab);
            log.info("tab saved");
        }catch (Exception ex){
            log.info("tab not saved");
            return null;
        }
        return tab;
    }

    /**
     * /tabId --> Return the tab having the passed id
     *
     * @param id the tab id to search in database
     * @return the tab or null if not found
     */
    @RequestMapping(value = "tabId", method = RequestMethod.GET)
    @ResponseBody
    public Tab getById(Long id){
        Tab tab;
        try{
            tab = tabDao.findById(id);
            log.info("tab found");
        }catch(Exception ex){
            log.info("tab not found");
            return null;
        }
        return tab;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------


    @Autowired
    private TabDao tabDao;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

}
