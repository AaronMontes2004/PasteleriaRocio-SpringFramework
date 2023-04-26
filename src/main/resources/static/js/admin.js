
function ir(){
    var user="AdminRocio123"
    var contra="123456789"

	if(document.form.username.value==""){
            document.getElementById("alerta").innerHTML='<div class="alertaj alert alert-danger"></a>Por Favor Ingrese su Usuario !!</div>';
            document.getElementById("username").focus();
        }
    else{
		 if(document.form.password.value==""){
        document.getElementById("alerta").innerHTML='<div class="alertaj alert alert-danger"></a>Por Favor Ingrese su Contraseña !!</div>';
        document.getElementById("password").focus();
    	}

       else if(document.form.password.value==contra && document.form.username.value==user){
            document.getElementById("alerta").innerHTML='<div class="alertaj alert alert-success"></a>Bienvenido a la Solucion Web</div>';
            window.location="/Producto/MenuAdministrativo";
        }
        else{
             document.getElementById("alerta").innerHTML='<div class="alertaj alert alert-warning"></a>Por Favor Ingrese su Usuario o Contraseña Correctamente!</div>';
        }
    }



}

function salir(){
	     alert("Ha cerrado sesion Exitosamente");
}

