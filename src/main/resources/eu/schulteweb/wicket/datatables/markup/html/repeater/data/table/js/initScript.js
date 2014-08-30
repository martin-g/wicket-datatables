$(document).ready(function() {
	$('#${tableId}').dataTable({
		"processing": true,
        "serverSide": true,
        "ajax": "${callbackUrl}",
        "columns": [
            { "data": "firstname" }
/*			{ "data": "lastname" },
			{ "data": "hr.position" },
			{ "data": "hr.salary" },
			{ "data": "hr.startDate" },
			{ "data": "hr.age" },
			{ "data": "email" }*/
		],
		"pagingType" : "full_numbers"
	});
});