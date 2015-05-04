package controladores;

import dao.DepartamentoDao;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.portlet.ModelAndView;


public class ControllerDepartamento {
    
    /** Metodo getBean ***/
    /** Recupera el objeto DAO de acceso a datos JdbcDepartamentoDao del contenedor **/
    private Object getBean(String nombrebean, ServletContext servlet) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }    
    
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        ModelAndView mv = new ModelAndView("WebDepartamento"); // Pagina salida
        String dato = hsr.getParameter("txtdeptno");           // dato de entrada  
        if (dato != null) {                           // verifica si el la primera vez          
            DepartamentoDao deptdao = (DepartamentoDao) this.getBean("departamentoDao", hsr.getServletContext());
            int deptno = Integer.parseInt(dato);            
            String nombre = deptdao.findById(deptno); // Llamada a la funcion ...
            mv.addObject("nombredepartamento", nombre);
        }
        return mv;
    }
    
}
