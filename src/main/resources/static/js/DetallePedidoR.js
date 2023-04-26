let boton = document.querySelector("#realizarcompra");
boton.addEventListener("click", (e)=>enviar(e));

function enviar(e){
	let validar = JSON.parse(localStorage.getItem('productos'));
	if(validar.length < 1){
		alert("No hay registros para realizar la compra");
	}else{
		let user = null;
		if (document.querySelector(".user").textContent != "Mi Cuenta" && document.querySelector(".user").textContent != "Mi cuenta"){
			user = document.querySelector(".user").textContent;
		}
		else{
			user = "v";
		}
		let arreglo = [];
		let productoLS = JSON.parse(localStorage.getItem('productos'));
		let cantidad = productoLS.length;
		for(let n = 0; n < cantidad; n++){
			let agregar = [productoLS[n].titulo, productoLS[n].cantidad,productoLS[n].precio, productoLS[n].id];
			arreglo.push(agregar);
		}
		let n1 = document.querySelector(".c1").value;
		let n2 = document.querySelector(".c2").value;
		let n3 = document.querySelector(".c3").value;
		let detalle = [
			n1,n2,n3
		]
		localStorage.clear();
		e.preventDefault();
		location.href=`/irR/${arreglo}/${detalle}/${user}`;
	}
}