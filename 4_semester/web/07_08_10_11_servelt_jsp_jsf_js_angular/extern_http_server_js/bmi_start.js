function berechnen() {
    let gewicht = document.getElementById("gewicht").value;
    let groese = document.getElementById("groese").value;
    let queryParam = new URLSearchParams({"gewicht": gewicht, "groese": groese});
    let url = "http://localhost:8080/BMIApplication/api/BMIResource?";
    fetch(url + queryParam)
        .then(response => response.json())
        .then(data => {
            localStorage.setItem("bmi", data.bmi);
            localStorage.setItem("ergebnis", data.ergebnis);
            window.location.href = "bmi_result.html";
        })
        .catch(err => {
            alert("Fetch error", err);
        })
}
document.getElementById("berechnen").onclick = berechnen;
