<%@page import="beans.Person" %>
<html>
    <%
        Person p = new Person(
                request.getParameter("kilos"),
                request.getParameter("meter")
        );
    %>
    <head> 
        <title> Zeige BMI an </title> 
    </head>
    <body>
        <h3>
            <%=p.sayBMI()%> 
        </h3>
    </body>
</html>


