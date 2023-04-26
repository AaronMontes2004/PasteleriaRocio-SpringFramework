/*========================================
Slider
==========================================*/
if(document.querySelector('.contenedor-slider')){

    let index=1;
    let selectedIndex=1;

    const slides=document.querySelector('.slider');
    const slide=slides.children;
    const slidesTotal=slides.childElementCount;

    const dots=document.querySelector('.dots');
    const prev=document.querySelector('.prev');
    const next=document.querySelector('.next');


    //agregamos los punto de acuerdo a la cantidad de slides
    for (let i = 0; i < slidesTotal; i++) {
        dots.innerHTML +='<span class="dot"></span>';
    }
    
    //ejecutamos la funcion
    mostrarSlider(index);

    //hacemos que nuestro slide sea automatico
    setInterval(()=>{
        mostrarSlider(index=selectedIndex);
    },3000); //rempresentados en milesegundos

    //funcion para mostrar el slider
    function mostrarSlider(num){
        if(selectedIndex > slidesTotal){
            selectedIndex=1;
        }else{
            selectedIndex++;
        }

        if(num > slidesTotal){
            index=1;
        }

        if(num<1){
            index=slidesTotal;
        }

        //removemos la clase active de todos los slide
        for(let i=0; i<slidesTotal;i++){
            slide[i].classList.remove('active');
        }

        //removemos la clase active de los puntos

        for (let x = 0; x < dots.children.length; x++) {
            dots.children[x].classList.remove('active');
        }

        //mostramos el slide
        slide[index-1].classList.add('active');

        //agregamos la clase active al punto donde se encuntra el slide
        dots.children[index-1].classList.add('active');

        
    }

    //evento para nuestro botones prev y next
    next.addEventListener('click',(e)=>{
        mostrarSlider(index +=1);
        selectedIndex=index;
    });

    prev.addEventListener('click',(e)=>{
        mostrarSlider(index +=-1);
        selectedIndex=index;
    });

    //puntos
    for (let y = 0; y < dots.children.length; y++) {
        
        //por cada dot que ecuentre le agregamos el evento click y ejecutamo la funcion de slide
        dots.children[y].addEventListener('click',()=>{
            mostrarSlider(index=y+1);
            selectedIndex=y+1;
        });
    }

}

const tabLink=document.querySelectorAll('.tab-link');
const formularios=document.querySelectorAll('.formulario');

for (let x = 0; x < tabLink.length; x++) {
    
    tabLink[x].addEventListener('click',()=>{

        //removemos la clase active de todos los tabs encotrados
        tabLink.forEach((tab)=> tab.classList.remove('active'));

        //le agregamos la clase active al tab que se le hizo click
        tabLink[x].classList.add('active');

        //mostramos el formulario correspondiente
        //para los formularios funciona exactamente los mismo que los tabs
        formularios.forEach((form)=>form.classList.remove('active'));
        formularios[x].classList.add('active');
       
    })
}

document.querySelector('.campo span').addEventListener('click', e => {
    const passwordInput = document.querySelector('#password');
    if (e.target.classList.contains('show')) {
        e.target.classList.remove('show');
        e.target.textContent = 'Ocultar';
        passwordInput.type = 'text';
    } else {
        e.target.classList.add('show');
        e.target.textContent = 'Mostrar';
        passwordInput.type = 'password';
    }
});










function validarTexto(parametro){
    var patron = /^[a-zA-Z\s]*$/;
    if(parametro.search(patron)){
     return false; 
    }else{
         return true; 
    }
 }
 function validarLongitud(parametro){

    if(parametro.length <=2){
     return false; 
    }else{
         return true; 
    }
 }
 function validarLongi(parametro){

    if(parametro.length <=8){
     return false; 
    }else{
         return true; 
    }
 }
/* function validarCorreo(parametro){
    // var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
     var patron=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.m;:\s@\"]+)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{2,3}]))))+$/;
     if(patron.test(parametro)){
         return false; 
     }else{
         return true; 
     }
  }*/

function ValidarFormulario(){
    //alert("todo en orden ")
    var formulario = document.addForm; 
    if(formulario.nombre.value == ""){
       // alert("porfavor ingresar su nombre")
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="close" data-dismiss="alert">&times;</a>Por Favor Ingrese su Nombre</div>';
        formulario.nombre.focus();
        return false;
    }else if(validarTexto(formulario.nombre.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-warning"><a href="" class="close" data-dismiss="alert">&times;</a>No se Aceptan valores numericos en el campo de Nombres</div>';
        formulario.nombre.value="";
        formulario.nombre.focus();
        return false;
    
    }else if(validarLongitud(formulario.nombre.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingresar mayor a 2 caracteres en el campo de nombres</div>';
        formulario.nombre.focus();
    }else{
        document.getElementById("alerta").innerHTML="";
    }

    if(formulario.apellido.value == ""){
        // alert("porfavor ingresar su nombre")
         document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese sus apellidos</div>';
         formulario.apellido.focus();
         return false;
     }else if(validarTexto(formulario.apellido.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-warning"><a href="" class="close" data-dismiss="alert">&times;</a>No se Aceptan valores numericos en el campo de Apellidos</div>';
        formulario.apellido.value="";
        formulario.apellido.focus();
        return false;
     }else if(validarLongitud(formulario.apellido.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingresar mayor a 2 caracteres en el campo de Apellidos </div>';
        formulario.apellido.focus();
     }else{
         document.getElementById("alerta").innerHTML="";
     }


     if(formulario.email.value == ""){
     
         document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese su Correo</div>';
         formulario.email.focus();
         return false;
     }else if(validarCorreo(formulario.email.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese un Correo Valido</div>';
        formulario.email.value="";
        formulario.email.focus();
        return false;
     }else{
         document.getElementById("alerta").innerHTML="";
     }


     if(formulario.password.value == ""){

         document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese su Contraseña</div>';
         formulario.password.focus();
         return false;
     }else if(validarLongi(formulario.password.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingresar mayor a 8 caracteres en su contraseña por seguridad </div>';
        formulario.password.focus();
        return false; 
     }else{
         document.getElementById("alerta").innerHTML="";
     }


   
    formulario.submit();
    formulario.nombre.value="";
    formulario.apellido.value="";
    formulario.email.value="";
    formulario.password.value="";

}


function ValidarFormulariologin(){
    var formulario = document.addFrm; 
    if(formulario.username.value == ""){
 
         document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese su Correo</div>';
         formulario.username.focus();
         return false;
     }else if(validarCorreo(formulario.username.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese un Correo Valido</div>';
        formulario.username.value="";
        formulario.username.focus();
        return false;
     }else{
         document.getElementById("alerta").innerHTML="";
     }


     if(formulario.password.value == ""){
         document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese su Contraseña</div>';
         formulario.password.focus();
         return false;
     }else if(validarLongi(formulario.password.value)==false){
        document.getElementById("alerta").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingresar mayor a 8 caracteres en su contraseña por seguridad </div>';
        formulario.password.focus();
        return false; 
     }else{
         document.getElementById("alerta").innerHTML="";
     }

     formulario.submit();
}

function ValidarRecuperarContra(){
	var formulario = document.addForm; 
	if(formulario.correo.value==""){
		document.getElementById("alertar").innerHTML='<div class="alert alert-danger"><a href="" class="btn-close" data-dismiss="alert">&times;</a>Por Favor Ingrese su Correo para Recuperar Contraseña</div>';
         formulario.correo.focus();
         return false;
	}
	
}


































