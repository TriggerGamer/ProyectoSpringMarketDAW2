document.addEventListener("DOMContentLoaded", function() {
	obtenerPreguntas();
	$("#EnviarPregunta").click(crearPreguntas);
});

function crearPreguntas(event) {
	event.preventDefault();
	
	let enlace = document.getElementById("formPreguntas").action;
	
	fetch(enlace, {
		headers: { "Content-Type": "application/json; charset=utf-8" }, method: 'POST',
		body: JSON.stringify({ nombre: $('#Buscarnombre').val() })
	})
		.then(res => res.json())
		.then(response => {
			
		})
}

function crearResouestas(event) {
	event.preventDefault();

	fetch('/buscar', {
		headers: { "Content-Type": "application/json; charset=utf-8" }, method: 'POST',
		body: JSON.stringify({ nombre: $('#Buscarnombre').val() })
	})
		.then(res => res.json())
		.then(response => {
			añadirInfoTabla(response);
		})
}

function obtenerPreguntas(){
	fetch('/obtener/respuestas', { headers: { "Content-Type": "application/json; charset=utf-8" } })
		.then(res => res.json())
		.then(response => {
			obtenerRespuestas(response);
		})
}

function obtenerRespuestas(responseRespuestas){
	fetch('/obtener/preguntas', { headers: { "Content-Type": "application/json; charset=utf-8" } })
		.then(res => res.json())
		.then(response => {
			anadirInfo(response, responseRespuestas);
		})
}

function anadirInfo(responsePreguntas, responseRespuestas){
	
}