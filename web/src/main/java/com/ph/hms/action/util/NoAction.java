package com.ph.hms.action.util;
import java.util.*;

import org.springframework.context.ApplicationContext;

import com.ph.hms.*;

import com.opensymphony.xwork.*;

public class NoAction extends ActionSupport
{
	
public String execute() throws Exception
{
   try{

             
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
