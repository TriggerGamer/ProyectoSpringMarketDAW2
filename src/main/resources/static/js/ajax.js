document.addEventListener("DOMContentLoaded", function() {
	obtenerPreguntas();
	$("#EnviarPregunta").click(crearPreguntas);
});

function crearPreguntas(event) {
	event.preventDefault();
	
	let enlace = document.getElementById("formPreguntas").action;
	
	var csrfToken = $("[name='_csrf']").attr("value");
	fetch(enlace, {
		headers: { "Content-Type": "application/json; charset=utf-8",'X-CSRF-TOKEN': csrfToken }, method: 'POST',
		credentials: 'same-origin',
		body: JSON.stringify({ pregunta: $('#Pregunta').val() })
	})
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}

function crearRespuestas(event) {
	event.preventDefault();

	fetch('/buscar', {
		headers: { "Content-Type": "application/json; charset=utf-8" }, method: 'POST',
		body: JSON.stringify({ nombre: $('#Buscarnombre').val() })
	})
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}

function obtenerPreguntas(){

	var csrfToken = $("[name='_csrf']").attr("value");
	
	let enlace = document.getElementById("formPreguntas").action;
	let contenedor = enlace.split("/");
	let idProducto = contenedor[5];

	fetch('/obtener/preguntas/' + idProducto, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })
		.then(res => res.json())
		.then(response => {
			anadirInfo(response);
		})
}

function obtenerRespuestas(idPregunta){
	fetch('/obtener/respuestas/' + idPregunta, { headers: { "Content-Type": "application/json; charset=utf-8" } })
		.then(res => res.json())
		.then(response => {
			
		})
}

function anadirInfo(responsePreguntas){

	let divInfo = document.getElementById("PyR");

	for(let preguntita of responsePreguntas){
		
		let divContenedor = document.createElement("div");
		let divHeader = document.createElement("div");
		let divBody = document.createElement("div");
		let headerFecha = document.createElement('div');
		let pregunta = document.createElement('p');
		let botonRespuestas = document.createElement('button');
		
		botonRespuestas.setAttribute('class', 'btn btn-lg btn-primary');
		botonRespuestas.setAttribute('type', 'button');
		divContenedor.setAttribute("class", "card text-white bg-primary mb-3");
		divContenedor.setAttribute("style", "max-width: 100%;");
		divHeader.setAttribute("class", "card-header");
		divBody.setAttribute("class", "card-body");
		headerFecha.setAttribute("class", "card-title");
		headerFecha.setAttribute("style", "float:right;");
		pregunta.setAttribute('class', 'card-text');
		
		divHeader.textContent = 'Usuairo: ' + preguntita.nombre_usuario ;
		headerFecha.textContent = 'Fecha de creación: ' +preguntita.fecha;
		pregunta.textContent = preguntita.pregunta;
		botonRespuestas.textContent = "Deja tu respuesta";
		
		divInfo.appendChild(divContenedor);				
		divContenedor.appendChild(divHeader);		
		divContenedor.appendChild(divBody);	
		divContenedor.appendChild(botonRespuestas);
		
		divHeader.appendChild(headerFecha);
		divBody.appendChild(pregunta);

	}
}

