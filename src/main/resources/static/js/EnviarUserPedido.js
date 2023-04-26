//let boton = document.querySelector('.pedidosId');
//boton.addEventListener("click",(e)=>enviar(e));

function llevar(event){
	let user = document.querySelector(".user").textContent;
	event.preventDefault();
	location.href = `/pedidosR/${user}`;
}
