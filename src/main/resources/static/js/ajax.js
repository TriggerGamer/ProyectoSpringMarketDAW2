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
	try {
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
	} catch (error) {
		window.location('/usuario/login');
	}
}

function obtenerPreguntas() {

	var csrfToken = $("[name='_csrf']").attr("value");

	let enlace = window.location.href;
	let contenedor = enlace.split("/");
	let idProducto = contenedor[4];

	let p3 = '/obtener/idUsuario';
	let p4 = '/obtener/preguntas/' + idProducto;
	let p5 = '/obtener/roles';

	var requestsArray = [p3, p4, p5];

	Promise.all(requestsArray.map((request) => {
		return fetch(request, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, credentials: 'same-origin', method: 'GET' }).then((response) => {
			return response.json();
		}).then((data) => {
			return data;
		});
	})).then((response) => {
		console.log('values', response);
		anadirPregunta(response[0], response[1], response[2]);

	});
}

function anadirPregunta(idUsuario, responsePreguntas, rolUsuario) {

	let divInfo = document.getElementById("PyR");
	divInfo.replaceChildren();

	for (let preguntita of responsePreguntas) {
		
		let li = document.createElement("li");
		
		let divContenedor = document.createElement("div");
		divContenedor.setAttribute("class", "d-flex");
		divContenedor.setAttribute("id", "divContenedor" + preguntita.id_pregunta);
	
		let divLeft = document.createElement("div");
		divLeft.setAttribute("class", "left");
		
		let divRight = document.createElement("div");
		divRight.setAttribute("class", "right");
		divRight.setAttribute("id", "body" + preguntita.id_pregunta);
		
		let h4 = document.createElement("h4");
		h4.textContent = preguntita.nombre_usuario;
		divRight.appendChild(h4);
		
		let divP = document.createElement('div');
		divP.setAttribute("class", "review-description");
		let pregunta = document.createElement('p');
		pregunta.setAttribute("class", "fs-2");
		pregunta.textContent = "Pregunta: " + preguntita.pregunta;
		divP.appendChild(pregunta);
		divRight.appendChild(divP);
		
		let spanFecha = document.createElement('span');
		spanFecha.setAttribute("class", "publish py-3 d-inline-block w-100");
		spanFecha.textContent = 'Fecha: ' + preguntita.fecha;
		divRight.appendChild(spanFecha);

		let botonRespuestas = document.createElement('button');
		botonRespuestas.setAttribute('class', 'btn btn-outline-warning');
		botonRespuestas.setAttribute('name', 'crearRespuesta');
		
		botonRespuestas.textContent = "Responder";
		
		let contador = 0;
		botonRespuestas.addEventListener('click', () => {
			//let linea = document.getElementById('idBody');

			if (contador == 1) {
				let RespuestaDiv = document.getElementById("div-respuesta" + preguntita.id_pregunta);
				RespuestaDiv.replaceChildren();
				contador = 0;
			}
			else if (contador == 0) {
				anadirRespuesta(preguntita.id_pregunta);
				contador = 1;
			}

		});
		
		let borrarPregunta = document.createElement('button');
		borrarPregunta.textContent = "Borrar";
		
		borrarPregunta.setAttribute('class', 'btn btn-outline-danger ms-4');
		borrarPregunta.setAttribute('name', 'borrarPregunta');

		borrarPregunta.addEventListener('click', () => {
			eliminarPregunta(preguntita.id_pregunta);
		});
		
		let divBotones = document.createElement('div');
		divBotones.setAttribute("class", "helpful-thumbs");
		
		let divbtn1 = document.createElement('div');
		divbtn1.setAttribute("class", "helpful-thumb");
		divbtn1.appendChild(botonRespuestas);
		
		let divbtn2 = document.createElement('div');
		divbtn2.setAttribute("class", "helpful-thumb");
		
		if (idUsuario == preguntita.id_usuario || rolUsuario[0] == 'Admin') {
			divbtn2.appendChild(borrarPregunta);
		}
		
		divBotones.appendChild(divbtn1);
		divBotones.appendChild(divbtn2);
		divRight.appendChild(divBotones);
		
		li.appendChild(divLeft);
		li.appendChild(divRight);
		
		divInfo.appendChild(li);

		obtenerRespuestas(preguntita.id_pregunta, idUsuario, rolUsuario);
	}
}

function eliminarPregunta(idPregunta) {

	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/borrar/pregunta/' + idPregunta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken, method: 'GET' } })
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

function obtenerRespuestas(idPregunta, idUsuario, rolUsuario) {

	var csrfToken = $("[name='_csrf']").attr("value");

	fetch('/obtener/respuesta/' + idPregunta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken } })

		.then(res => res.json())
		.then(response => {
			imprimirRespuestas(response, idUsuario, rolUsuario);
		})
}


