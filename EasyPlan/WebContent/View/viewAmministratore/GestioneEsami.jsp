<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>EasyPlan | Aggiunta gruppo esame</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- for social icon -->
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
    .navbar-inverse {
      background-color: #ada2b2;
      border-color: #ada2b2;
    }

    .reset-this {
      all: initial;
    }

    .redo-fieldset {
      border: 1px solid black;
      padding: 10px;
    }

    .redo-legend {
      color: black;
    }

    input[type=button]:active {
      border-color: #ffffff;
    }
  </style>
  
  <script>
  // funzione di aggiunta nuovo campi docenti da migliorare nel momento di aggiunta dao
  	function add()
  	{
  		$("#prof1").after('<div class="row">'+
                '<div class="col-sm-3 col-lg-3"> <h4>Nome docente classe 1:</h4></div>'+
                '<div class="col-sm-3 col-lg-3"><input type="text" class="form-control" placeholder="Costantino Delizia" name="nomeProf">'+
                '</div><div class="col-sm-3 col-lg-3">'+
                '<input type="text" class="form-control" placeholder="Inserire url prof" name="urlProf" style="display:inline"></div>'+
                '<div class="col-sm-3 col-lg-3"> <button type="button" name="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button> </div></div>');
  	}
  
  </script>
</head>

<body>
  <div class="panel panel-default">
    <nav class="navbar navbar-inverse ">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav navbar-right">
            <!-- "Login amministratore" -->
            <li><a href="Login amministratore" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
        </div>
      </div>
    </nav>

    <center>
      <h1>Nome laurea anno offerta formativa</h1>
      <fieldset class="reset-this redo-fieldset" style="margin-left: 10px; width:95%">
        <legend class="reset-this redo-legend">Inserire anno</legend>
        <fieldset class="reset-this redo-fieldset" style="margin-left: 10px;  width:97%">
          <legend class="reset-this redo-legend">Tipo gruppo</legend>
          <fieldset class="reset-this redo-fieldset" style="margin-left: -11px; width:100%">
            <input type="button" value="Nome esame" data-toggle="collapse" data-target="#demo" style="border:0px; background: #ffffff;">
          </fieldset>
          <div class="contents">
            <div id="demo" class="collapse">
              <div class="container">
                <center>
                  <div class="row">
                    <div class="col-sm-3 col-lg-3">
                      CFU <input type="number" min="1" max="12" class="btn btn-default" name="insertCFU" value="1">
                    </div>
                    <div class="col-sm-3 col-lg-3">
                      Ore <input type="number" min="1" max="96" class="btn btn-default" name="insertOre" value="1">
                    </div>
                    <div class="col-sm-6 col-lg-6">
                      Anno <select class="form-control selcls" name="Scelta anno" style="width: 40%; display:inline">
                        <option value="primo anno obbiligatorio">Primo anno obbiligatorio</option>
                        <option value="secondo anno obbiligatorio">Secondo anno obbiligatorio</option>
                      </select>
                    </div>
                  </div>
                </center>
                <div id="prof1" class="row">
                  <br><br>
                  <div class="col-sm-12 col-lg-12">
                    <h4>Docenti:</h4>
                  </div>
				<div class="col-sm-3 col-lg-3">
                    <h4>Nome docente classe 1:</h4>
                  </div>
                  <div class="col-sm-3 col-lg-3"><input type="text" class="form-control" placeholder="Costantino Delizia" name="nomeProf">
                  </div>
                  <div class="col-sm-3 col-lg-3">
                    <input type="text" class="form-control" placeholder="Inserire url prof" name="urlProf" style="display:inline">
                  </div>
                  <div class="col-sm-3 col-lg-3">
                    <button type="button" name="button" onClick=add() class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button> </div>
                </div>
                <div class="col-sm-3 col-lg-3">
                  <h4>Syllabus:</h4>
                </div>
                <div class="col-sm-9 col-lg-9"><textarea name="descrizione" rows="5" cols="79"></textarea>
                </div>
                <div class="col-sm-3 col-lg-3">
                  <h4>Modalità di esame:</h4>
                </div>
                <div class="col-sm-9 col-lg-9"><textarea name="descrizione" rows="5" cols="79"></textarea>
                </div>
                <div class="col-sm-4 col-lg-4" style="margin-top:2%">
                  <center>
                    <div><button class="btn btn-default btn-responsive center"><span class="glyphicon glyphicon-trash"><br>Cancella esame</button></span></div>
                  </center>
                </div>
                <div class="col-sm-8 col-lg-8" style="margin-top:2%"><input type="submit" class="btn btn-default" name="applica" value="Applica" style="margin-left: 15%; height: 45px" ></div>
              </div>
            </div>
          </div>
           <fieldset class="reset-this redo-fieldset"
                    style="margin-left: -11px; width:100%">
                  <input type="button" value="Nome esame 2" data-toggle="collapse" data-target="#demo2" style="border:0px; background: #ffffff;">
        </fieldset>
        <div class="contents">
          <div id="demo2" class="collapse">
            <div class="container">
              <center>
                <div class="row">
                  <div class="col-sm-3 col-lg-3">
                    CFU <input type="number" min="1" max="12" class="btn btn-default" name="insertCFU" value="1">
                  </div>
                  <div class="col-sm-3 col-lg-3">
                    Ore <input type="number" min="1" max="96" class="btn btn-default" name="insertOre" value="1">
                  </div>
                  <div class="col-sm-6 col-lg-6">
                    Anno <select class="form-control selcls" name="Scelta anno" style="width: 40%; display:inline">
                      <option value="primo anno obbiligatorio">Primo anno obbiligatorio</option>
                      <option value="secondo anno obbiligatorio">Secondo anno obbiligatorio</option>
                    </select>
                  </div>
                </div>
              </center>
              <div class="row">
                <br><br>
                <div class="col-sm-12 col-lg-12">
                  <h4>Docenti:</h4>
                </div>
                <div class="col-sm-3 col-lg-3">
                  <h4>Nome docente classe 1:</h4>
                </div>
                <div class="col-sm-3 col-lg-3"><input type="text" class="form-control" placeholder="Costantino Delizia" name="nomeProf">
                </div>
                <div class="col-sm-3 col-lg-3">
                  <input type="text" class="form-control" placeholder="Inserire url prof" name="urlProf" style="display:inline">
                </div>
                <div class="col-sm-3 col-lg-3">
                  <button type="button" name="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span></button> </div>
              </div>
              <div class="col-sm-3 col-lg-3">
                <h4>Syllabus:</h4>
              </div>
