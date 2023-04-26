const carro = new Carrito();
const carrito = document.getElementById('carrito');
const productos = document.getElementById('lista-tortas');
const listaProductos = document.querySelector('#lista-carrito tbody');
const vaciarCarritoBtn = document.getElementById('vaciar-carrito');
const procesarPedidoBtn = document.getElementById('realizar-compra')
const procesarPedidoBtn2 = document.getElementById('realizarcompra')
const ActualizarCarrito = document.getElementById('recargarcarrito')

cargarEventos();

function cargarEventos(){
    productos.addEventListener('click', (e)=>{carro.comprarProducto(e)});

    carrito.addEventListener('click', (e)=>{carro.eliminarProducto(e)})

    vaciarCarritoBtn.addEventListener('click', (e)=>{carro.vaciarCarrito(e)})

    document.addEventListener('DOMContentLoaded', carro.leerLocalStorage());

    procesarPedidoBtn.addEventListener('click', (e)=>{carro.procesarPedido(e)});

    procesarPedidoBtn2.addEventListener('click', (e)=>{carro.procesarPedido2(e)});

    ActualizarCarrito.addEventListener('click', (e)=>{carro.actualizarCarrito(e)});
}