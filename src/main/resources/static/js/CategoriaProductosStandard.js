
function tortas_pequeñas(){
    document.getElementById("tortas-pequeñas").style.display="flex"
    document.getElementById("tortas-pequeñas").style.transitionDuration="1s"
    document.getElementById("t-p").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-medianas").style.display="none"
    document.getElementById("t-m").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-grandes").style.display="none"
    document.getElementById("t-g").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cuadradas").style.display="none"
    document.getElementById("t-c").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-circulares").style.display="none"
    document.getElementById("t-ci").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-rectangulares").style.display="none"
    document.getElementById("t-r").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_medianas(){
    document.getElementById("tortas-pequeñas").style.display="none"
    document.getElementById("t-p").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-medianas").style.display="flex"
    document.getElementById("t-m").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-grandes").style.display="none"
    document.getElementById("t-g").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cuadradas").style.display="none"
    document.getElementById("t-c").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-circulares").style.display="none"
    document.getElementById("t-ci").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-rectangulares").style.display="none"
    document.getElementById("t-r").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_grandes(){
    document.getElementById("tortas-pequeñas").style.display="none"
    document.getElementById("t-p").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-medianas").style.display="none"
    document.getElementById("t-m").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-grandes").style.display="flex"
    document.getElementById("t-g").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-cuadradas").style.display="none"
    document.getElementById("t-c").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-circulares").style.display="none"
    document.getElementById("t-ci").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-rectangulares").style.display="none"
    document.getElementById("t-r").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_cuadradas(){
    document.getElementById("tortas-pequeñas").style.display="none"
    document.getElementById("t-p").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-medianas").style.display="none"
    document.getElementById("t-m").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-grandes").style.display="none"
    document.getElementById("t-g").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cuadradas").style.display="flex"
    document.getElementById("t-c").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-circulares").style.display="none"
    document.getElementById("t-ci").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-rectangulares").style.display="none"
    document.getElementById("t-r").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_circulares(){
    document.getElementById("tortas-pequeñas").style.display="none"
    document.getElementById("t-p").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-medianas").style.display="none"
    document.getElementById("t-m").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-grandes").style.display="none"
    document.getElementById("t-g").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cuadradas").style.display="none"
    document.getElementById("t-c").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-circulares").style.display="flex"
    document.getElementById("t-ci").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-rectangulares").style.display="none"
    document.getElementById("t-r").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_rectangulares(){
    document.getElementById("tortas-pequeñas").style.display="none"
    document.getElementById("t-p").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-medianas").style.display="none"
    document.getElementById("t-m").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-grandes").style.display="none"
    document.getElementById("t-g").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cuadradas").style.display="none"
    document.getElementById("t-c").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-circulares").style.display="none"
    document.getElementById("t-ci").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-rectangulares").style.display="flex"
    document.getElementById("t-r").style.color="rgb(209, 87, 47)"
};

function mostrar_form(){
    document.getElementById("opc").style.right="0%";
    document.getElementById("opc").style.transitionDuration="0.7s";
    document.getElementById("i-arrow").style.left="100%";
};

function cerrar_form(){
    document.getElementById("opc").style.right="100%";
    document.getElementById("i-arrow").style.left="0%"
};

/* ************TORTAS PERSONALIZADAS*********** */
/*
function tortas_18(){
    document.getElementById("tortas-18").style.display="flex"
    document.getElementById("tp-18").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-bb").style.display="none"
    document.getElementById("tp-bb").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("tp-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="none"
    document.getElementById("tp-i").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display="none"
    document.getElementById("tp-15").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_babyshower(){
    document.getElementById("tortas-18").style.display="none"
    document.getElementById("tp-18").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display="flex"
    document.getElementById("tp-bb").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("tp-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="none"
    document.getElementById("tp-i").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display="none"
    document.getElementById("tp-15").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_cumpleanos() {
    document.getElementById("tortas-18").style.display = "none";
    document.getElementById("tp-18").style.color = "rgba(0, 0 , 0, 0.5)";
    document.getElementById("tortas-bb").style.display = "none";
    document.getElementById("tp-bb").style.color = "rgba(0, 0 , 0, 0.5)";
    document.getElementById("tortas-cumple").style.display = "flex";
    document.getElementById("tp-cumple").style.color = "rgb(209, 87, 47)";
    document.getElementById("tortas-infantil").style.display = "none";
    document.getElementById("tp-i").style.color = "rgba(0, 0 , 0, 0.5)";
    document.getElementById("tortas-quince").style.display = "none";
    document.getElementById("tp-15").style.color = "rgba(0, 0 , 0, 0.5)";
};

function tortas_infantil(){
    document.getElementById("tortas-18").style.display="none"
    document.getElementById("tp-18").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display="none"
    document.getElementById("tp-bb").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("tp-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="flex"
    document.getElementById("tp-i").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-quince").style.display="none"
    document.getElementById("tp-15").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_quince(){
    document.getElementById("tortas-18").style.display="none"
    document.getElementById("tp-18").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display="none"
    document.getElementById("tp-bb").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("tp-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="none"
    document.getElementById("tp-i").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display="flex"
    document.getElementById("tp-15").style.color="rgb(209, 87, 47)"
};*/