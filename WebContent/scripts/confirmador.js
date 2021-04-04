function confirmar(idcon) {
	let resposta = confirm("Confirma a exclusão deste contato?");
	
	if(resposta) {
		window.location.href = "delete?idcon=" + idcon;
	} 
}