

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar contacto</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Actualizar Estado del Servicio</h1>
                <form action="Servicios" method="post" style="margin: auto; display: table"> 
                    <input type="hidden" name="accion" value="EUPD"/>            
                    <input type="hidden" name="id" value="${servicio.getIdServicio()}"/>
                    <fieldset>
                        <legend>Actualizar Estado</legend>
                        <br/>
                        <label>Ingrese el Estado</label><br>
                        <select name="estado" class="form-control" style="width: 400px">
                                <option value="ACTIVO">ACTIVO</option>
                                <option value="BAJA">BAJA</option>
                        </select>    
                        <br/> 
                        <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-primary" href="servicios.jsp">Regresar</a><br/>
                        <c:if test="${mensaje != null}">
                            <div>${mensaje}</div>
                        </c:if>         
                    </fieldset>
                </form>

            </div>
        </div>
    </body>
</html>
