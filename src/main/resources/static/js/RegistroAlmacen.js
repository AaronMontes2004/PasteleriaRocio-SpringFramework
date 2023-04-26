function VNombre(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
	if(code==8) {
		return true;
	} else if(code==32) {
		return true;
    } else if(code==237){
        return true;
    } else if(code==233){
        return true;
    } else if(code==243){
        return true;
    } else if(code==250) {
		return true;
	} else if (code == 225){
		return true;
	} else if(code>=65 && code<=90) {
		return true;
    } else if(code>=97 && code<=122) {
		return true;
	} else{
		return false;
	}
}


function VCantidad(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
	if(code==8) {
		return true;
	} else if(code >47 && code < 58){
		return true;
	} else{
        return false;
    }
}

function VCategoria(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
	if(code==8) {
		return true;
	} else if(code >47 && code < 58){
		return true;
	} else{
        return false;
    }
}