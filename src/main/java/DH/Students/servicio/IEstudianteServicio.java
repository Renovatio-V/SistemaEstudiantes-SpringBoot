package DH.Students.servicio;

import DH.Students.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiante> ListarEstudiantes();
    public Estudiante buscarEstudiantePorId(Integer idEstudiante);
    public void guardarEstudiante(Estudiante estudiante);
    public void eliminarEstudiante(Estudiante estudiante);
}
