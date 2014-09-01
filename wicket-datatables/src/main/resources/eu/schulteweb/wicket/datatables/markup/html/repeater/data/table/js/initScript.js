$(document).ready(function() {
	$('#${tableId}').dataTable({
		"processing": true,
        "serverSide": true,
        "ajax": "${callbackUrl}",
        "columns": [
${columns}
		],
		"pagingType" : "full_numbers"
	});
});