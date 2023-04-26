
const VEmitido = () =>{
	Swal.fire({
	  icon: 'success',
	  title: 'La factura fue enviada con éxito',
	  showConfirmButton: false,
	  timer: 2500
	})
}

window.onload = function(){
	document.querySelector("#msj-factura").click();
}