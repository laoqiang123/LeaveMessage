/**
 * 
 */

function change() {
	var name = document.getElementById("email").value;
	if (name == null) {
		alert("email must not null");
	}
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET",
			"http://localhost:9999/LeaveMessageSystem/findpass/h1?email="
					+ name, true);
	xmlhttp.send();

}