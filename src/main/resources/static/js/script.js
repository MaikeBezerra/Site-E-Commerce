$(document).ready(function() {
	
	
	$("#maisProdutos").hide();

	$('#button_maisProdutos').click(function (e) {
		$("#maisProdutos").show();
		$(this).hide();
	})
});

var BRMaskBehavior = function (val) {
  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
},
brOptions = {
  onKeyPress: function(val, e, field, options) {
      field.mask(BRMaskBehavior.apply({}, arguments), options);
    }
};

$('#br_celphones').mask(BRMaskBehavior, brOptions);


function toggleMenu(){
	var menu = document.getElementById("menu");

	if (menu.style.display == "none") {
		menu.style.display = "block";
	} else {
		menu.style.display = "none";
	}
}