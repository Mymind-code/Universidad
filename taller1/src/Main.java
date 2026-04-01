import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main{

//Spawn de los jugadores
    public static double jugador1X = 500;
    public static double jugador1Y = 250;
    public static double jugador2X = 0;
    public static double jugador2Y = 250;


    //Tamaño jugadores
    public static double tamanioX = 40; //Cambiar a 15 luego de probar colision
    public static double tamanioY = 80; //cambiar a 75 luego de probar colision

    //Velocidad para los jugadores

    public static double velocidad =2;

    //PELOTA PING PONG
    public static double pelotaX =250;
    public static double pelotaY = 250;

    public static double tamanioPelota = 20;
    public static double  velocidadPelotaX = 2;
    public static double velocidadPelotaY = 3;


    public static void main(String[]Args){

        //EJES Y DIBUJO 500 PIXELES POR 500 PIXELES DE UNA ESCALA DE 0 A 500 EN AMBOS EJES
        StdDraw.setCanvasSize(500,500);
        StdDraw.setXscale(0,500);
        StdDraw.setYscale(0,500);
        StdDraw.enableDoubleBuffering();

        StdDraw.setTitle("Pin pon ");

        //CICLO WHILE PARA QUE SE EJECUTE HASTA QUE EL TIEMPO SE ACABE
        while (true) {

            //Jugador 1 Velocidad
            if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
                jugador1Y += velocidad;

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
                jugador1Y -= velocidad;
            }
            //Jugador 2 Velocidad/ movimiento

            if (StdDraw.isKeyPressed(KeyEvent.VK_O)) {
                jugador2Y += velocidad;
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_L)) {
                jugador2Y -= velocidad;
            }

            StdDraw.clear();

            //PARA QUE EL JUGADOR NO SE SALGA DE LA PANTALLA
            //USAMOS SOLO EL TAMAÑO EN Y (EL LARGO) YA QUE SOLO TIENE MOVIMIENTO VERTICAL
            if (jugador1Y < tamanioY) {
                jugador1Y = tamanioY;
            } else if (jugador1Y > 500 - tamanioY) {
                jugador1Y = 500 - tamanioY;
            }

            //LO MISMO PARA EL JUGADOR 2
            if (jugador2Y < tamanioY) {
                jugador2Y = tamanioY;
            } else if (jugador2Y > 500 - tamanioY) {
                jugador2Y = 500 - tamanioY;
            }

            //MOVIMIENTO DE LA PELOTA
            pelotaX += velocidadPelotaX;
            pelotaY += velocidadPelotaY;

            //Pelota rebota en x
            if (pelotaX < tamanioPelota) {
                velocidadPelotaX = -velocidadPelotaX;
            } else if (pelotaX > 500 - tamanioPelota) {
                velocidadPelotaX = -velocidadPelotaX;
            }

            //PELOTA REBOTA EN Y
            if (pelotaY < tamanioPelota) {
                velocidadPelotaY = -velocidadPelotaY;
            } else if (pelotaY > 500 - tamanioPelota) {
                velocidadPelotaY = -velocidadPelotaY;
            }

            //PELOTA REBOTA AL COLISIONAR CON UN JUGADOR


            //SI LA PELOTA SE ENCUENTRA DENTRO DEL RANGO DE
            //DEL JUGADOR CAMBIA SU VELOCIDAD (REBOTA)
            if (pelotaX + tamanioPelota > jugador1X - tamanioX) {
                if (pelotaY + tamanioPelota > jugador1Y - tamanioY) {
                    velocidadPelotaX = -velocidadPelotaX;
                }

            }
            if (pelotaX + tamanioPelota > jugador1X - tamanioX) {
                if (pelotaY + tamanioPelota > jugador2Y - tamanioY) {
                    velocidadPelotaX = -velocidadPelotaX;
                }
            }




            //JUGADOR 1 PERSONAJE
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.filledRectangle(jugador1X, jugador1Y,tamanioX,tamanioY);

            //JUGADOR 2 PERSONAJE
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledRectangle(jugador2X,jugador2Y,tamanioX,tamanioY);


            //NOTA: REVISAR EL TEMA DEL RECTANGULO, TIENE DOS YA QUE NO ES SIMETRICO NECESITO OTRA VARIABLE

            //PElOTA PING PONG
            StdDraw.setPenColor(Color.CYAN);
            StdDraw.filledCircle(pelotaX, pelotaY, tamanioPelota);

            StdDraw.show();
            //Para realentizar un poco el movimiento
            StdDraw.pause(5);



        }

    }
}