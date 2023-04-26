class Carrito{

    comprarProducto(e){
        //e.preventDefault();
        if(e.target.classList.contains('agregar-carrito')){
            const producto = e.target.parentElement.parentElement;
            this.leerDatosProducto(producto);
        }
    }

    leerDatosProducto(producto){
        const infoProducto = {
            imagen : producto.querySelector('img').src,
            titulo : producto.querySelector('h3').textContent,
            precio : producto.querySelector('.precio span').textContent,
            id : producto.querySelector('.agregacion').getAttribute('data-id'),
            cantidad : 1
        }
        this.insertarCarrito(infoProducto);
    }

    insertarCarrito(producto){
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <img src="${producto.imagen}" width = 100 height= 100>
            </td>
            <td class = "cln">${producto.titulo}</td>
            <td class="prc">S/. ${producto.precio}</td>
            <td>
                <a href="#" class="agregacion borrar-producto fas fa-times-circle" data-id="${producto.id}"></a>
            </td>
        `;

        console.log(producto.id);
        listaProductos.appendChild(row);
        this.guardarProductosLocalStorage(producto);
    }

    eliminarProducto(e){
        e.preventDefault();
        let producto, productoID;
        if(e.target.classList.contains('borrar-producto')){
            e.target.parentElement.parentElement.remove();
            producto = e.target.parentElement.parentElement;
            productoID = producto.querySelector('.agregacion').getAttribute('data-id');
        }
        this.eliminarProductoLocalStorage(productoID);
        this.calcularTotal();
    }

    vaciarCarrito(e){
        e.preventDefault();
        while(listaProductos.firstChild){
            listaProductos.removeChild(listaProductos.firstChild);
        }
        this.vaciarLocalStorage();
        return false;
    }

    guardarProductosLocalStorage(producto){
        let productos;
        productos = this.obtenerProductosLocalStorage();
        productos.push(producto);
        localStorage.setItem('productos', JSON.stringify(productos));
    }

    obtenerProductosLocalStorage(){
        let productoLS;

        if(localStorage.getItem('productos') === null){
            productoLS = [];
        }
        else{
            productoLS = JSON.parse(localStorage.getItem('productos'));
        }
        return productoLS;
    }

    eliminarProductoLocalStorage(productoID){
        let productosLS;
        productosLS = this.obtenerProductosLocalStorage();
        productosLS.forEach(function(productoLS, index){
            if(productoLS.id === productoID){
                productosLS.splice(index, 1);
            }
        });

        localStorage.setItem('productos', JSON.stringify(productosLS));
    }

    leerLocalStorage(){
        let productosLS;
        productosLS = this.obtenerProductosLocalStorage();
        productosLS.forEach(function(producto){
            const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <img src="${producto.imagen}" width = 100 height=100>
            </td>
            <td class="cln">${producto.titulo}</td>
            <td class="prc">S/. ${producto.precio}</td>
            <td>
                <a href="#" class="agregacion borrar-producto fas fa-times-circle" data-id="${producto.id}"></a>
            </td>
        `;
        listaProductos.appendChild(row); 
        });
    }
    leerLocalStorageCompra(){
        let productosLS;
        productosLS = this.obtenerProductosLocalStorage();
        productosLS.forEach(function(producto){
            const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <img src="${producto.imagen}" width = 100 height=100>
            </td>
            <td>${producto.titulo}</td>
            <td>
                <input type="number" class="form-control cantidad valor" style="width:50px; font-size:12px"  min="1" value=${producto.cantidad}>
            </td>
            <td>S/. ${producto.precio}</td>
            <td>
                <a href="#" class="agregacion borrar-producto fas fa-times-circle" style="font-size:30px" data-id="${producto.id}"></a>
            </td>
        `;
        listaCompra.appendChild(row); 
        });
    }

    vaciarLocalStorage(){
        localStorage.clear();
    }

    procesarPedido(e){
        e.preventDefault();
        location.href = "/carritodecomprasR"
    }

    procesarPedido2(e){
        e.preventDefault();
        location.href = "/carritodecomprasR"
    }

    actualizarCarrito(e){
        e.preventDefault();
        location.reload()
    }

    seguircomprando(e){
        e.preventDefault();
        location.href= "/carritodecomprasR"
    }

    calcularTotal(){
        let productoLS;
        let total = 0, subtotal = 0, igv = 0;
        productoLS = this.obtenerProductosLocalStorage();
        for(let i = 0; i < productoLS.length; i++){
            /*let element;
            if(productoLS[i].id === id){
                element = Number(productoLS[i].precio * c);
            }
            else{*/
            let element = Number(productoLS[i].precio * productoLS[i].cantidad);
            //}
            total = total + element;
        }
        igv = parseFloat(total * 0.18);
        subtotal = parseFloat(total+igv).toFixed(2);

        document.getElementById('total').innerHTML = "S/. " + subtotal;
        document.getElementById('igv').innerHTML = "S/. " + igv.toFixed(2);
        document.getElementById('subtotal').innerHTML = "S/. " + total.toFixed(2);
    }
//AQUI TODO OARA LO DEL CONTADOR
    calculo(e){
        let producto, productoID, cantidadP;
        if(e.target.classList.contains('valor')){
            producto = e.target.parentElement.parentElement;
            productoID = producto.querySelector('.agregacion').getAttribute('data-id');
            cantidadP = producto.querySelector('.valor').value;
        }
        this.actualizarCantidad(cantidadP, productoID);
    }

    actualizarCantidad(cantidadP,productoID){
        let productoLS;
        productoLS = this.obtenerProductosLocalStorage();

        let indice = productoLS.findIndex((elemento) => elemento.id === productoID);
        productoLS[indice].cantidad = cantidadP;

        localStorage.setItem('productos', JSON.stringify(productoLS));

        /*for(let i = 0; i < productoLS.length; i++){
            if(productoLS[i].id == productoID){
                productoLS[i].cantidad = cantidadP;
                break;
            }
        }*/
    }

    //HASTA AQUI LO DEL CONTADOR
}

//ESTO ES PORQUE CUANDO CARGAS LA PÁGINA NECESITABAS HACER UN CLICK PARA QUE SE VEA EL SUBTOTAL, IGV Y TOTAL
window.onload = function()
{
    document.querySelector(".auto-click").click();
}