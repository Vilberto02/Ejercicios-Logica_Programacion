import tkinter as tk
from tkinter import messagebox
import numpy as np

class CandadoApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Adivinar candado")
        
        self.digitos = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        self.clave = np.random.choice(self.digitos, size=(4,))
        self.cadena_concatenada = "".join([str(numero) for numero in self.clave])
        self.contador = 3
        
        self.label_clave = tk.Label(master, text="Adivina la clave del candado:")
        self.label_clave.grid(column=1, columnspan=3, row=0, sticky="nsew")

        self.entry_clave = tk.Entry(master)
        self.entry_clave.grid(column=1, row=1, sticky="nsew")

        self.button_enviar = tk.Button(master, text="Enviar", command=self.verificar_clave)
        self.button_enviar.grid(column=2, row=1, sticky="nsew")

        self.button_salir = tk.Button(master, text="Salir", command=self.salir)
        self.button_salir.grid(column=1, row=2, sticky="nsew")

        self.label_intentos = tk.Label(master, text=f"Solo tienes {self.contador} intentos.")
        self.label_intentos.grid(column=1, row=3, columnspan=3, sticky="nsew")

    def verificar_clave(self):
        clave_usuario = self.entry_clave.get()
        try:
            clave_usuario = int(clave_usuario)
        except ValueError:
            messagebox.showerror("Error", "Por favor, ingresa un número entero.")
            return

        if clave_usuario == int(self.cadena_concatenada):
            messagebox.showinfo("¡Correcto!", f"El candado está abierto. Se demoró {3 - self.contador + 1} veces en encontrar la clave.")
            self.master.destroy()
        else:
            self.contador -= 1
            if self.contador == 0:
                messagebox.showinfo("Fin de Juego", "Completaste tus 3 intentos.")
                self.master.destroy()
            else:
                messagebox.showinfo("Incorrecto", f"Clave incorrecta. Solo te quedan {self.contador} intentos.")
                self.entry_clave.delete(0, tk.END)

    def salir(self):
        self.master.destroy()

def main():
    root = tk.Tk()
    app = CandadoApp(root)
    root.mainloop()

if __name__ == "__main__":
    main()
