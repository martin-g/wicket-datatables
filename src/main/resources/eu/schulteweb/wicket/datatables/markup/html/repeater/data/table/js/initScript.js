$(document).ready(function() {
	$('#${tableId}').dataTable({
		"processing": true,
        "serverSide": true,
        "ajax": "${callbackUrl}"
		"pagingType" : "full_numbers"
	});
});