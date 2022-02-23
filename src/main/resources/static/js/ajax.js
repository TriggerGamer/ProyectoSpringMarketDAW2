/* 
	Funciones que se ejecutan al cargar la página
*/

document.addEventListener("DOMContentLoaded", function() {
	obtenerPreguntas();
	$("#EnviarPregunta").click(crearPreguntas);
});


/*
	Todo el código para preguntas
*/

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

function obtenerPreguntas() {

	var csrfToken = $("[name='_csrf']").attr("value");

	let enlace = window.location.href;
	let contenedor = enlace.split("/");
	let idProducto = contenedor[4];

	let p3 = '/obtener/idUsuario';
	let p4 = '/obtener/preguntas/' + idProducto;
	
	var requestsArray = [p3, p4];

	Promise.all(requestsArray.map((request) => {
		return fetch(request,  { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } }).then((response) => {
			return response.json();
		}).then((data) => {
			return data;
		});
	})).then((response) => {
		console.log('values', response);
		anadirPregunta(response[0], response[1]);
		
	});
}

function anadirPregunta(idUsuario, responsePreguntas) {

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
		divContenedor.setAttribute("id", "divContenedor");

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
		
		if (idUsuario == preguntita.id_usuario) {
			divBody.appendChild(borrarPregunta);
		}

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

/* 
	Todo el código para respuestas
*/

function crearRespuestas(idPregunta) {

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

function obtenerRespuestas(idPregunta) {

	var csrfToken = $("[name='_csrf']").attr("value");

	fetch('/obtener/respuesta/' + idPregunta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })

		.then(res => res.json())
		.then(response => {
			imprimirRespuestas(response);
		})
}


function imprimirRespuestas(response) {

	let divContenedor = document.getElementById("divContenedor");
	let divRespuestas = document.createElement("div");
	
	divContenedor.appendChild(divRespuestas);

	for (let respuesta of response) {

		let divHeader = document.createElement("div");
		let respuesta1 = document.createElement('p');
		let divRespuesta = document.createElement("div");
		let botonBorrar = document.createElement('button');
		let botonEditar = document.createElement('button');
		let headerFecha = document.createElement('div');


		headerFecha.setAttribute("style", "float:right;");
		headerFecha.textContent = 'Fecha de creación: ' + respuesta.fecha;


		botonBorrar.setAttribute('class', 'btn btn-outline-danger');
		botonBorrar.setAttribute('name', 'borrarRespuesta');
		botonBorrar.textContent = "Borrar";
		
		divHeader.setAttribute("class", "card-header");
		divHeader.textContent = 'Usuario: ' + respuesta.nombre_usuario;

		divRespuesta.setAttribute("style", "max-width: 75%;");
		divRespuesta.setAttribute("class", "card-body");
		divRespuesta.setAttribute("id", "divRespuestas");

		botonEditar.setAttribute('class', 'btn btn-outline-warning ms-4');
		botonEditar.setAttribute('name', 'editarRespuesta');
		botonEditar.textContent = "Editar";
		respuesta1.textContent = "Respuesta: " + respuesta.respuesta;

		botonBorrar.addEventListener('click', () => {
			eliminarRespuesta(respuesta.id_respuesta);
		});

		botonEditar.addEventListener('click', () => {
			let guardar = document.createElement('button');
			let areaRespuesta = document.createElement('textarea');
			areaRespuesta.setAttribute('id', 'respuestaEditada');
			areaRespuesta.setAttribute('class', 'form-group');
			areaRespuesta.setAttribute('placeholder', respuesta.respuesta);
			
			guardar.setAttribute('class', 'btn btn-outline-success ms-4');
			guardar.setAttribute('name', 'guardarRespuesta');
			guardar.setAttribute('type', 'submit');
			guardar.textContent = "Guardar";
			
			divRespuesta.appendChild(areaRespuesta);
			divRespuesta.appendChild(guardar);
			
			guardar.addEventListener('click', () => {
				editarRespuesta(respuesta.id_respuesta);
			});
		});

		divRespuestas.appendChild(divHeader);
		divHeader.appendChild(headerFecha);
		divRespuestas.appendChild(divRespuesta);
		divRespuesta.appendChild(respuesta1);
		divRespuesta.appendChild(botonBorrar);
		divRespuesta.appendChild(botonEditar);


	}
}

function eliminarRespuesta(idRespuesta) {

	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/borrar/respuesta/' + idRespuesta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'POST' })
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}


function editarRespuesta(idRespuesta) {
	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/editar/respuesta/' + idRespuesta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'POST',
	body: JSON.stringify({ respuesta: $('#respuestaEditada').val() }) })
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
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

	let areaRespuesta = document.createElement('textarea');
	let botonEnviar = document.createElement('button');
	let csrf = document.createElement('input');

	areaRespuesta.setAttribute('id', 'respuesta');
	areaRespuesta.setAttribute('class', 'form-group');

	botonEnviar.setAttribute('class', 'btn btn-outline-warning');
	botonEnviar.setAttribute('type', 'submit');
	botonEnviar.textContent = "Enviar";

	botonEnviar.addEventListener('click', () => {
		crearRespuestas(idPregunta);
	});

	div.appendChild(areaRespuesta);
	div.appendChild(document.createElement('br'));
	div.appendChild(botonEnviar);

}
