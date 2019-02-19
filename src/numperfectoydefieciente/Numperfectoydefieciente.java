/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numperfectoydefieciente;

import java.util.Scanner;

public class Numperfectoydefieciente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Numperfectoydefieciente Num = new Numperfectoydefieciente();
                
        System.out.print("Introduzca el límite maximo (entero positivo): ");
        Scanner maximo = new Scanner(System.in);
        if ( ! maximo.hasNextInt()) {
            System.out.println("ERROR, limite maximo invalido,intente nuevamente");
            return;
        }
        int LimSup = maximo.nextInt();
        
        if (LimSup < 0) {
            System.out.println("El límite maximo no es válido. intenta nuevamente");
            return;
        }
        
        System.out.println("Numeros perfectos son:");
        int ContNumPerfectos   = 0;
        for (int i = 1; i <= LimSup; i++) {
            if ( ! Num.esPerfecto(i)) {
                continue;
            }
            System.out.printf("%d ", i);
            ContNumPerfectos++;
        }
        System.out.println("\n Numeros perfectos encontrados \n"+
                ContNumPerfectos+ ((double)100 * ContNumPerfectos/LimSup)
        );
        
        System.out.println();
        
        System.out.println("Estos números no son ni deficientes ni perfectos::");
        int ContNumDeficientes = 0;
        for (int i = 1; i <= LimSup; i++) {
            if ( Num.esdeficiente(i) || Num.esPerfecto(i)) {
                continue;
            }
            System.out.printf("%d ", i);
            ContNumDeficientes++;
        }
        System.out.printf("\n[%1$d Numeros encontrados (%2$.2f%%)]\n",
                ContNumDeficientes, ((double)100 * ContNumDeficientes/LimSup)
        );     
    }
      private boolean esdeficiente(int posInt)
    {
        int SumDivisor = 0;
        for (int i = 1 ; i < posInt; i++) {
            SumDivisor += (posInt%i == 0) ? i : 0;
        }
        return (SumDivisor < posInt);
    }     
    
    private boolean esPerfecto(int posInt)
    {
        int SumDiv = 0;
        for (int i = 1 ; i < posInt; i++) {
            SumDiv += (posInt%i == 0) ? i : 0;
        }
        return (SumDiv == posInt);
    }
    }
    
