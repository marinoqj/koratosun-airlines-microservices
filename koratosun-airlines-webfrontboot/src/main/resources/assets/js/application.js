function normalizarDecimales(objInput) {
	objInput.value = objInput.value.replace(',', '.');
}

$(document).ready(function () {
	$('#dataTable').DataTable(
		{
			ordering: false,
			lengthChange: false,
			info: false,
			pageLength: 15,
			pagingType: 'full_numbers',
			language: {
				search: "Buscar:",
				paginate: {
					first: "Primero",
					previous: "&laquo;",
					next: "&raquo;",
					last: "Último"
				},
			}
		}
	);
});

$( document ).ready(function() {
	let primeraSeccion = document.getElementsByTagName("section")[0];
	if (primeraSeccion) {
		let idPrimeraSeccion = primeraSeccion.id;
		if (idPrimeraSeccion) {
			let enlaceMenu = document.getElementById("link-" + idPrimeraSeccion);
			if (enlaceMenu) {
				enlaceMenu.classList.add("active"); // Añade la clase 'active'
			}
		}
	}
});
