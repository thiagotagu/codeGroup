const ProjetoController = (function() {

	const init = function() {

		$("#btnNovo").on("click", function() {
			novoProjeto();
		});

		$("#btnCancelar").on("click", function() {
			$('form').get(0).reset();
			$("#formulario").hide();
		});

		setInterval(function() { $('#msgSucesso').remove() }, 5000);

		$('#dtPrevisao').datepicker();
		$('#orcamento').mask("#,##0.00", { reverse: true });

		if ($('#id').val() != "") {
			$("#formulario").show();
		}

	 	$('#membros').bootstrapDualListbox();


	}

	const novoProjeto = function() {
		$('input').val("");
		$("#formulario").show();
	}

	const cancelarProjeto = function(id) {
		$.ajax({
			url: '/projeto/' + id,
			type: 'Post',
			success: function(result) {
				location.reload();
			}
		});
	}

	return {
		init: init,
		cancelarProjeto: cancelarProjeto
	}

})();

$(document).ready(function() {
	ProjetoController.init();
});


(function() {
	'use strict'

	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	var forms = document.querySelectorAll('.needs-validation')

	// Loop over them and prevent submission
	Array.prototype.slice.call(forms)
		.forEach(function(form) {
			form.addEventListener('submit', function(event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated')
			}, false)
		})
})()

