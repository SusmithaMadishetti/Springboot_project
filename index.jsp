<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/ bootstrap.min.css">
<title>Create Profile Page</title>
</head>
<style>
body
{
    background: url('http://www.intentionalcaregiver.com/wp-content/uploads/2014/08/memories-by-lilgraphie.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}
 
  .sbutton{
  background-color: #blue;
    border: none;
    color: white;
    padding: 10px 10px;
    text-align: left;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
  }
  
  .sbutton {
    backgroundcolor:black;
    padding: 10px 15px;
    	size:20px;
    	text-align:left;
    
}
.container{
padding-right:15px;
padding-left:15px;
display: flex;
justify-content: center;
align-items: center;
height: 100vh;
width: 100vw;
backgroundcolor:blue;
}
.form-group{
padding:25px;
background: #ecf0f1;
}
p.form-title
{
    font-family: 'Open Sans' , sans-serif;
    font-size: 50px;
    font-weight: 600;
    font-color:white;
    text-align: center;
    color: #FFFFFF;
    margin-top: 5%;
    text-transform: uppercase;
    letter-spacing: 4px;
}
  
</style>
<body>

<div class ="container">
<div class="jumbotron text-center">
<div class="row">
<p class="form-title">create your profile</p>
<div class="form-group">
<form action="/upload" method="POST" enctype="multipart/form-data">
<input type="file" name="file"/>
</div>
<br>
<div class="form-group">
<label for ="pname"><strong>Profile Name</strong></label>
<input type="text" name="name" class="form-control" placeholder="Your Name...">
</div>
<br>
<div class= "form-group">
<label for ="desc"><strong>Description</strong></label>
<input type="text" name="desc" class="form-control" placeholder="Type about Yourself...">
</div>
<div class="sbutton">
<button type="submit">Submit</button>
</div>
</form>

</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>