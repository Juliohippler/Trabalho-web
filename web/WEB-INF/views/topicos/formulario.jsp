<%-- 
    Document   : tarefa-formulario
    Created on : 26/05/2017, 21:42:13
    Author     : ufpr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Topico</title>
    </head>
    <body>
        <h3>Adicionar topico</h3>
        <form action="adicionaTopico" method="post">
            Descrição: <br />
            <textarea name="descricao" rows="5" cols="100"></textarea><br />

            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