function imprimirRespuestas(response, idUsuario, rolUsuario) {

	for (let respuesta of response) {

		let divContenedor = document.getElementById("divContenedor" + respuesta.id_pregunta);
		let divRespuestas = document.createElement("div");

		divContenedor.appendChild(divRespuestas);

		let divHeader = document.createElement("div");
		let respuesta1 = document.createElement('p');
		let divRespuesta = document.createElement("div");
		let botonBorrar = document.createElement('button');
		let botonEditar = document.createElement('button');
		let headerFecha = document.createElement('div');


		headerFecha.setAttribute("style", "float:right;");
		headerFecha.textContent = 'Fecha: ' + respuesta.fecha;


		botonBorrar.setAttribute('class', 'btn btn-outline-danger');
		botonBorrar.setAttribute('name', 'borrarRespuesta');
		botonBorrar.textContent = "Borrar";

		divHeader.setAttribute("class", "card-header");
		divHeader.textContent = 'Usuario: ' + respuesta.nombre_usuario;

		divRespuesta.setAttribute("style", "max-width: 75%;");
		divRespuesta.setAttribute("class", "card-body");
		divRespuesta.setAttribute("id", "divRespuestas" + respuesta.id_pregunta);

		botonEditar.setAttribute('class', 'btn btn-outline-warning ms-4');
		botonEditar.setAttribute('name', 'editarRespuesta');
		botonEditar.textContent = "Editar";
		respuesta1.textContent = "Respuesta: " + respuesta.respuesta;

		botonBorrar.addEventListener('click', () => {
			eliminarRespuesta(respuesta.id_respuesta);
		});
						
		let contador = 0;
		botonEditar.addEventListener('click', () => {
			contador ++;
			if(contador%2 == 1){
				let guardar = document.createElement('button');
				let areaRespuesta = document.createElement('textarea');
				let div = document.createElement('div');
				
				div.setAttribute('id',  'idpregunta' + respuesta.id_pregunta )
				areaRespuesta.setAttribute('id', 'respuestaEditada');
				areaRespuesta.setAttribute('class', 'form-group');
				areaRespuesta.setAttribute('placeholder', respuesta.respuesta);

				guardar.setAttribute('class', 'btn btn-outline-success ms-1');
				guardar.setAttribute('name', 'guardarRespuesta');
				guardar.setAttribute('type', 'submit');
				guardar.textContent = "Guardar";

				divRespuesta.appendChild(div);
				div.appendChild(document.createElement('hr'));
				div.appendChild(areaRespuesta);
				div.appendChild(document.createElement('br'));
				div.appendChild(guardar);

				guardar.addEventListener('click', () => {
					editarRespuesta(respuesta.id_respuesta);
				});
			}else{
				let bodyRespuesta = document.getElementById("divRespuestas" + respuesta.id_pregunta);
				let borrar = document.getElementById('idpregunta' + respuesta.id_pregunta);
				bodyRespuesta.removeChild(borrar);
			}			
		});

		divRespuestas.appendChild(divHeader);
		divHeader.appendChild(headerFecha);
		divRespuestas.appendChild(divRespuesta);
		divRespuesta.appendChild(respuesta1);
		
		if (idUsuario == respuesta.id_usuario || rolUsuario[0] == 'Admin') {
			divRespuesta.appendChild(botonBorrar);
		}
		
		if (idUsuario == respuesta.id_usuario) {
			divRespuesta.appendChild(botonEditar);
		}
		


	}
}

function eliminarRespuesta(idRespuesta) {

	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/borrar/respuesta/' + idRespuesta, { headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'GET' })
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}


function editarRespuesta(idRespuesta) {
	let csrfToken = $("[name='_csrf']").attr("value");

	fetch('/editar/respuesta/' + idRespuesta, {
		headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'POST',
		body: JSON.stringify({ respuesta: $('#respuestaEditada').val() })
	})
		.then(res => res.json())
		.then(response => {
			obtenerPreguntas();
		})
}

function anadirRespuesta(idPregunta) {

	let bodyRespuesta = document.getElementById("body" + idPregunta);
	let RespuestaDiv = document.getElementById("div-respuesta" + idPregunta);
	let div;

	if (RespuestaDiv != null) {
		RespuestaDiv.replaceChildren();
		div = RespuestaDiv;
	}
	else {
		div = document.createElement('div');

		div.setAttribute("id", "div-respuesta" + idPregunta);

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

	div.appendChild(document.createElement('hr'))
	div.appendChild(areaRespuesta);
	div.appendChild(document.createElement('br'));
	div.appendChild(botonEnviar);

}
