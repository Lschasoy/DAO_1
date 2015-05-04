package dao;

import java.util.List;
import modelos.Departamento;

public interface DepartamentoDao {
    public List<Departamento> findAll();
    
    public List<Departamento> findByLocalidad(String localidad);
    
    public String findById(int iddepartamento);

    public void insertarDepartamento(Departamento departamento);

    public void modificarDepartamento(Departamento departamento);

    public void eliminarDepartamento(int iddepartamento);

}