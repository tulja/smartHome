<!DOCTYPE html>
<html>
<body>

   <?php 
$fan = $_GET['fan'];
$light =  $_GET['light'];
echo $light;

if($fan === NULL && $light === NULL)
  echo '';
if($fan != NULL){
file_put_contents("fan.txt", $fan);
}
if($light != NULL)
{
file_put_contents("light.txt", $light);
}
 ?>  Fan  :<br>
  <?php echo substr(trim(readfile("fan.txt")),0,-1);?>
  <br>
  <br>
  Light_ :<br> 
  <?php 
 echo substr(trim(readfile("light.txt")), 0, -2); ?> 
  <br><br>
  



</body>
</html>
