<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Downloads</h1>

<h2>Paddlefoot - The Second CD</h2>
<table>
    <tr>
        <th>Song title</th>
        <th>Audio Format</th>
    </tr>
    <tr>
        <td>River's Edge</td>
        <td>
            <a href="/musicStore/sound/${productCode}/river.mp3">MP3</a>
        </td>
    </tr>
    <tr>
        <td>Lost My Way</td>
        <td>
            <a href="/musicStore/sound/${productCode}/lost_way.mp3">
                MP3</a>
        </td>
    </tr>
</table>
<p>
    <a href="download?action=viewAlbums">Tiếp tục xem danh sách Album</a>
</p>

</body>
</html>