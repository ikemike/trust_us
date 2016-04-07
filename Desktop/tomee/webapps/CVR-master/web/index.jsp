<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="index.css">
  <title>CVR</title>
</head>
<body>
<img src="//images/pilot.png" alt="pilot inside airplane" style="width:304px;height:228px;">


<h2>File Upload</h2>
<form action="rest/files/upload" method="post" enctype="multipart/form-data">
  <p>
    Select a file : <input type="file" name="file" size="45" />
  </p>
  <input type="submit" value="Upload File" />
</form>
</body>
</html>