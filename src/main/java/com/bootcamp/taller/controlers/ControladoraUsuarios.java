package com.bootcamp.taller.controlers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.taller.models.Usuario;
import com.bootcamp.taller.services.ServicioUsuarios;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "Controladora de usuario")
@RestController
public class ControladoraUsuarios {
	
	@Autowired
	private ServicioUsuarios servicio;
	
	//create, read, update, delete
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully updated schema"), @ApiResponse(code = 404, message = "Schema not found"), @ApiResponse(code = 400, message = "Missing or invalid request body"), @ApiResponse(code = 500, message = "Internal error")})
	@ApiOperation(value = "Crea un usuario")
	@ApiParam(name = "usuario", type = "Usuario", value = "Un usuario", required = true)
	@RequestMapping(method = RequestMethod.POST, value = "/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return servicio.anadirOActualizarUsuario(usuario);
	}
	
	@ApiOperation(value = "Devuelve un usuario")
	@RequestMapping(method = RequestMethod.GET, value="usuarios/{id}")
	public Optional<Usuario> mostrarUsuario(@PathVariable("id") Integer id) {
		return servicio.getUsuarioPorId(id);
	}
	
	@ApiOperation(value = "Devuelve todos los usuarios")
	@RequestMapping(method = RequestMethod.GET, value = "/usuarios")
	@ResponseBody
	public List<Usuario> getAllUsuarios() {
		return servicio.getAllUsuarios();
	}
	
	@ApiOperation(value = "Elimina un usuario")
	@RequestMapping(method = RequestMethod.DELETE, value = "usuarios/{id}")
	public void eliminarUsuario(@PathVariable("id")Integer id) {
		servicio.eliminarUsuario(id);
	}

}
