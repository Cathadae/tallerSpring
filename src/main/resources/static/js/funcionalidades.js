function sendDelete(url){
	var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", url, true);
        xhttp.onload = function () {
            let responseURL = xhttp.responseURL;
            window.location.replace(responseURL);
        };
        xhttp.send();
}