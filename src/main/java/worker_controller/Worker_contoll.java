package worker_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import worker_dao.Worker_dao;
import worker_dto.Worker_dto;

@Controller

public class Worker_contoll {
	@Autowired
	Worker_dao ds;
	@RequestMapping("/sign")
	@ResponseBody
	public String databasecreated(@ModelAttribute Worker_dto dt) {
		System.out.println("HEY ITS CREATED");
 String	msg	=ds.insert(dt);
 return msg;
		
	}
 // 	@RequestMapping("/delete")
//	@ResponseBody
 //	public String delete(@RequestParam int wno) {
	//	 String  msg=ds.delete(wno);
	//	 return msg;
	@RequestMapping("/delete")
	public ModelAndView deleteAccount(@ModelAttribute Worker_dto wno) {
		System.out.println(wno);
		int id= wno.getWno();
		String msg=ds.deleteById(id);
		
		 ModelAndView v1 = new ModelAndView("index.jsp");
		 v1.addObject("message", msg);
		 return v1;
		
		
		
	}
	@RequestMapping("/dall")
	public ModelAndView deleteAll(@ModelAttribute Worker_dto wno) {
		System.out.println(wno);
		 // int id= wno.getWno();
		Object msg=ds.deleteAll();
		
		 ModelAndView v1 = new ModelAndView("index.jsp");
		 v1.addObject("message", msg);
		 return v1;
}
	
	public ModelAndView fetchById( @ModelAttribute Worker_dto wno) {
		int id=wno.getWno();
		Object msg=ds.fetchById(id);
		ModelAndView v2= new ModelAndView("index.jsp");
				v2.addObject("message", msg);
				return v2;
	}
	@RequestMapping("/feall")
	@ResponseBody
	public ModelAndView fetchAll(@ModelAttribute Worker_dto w) {
		Object msg=ds.fetchAll();
		 ModelAndView v3 = new ModelAndView("index.jsp");
		 v3.addObject("message", msg);
		 return v3;
	}
}
