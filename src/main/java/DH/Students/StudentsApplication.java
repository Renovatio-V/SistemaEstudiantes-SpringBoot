package DH.Students;

import DH.Students.modelo.Estudiante;
import DH.Students.servicio.EstudianteServicio;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;
	private static final Logger logger = LoggerFactory.getLogger(StudentsApplication.class);
	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		//Levantar la fabrica de Spring
		SpringApplication.run(StudentsApplication.class, args);
		logger.info("Aplicacion Finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando método run de Spring..." + nl );
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//Fin while
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				*** Sistema de Estudiantes
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				Elige una opcion:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 -> {// Listar estudiantes
				logger.info(nl + "Listado de Estudiantes: " + nl);
				List<Estudiante> estudiantes = estudianteServicio.ListarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}
			case 2 ->  {//Buscar estudiantes por ID
				logger.info("Introduce el id del Estudiante a Buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Estudiante Encontrado: " + estudiante + nl);
				} else {
					logger.info("Estudiante No Encontrado con id: " + idEstudiante + nl);
				}
			}
			case 3 -> {//Agregar Estudiante
				logger.info("Agregar Estudiante: " + nl);
				logger.info("Nombre: ");
				var nombre =  consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				//Crear el objeto sin id
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante Agregado: " + estudiante + nl);
			}
			case 4 -> {//Modificar Estudiante
				logger.info("Modificar Estudiante: " + nl);
				logger.info("Id Estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos el Estudiante a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Nombre: ");
					var nombre =  consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante Modificado: "+ estudiante + nl);
				} else {
					logger.info("Estudiante NO encontrado con Id: " + idEstudiante);
				}
			}
			case 5 -> {//Eliminar Estudiante
				logger.info("Eliminar Estudiante: " + nl);
				logger.info("ID Estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				//Buscamos el id a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante Eliminado: "+ estudiante);
				} else {
					logger.info("Estudiante NO encontrado, con ID: " + idEstudiante);
				}
			}
			case 6 -> {//Salir
				logger.info("Hasta pronto! " + nl + nl);
				salir = true;
			}
			default -> logger.info("Opcion NO reconocida: " + opcion + nl );

		}//fin Switch
		return salir;
	}
}
