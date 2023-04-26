/* ************TORTAS PERSONALIZADAS*********** */

function tortas_mayordeedad(){
    document.getElementById("tortas-mayordeedad").style.display="flex"
    document.getElementById("t-mayordeedad").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-bb").style.display="none"
    document.getElementById("t-bb").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("t-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="none"
    document.getElementById("t-i").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display="none"
    document.getElementById("t-15").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_babyshower(){
    document.getElementById("tortas-mayordeedad").style.display="none"
    document.getElementById("t-mayordeedad").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display="flex"
    document.getElementById("t-bb").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("t-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="none"
    document.getElementById("t-i").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display="none"
    document.getElementById("t-15").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_cumpleanos() {
    document.getElementById("tortas-mayordeedad").style.display = "none"
    document.getElementById("t-mayordeedad").style.color = "rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display = "none"
    document.getElementById("t-bb").style.color = "rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display = "flex"
    document.getElementById("t-cumple").style.color = "rgb(209, 87, 47)"
    document.getElementById("tortas-infantil").style.display = "none"
    document.getElementById("t-i").style.color = "rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display = "none"
    document.getElementById("t-15").style.color = "rgba(0, 0 , 0, 0.5)"
};

function tortas_infantil(){
    document.getElementById("tortas-mayordeedad").style.display="none"
    document.getElementById("t-mayordeedad").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display="none"
    document.getElementById("t-bb").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("t-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="flex"
    document.getElementById("t-i").style.color="rgb(209, 87, 47)"
    document.getElementById("tortas-quince").style.display="none"
    document.getElementById("t-15").style.color="rgba(0, 0 , 0, 0.5)"
};

function tortas_quince(){
    document.getElementById("tortas-mayordeedad").style.display="none"
    document.getElementById("t-mayordeedad").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-bb").style.display="none"
    document.getElementById("t-bb").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-cumple").style.display="none"
    document.getElementById("t-cumple").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-infantil").style.display="none"
    document.getElementById("t-i").style.color="rgba(0, 0 , 0, 0.5)"
    document.getElementById("tortas-quince").style.display="flex"
    document.getElementById("t-15").style.color="rgb(209, 87, 47)"
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

