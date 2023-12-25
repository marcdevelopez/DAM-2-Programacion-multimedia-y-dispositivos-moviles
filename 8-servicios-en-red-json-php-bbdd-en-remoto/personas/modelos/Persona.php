<?php

// Esta clase representa una persona

class Persona
{
    // Variables de clase
    private $DNI, $nombre, $apellidos, $telefono, $email;

    // Constructor
    public function __construct($nDNI, $nnombre, $napellidos, $ntelefono, $nemail)
    {
        $this->DNI = $nDNI;
        $this->nombre = $nnombre;
        $this->apellidos = $napellidos;
        $this->telefono = $ntelefono;
        $this->email = $nemail;
    }

    // Muestra los datos de la persona
    public function toString()
    {
        return
            [
                "DNI" => utf8_encode($this->DNI),
                "nombre" => utf8_encode($this->nombre),
                "apellidos" => utf8_encode($this->apellidos),
                "telefono" => utf8_encode($this->telefono),
                "email" => utf8_encode($this->email)
            ];
    }
}