<div class="col-sm-9 col-lg-9"><textarea name="descrizione" rows="5" cols="79"></textarea>
              </div>
              <div class="col-sm-3 col-lg-3">
                <h4>Modalità di esame:</h4>
              </div>
              <div class="col-sm-9 col-lg-9"><textarea name="descrizione" rows="5" cols="79"></textarea>
              </div>
              <div class="col-sm-4 col-lg-4" style="margin-top:2%">
                <center>
                  <div><button class="btn btn-default btn-responsive center"><span class="glyphicon glyphicon-trash"><br>Cancella esame</button></span></div>
                </center>
              </div>
              <div class="col-sm-8 col-lg-8" style="margin-top:2%"><input type="submit" class="btn btn-default" name="applica" value="Applica" style="margin-left: 15%; height: 45px"> </div>
            </div>
           </div>
         </div>
         <center><div>
                  <button class="btn btn-default btn-responsive center"><span class="glyphicon glyphicon-trash"><br>Cancella gruppo</button></span>
                  <button class="btn btn-default btn-responsive center">Aggiungi un nuovo esame</button>
                  <button class="btn btn-default btn-responsive center">Aggiungi esame esistente</button>
                  <button class="btn btn-default btn-responsive center"><span class="glyphicon glyphicon-pencil"><br>Modifica gruppo</button></span>

        </div></center>
    </fieldset>
  </fieldset>
  </center>
</div>
</body>
</html>