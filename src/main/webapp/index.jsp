<html>
<head>
    <title>Form to create a new resource</title>
</head>
<body>
<!-- This form will submit a POST request and the POST method defined in TodoResource will respond to it -->
<h2>Create a new TODO</h2>
<form action="../TomeRestService/tomerest/books" method="POST">
    <label for="summary">Summary</label>
    <input id="summary" name="summary" />
    <br/>
    Description:
    <input name="description" ></input>
    <br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
