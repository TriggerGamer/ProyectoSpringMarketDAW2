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

	fetch('/obtener/preguntas', { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })
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

function obtenerUsuarios(idUsuario){
	fetch('/usuario/' + idUsuario, { headers: { "Content-Type": "application/json; charset=utf-8" } })
		.then(res => res.json())
		.then(response => {
			return response.nombreUsuario;
		})
}

function anadirInfo(responsePreguntas){

	let divInfo = document.getElementById("PyR");

	for(let preguntita of responsePreguntas){
		
		let p = document.createElement("p");
		let p2 = document.createElement("p");

		p.textContent = "pregunta: " + preguntita.pregunta
		p2.textContent = obtenerUsuarios(preguntita.idUsuario) + " " +  preguntita.fecha_Pregunta;
		p2.setAttribute("class", "ml-6");

		divInfo.appendChild(p);
		divInfo.appendChild(document.createElement("br"));
		divInfo.appendChild(p2);
	}
}

