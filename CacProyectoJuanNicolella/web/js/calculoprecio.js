

function total(cantidad, categoria){
    var res = 0;
    if(categoria == "Básico"){
        res = 800;
    } else if(categoria == "Intermedio"){
        res = 1400;
    } else {
        res = 2000; 
    }

    return res;
}

function calcularPrecio() {
    var list = document.getElementById("sel1");
    var categoria = list.options[list.selectedIndex].text;
    var cantidad = document.getElementById("cantidad").value;
    document.getElementById("totalAPagar").innerHTML = "Total a Pagar: $" + total(cantidad, categoria);
}

function erase(){
    document.getElementById("cantidad").value = "";
    var list = document.getElementById("sel1");
    document.getElementById("sel1").value = list.options[0].text;
    document.getElementById("totalAPagar").innerHTML = "Total a Pagar: ";


}