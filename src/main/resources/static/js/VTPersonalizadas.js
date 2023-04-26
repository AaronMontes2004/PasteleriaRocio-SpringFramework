const validacion = () => {
	let cake = document.querySelector('.txtcake').value;
	let relleno = document.querySelector('.txtrelleno').value;
	let porciones = document.querySelector('.txtporciones').value;
	let cantidad = document.querySelector('.ncantidad').value;
	
	if (cake == 'Seleccionar'){
		Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Seleccione un sobor de queque!!',
		})
		return false;
	} else if(relleno == 'Seleccionar'){
		Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Seleccione un relleno para el queque!!',
		})
		return false;
	} else if(porciones == 0){
		Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Seleccione un cantidad de porciones!!',
		})
		return false;
	} else if(cantidad < 1){
		Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Si va realizar una compra la cantidad no puede ser menor que 1!!',
		})
		return false;
	}
	return true;
};

const Veliminar = (event,enlace) => {
	event.preventDefault();
	const swalWithBootstrapButtons = Swal.mixin({
  	customClass: {
    	confirmButton: 'btn btn-success',
    	cancelButton: 'btn btn-danger'
  	},
 	buttonsStyling: false
	})

	swalWithBootstrapButtons.fire({
  	title: '¿Desea eliminar el proveedor?',
  	text: "Una vez realizado no hay vuelta atras",
  	icon: 'warning',
  	showCancelButton: true,
  	confirmButtonText: 'Aceptar',
  	cancelButtonText: 'Cancelar',
  	reverseButtons: true
	}).then((result) => {
  	if (result.isConfirmed) {
    	swalWithBootstrapButtons.fire(
      	'¡Proveedor eliminado!',
      	'Operación exitosa',
      	'success'
    ).then((x) => {
		if (x.isConfirmed){
			window.location.href = enlace;
		}
	})
  } else if (result.dismiss === Swal.DismissReason.cancel) {
    swalWithBootstrapButtons.fire(
      'Cancelado',
      'No se eliminó el proveedor',
      'error'
    )
  }
})
}

window.onload = function(){
	document.querySelector('#msj-reg').click();
}

const VRegistrar = () =>{
	Swal.fire({
	  icon: 'success',
	  title: 'Productos registrado con éxito',
	  showConfirmButton: false,
	  timer: 2000
	})
}

window.onload = function(){
	document.querySelector('#msj-edi').click();
}

const VEditar = () =>{
	Swal.fire({
	  icon: 'success',
	  title: 'Productos modificado con éxito',
	  showConfirmButton: false,
	  timer: 2000
	})
}

const VRegistrarAlmacen = () =>{
	Swal.fire({
	  icon: 'success',
	  title: 'Insumo registrado con éxito',
	  showConfirmButton: false,
	  timer: 2000
	})
}

(document.querySelector('#msj-regAlmacen').click());

const VEditarAlmacen = () =>{
	alert("aea");
	Swal.fire({
	  icon: 'success',
	  title: 'Productos modificado con éxito',
	  showConfirmButton: false,
	  timer: 2000
	})
}

(document.querySelector('#msj-ediAlmacen').click());

window.onload = function(){
	document.querySelector('#msj-regProveedor').click();
	//document.querySelector('#msj-ediProveedor').click();
}

const VRegistrarProveedor = () =>{
	Swal.fire({
	  icon: 'success',
	  title: 'Proveedor registrado con éxito',
	  showConfirmButton: false,
	  timer: 2000
	})
}

/*const VEditarProveedor = () =>{
	Swal.fire({
	  icon: 'success',
	  title: 'Proveedor modificado con éxito',
	  showConfirmButton: false,
	  timer: 2000
	})
}*/
