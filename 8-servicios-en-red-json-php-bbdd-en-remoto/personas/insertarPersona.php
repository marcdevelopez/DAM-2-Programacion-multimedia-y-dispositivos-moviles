<?php

// Hago que se muestren los errores si los hay
ini_set('display_errors', 1);

require_once('vistas/VistaJson.php');
require_once('controladores/ControladorPersonas.php');
require_once('modelos/Persona.php');

// Tipo de vista de la salida de datos.
$vista = new VistaJson();

// Con esta función nos aseguramos que cualquier excepción que ocurra se muestre adecuadamente
// en el mismo formato para evitar problemas.
set_exception_handler(function ($exception) use ($vista) 
	{
	    $cuerpo = array(
	    	array(
	        	"estado" => $exception->estado,
	        	"mensaje" => $exception->getMessage()
	    	)
	    );
	    if ($exception->getCode()) 
	    {
	        $vista->estado = $exception->getCode();
	    } 
	    else 
	    {
	        $vista->estado = 500;
	    }

	    $vista->imprimir($cuerpo);
	}
);

// Obtengo los datos pasados por POST
$dni = $_REQUEST['dni'];
$nombre = $_REQUEST['nombre'];
$apellidos = $_REQUEST['apellidos'];
$telefono = $_REQUEST['telefono'];
$email = $_REQUEST['email'];

// Me creo una persona con los datos
$persona = new Persona($dni, $nombre, $apellidos, $telefono, $email);

// Me creo un controlador de personas
$controladorp = new ControladorPersonas();

// Saco por pantalla en formato JSON el resultado
$vista->imprimir($controladorp->insertarPersona($persona));