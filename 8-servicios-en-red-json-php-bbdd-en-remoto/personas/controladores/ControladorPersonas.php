<?php

require_once('datos/ConexionBD.php');
require_once('utilidades/ExcepcionApi.php');
require_once('datos/mensajes.php');

// Esta clase representa un controlador para las personas
class ControladorPersonas
{
    // Nombres de la tabla y de los atributos
	const NOMBRE_TABLA = "persona";
	const DNI = "DNI";
    const NOMBRE = "nombre";
    const APELLIDOS = "apellidos";
    const TELEFONO = "telefono";
    const EMAIL = "email";

    /**
	 * Descripción: Obtiene los datos de todas las personas que hay en el sistema
	 * @return Datos de todas las personas que hay en el sistema
	 */
    public function obtenerTodasPersonas()
    {
    	try 
		{
		    $pdo = ConexionBD::obtenerInstancia()->obtenerBD();

		    // Sentencia SELECT
		    $comando = "SELECT * FROM " . self::NOMBRE_TABLA;

		    $sentencia = $pdo->prepare($comando);

		    $sentencia->execute();

		    $array = array();

		    while ($row = $sentencia->fetch(PDO::FETCH_ASSOC)) 
		    { 
				array_push($array, $row);
			}

			return [
            	[
               	 	"estado" => ESTADO_CREACION_EXITOSA,
                	"mensaje" => $array
                ]
            ];
		} 
		catch (PDOException $e) 
		{
		    throw new ExcepcionApi(ESTADO_ERROR_BD, $e->getMessage());
		}
    }

    /**
	 * Descripción: Obtiene y devuelve una persona según su DNI
	 * @param DNI DNI de la persona
	 * @return Datos de la persona indicada con su DNI
	 */
    public function obtenerPersonaDNI($DNI)
    {
        try 
        {
            $pdo = ConexionBD::obtenerInstancia()->obtenerBD();

            // Sentencia SELECT
            $comando = "SELECT * FROM " . self::NOMBRE_TABLA . " " .
            "WHERE " . self::DNI . " = ?";

            $sentencia = $pdo->prepare($comando);

            // Pongo los datos en la consulta INSERT
            $sentencia->bindParam(1, $DNI);

            $sentencia->execute();

            $array = array();

            while ($row = $sentencia->fetch(PDO::FETCH_ASSOC)) 
            { 
                array_push($array, $row);
            }

            return [
            	[
               	 	"estado" => ESTADO_CREACION_EXITOSA,
                	"mensaje" => $array
                ]
            ];
        } 
        catch (PDOException $e) 
        {
            throw new ExcepcionApi(ESTADO_ERROR_BD, $e->getMessage());
        }
    }

    /**
	 * Descripción: Inserta una persona en la base de datos
	 * @param persona Persona para insertar en la base de datos
	 * @return Indica si se ha insertado la persona correctamente (Código 1)
	 */
    public function insertarPersona($persona)
    {
        try 
        {
            // Obtengo una instancia de la base de datos ya conectada
            $pdo = ConexionBD::obtenerInstancia()->obtenerBD();

            // Creo la sentencia INSERT
            $comando = "INSERT INTO " . self::NOMBRE_TABLA . " ( " .
                self::DNI . "," .
                self::NOMBRE . "," .
                self::APELLIDOS . "," .
                self::TELEFONO . "," .
                self::EMAIL . ")" .
                " VALUES(?,?,?,?,?)";

            $sentencia = $pdo->prepare($comando);

            // Pongo los datos en la consulta INSERT
            $sentencia->bindParam(1, $persona->DNI);
            $sentencia->bindParam(2, $persona->nombre);
            $sentencia->bindParam(3, $persona->apellidos);
            $sentencia->bindParam(4, $persona->telefono);
            $sentencia->bindParam(5, $persona->email);

            // Ejecuto la consulta
            $resultado = $sentencia->execute();
        } 
        catch (PDOException $e) 
        {
            throw new ExcepcionApi(self::ESTADO_ERROR_BD, $e->getMessage());
        }

        switch ($resultado) 
        {
            case self::ESTADO_CREACION_EXITOSA:
                http_response_code(200);
                return correcto;
                break;
            case self::ESTADO_CREACION_FALLIDA:
                throw new ExcepcionApi(self::ESTADO_CREACION_FALLIDA, "Ha ocurrido un error.");
                break;
            default:
                throw new ExcepcionApi(self::ESTADO_FALLA_DESCONOCIDA, "Fallo desconocido.", 400);
        }
    }
}