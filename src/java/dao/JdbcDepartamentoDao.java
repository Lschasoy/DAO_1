package dao;

import java.util.List;
import javax.sql.DataSource;
import modelos.Departamento;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDepartamentoDao implements DepartamentoDao, InitializingBean
{
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        /** clase encargada de realizar las consultas es la clase JdbcTemplate **/
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException(
                    "Debe establecer el dataSource ContactDao");
        }
    }    

    @Override
    public List<Departamento> findAll() {
	return null;
    }

    @Override
    public List<Departamento> findByLocalidad(String localidad) {
	return null;
    }

    @Override
    public String findById(int iddepartamento) {
        
        String nombre = jdbcTemplate.queryForObject(
            "SELECT DNOMBRE FROM DEPT WHERE DEPT_NO = ?",
        new Object[]{iddepartamento}, String.class);
        return nombre;
    }

    @Override
    public void insertarDepartamento(Departamento departamento) {

    }

    @Override
    public void modificarDepartamento(Departamento departamento) {

    }

    @Override
    public void eliminarDepartamento(int iddepartamento) {

    }
}