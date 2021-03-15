/**
 * Validação de formulário
 * @author Ezandro Bueno
 */

function validar() {
	let nome = frmContato.nome.value;
	let telefone = frmContato.fone.value;
	
	if(nome === "") {
		alert('Preencha o campo Nome');
		frmContato.nome.focus();
		return false;
	} else if(telefone === "") {
		alert('Preencha o campo Telefone');
		frmContato.fone.focus();
		return false;
	} else {
		document.forms["frmContato"].submit();
	}
}