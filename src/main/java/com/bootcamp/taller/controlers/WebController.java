package com.bootcamp.taller.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.taller.models.Usuario;
import com.bootcamp.taller.services.ServicioUsuarios;

@Controller
public class WebController {
	
	@Autowired
	private ServicioUsuarios servicio;
	
   @RequestMapping(value = "/")
   public String index() {
      return "index";
   }
   
    @RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public ModelAndView usuariosTabla() {
		ModelAndView mav = new ModelAndView("users");
		mav.addObject("usuarios", servicio.getAllUsuarios());
		return mav;
	}
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public ModelAndView usuarioTabla(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("user");
		Usuario u = servicio.getUsuarioPorId(id).get();
		mav.addObject("usuario", u);
		return mav;
	}
    
    // Metodo post dado que Thymeleaf cambia el metodo de "delete" a "post" al generar el html
    // Aun así es un metodo Delete
    @RequestMapping(method = RequestMethod.POST, value = "/users")
	@ResponseBody
	public ModelAndView deleteUsuario(@RequestParam("id")Integer id) {
		System.out.println("he entrado en el delete");
    	ModelAndView mav = new ModelAndView("users");
    	servicio.eliminarUsuario(id);
		mav.addObject("usuarios", servicio.getAllUsuarios());
		return mav;
	}
}
