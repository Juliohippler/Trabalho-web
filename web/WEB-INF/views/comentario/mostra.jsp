<%-- 
    Document   : mostra
    Created on : 08/06/2017, 11:33:11
    Author     : julio
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
  <h3>Alterar Comentario - ${comentario.id}</h3>
  <form action="alteraComentario?id_topico=${comentario.id_topico}" method="post">

    <input type="hidden" name="id" value="${comentario.id}" />
  
    Descri��o:<br />
    <textarea name="comentario" cols="100" rows="5"> ${comentario.comentario} </textarea>
    <br />      

  
    <input type="submit" value="Alterar" />
  </form>
</body>
</html>
