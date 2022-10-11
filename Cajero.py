# -*- coding: utf -8 -*-
import os

from datetime import datetime


class Cajero:

    def __init__(self):
        self.estado = True
        self.monto = 1000
        self.menu()
        self.historial=""
        self.imprimir()

    def contraseña(self):
        contador = 1
        while contador <= 3:
            try:
                x = int(input("Ingrese su pin o contraseña:"))
                if x == 1235:
                   # print("Pin Correcto")
                    break
                else:
                    print(f"Pin incorrecto, restan {3 - contador} intentos más")

                    if contador == 3:
                        self.estado = False
                        break
                    contador += 1

            except ValueError:
                print(f"Pin incorrecto, restan {3 - contador} intentos más")
                contador += 1
                print("Ingrese solo numeros")

    def menu(self):
        self.contraseña()
        print("Bienvenido cliente Victor Manuel")
        opcion = 0
        while opcion != "5":
            os.system("cls")
            print(""" Bienvenido al cajero automatico Victor Manuel
            ******Menú******
            1-  Depositar
            2- Retirar
            3- Consultar saldo
            4- Historial
            5- Salir """)
            opcion = input("Introdusca el número de operacion a realizar: ")
            if self.estado:
                if opcion == "1":
                    self.depositar()
                elif opcion == "2":
                    self.retiro()
                elif opcion == "3":
                    self.ver()
                elif opcion == "4":
                    self.imprimir()
                elif opcion == "5":
                    print("Programa finalizado")
                else:
                    print("NO existe esa opción, vuelva a intentar")

    def depositar(self):
        deposito = float(input("Ingrese la cantidad a depositar:"))
        self.registroHistorial()
        print("Usted a depositado $", deposito)
        print(f"Su  saldo es de: $ {self.monto + deposito}")
        self.monto += deposito

    def retiro(self):
        retiro = float(input("Ingrese la cantidad a retirar : "))
        if self.monto >= retiro:
            # self.historial()
            print(f"Usted a retirado: ${retiro} , su nuevo saldo es de ${self.monto - retiro}")
            self.monto -= retiro
        else:
            print("Imposible realizar el retiro, su monto es menor")

    def ver(self):
        print("Su saldo es de: $", self.monto)

    def registroHistorial(self):
        date = datetime.now()
        self.historial = date.strftime("%d %B, %Y %H:%M:%S"), "$",self.monto
        #print(self.historial)

    def imprimir(self):
        print(type(self.historial))
        if(self.historial != ""):
            print(type( self.historial))
        else:
            print("No existe registro")


Cajero()
