document.getElementById("currentBMI").innerHTML = localStorage.getItem("bmi");
document.getElementById("ergebnis").innerHTML = localStorage.getItem("ergebnis");

// maxBMI bestimmen
if(document.getElementById("currentBMI").innerHTML > Math.round(localStorage.getItem("maxBMI")*100)/100) {
    localStorage.setItem("maxBMI", document.getElementById("currentBMI").innerHTML);
    document.getElementById("maxBMI").innerHTML = document.getElementById("currentBMI").innerHTML;
 } else {
     document.getElementById("maxBMI").innerHTML = Math.round(localStorage.getItem("maxBMI")*100)/100;
 } 

function zurueck() {
    window.location.href = "bmi_start.html";
}

document.getElementById("zurueck").onclick = zurueck;
