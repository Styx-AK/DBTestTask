<html>
<head>
<title>DB Representation</title>
</head>

<body>
<p>testing process</p>

<form action="/tryout">
    First name:<br>
    <input type="text" name="firstName" value="name"><br>
    Last name:<br>
    <input type="text" name="lastName" value="last name"><br>
    <br>
    <input type="submit" value="Submit">
</form>

<h1>Using GET Method to Read Form Data</h1>
<ul>
    <li><p><b>First Name:</b>
        <%= request.getAttribute("firstName")%>
    </p></li>
    <li><p><b>Last  Name:</b>
        <%= request.getAttribute("lastName")%>
    </p></li>
</ul>

</body>
</html>
