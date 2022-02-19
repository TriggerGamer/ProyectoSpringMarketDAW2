document.addEventListener("DOMContentLoaded", function() {
	obtenerPreguntas();
	$("#EnviarPregunta").click(crearPreguntas);
});

function crearPreguntas(event) {
	event.preventDefault();

	let enlace = document.getElementById("formPreguntas").action;

	var csrfToken = $("[name='_csrf']").attr("value");

	fetch(enlace, {
		headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'POST',
		credentials: 'same-origin',
		body: JSON.stringify({ pregunta: $('#Pregunta').val() })
	})
		.then(function(response) {
			if (response.ok) {
				return response.json();
			}
		})
		.then(response => {
			obtenerPreguntas();
		})
}

function crearRespuestas(idPregunta /* event */) {
	//event.preventDefault();

	//let enlace = document.getElementById("formRespuesta").action;

	var csrfToken = $("[name='_csrf']").attr("value");

	fetch('/crear/respuesta/' + idPregunta, {
		headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'POST',
		body: JSON.stringify({ respuesta: $('#respuesta').val() })
	})
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}

function obtenerPreguntas() {

	var csrfToken = $("[name='_csrf']").attr("value");

	let enlace = window.location.href;
	let contenedor = enlace.split("/");
	let idProducto = contenedor[4];

	fetch('/obtener/preguntas/' + idProducto, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })
		.then(res => res.json())
		.then(response => {
			anadirInfo(response);
		})
}

function obtenerRespuestas(idPregunta) {

	var csrfToken = $("[name='_csrf']").attr("value");

	fetch('/obtener/respuesta/' + idPregunta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })

		.then(res => res.json())
		.then(response => {

		})
}

function anadirInfo(responsePreguntas) {

	let divInfo = document.getElementById("PyR");
	divInfo.replaceChildren();

	for (let preguntita of responsePreguntas) {

		let divContenedor = document.createElement("div");
		let divHeader = document.createElement("div");
		let divBody = document.createElement("div");
		let headerFecha = document.createElement('div');
		let pregunta = document.createElement('p');
		let botonRespuestas = document.createElement('button');
		let borrarPregunta = document.createElement('button');

		divContenedor.setAttribute("class", "centro card border-info mb-3");
		divContenedor.setAttribute("style", "max-width: 75%;");

		divHeader.setAttribute("class", "card-header");
		divBody.setAttribute("class", "card-body");
		divBody.setAttribute("id", "body");

		headerFecha.setAttribute("style", "float:right;");
		pregunta.setAttribute("class", "card-text");

		botonRespuestas.setAttribute('class', 'btn btn-outline-warning');
		botonRespuestas.setAttribute('name', 'crearRespuesta');

		botonRespuestas.addEventListener('click', () => {
			anadirRespuesta(preguntita.id_pregunta);
		});

		borrarPregunta.setAttribute('class', 'btn btn-outline-danger ms-4');
		borrarPregunta.setAttribute('name', 'borrarPregunta');

		borrarPregunta.addEventListener('click', () => {
			eliminarPregunta(preguntita.id_pregunta);
		});


		divHeader.textContent = 'Usuario: ' + preguntita.nombre_usuario;
		headerFecha.textContent = 'Fecha de creación: ' + preguntita.fecha;
		pregunta.textContent = "Pregunta: " + preguntita.pregunta;
		botonRespuestas.textContent = "Responder";
		borrarPregunta.textContent = "Borrar";

		divInfo.appendChild(divContenedor);
		divContenedor.appendChild(divHeader);
		divContenedor.appendChild(divBody);

		divHeader.appendChild(headerFecha);
		divBody.appendChild(pregunta);
		divBody.appendChild(botonRespuestas);
		divBody.appendChild(borrarPregunta);

		obtenerRespuestas(preguntita.id_pregunta);
	}
}

function eliminarPregunta(idPregunta) {
	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/borrar/pregunta/' + idPregunta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}

function eliminarRespuesta(idRespuesta) {
	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/borrar/respuesta/' + idRespuesta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })
		.then(res => res.json())
		.then(response => {

		})
}

function editarRespuesta(idRespuesta) {
	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/editar/respuesta/' + idRespuesta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })
		.then(res => res.json())
		.then(response => {

		})
}

function anadirRespuesta(idPregunta) {

	let bodyRespuesta = document.getElementById("body");
	let RespuestaDiv = document.getElementById("div-respuesta");
	let div;

	if (RespuestaDiv != null) {
		RespuestaDiv.replaceChildren();
		div = RespuestaDiv;
	}
	else {
		div = document.createElement('div');

		div.setAttribute("id", "div-respuesta");

		bodyRespuesta.appendChild(div);
	}

	//let formRespuestas = document.createElement('form');
	let areaRespuesta = document.createElement('textarea');
	let botonEnviar = document.createElement('button');
	let csrf = document.createElement('input');



	//formRespuestas.setAttribute('action', '/crear/respuesta/' + idPregunta);
	//formRespuestas.setAttribute('method', 'POST');
	///formRespuestas.setAttribute('id', 'formRespuesta');
	//formRespuestas.setAttribute('class', 'form-inline');

	areaRespuesta.setAttribute('id', 'respuesta');
	areaRespuesta.setAttribute('class', 'form-group');


	//csrf.setAttribute("type", "hidden");
	//csrf.setAttribute("name", "_csrf");
	//csrf.setAttribute("value", "1c623809-65fe-4427-9a64-a47633c3e904");
	//csrf.setAttribute("type", "hidden");

	botonEnviar.setAttribute('class', 'btn btn-outline-warning');
	botonEnviar.setAttribute('type', 'submit');
	botonEnviar.textContent = "Enviar";

	botonEnviar.addEventListener('click', () => {
		crearRespuestas(idPregunta);
	});

	//div.appendChild(formRespuestas);
	//formRespuestas.appendChild(csrf);
	div.appendChild(areaRespuesta);
	div.appendChild(document.createElement('br'));
	div.appendChild(botonEnviar);


}
