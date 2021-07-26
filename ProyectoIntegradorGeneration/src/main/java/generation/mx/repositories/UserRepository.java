package generation.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository; //amigo spring que nos crea un CrudRepository con metodos predefinidos, tiene bastantes, borrar, actualizar, modifcar, CRUD create read
import org.springframework.stereotype.Repository;

import generation.mx.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
//User model y Long es el tipo de dato como las ID, User model es el Modelo de Usuarios
	public abstract ArrayList<UserModel> findByName(String name);//el metodo find by name me permte buscar usuario spor su nombre
	
}
