package generation.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// en este lugar creamos nuestra tabla en la base de datos, la tabla se aplica a nuesta base de datos por la aplication propierties que establecimos
@Entity // escribimos @entity y usamos el auto completar para que nos importe el entity 
@Table(name="users") // esto le cambia el nombre a la tabla igualmente usamos el auto completar para importar el table
public class UserModel {
	@Id // el Id se genera de manera automatica, le pone un numero 1 ya 
	@GeneratedValue(strategy = GenerationType.IDENTITY)// con esto le digo que el valor lo asigna desde java y la estrategia elegida es el IDENTITY, tenemos la (AUTO,IDENTITY,SEQUENCE, etc.
	@Column(nullable=false)//esta columna no puede ser nula
	private long id;
	@Column(nullable = false,length = 100, name = "name")// atributos de la columna
	private String name;
	@Column(nullable=false,length = 100)
	private String surname;
	@Column(nullable = false, length=100,unique=true)
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
