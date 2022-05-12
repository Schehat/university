 <html>
    <head> <title> Show BMI result </title> 
        <link rel="stylesheet" type="text/css" href="myWt.css"/> 
    </head>
 
    <body>

        <% 
           float kg = 0;
           float meter = 0 ;
           boolean valid = true;
           float bmi = 0;
           try{
                kg = Float.parseFloat(request.getParameter("kilos"));
                meter = Float.parseFloat(request.getParameter("meter")); 
           }
           catch(Exception e){
                valid = false;
           }     
           if (valid){
                bmi = kg / (meter*meter);
                bmi = Math.round(bmi);
           %> 
                <h1>Dein BMI hat den Wert: </h1>  <br/>
                <%= bmi %> <br/>
                <% if (bmi < 20) { %>
                    du hast Untergewicht
                <% } %>
                <% if (20 <= bmi && bmi < 24) { %>
                    du hast Normalgewicht
                <% } %>
                <% if (bmi > 24) { %>
                    du hast Übergewicht
                <% } %>
   
           <% 
             }
             else
            { %> 
            die Eingabe war nicht korekt!! <br/>
            Das Gewicht und die Größe müssen  Gleitpunktzahlen sein.             
            <% 
            }
            %>      
    </body>
</html>

