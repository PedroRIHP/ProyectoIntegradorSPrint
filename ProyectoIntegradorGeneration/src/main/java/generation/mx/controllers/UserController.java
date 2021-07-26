package generation.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.UserModel;
import generation.mx.services.UserService;
//nuestro controlador es el ultimo nivel se conecta al servicio que  a su vez se conecta al repositrio, se activa por la url
//este es el nivel mas alto que interactuda con el usuario final
//los metodos mas populares son el [@Get/@POSt/@Delete: MApping)
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping //los formularios viajan ocultos por el metodo post, y como no le definimos una ruta va a tomar la que tenemos en el controlador
	public ArrayList<UserModel> getUsers() {
		return userService.getUsers();
	}
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) { 
		//necesito interseptar los datos que se ejecuten por metodo post con el @RequestBody
		return userService.saveUser(user);
	}
	@GetMapping (path= "/{id}") // "id": 3 manda un id, si ya existe reemplaza los datos en ese Id
	// la ruta aqui es "/user/{id}" el user se hereda de arriba en la linea 17 
	public Optional<UserModel> getUserById(@PathVariable("id") Long id) { //le pusimos opcional por que va a devolver opcional mente un User Model
		//nuevo metodo llamado getUserById, el opcional nos ayuda a evitar errores en caso de buscar un Id que no existe en nuestra base de datos
		return userService.getUserById(id); 
		// el "@pathvariable" nos dice que la variable que vamos a meter dentro es el id
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id")Long id) {
		boolean ok = userService.deleteUser(id);
		 
		//ok == true es igual a Ok
		if (ok == true){
			return "se elimino el usuario";
		}else {
			return "no se pudo eliminar el suaurio";
		}
	}
	//users/query es la direccion a la que estamos apuntando
	@GetMapping("/query")// quiere decir que se dispara hasta que lleguemos a esta URl
	public ArrayList<UserModel> getUsersByName(@RequestParam(value = "name", defaultValue="")String name){
		return userService.getUsersByName(name);
	}

}
