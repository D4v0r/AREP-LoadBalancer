# Modularización con virtualización e Introducción a Docker y a AWS

## Descripción

- El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
- LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
- La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.

## Despliegue

La aplicación se encuentra desplegada en una máquina de EC2.
[App](http://ec2-54-164-164-190.compute-1.amazonaws.com:8091/)

![](https://media.discordapp.net/attachments/749330138407370856/759191528643625001/unknown.png)



## Autor

>Davor Javier Cortés Cardozo
>
>Estudiante de la Escuela Colombiana de Ingeniería Julio Garavito


## Licencia

Este proyecto está licenciado bajo la GNU General Public License v3.0, para más información ver la [LICENCIA](LICENSE.txt).

