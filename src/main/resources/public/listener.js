//Establish the WebSocket connection and set up event handlers
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/listen");
webSocket.onmessage = function (msg) { onBadgeResult(msg); };

webSocket.onclose = function () { alert("WebSocket connection closed") };

function onBadgeResult(msg)
{
    var data = JSON.parse(msg.data);

    if (data.resultType == "ErrorResult")
        document.write("<p>An error occurred while processing the badge.</p>");

    else if (data.resultType == "DeniedResult")
        if (data.result.user == null)
            document.write("<p>Access denied, no user found matching the badgeId.</p>");
        else
            document.write("<p>Access denied, user "+data.result.user.firstName+" "+data.result.user.lastName+" has no permission.</p>");
    else if (data.resultType == "GrantedResult")
        document.write("<p>Access granted for user "+data.result.user.firstName+" "+data.result.user.lastName+".</p>")
}
