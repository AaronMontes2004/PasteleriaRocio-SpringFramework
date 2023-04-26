const compra = new Carrito();
//const a = document.querySelector('#lista-compra');
const listaCompra = document.querySelector('#lista-compra tbody');
const carrito =  document.getElementById('compra');
const seguircomprandobtn = document.getElementById('seguircomprando')
const procesarcomprabtn = document.getElementById('terminarcompra')
const nombres = document.getElementById('Nombres')
const apellidos = document.getElementById('Apellidos')
const dni = document.getElementById('DNI')
const telefono = document.getElementById('Telefono')
const correo = document.getElementById('Correo')
const personarecibo = document.getElementById('PersonaRecibo')
const telefonorecibo = document.getElementById('TelefonoRecibo')
const referencias = document.getElementById('Referencias')
cargarEventos();

function cargarEventos(){

    document.addEventListener('DOMContentLoaded', compra.leerLocalStorageCompra());

    carrito.addEventListener('click', (e)=>{compra.eliminarProducto(e)});

    carrito.addEventListener('change',(e)=>{compra.calculo(e)});

    seguircomprandobtn.addEventListener('click', (e)=>{compra.seguircomprando(e)});

    compra.calcularTotal();

    procesarcomprabtn.addEventListener('click', procesarCompra);
}

function procesarCompra(e){
    e.preventDefault();

    if(compra.obtenerProductosLocalStorage().length === 0){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'El carrito esata Vacio, tienes que comprar algo!!!',
            timer: 4000,
            showConfirmButton: false
          }).then(function(){
            window.location = "carritodecomprasR"
          })
    }
    else if(nombres.value === '' || apellidos.value === '' || dni.value === '' || telefono.value === '' 
    || correo.value === '' || personarecibo.value === '' || telefonorecibo.value === '' || referencias.value === ''){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Todos los Campos son obligatorios!!!',
            timer: 4000,
            showConfirmButton: false
          })
    }
    else{
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Compra Realizada con Exito, Detalles en su Correo!',
            showConfirmButton: false,
            timer: 2500
          })
    }
}