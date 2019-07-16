<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Image-only Example - Record Plugin for Video.js</title>

  <link href="//vjs.zencdn.net/6.8.0/video-js.min.css" rel="stylesheet">
  <link href="../dist/css/videojs.record.min.css" rel="stylesheet">

  <script>
  // disable analytics tracking (note: used in vjs.zencdn.net CDN-hosted version
  // of video.js only, see https://github.com/videojs/video.js#quick-start)
  //window.HELP_IMPROVE_VIDEOJS = false;
  </script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

  <script src="//vjs.zencdn.net/6.8.0/video.min.js"></script>
  <script src="//webrtc.github.io/adapter/adapter-latest.js"></script>

  <script src="../dist/videojs.record.min.js"></script>

  <style>
  /* change player background color */
  #myImage {
      background-color: #efc3e6;
  }
  </style>
</head>
<body>

<video id="myImage" class="video-js vjs-default-skin"></video>

<script>
var player = videojs("myImage", {
    controls: true,
    width: 420,
    height: 440,
    controlBar: {
        volumePanel: false,
        fullscreenToggle: false
    },
    plugins: {
        record: {
            image: true,
            debug: true
        }
    }
}, function(){
    // print version information at startup
    videojs.log('Using video.js', videojs.VERSION,
        'with videojs-record', videojs.getPluginVersion('record'));
});

// error handling
player.on('deviceError', function() {
    console.warn('device error:', player.deviceErrorCode);
});

// snapshot is available
player.on('finishRecord', function() {
    // the blob object contains the image data that
    // can be downloaded by the user, stored on server etc.
    console.log('snapshot ready: ', player.recordedData);
});

var reader=new FileReader(); 
var base64data1;
reader.readAsDataURL(player.recordedData);
reader.onloadend=function(){
	base64data1=reader.result;
	console.log(base64data1);
	$("#recording1").val(base64data1);
}



});

$(document).ready(function(){
$("#saveButton1").on("click",function(){
	//alert("called");
	$("#pictureForm").submit();
});
});
</script>
<form id="pictureForm" action="/base64picture" method="post">
<input type="hidden" id="recording1" name="recording1">
</form> 
<button id="saveButton1">Save</button>
</body>
</html>


