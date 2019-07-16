<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js">

</script>
</head>
<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else {
      // The person is not logged into your app or we are unable to tell.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '871741186339218',
      cookie     : true,  // enable cookies to allow the server to access 
                          // the session
      xfbml      : true,  // parse social plugins on this page
      version    : 'v2.8' // use graph api version 2.8
    });

    // Now that we've initialized the JavaScript SDK, we call 
    // FB.getLoginStatus().  This function gets the state of the
    // person visiting this page and can return one of three states to
    // the callback you provide.  They can be:
    //
    // 1. Logged into your app ('connected')
    // 2. Logged into Facebook, but not your app ('not_authorized')
    // 3. Not logged into Facebook and can't tell if they are logged into
    //    your app or not.
    //
    // These three cases are handled in the callback function.

    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me?fields=id,name,email', function(response) {
      console.log(response);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
   //   $('[name="myId"]').val(response.id);
     // $('[name="myName"]').val(response.name);
     // $('[name="myEmail"]').val(response.email);
      
       
      FB.api('/me/friends',function(response){
      	console.log(response);
      	
      	/* response.data.forEach(function(ele,i){
      		$("#tableBody").append(
      		'<tr><th scope="row">'+ i + '</th>' +
      		'<td>' + ele.name +'</td>' +
      		'<td>' + ele.id+'</td>' +
  			'</tr>'
      		);
      		var earlierVal=$('[name="myFriends"]').val();
      	$('[name= "myFriends"]').val(earlierVal + ele.id + "/" +ele.name + "/");
      	
      	}); */
 $("#redirectForm1").submit();
      	
      });
    });
    
   
    
  }
</script>

<body>

<style>



ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: rgb(153,50,204);
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
    background-color: #111;
}
.form-button{
text-align:left;
}
.fb-form{
align:right-top;
}
.btn.outline {
    backgroundcolor:black;
    padding: 10px 15px;
    	size:20px;
    	text-align:left;
    
}
.btn-default.outline {
	background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 10px;
    text-align: left;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
</style>

<ul>
<li><a href="#home"hspace="20">Profile</a></li>
<li>
<div class ="fb-form">
<fb:login-button data-max-rows="1" data-size="large" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="true" data-use-continue-as="false"scope="public_profile,email,user_friends" onlogin="checkLoginState();">
</fb:login-button>
</div>
</li>
<nbsp>
<nbsp>
</ul>



<div class="container">
<div class ="row">
<div class="col-12">



<div style="display:block;text-align:left">

<br>
<div style="display:block;text-align:centre"><a href="https://some.addres" imageanchor="1"><img align="left"  src="${ imgSrc }" alt ="Profile Page Image" width="200" height="240"border="0" hspace="20">
</a><Strong><font size="6" padding="40px">Susmitha Madishetti</font></Strong>
             <br>
			 <br>Masters at UAlbany<br>
</div>
</div>
<br>
<br>
<div class="form-button">
<a href="https://localhost:8080/recordAudio">
   <input type="button" class="btn btn-default btn-sm outline" value="Create Post" />
</a>
</div>
<script>
</script>
</div>
</div>
</div>

    

<script  src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>