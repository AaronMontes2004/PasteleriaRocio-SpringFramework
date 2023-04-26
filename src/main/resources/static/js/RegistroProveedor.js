function VNombre(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
	if(code==8) {
		return true;
	} else if(code==32) {
		return true;
    } else if(code==237){
        return true;
    } else if(code==233){
        return true;
    } else if(code==243){
        return true;
    } else if(code==250) {
		return true;
	} else if (code == 225){
		return true;
	} else if(code>=65 && code<=90) {
		return true;
    } else if(code>=97 && code<=122) {
		return true;
	} else if(code >47 && code < 58){
		return true;
	} else{
		return false;
	}
}

function VTelefono(evt){
	var code = (evt.which) ? evt.which : evt.keyCode;
	if(code==8) {
		return true;
	} else if(code >47 && code < 58){
		return true;
	} else{
		return false;
	}
}

function VDireccion(evt){
	var code = (evt.which) ? evt.which : evt.keyCode;
	if(code==8) {
		return true;
	} else if(code >47 && code < 58){
		return true;
	} else if(code==32) {
		return true;
    } else if(code==237){
        return true;
    } else if(code==233){
        return true;
    } else if(code==243){
        return true;
    } else if(code==250) {
		return true;
	} else if (code == 225){
		return true;
	} else if(code>=65 && code<=90) {
		return true;
    } else if(code>=97 && code<=122) {
		return true;
	} else{
		return false;
	}
}

function VDatosSubmit(){
	var nombre = document.getElementById("nombre").value
	var telefono = document.getElementById("telefono").value
	var direccion = document.getElementById("direccion").value

	if (nombre === null || nombre === ''){
		alert("El campo nombre esta vacio")
		return false;
	} else if (telefono === null || telefono === ''){
		alert("El campo telefono esta vacio")
		return false;
	} else if (telefono.length < 9){
		alert("El telefono debe ser de 9 digitos")
		return false;
	} else if (direccion === null || direccion === ''){
		alert("El campo direccion esta vacio")
		return false;
	} else {
		alert("Proveedor registrado con éxito");
		return true;
	}
	
}