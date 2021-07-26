package generation.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.mx.models.UserModel;
import generation.mx.repositories.UserRepository;

@Service
public class UserService {
	@Autowired //para evitar la inicializacon de el nuevo contructor usando el = new Nombre del objeto etc.
	UserRepository userRepository; //uno es la clase y el otro el de enfretne es un Objeto
	//le decimos oye.. estoy creando un userrepository y todoo lo demas encargate tu.el objeto "userRepository que creamos es donde hacemos las operaciones
	public ArrayList<UserModel> getUsers(){
		return (ArrayList<UserModel>)userRepository.findAll(); //heredo metodos de nuestra interfase Repositorio vienen de CRUD repository, el Arraylist es apra tranformalo en un array list 
	}
	
	/*public UserModel saveUser(UserModel user) {
		return userRepository.save(user);
	}*/
	
	
	public UserModel saveUser(UserModel user) {
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		if(name !=null && surname != null && email != null){
		return userRepository.save(user);
	}
		return user;
	}

	public Optional<UserModel> getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	//metodo para borrar
	public boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		}catch (Exception error) {
			return false;
		}
		
	}
	public ArrayList<UserModel> getUsersByName(String name){
		return userRepository.findByName(name);
		
	}
} 
