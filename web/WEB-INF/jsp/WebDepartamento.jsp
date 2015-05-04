<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" action="WebDepartamento.htm">
            <table border="1">
                <tr>
                    <th>Introduzca un número de departamento</th>
                    <td>
                        <input type="text" name="txtdeptno"/>
                    </td>
                    <td>
                        <input type='submit' value='Mostrar nombre'/>
                    </td>
                </tr>
            </table>
        </form>
        <c:if test="${nombredepartamento != null}">
            <div style='color:red'>
                El nombre del departamento es
                <c:out value="${nombredepartamento}"/>
            </div>
        </c:if>
    </body>
</html>
