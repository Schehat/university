"use strict"
function init() {
    let arr_receipe = [document.getElementById("salami"), document.getElementById("schinken"), 
            document.getElementById("ananas"), document.getElementById("pilze")];
    let map_price = {mini:3, maxi:6, party:9};
    let map_calories = {mini:300, maxi:600, party:900};
    let map_size = {mini:15, maxi:30, party:45};

    let pizza_type;
    let price = 0;
    let calories = 0;
    var receipe_text = "";

    function open() {
        if (document.getElementById("select_pizza").value == "Mini (15 cm)") {
            pizza_type = "mini";
        } else if (document.getElementById("select_pizza").value == "Maxi (30 cm)") {
            pizza_type = "maxi";
        } else {
            pizza_type = "party";
        }

        // clear string
        receipe_text = "";
        // check if at least one receipe is selected 
        for (const receipe of arr_receipe) {
            if (receipe.checked) {
                price += map_price[pizza_type];
                calories += map_calories[calories];
                receipe_text += receipe.id + " "
            }
        }

        if (price <= 0) {
            alert("Mindestens eine Zutat muss ausgewählt werden!");
            // exit from function
            return;
        }

        var tr = document.createElement('tr');   
        var td_size = document.createElement('td');
        var td_receipe = document.createElement('td');
        var td_price = document.createElement('td');
        var td_calories = document.createElement('td');

        td_size.innerHTML = map_size[pizza_type];
        td_receipe.innerHTML = receipe_text;
        td_price.innerHTML = map_price[pizza_type];
        td_calories.innerHTML = map_calories[pizza_type];

        tr.appendChild(td_size);
        tr.appendChild(td_receipe);
        tr.appendChild(td_price);
        tr.appendChild(td_calories);

        document.getElementById("table").appendChild(tr);

        console.log(document.getElementById("price").innerHTML);
        document.getElementById("price").innerHTML = parseInt(document.getElementById("price").innerHTML) + map_price[pizza_type];
    }

    document.getElementById("bestellen").onclick = open;
}

init();
