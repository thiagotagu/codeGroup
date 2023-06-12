const WorkFlowController = (function() {

	let statusCorrente = "";
	let task = "";

	const init = function() {
		dragula([
			document.getElementById("em_analise"),
			document.getElementById("analise_realizada"),
			document.getElementById("analise_aprovada"),
			document.getElementById("iniciado"),
			document.getElementById("planejado"),
			document.getElementById("em_andamento"),
			document.getElementById("encerrado"),
			document.getElementById("cancelado")

		]).on('drag', function(el, container, teste) {

			task = $(el).find("input").val();
			console.log(task);
		}).on('dragend', function(el, container) {

			alteraStatus(task, statusCorrente);

		}).on("over", function(el, container) {

			statusCorrente = $(container).attr("id");
			console.log(statusCorrente);
		})
			.on("out", function(el, container) {
			});

	}

const alteraStatus =  function (task, novoStatus) {
		
		$.ajax({
			url: '/projeto/workflow/'+task+"/"+novoStatus,
			type: 'Post',
			success: function(result) {
				console.log("result",result)
			}
		});
	}



	return {
		init: init

	}

})();

$(document).ready(function() {
	WorkFlowController.init();
});

