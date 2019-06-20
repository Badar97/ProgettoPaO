package com.progetto.oop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController 
{
	/*@RequestMapping ( "/dati" )
	@ResponseBody
	public String dati() throws IOException
	{
		return test("dati");
	}
	@RequestMapping ( "/statistiche" )
	@ResponseBody
	public String statistiche() throws IOException  
	{
		return test("statistiche","Permanenza lunga");
	}
	@RequestMapping ( "/filtri" )
	@ResponseBody
	public String filtri() throws IOException
	{
		return test("filtri","Permanenza media");
	}
	@RequestMapping ( "/metadati" )
	@ResponseBody
	public String metadati()
	{
		return "My Quick Blog2";
	}
	@RequestMapping( "/" )
	public ModelAndView index(@RequestParam( "name" ) String name)
	{
		Map<String, Object> model = new HashMap<>();
		model.put( "name" , name);
		return new ModelAndView( "/index" , model);
	}
	public String test(String oggetto, String...attributo) throws IOException
	{
		AnalisiDati test=new AnalisiDati();
		return test.OttieniJson(oggetto,attributo);
	}*/
	
	@Controller
	public class HelloController {
	    @GetMapping("/")
	    public String index() {
	        return "index";
	    }
	    @PostMapping("/hello") 
	    public String sayhello(@RequestParam("name") String name, Model model) {
	        model.addAttribute("name", name);
	        return "hello";
	    }
	}
}
